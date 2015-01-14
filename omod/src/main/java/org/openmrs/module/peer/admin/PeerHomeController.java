package org.openmrs.module.peer.admin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.PersonAttribute;
import org.openmrs.PersonAttributeType;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.PatientService;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Authorized("Manage Pharmacy")
public class PeerHomeController {

    private static final Log log = LogFactory.getLog(PeerHomeController.class);


    @Authorized("Manage Pharmacy")
    @RequestMapping(method = RequestMethod.GET, value = "module/peer/peer")
    public synchronized void pageLoad(ModelMap map) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "module/peer/peer")
    public synchronized void pageLoadd(HttpServletRequest request, HttpServletResponse response) {

    }

}
