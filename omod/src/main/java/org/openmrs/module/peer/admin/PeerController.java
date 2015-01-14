package org.openmrs.module.peer.admin;

import com.futronic.SDKHelper.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openmrs.api.context.Context;
import org.openmrs.module.peer.PeerMessages;
import org.openmrs.module.peer.PeerObs;
import org.openmrs.module.peer.PeerPatient;
import org.openmrs.module.peer.PeerProviders;
import org.openmrs.module.peer.api.PeerService;
import org.openmrs.module.peer.model.ModelController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

/**
 * The
 * main
 * controller.
 */
@Controller
public class PeerController {

    private static Integer maximumResults;
    protected final Log log = LogFactory.getLog(getClass());
    /**
     * Contain reference for current operation object
     */
    public FutronicSdkBase m_Operation = null;
    PeerService service;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private JSONObject jsonObjectParameters;
    private JSONObject responseJson;
    private ModelController modelController;
    /**
     * A database directory name.
     */
    private String m_DbDir;
    /**
     * The type of this parameter is depending from current operation. For
     * enrollment operation this is DbRecord.
     */
    private Object m_OperationObj;
    private Vector<FingerprintRecord> patients;
    private Vector<DbRecord> patt;
    private String fingeprint;
    private JSONObject json;
    private PeerPatient peerPatient;
    private PeerProviders peerProvider;

