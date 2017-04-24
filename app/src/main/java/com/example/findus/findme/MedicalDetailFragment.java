package com.example.findus.findme;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findus.findme.models.medicalDetails;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MedicalDetailFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.userFullName) EditText mUserFullName;
    @Bind(R.id.userAge) EditText mUserAge;
    @Bind(R.id.gender_spinner) Spinner mGenderSpinner;
    @Bind(R.id.bloodGroup_Spinner) Spinner mBloodGroupSpinner;
    @Bind(R.id.userMedicalConditions) EditText mUserMedicalConditions;
    @Bind(R.id.addMedicalConditions) Button mAddMedicalConditions;
    @Bind(R.id.userMedAllergies) EditText mUserMedAllergies;
    @Bind(R.id.userAllergies) EditText mUserAllergies;
    @Bind(R.id.userMedicalBtn) Button mUserSaveMedicalButton;
    @Bind(R.id.userPhoneNumber) EditText mUserPhoneNumber;

    public MedicalDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserSaveMedicalButton.setOnClickListener(this);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

      ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_medical_detail, container, false);

        ButterKnife.bind(this,view);

        return  view;

    }

    @Override
    public void onClick(View v){
        if(v ==  mUserSaveMedicalButton){
            mUserAge.setVisibility(View.INVISIBLE);
            mUserFullName.setVisibility(View.INVISIBLE);
            mUserMedicalConditions.setVisibility(View.INVISIBLE);
            mUserMedAllergies.setVisibility(View.INVISIBLE);
            mUserAllergies.setVisibility(View.INVISIBLE);
            mUserPhoneNumber.setVisibility(View.INVISIBLE);

            saveToFirebase();
        }


    }

    public void saveToFirebase(){

        String username = mUserFullName.getText().toString();
        String userAge = mUserAge.getText().toString();
        String medicalConditions = mUserMedicalConditions.getText().toString();
        String medicalAllergies = mUserMedAllergies.getText().toString();
        String otherAllergies = mUserAllergies.getText().toString();
        String phoneNumber = mUserPhoneNumber.getText().toString();
       // String gender= mGenderSpinner.getItemIdAtPosition(mGenderSpinner.getSelectedItemPosition()).toString();
       // String bloodGroup = mBloodGroupSpinner.getItemIdAtPosition(mBloodGroupSpinner.getSelectedItemPosition()).toString();




        DatabaseReference  reference = FirebaseDatabase.getInstance().getReference().child("phoneNumber");
        reference.setValue(phoneNumber);


        medicalDetails medDetails = new medicalDetails (username,userAge, medicalConditions, medicalAllergies, otherAllergies);

        reference.child("medicalDetails").setValue(medDetails);

        Toast.makeText(getActivity(), " Details Saved", Toast.LENGTH_SHORT).show();
    }

}
