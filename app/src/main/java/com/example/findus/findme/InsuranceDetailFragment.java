package com.example.findus.findme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;


public class InsuranceDetailFragment extends Fragment {
    @Bind(R.id.userNationalId)
    EditText mNationalId;
    @Bind(R.id.insurancePolicyNo) EditText mPolicyNo;
    @Bind(R.id.userMedCover) EditText mMedCover;
    @Bind(R.id.userPrefHospital) EditText mPrefHospital;
    @Bind(R.id.userBtn)
    Button mUserBtn;

    public InsuranceDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insurance_detail, container, false);
    }

}
