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
package org.openmrs.module.peer.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.peer.PeerObs;
import org.openmrs.module.peer.PeerMessages;
import org.openmrs.module.peer.PeerPatient;
import org.openmrs.module.peer.PeerProviders;
import org.openmrs.module.peer.api.PeerService;
import org.openmrs.module.peer.api.db.PeerDAO;

import java.util.ArrayList;
import java.util.List;


public class PeerServiceImpl extends BaseOpenmrsService implements PeerService {

	protected final Log log = LogFactory.getLog(this.getClass());

	private PeerDAO dao;
	/**
     * @param dao the dao to set
     */
    public void setDao(PeerDAO dao) {
	    this.dao = dao;
    }

    /**
     * @return the dao
     */
    public PeerDAO getDao() {
	    return dao;
    }



    @Override
    public PeerMessages savePeerMessages(PeerMessages PeerMessages) {
        return dao.savePeerMessages(PeerMessages);
    }

    @Override
    public List<PeerMessages> getPeerMessages() {
        return dao.getPeerMessages();
    }

    @Override
    public PeerMessages getPeerMessagesByUuid(String uuid) {
        return  dao.getPeerMessagesByUuid(uuid);
    }
    @Override
    public PeerMessages getPeerMessagesByName(String uuid) {
        return  dao.getPeerMessagesByName(uuid);
    }

    @Override
    public List<PeerMessages> getPeerMessagesListByUuid(String uuid) {
        return dao.getPeerMessagesListByUuid(uuid);
    }

    @Override
    public PeerObs savePeer(PeerObs peerObsMessages) {
        return dao.savePeer(peerObsMessages);
    }

    @Override
    public PeerObs savePeerList(ArrayList<PeerObs> peerObsMessages) {
        return dao.savePeerList(peerObsMessages);
    }


    @Override
    public List<PeerObs> getPeer() {
        return dao.getPeer();
    }

    @Override
    public PeerObs getPeerByUuid(String uuid) {
        return  dao.getPeerByUuid(uuid);
    }
    @Override
    public PeerObs getPeerByPatientId(PeerPatient uuid) {
        return  dao.getPeerByPatientId(uuid);
    }


    @Override
    public PeerObs getPeerByName(String fname,String lname,String sname,String location) {
        return  dao.getPeerByName(fname,lname,sname,location);
    }


    @Override
    public PeerObs getPeerByPhone(String uuid) {
        return  dao.getPeerByPhone(uuid);
    }


    @Override
    public List<PeerObs> getPeerListByUuid(String uuid) {
        return dao.getPeerListByUuid(uuid);
    }


    public List<PeerObs> searchPeerByName(String fname){
        return dao.searchPeerByName(fname);
    }




    public PeerProviders savePeerProviders(PeerProviders Peercdm){
        return dao.savePeerProviders(Peercdm);
    }

    public PeerProviders savePeerProvidersList(ArrayList<PeerProviders> Peercdm){
        return dao.savePeerProvidersList(Peercdm);
    }


    public List<PeerProviders> getPeerProviders(){
        return dao.getPeerProviders();
    }

    public PeerProviders getPeerProvidersByUuid(String uuid){
        return dao.getPeerProvidersByUuid(uuid);
    }




    @Override
    public PeerProviders getPeerProvidersByName(String fname,String lname) {
        return  dao.getPeerProvidersByName(fname,lname);
    }


    @Override
    public PeerProviders getPeerProvidersByUName(String uname,String pwd) {
        return  dao.getPeerProvidersByUName(uname,pwd);
    }

    @Override
    public PeerPatient savePeerPatient(PeerPatient peerPatient){

        return dao.savePeerPatient(peerPatient);
    }

    @Override
    public PeerPatient savePeerPatientList(ArrayList<PeerPatient> peerPatient){
        return dao.savePeerPatientList(peerPatient);

    }

    @Override
    public List<PeerPatient> getPeerPatients(){

        return dao.getPeerPatients();
    }

    @Override
    public List<PeerPatient> searchPeerPatientByName(String fname){

        return dao.searchPeerPatientByName(fname);
    }

    @Override
    public PeerPatient getPeerPatientByUuid(String uuid){
        return  dao.getPeerPatientByUuid(uuid);
    }
}
