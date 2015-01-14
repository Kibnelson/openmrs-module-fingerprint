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
package org.openmrs.module.peer;

import org.openmrs.BaseOpenmrsData;

import java.util.Date;


public class PeerObs extends BaseOpenmrsData{ //implements Serializable {

    private Integer id;



    private String currentHIVRegimen;
    private String regimenOne;
    private String regimenOneValue;
    private String regimenTwo;
    private String regimenTwoValue;
    private String regimenThree;
    private String regimenThreeValue;
    private String regimenFour;
    private String regimenFourValue;
    private String tbTreatment;
    private String pcp;
    private String crypto;
    private String otherOI;
    private PeerProviders provider;
    private PeerPatient peerPatient;

    private Date dateOfLastEncounter;

    private Date dateOfNextEncounter;
    private Date dateOfNextPeerCall;

    private String phoneCallInitiator;
    private String patientTypeOptions;
    private String inPatientOption;
    private String adherance;
    private String comments;

    private Date deceased;
    private String lostToFollow;

    private Long timeStampval;



    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }




    public String getCurrentHIVRegimen() {
        return currentHIVRegimen;
    }

    public void setCurrentHIVRegimen(String currentHIVRegimen) {
        this.currentHIVRegimen = currentHIVRegimen;
    }

    public String getRegimenOne() {
        return regimenOne;
    }

    public void setRegimenOne(String regimenOne) {
        this.regimenOne = regimenOne;
    }

    public String getRegimenOneValue() {
        return regimenOneValue;
    }

    public void setRegimenOneValue(String regimenOneValue) {
        this.regimenOneValue = regimenOneValue;
    }

    public String getRegimenTwo() {
        return regimenTwo;
    }

    public void setRegimenTwo(String regimenTwo) {
        this.regimenTwo = regimenTwo;
    }

    public String getRegimenTwoValue() {
        return regimenTwoValue;
    }

    public void setRegimenTwoValue(String regimenTwoValue) {
        this.regimenTwoValue = regimenTwoValue;
    }

    public String getRegimenThree() {
        return regimenThree;
    }

    public void setRegimenThree(String regimenThree) {
        this.regimenThree = regimenThree;
    }

    public String getRegimenThreeValue() {
        return regimenThreeValue;
    }

    public void setRegimenThreeValue(String regimenThreeValue) {
        this.regimenThreeValue = regimenThreeValue;
    }

    public String getRegimenFour() {
        return regimenFour;
    }

    public void setRegimenFour(String regimenFour) {
        this.regimenFour = regimenFour;
    }

    public String getRegimenFourValue() {
        return regimenFourValue;
    }

    public void setRegimenFourValue(String regimenFourValue) {
        this.regimenFourValue = regimenFourValue;
    }

    public String getTbTreatment() {
        return tbTreatment;
    }

    public void setTbTreatment(String tbTreatment) {
        this.tbTreatment = tbTreatment;
    }

    public String getPcp() {
        return pcp;
    }

    public void setPcp(String pcp) {
        this.pcp = pcp;
    }

    public String getCrypto() {
        return crypto;
    }

    public void setCrypto(String crypto) {
        this.crypto = crypto;
    }

    public String getOtherOI() {
        return otherOI;
    }

    public void setOtherOI(String otherOI) {
        this.otherOI = otherOI;
    }

    public PeerProviders getProvider() {
        return provider;
    }

    public void setProvider(PeerProviders provider) {
        this.provider = provider;
    }

    public Date getDateOfLastEncounter() {
        return dateOfLastEncounter;
    }

    public void setDateOfLastEncounter(Date dateOfLastEncounter) {
        this.dateOfLastEncounter = dateOfLastEncounter;
    }

    public Date getDateOfNextPeerCall() {
        return dateOfNextPeerCall;
    }

    public void setDateOfNextPeerCall(Date dateOfNextPeerCall) {
        this.dateOfNextPeerCall = dateOfNextPeerCall;
    }

    public String getPhoneCallInitiator() {
        return phoneCallInitiator;
    }

    public void setPhoneCallInitiator(String phoneCallInitiator) {
        this.phoneCallInitiator = phoneCallInitiator;
    }

    public String getInPatientOption() {
        return inPatientOption;
    }

    public void setInPatientOption(String inPatientOption) {
        this.inPatientOption = inPatientOption;
    }

    public String getAdherance() {
        return adherance;
    }

    public void setAdherance(String adherance) {
        this.adherance = adherance;
    }

    public String getPatientTypeOptions() {
        return patientTypeOptions;
    }

    public void setPatientTypeOptions(String patientTypeOptions) {
        this.patientTypeOptions = patientTypeOptions;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    public Date getDateOfNextEncounter() {
        return dateOfNextEncounter;
    }

    public void setDateOfNextEncounter(Date dateOfNextEncounter) {
        this.dateOfNextEncounter = dateOfNextEncounter;
    }

    public PeerPatient getPeerPatient() {
        return peerPatient;
    }

    public void setPeerPatient(PeerPatient peerPatient) {
        this.peerPatient = peerPatient;
    }

    public Long getTimeStampval() {
        return timeStampval;
    }

    public void setTimeStampval(Long timeStampval) {
        this.timeStampval = timeStampval;
    }

    public Date getDeceased() {
        return deceased;
    }

    public void setDeceased(Date deceased) {
        this.deceased = deceased;
    }

    public String getLostToFollow() {
        return lostToFollow;
    }

    public void setLostToFollow(String lostToFollow) {
        this.lostToFollow = lostToFollow;
    }
}