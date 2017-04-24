package com.example.findus.findme.models;

/**
 * Created by pauline on 4/24/17.
 */

public class EmergencyContacts {
    String  EmergencyContactName;
    String  EmergencyContactNumber;

    public EmergencyContacts(String  EmergencyContactName, String  EmergencyContactNumber) {
        this.EmergencyContactName = EmergencyContactName;
        this.EmergencyContactNumber = EmergencyContactNumber;
    }
    public  String getEmergencyContactName(){
        return EmergencyContactName;
    }
    public String getEmergencyContactNumber(){
        return EmergencyContactNumber;
    }


}
