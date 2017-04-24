package com.example.findus.findme.models;

/**
 * Created by pauline on 4/24/17.
 */

public class medicalDetails {

    String name;
    String age;
    String gender;
    String phoneNumber;
    String bloodGroup;
    String condition;
    String medAllergies;
    String userAllegies;




    public medicalDetails() {}

    public medicalDetails( String name, String age, String condition, String medAllergies, String userAllegies) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.condition=condition;
        this.medAllergies= medAllergies;
        this.userAllegies= userAllegies;
    }

    public String getName() {
        return name;
    }

    public String getAge()
    {
        return age;
    }

    public String getGender() {

        return gender;
    }

     public  String getPhoneNumber(){
         return  phoneNumber;

    }
    public  String getBloodGroup(){
        return  bloodGroup;

    }
    public  String getCondition(){

        return  condition;
    }
    public  String getMedAllergies(){

        return  medAllergies;
    }

    public  String getUserAllergies(){

        return userAllegies;
    }


}
