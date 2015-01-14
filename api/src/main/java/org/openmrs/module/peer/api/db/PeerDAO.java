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
package org.openmrs.module.peer.api.db;

import org.openmrs.module.peer.PeerObs;
import org.openmrs.module.peer.PeerMessages;
import org.openmrs.module.peer.PeerPatient;
import org.openmrs.module.peer.PeerProviders;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface PeerDAO {



    public PeerMessages savePeerMessages(PeerMessages PeerMessages);

    @Transactional(readOnly=true)
    public List<PeerMessages> getPeerMessages();


    @Transactional(readOnly=true)
    public PeerMessages getPeerMessagesByUuid(String uuid);
    @Transactional(readOnly=true)
    public PeerMessages getPeerMessagesByName(String uuid);


    @Transactional(readOnly=true)
    public List<PeerMessages> getPeerMessagesListByUuid(String uuid);





    public PeerObs savePeer(PeerObs peerObs);


    public PeerObs savePeerList(ArrayList<PeerObs> peerObs);


    @Transactional(readOnly=true)
    public List<PeerObs> getPeer();


    @Transactional(readOnly=true)
    public PeerObs getPeerByUuid(String uuid);

    @Transactional(readOnly=true)
    public PeerObs getPeerByPatientId(PeerPatient uuid);


    @Transactional(readOnly=true)
    public PeerObs getPeerByName(String fname,String lname,String sname,String location);

    @Transactional(readOnly=true)
    public PeerObs getPeerByPhone(String uuid);


    @Transactional(readOnly=true)
    public List<PeerObs> getPeerListByUuid(String uuid);


    @Transactional(readOnly=true)
    public List<PeerObs> searchPeerByName(String fname);





    @Transactional(readOnly=true)
    public PeerProviders savePeerProviders(PeerProviders Peercdm);

    @Transactional(readOnly=true)
    public PeerProviders savePeerProvidersList(ArrayList<PeerProviders> Peercdm);


    @Transactional(readOnly=true)
    public List<PeerProviders> getPeerProviders();


    @Transactional(readOnly=true)
    public PeerProviders getPeerProvidersByUuid(String uuid);



    @Transactional(readOnly=true)
    public PeerProviders getPeerProvidersByName(String fname,String lname);

    @Transactional(readOnly=true)
    public PeerProviders getPeerProvidersByUName(String uname,String pwd);


    @Transactional(readOnly=true)
    public PeerPatient savePeerPatient(PeerPatient peerPatient);

    @Transactional(readOnly=true)
    public PeerPatient savePeerPatientList(ArrayList<PeerPatient> peerPatient);

    @Transactional(readOnly=true)
    public List<PeerPatient> getPeerPatients();

    @Transactional(readOnly=true)
    public List<PeerPatient> searchPeerPatientByName(String fname);

    @Transactional(readOnly=true)
    public PeerPatient getPeerPatientByUuid(String uuid);


}