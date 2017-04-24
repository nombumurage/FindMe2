package com.example.findus.findme;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.findus.findme.models.InsuranceDetails;
import com.example.findus.findme.models.medicalDetails;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;


public class InsuranceDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.userNationalId) EditText mNationalId;
    @Bind(R.id.insurancePolicyNo) EditText mPolicyNo;
    @Bind(R.id.userMedCover) EditText mMedCover;
    @Bind(R.id.userPrefHospital) EditText mPrefHospital;
    @Bind(R.id.userBtn) Button mUserBtn;

    public InsuranceDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserBtn.setOnClickListener(this);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_medical_detail, container, false);

        return view;
    }

    @Override
    public void onClick(View v){
        if (v == mUserBtn) {

            mNationalId.setVisibility(View.INVISIBLE);
            mPolicyNo.setVisibility(View.INVISIBLE);
            mMedCover.setVisibility(View.INVISIBLE);
            mPrefHospital.setVisibility(View.INVISIBLE);

            saveToFirebase();
        }


    }

    public void saveToFirebase(){

        String nationalId = mNationalId.getText().toString();
        String policyNumber = mPolicyNo.getText().toString();
        String medicalCover = mMedCover.getText().toString();
        String preferedHospital = mPrefHospital.getText().toString();




        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("phoneNumber");


        InsuranceDetails insuranceDetails = new InsuranceDetails(nationalId, policyNumber,medicalCover, preferedHospital);

        reference.child("insuranceDetails").setValue(insuranceDetails);

        Toast.makeText(getActivity(), " Details Saved", Toast.LENGTH_SHORT).show();
    }



}
