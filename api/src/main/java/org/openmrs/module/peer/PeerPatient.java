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


public class PeerPatient extends BaseOpenmrsData{ //implements Serializable {

    private Integer id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String gender;
    private Date dateOfBirth;
    private Date dateOfEnrollment;
    private String fingerprint;
    private String fingerName;
    private String phoneOneType;
    private String phoneOne ;
    private String phoneTwoType;
    private String phoneTwo;
    private String amrsID;
    private String mtrhID;

    private String identificationPoint;
    private String identificationPointValue;
    private String nonAmpathPatient;

    private String PatientType;
    private String PatientTypeValue;

    private String outpatientLocation;
    private String outpatientLocationValue;



    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(Date dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }



    public String getAmrsID() {
        return amrsID;
    }

    public void setAmrsID(String amrsID) {
        this.amrsID = amrsID;
    }

    public String getMtrhID() {
        return mtrhID;
    }

    public void setMtrhID(String mtrhID) {
        this.mtrhID = mtrhID;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getFingerName() {
        return fingerName;
    }

    public void setFingerName(String fingerName) {
        this.fingerName = fingerName;
    }

    public String getPhoneOneType() {
        return phoneOneType;
    }

    public void setPhoneOneType(String phoneOneType) {
        this.phoneOneType = phoneOneType;
    }

    public String getPhoneOne() {
        return phoneOne;
    }

    public void setPhoneOne(String phoneOne) {
        this.phoneOne = phoneOne;
    }

    public String getPhoneTwoType() {
        return phoneTwoType;
    }

    public void setPhoneTwoType(String phoneTwoType) {
        this.phoneTwoType = phoneTwoType;
    }

    public String getPhoneTwo() {
        return phoneTwo;
    }


    public void setPhoneTwo(String phoneTwo) {
        this.phoneTwo = phoneTwo;
    }

    public String getIdentificationPoint() {
        return identificationPoint;
    }

    public void setIdentificationPoint(String identificationPoint) {
        this.identificationPoint = identificationPoint;
    }

    public String getIdentificationPointValue() {
        return identificationPointValue;
    }

    public void setIdentificationPointValue(String identificationPointValue) {
        this.identificationPointValue = identificationPointValue;
    }

    public String getNonAmpathPatient() {
        return nonAmpathPatient;
    }

    public void setNonAmpathPatient(String nonAmpathPatient) {
        this.nonAmpathPatient = nonAmpathPatient;
    }

    public String getPatientType() {
        return PatientType;
    }

    public void setPatientType(String patientType) {
        this.PatientType = patientType;
    }

    public String getPatientTypeValue() {
        return PatientTypeValue;
    }

    public void setPatientTypeValue(String patientTypeValue) {
        this.PatientTypeValue = patientTypeValue;
    }

    public String getOutpatientLocation() {
        return outpatientLocation;
    }

    public void setOutpatientLocation(String outpatientLocation) {
        this.outpatientLocation = outpatientLocation;
    }

    public String getOutpatientLocationValue() {
        return outpatientLocationValue;
    }

    public void setOutpatientLocationValue(String outpatientLocationValue) {
        this.outpatientLocationValue = outpatientLocationValue;
    }
}