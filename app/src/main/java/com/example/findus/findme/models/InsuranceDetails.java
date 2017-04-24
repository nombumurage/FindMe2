package com.example.findus.findme.models;

/**
 * Created by pauline on 4/24/17.
 */

public class InsuranceDetails {


    String natId;
    String policyNumber;
    String medCover;
    String prefHospital;

    public InsuranceDetails(){}

    public InsuranceDetails(  String natId,  String policyNumber,String medCover, String prefHospital){

        this.medCover= medCover;
        this.natId=natId;
        this.policyNumber=policyNumber;
        this.prefHospital=prefHospital;
    }

    public String getMedCover() {
        return medCover;
    }

    public String getNatId() {
        return natId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPrefHospital() {return prefHospital;}



}
