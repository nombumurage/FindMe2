package com.example.findus.findme;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment  implements View.OnClickListener{
    @Bind(R.id.header_cover_image) ImageView mLogoImage;
    @Bind(R.id.user_profile_photo) ImageView mUserProfilePhoto;
    @Bind(R.id.editProfile) ImageView mEditProfile;
    @Bind(R.id.user_profile_name) TextView mUserName;
    @Bind(R.id.bloodTypeField) TextView mBloodTypeField;
    @Bind(R.id.bloodType) TextView mBloodType;
    @Bind(R.id.genderField) TextView mGenderField;
    @Bind(R.id.gender) TextView mGender;
    @Bind(R.id.emergencyContact) TextView mEmergencyContactFiled;
    @Bind(R.id.emergencyContact1) TextView mEmergencyContactOne;
    @Bind(R.id.emergencyContact1phone) TextView mEmergencyContactOnePhone;
    @Bind(R.id.userPhoneIcon) ImageView mUserPhoneIcon;
    @Bind(R.id.userPhoneIcon2) ImageView mUserPhoneICon1;
    @Bind(R.id.userPhoneIcon3) ImageView mUserPhoneICon2;
    @Bind(R.id.emergencyContact2) TextView mEmergencyContactTwo;
    @Bind(R.id.emergencyContact2phone) TextView mEmergencyContactTwoPhone;
    @Bind(R.id.emergencyContact3) TextView mEmergencyContactThree;
    @Bind(R.id.emergencyContact3phone) TextView mEmergencyContactThreePhone;
    @Bind(R.id.conditions) TextView mConditions;
    @Bind(R.id.listConditions) ListView mConditionsList;
    @Bind(R.id.medicalAllergies) TextView mMedicalAllergies;
    @Bind(R.id.listMedicalAllergies)ListView mListMedicalAllergies;
    @Bind(R.id.otherAllergies) TextView mOtherAllergies;
    @Bind(R.id.listotherAllergies) ListView mlistOtherAllergies;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        // Inflate the layout for this fragment

        ButterKnife.bind(this,view);

        mUserProfilePhoto.setOnClickListener(this);
        mEditProfile.setOnClickListener(this);
        mEmergencyContactOnePhone.setOnClickListener(this);
        mUserPhoneIcon.setOnClickListener(this);
        mUserPhoneICon1.setOnClickListener(this);
        mUserPhoneICon2.setOnClickListener(this);
        mEmergencyContactTwoPhone.setOnClickListener(this);
        mEmergencyContactThreePhone.setOnClickListener(this);


        return view;

    }

    @Override
    public void onClick(View v){

    }

}
