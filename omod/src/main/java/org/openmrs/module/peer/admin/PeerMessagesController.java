package org.openmrs.module.peer.admin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.peer.PeerMessages;
import org.openmrs.module.peer.api.PeerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class PeerMessagesController {

    private static final Log log = LogFactory.getLog(PeerMessagesController.class);

    private JSONArray drugStrengthA;


    private boolean found = false;

    private JSONArray supplierNames;

    private UserContext userService;

    private boolean editPeer = false;

    private boolean deletePeer = false;

    private JSONArray datad2;
    private JSONObject jsonObject;
    private List<PeerMessages> peerMessagesList;
    private int size;
    private JSONArray jsonArray;
    private PeerMessages PeerMessages;
    private PeerService service;

    @RequestMapping(method = RequestMethod.GET, value = "module/peer/peerMsgs")
    public synchronized void pageLoad(HttpServletRequest request, HttpServletResponse response) {
        userService = Context.getUserContext();
        String uuid = request.getParameter("nameuuid");
        String drop = request.getParameter("drop");
        service = Context.getService(PeerService.class);

        peerMessagesList = service.getPeerMessages();
        size = peerMessagesList.size();
        jsonObject = new JSONObject();

        jsonArray = new JSONArray();

        try {

            if (drop != null) {
                if (drop.equalsIgnoreCase("drop")) {
                    if (size != 0) {
                        for (int i = 0; i < size; i++) {
                            jsonArray.put("" + getDropDown(peerMessagesList, i));
                        }
                    } else {
                        jsonArray.put("" + null);

                    }
                    response.getWriter().print(jsonArray);
                }

            } else {

                if (size != 0) {
                    for (int i = 0; i < size; i++) {

                        jsonObject.accumulate("aaData", getArray(peerMessagesList, i));

                    }

                }
                if (!jsonObject.has("aaData")) {

                    datad2 = new JSONArray();
                    datad2.put("None");
                    datad2.put("None");
                    datad2.put("None");
                    datad2.put("None");
                    datad2.put("None");

                    datad2.put("None");
                    datad2.put("None");

                    jsonObject.accumulate("aaData", datad2);

                }

                jsonObject.accumulate("iTotalRecords", jsonObject.getJSONArray("aaData").length());
                jsonObject.accumulate("iTotalDisplayRecords", jsonObject.getJSONArray("aaData").length());
                jsonObject.accumulate("iDisplayStart", 0);
                jsonObject.accumulate("iDisplayLength", 10);

                response.getWriter().print(jsonObject);
            }
            response.flushBuffer();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("Error generated", e);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "module/peer/peerMsgs")
    public synchronized void pageLoadd(HttpServletRequest request, HttpServletResponse response) {

        String peerMsgs = request.getParameter("suppliername");

        String peerMsgs1 = request.getParameter("suppliername1");

        String description = request.getParameter("description");
        String edit = request.getParameter("supplieredit");
        String uuid = request.getParameter("supplieruuid");
        String uuidvoid = request.getParameter("supplieruuidvoid");
        String reason = request.getParameter("supplierreason");


        userService = Context.getUserContext();
        if (edit != null) {
            if (edit.equalsIgnoreCase("false")) {

                //check for same entry before saving
                peerMessagesList = service.getPeerMessages();
                size = peerMessagesList.size();
                for (int i = 0; i < size; i++) {

                    found = getCheck(peerMessagesList, i, peerMsgs);
                    if (found)
                        break;
                }

                if (!found) {

                    PeerMessages = new PeerMessages();
                    PeerMessages.setPatientsMessage(peerMsgs);
                    PeerMessages.setPatientsMessageMissed(peerMsgs1);
                    PeerMessages.setCoughMonitorMessage(description);

                    service.savePeerMessages(PeerMessages);

                } else //do code to display to the user
                {

                }

            } else if (edit.equalsIgnoreCase("true")) {
                PeerMessages = new PeerMessages();

                PeerMessages = service.getPeerMessagesByUuid(uuid);


                if (userService.getAuthenticatedUser().getUserId().equals(PeerMessages.getCreator().getUserId())) {

                    // saving/updating a record
                    PeerMessages.setPatientsMessage(peerMsgs);//(drugName);
                    PeerMessages.setCoughMonitorMessage(description);
                    PeerMessages.setPatientsMessageMissed(peerMsgs1);

                    service.savePeerMessages(PeerMessages);
                }
            }

        } else if (uuidvoid != null) {

            PeerMessages = new PeerMessages();

            PeerMessages = service.getPeerMessagesByUuid(uuidvoid);

            PeerMessages.setVoided(true);
            PeerMessages.setVoidReason(reason);

            service.savePeerMessages(PeerMessages);

        }

    }

    public synchronized JSONArray getArray(List<PeerMessages> supplierNamee, int size) {

        supplierNames = new JSONArray();


        editPeer = true;
        deletePeer = true;
        editPeer = true;
        deletePeer = true;

        if (editPeer) {

            supplierNames.put("edit");
            editPeer = false;
        } else
            supplierNames.put("");

        supplierNames.put("");
        supplierNames.put(supplierNamee.get(size).getUuid());
        supplierNames.put(supplierNamee.get(size).getPatientsMessage());
        supplierNames.put(supplierNamee.get(size).getPatientsMessageMissed());
        supplierNames.put(supplierNamee.get(size).getCoughMonitorMessage());
        if (deletePeer) {
            supplierNames.put("void");
            deletePeer = false;
        } else
            supplierNames.put("");
        return supplierNames;
    }

    public synchronized String getDropDown(List<PeerMessages> supplierNamee, int size) {

        return supplierNamee.get(size).getPatientsMessage();
    }

    public synchronized boolean getCheck(List<PeerMessages> supplierNamee, int size, String names) {
        if (supplierNamee.get(size).getPatientsMessage().equalsIgnoreCase(names)) {

            return true;

        } else
            return false;

    }
}