    public static int daysBetween(Calendar startDate, Calendar endDate) {
        Calendar date = (Calendar) startDate.clone();
        int daysBetween = 0;
        while (date.before(endDate)) {
            date.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

    // This method is used to save a peer provider which includes fingerprint

    @RequestMapping(value = "/module/peer/savePeer", method = RequestMethod.POST)
    public void savePeerProviders(ModelMap model, HttpServletRequest request, HttpServletResponse response) {


        service = Context.getService(PeerService.class);
        jsonArray = new JSONArray();
        responseJson = new JSONObject();


        try {

            modelController = ModelController.getModelController();

            String jsonString = request.getParameter("param3");

            if (jsonString != null) {


                try {

                    jsonObjectParameters = new JSONObject(jsonString);


                    String finger = jsonObjectParameters.getString("finger");
                    String fingername = jsonObjectParameters.getString("fingername");


                    String fname = jsonObjectParameters.getString("fname");

                    String lname = jsonObjectParameters.getString("lname");


                    String sname = jsonObjectParameters.getString("sname");

                    String edit = jsonObjectParameters.getString("edit");

                    String uname = jsonObjectParameters.getString("uname");

                    String pwd = jsonObjectParameters.getString("pwd");


                    service = Context.getService(PeerService.class);

                    PeerProviders fmap = null;
                    int searchIndex = searchThroughfingeprints(finger);

                    if (searchIndex != -1) {

                        fmap = service.getPeerProvidersByUuid(patients.get(searchIndex).getIdentifier());

                    }
                    jsonObject = new JSONObject();

                     if(service.getPeerProvidersByUName(uname,pwd)!=null){
                         responseJson.put("STATUS_CODE", "2");

                     }
                    else if (fmap == null && edit.equalsIgnoreCase("false")) {
                        fmap = new PeerProviders();

                        fmap.setFname(fname);

                        fmap.setLname(lname);

                        fmap.setFingerprint(finger);
                        fmap.setFinger_name(fingername);

                        fmap.setSname(sname);
                        fmap.setUname(uname);
                        fmap.setPwd(pwd);

                        service.savePeerProviders(fmap);

                        responseJson.put("data", jsonArray);
                        responseJson.put("STATUS_CODE", "1");


                    } else if (edit.equalsIgnoreCase("true")) {

                        fmap.setFname(fname);

                        fmap.setLname(lname);
                        fmap.setFingerprint(finger);
                        fmap.setFinger_name(fingername);
                        fmap.setSname(sname);
                        fmap.setUname(uname);
                        fmap.setPwd(pwd);

                        service.savePeerProviders(fmap);


                        responseJson.put("STATUS_CODE", "1");

                    } else {


                        responseJson.put("STATUS_CODE", "2");
                    }

                    modelController.sendResponse(response, responseJson);


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    try {

                        responseJson.put("STATUS_CODE", "0");
                        modelController.sendResponse(response, responseJson);
                    } catch (Exception e1) {
                        e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }

                }
            } else {
                try {
                    jsonObject.put("STATUS_CODE", "0");
                             } catch (JSONException e1) {

                    e1.printStackTrace();
                }
                modelController.sendResponse(response, jsonObject);
            }

        } catch (Exception e1) {

            try {
                jsonObject.put("STATUS_CODE", "0");
                jsonObject
                        .put("STATUS_MSG",
                                "There was a problem in processing your request, it could be the security of your channel please sign out and resecure your channel");
            } catch (JSONException x) {

            }
            modelController.sendResponse(response, jsonObject);
        }
    }

    // Used to indentify user provider by fingerprint
    @RequestMapping(value = "/module/peer/userauthPeerFingeprint", method = RequestMethod.POST)
    public void userAuthControllerFingerprint(ModelMap model, HttpServletRequest request,
                                              HttpServletResponse response) throws IOException {

        service = Context.getService(PeerService.class);
        jsonArray = new JSONArray();
        jsonObject = new JSONObject();


        try {

            modelController = ModelController.getModelController();

            String jsonString = request.getParameter("param3");

            if (jsonString != null) {

                try {

                    jsonObjectParameters = new JSONObject(jsonString);
                    fingeprint = jsonObjectParameters.getString("fingerprint");
                    int searchIndex = searchThroughfingeprints(fingeprint);

                    if (searchIndex != -1) {
                        jsonObject.put("STATUS_CODE", "1");
                        PeerProviders peerProviders = service.getPeerProvidersByUuid(patients.get(searchIndex).getIdentifier());

                        jsonObject.put("username", peerProviders.getUname());
                        jsonObject.put("password", peerProviders.getPwd());


                    } else {
                        jsonObject.put("STATUS_CODE", "0");

                    }
                    response.getWriter().print(jsonObject);

                    response.flushBuffer();


                } catch (Exception e) {

                    e.printStackTrace();
                    try {
                        jsonObject.put("STATUS_CODE", "0");
                        jsonObject.put("STATUS_MSG",
                                "Invalid username and/or password");
                    } catch (JSONException e2) {

                        e2.printStackTrace();
                    }
                    modelController.sendResponse(response, jsonObject);
                }
            } else {
                try {
                    jsonObject.put("STATUS_CODE", "0");
                    jsonObject
                            .put("STATUS_MSG",
                                    "There was a problem in processing your request, it could be the security of your channel please sign out and resecure your channel");
                } catch (JSONException e1) {

                    e1.printStackTrace();
                }
                modelController.sendResponse(response, jsonObject);
            }

        } catch (Exception e1) {

            try {
                jsonObject.put("STATUS_CODE", "0");
                jsonObject
                        .put("STATUS_MSG",
                                "There was a problem in processing your request, it could be the security of your channel please sign out and resecure your channel");
            } catch (JSONException x) {

            }
            modelController.sendResponse(response, jsonObject);
        }

    }

    @RequestMapping(value = "/module/peer/obsauthPeerFingeprint", method = RequestMethod.POST)
    public void searchAuthControllerFingerprint(ModelMap model, HttpServletRequest request,
                                                HttpServletResponse response) throws IOException {

        service = Context.getService(PeerService.class);
        jsonArray = new JSONArray();
        jsonObject = new JSONObject();


        try {

            modelController = ModelController.getModelController();

            String jsonString = request.getParameter("param3");

            if (jsonString != null) {

                try {

                    jsonObjectParameters = new JSONObject(jsonString);
                    fingeprint = jsonObjectParameters.getString("fingerprint");
                    int searchIndex = searchThroughfingeprints(fingeprint);

                    if (searchIndex != -1) {
                        jsonObject.put("STATUS_CODE", "1");
                    } else {
                        jsonObject.put("STATUS_CODE", "0");

                    }
                    response.getWriter().print(jsonObject);

                    response.flushBuffer();


                } catch (Exception e) {

                    e.printStackTrace();
                    try {
                        jsonObject.put("STATUS_CODE", "0");
                        jsonObject.put("STATUS_MSG",
                                "Invalid username and/or password");
                    } catch (JSONException e2) {

                        e2.printStackTrace();
                    }
                    modelController.sendResponse(response, jsonObject);
                }
            } else {
                try {
                    jsonObject.put("STATUS_CODE", "0");
                    jsonObject
                            .put("STATUS_MSG",
                                    "There was a problem in processing your request, it could be the security of your channel please sign out and resecure your channel");
                } catch (JSONException e1) {

                    e1.printStackTrace();
                }
                modelController.sendResponse(response, jsonObject);
            }

        } catch (Exception e1) {

            try {
                jsonObject.put("STATUS_CODE", "0");
                jsonObject
                        .put("STATUS_MSG",
                                "There was a problem in processing your request, it could be the security of your channel please sign out and resecure your channel");
            } catch (JSONException x) {

            }
            modelController.sendResponse(response, jsonObject);
        }

    }


    public int OnGetBaseTemplateComplete(boolean bSuccess, int nResult, String fingerprint) {
        FtrIdentifyResult result = new FtrIdentifyResult();

        StringBuffer szMessage = new StringBuffer();
        if (bSuccess) {
            System.out.println("Starting identification...");
            try {

                if(m_Operation==null)
                m_Operation = new FutronicIdentification();

                ((FutronicIdentification) m_Operation).setBaseTemplate(Base64.decode(fingerprint));
                Vector<DbRecord> vpatients = patt;
                FtrIdentifyRecord[] rgRecords = new FtrIdentifyRecord[vpatients.size()];

                for (int iPatients = 0; iPatients < vpatients.size(); iPatients++)
                    rgRecords[iPatients] = vpatients.get(iPatients).getFtrIdentifyRecord();


                nResult = ((FutronicIdentification) m_Operation).Identification(
                        rgRecords, result);

                nResult = ((FutronicIdentification) m_Operation).Identification(rgRecords, result);

                if (nResult == FutronicSdkBase.RETCODE_OK) {
                    szMessage.append("Identification process complete. User: ");
                    if (result.m_Index != -1)
                        szMessage.append(patients.get(result.m_Index).getName());
                    else
                        szMessage.append("not found");
                } else {
                    szMessage.append("Identification failed.");
                    szMessage.append(FutronicSdkBase.SdkRetCode2Message(nResult));
                }
                // SetIdentificationLimit( m_Operation.getIdentificationsLeft() );
                ((FutronicIdentification) m_Operation).Dispose();

            } catch (Exception e) {
                System.out.println("Error..." + e.getMessage());

            }


        } else {
            szMessage.append("Can not retrieve base template.");
            szMessage.append("Error description: ");
            szMessage.append(FutronicSdkBase.SdkRetCode2Message(nResult));
        }

        m_Operation = null;
        m_OperationObj = null;
        return result.m_Index;

    }

    private int searchThroughfingeprints(String fingerprint) {

        patients = new Vector<FingerprintRecord>();
        patt = new Vector<DbRecord>();


        List<PeerProviders> response = service.getPeerProviders();
        FingerprintRecord fr;
        DbRecord dr;

        for (int i = 0; i < response.size(); i++) {
            try {

                dr = new DbRecord();
                dr.setTemplate(Base64.decode(response.get(i).getFingerprint()));

                fr = new FingerprintRecord(response.get(i).getUuid(), response.get(i).getFingerprint());
                fr.setName(response.get(i).getFname());

                fr.setIdentifier(response.get(i).getUuid());
                fr.setAge(response.get(i).getLname());

                patients.add(fr);
                patt.add(dr);
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return OnGetBaseTemplateComplete(true, 1, fingerprint);

    }

}