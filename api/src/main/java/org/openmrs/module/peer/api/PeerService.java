/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.peer.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.peer.PeerObs;
import org.openmrs.module.peer.PeerMessages;
import org.openmrs.module.peer.PeerPatient;
import org.openmrs.module.peer.PeerProviders;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * This service exposes module's core functionality. It is a Spring managed bean which is configured in moduleApplicationContext.xml.
 * <p>
 * It can be accessed only via Context:<br>
 * <code>
 * Context.getService(PeerService.class).someMethod();
 * </code>
 *
 * @see org.openmrs.api.context.Context
 */
@Transactional
public interface PeerService extends OpenmrsService {

	/*
	 * Add service methods here
	 *
	 */



    ///

    public PeerMessages savePeerMessages(PeerMessages PeerMessages);


    public List<PeerMessages> getPeerMessages();



    public PeerMessages getPeerMessagesByUuid(String uuid);

    public PeerMessages getPeerMessagesByName(String uuid);



    public List<PeerMessages> getPeerMessagesListByUuid(String uuid);

    public PeerPatient savePeerPatient(PeerPatient peerPatient);

    public PeerPatient savePeerPatientList(ArrayList<PeerPatient> peerPatient);


    public List<PeerPatient> getPeerPatients();


    public List<PeerPatient> searchPeerPatientByName(String fname);

    public PeerPatient getPeerPatientByUuid(String uuid);





    public PeerObs savePeer(PeerObs PeerObs);

    public PeerObs savePeerList(ArrayList<PeerObs> PeerObs);


    public List<PeerObs> getPeer();


    public List<PeerObs> searchPeerByName(String fname);

    public PeerObs getPeerByUuid(String uuid);


    public PeerObs getPeerByPatientId(PeerPatient uuid);

    public PeerObs getPeerByName(String fname,String lname,String sname,String location);


    public PeerObs getPeerByPhone(String phone);


    public List<PeerObs> getPeerListByUuid(String uuid);







    public PeerProviders savePeerProviders(PeerProviders Peercdm);

    public PeerProviders savePeerProvidersList(ArrayList<PeerProviders> Peercdm);


    public List<PeerProviders> getPeerProviders();

    public PeerProviders getPeerProvidersByUuid(String uuid);


    public PeerProviders getPeerProvidersByName(String fname,String lname);


    public PeerProviders getPeerProvidersByUName(String fname,String pwd);






}