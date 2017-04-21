package com.example.findus.findme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.Bind;


/**
 * A simple {@link Fragment} subclass.
 */
public class MedicalDetailFragment extends Fragment {
    @Bind(R.id.userFullName)
    EditText mUserFullName;
    @Bind(R.id.userAge)
    EditText mUserAge;
    @Bind(R.id.gender_spinner)
    Spinner mGenderSpinner;
    @Bind(R.id.bloodGroup_Spinner)
    Spinner mBloodGroupSpinner;
    @Bind(R.id.userMedicalConditions)
    EditText mUserMedicalConditions;
    @Bind(R.id.addMedicalConditions)
    EditText mAddMedicalConditions;
    @Bind(R.id.userMedAllergies)
    EditText mUserMedAllergies;
    @Bind(R.id.userAllergies)
    EditText mUserAllergies;
    @Bind(R.id.userMedicalBtn)
    Button mUserMedicalButton;


    public MedicalDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medical_detail, container, false);
    }

}
