package com.example.findus.findme;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeScreenProfile extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.header_cover_image)
    ImageView mUserProfilePhoto;
    @Bind(R.id.user_profile_name)
    TextView mUserName;
    @Bind(R.id.bloodType)
    TextView mBloodType;
    @Bind(R.id.gender)
    TextView mGender;
    @Bind(R.id.emergencyContact1)
    TextView mEmergencyContactOne;
    @Bind(R.id.emergencyContact1phone)
    TextView mEmergencyContactOnePhone;
    @Bind(R.id.userPhoneIcon)
    ImageView mUserPhoneIcon;
    @Bind(R.id.userPhoneIcon2)
    ImageView mUserPhoneICon1;
    @Bind(R.id.userPhoneIcon3)
    ImageView mUserPhoneICon2;
    @Bind(R.id.emergencyContact2)
    TextView mEmergencyContactTwo;
    @Bind(R.id.emergencyContact2phone)
    TextView mEmergencyContactTwoPhone;
    @Bind(R.id.emergencyContact3)
    TextView mEmergencyContactThree;
    @Bind(R.id.emergencyContact3phone)
    TextView mEmergencyContactThreePhone;
    @Bind(R.id.listConditions)
    TextView mConditionsList;
    @Bind(R.id.listMedicalAllergies)
    TextView mListMedicalAllergies;
    @Bind(R.id.listotherAllergies)
    TextView mlistOtherAllergies;
    @Bind(R.id.userNationalId)
    TextView mNationalId;
    @Bind(R.id.insurancePolicyNo)
    TextView mPolicyNo;
    @Bind(R.id.userMedCover)
    TextView mMedCover;
    @Bind(R.id.userPrefHospital)
    TextView mPrefHospital;
    @Bind(R.id.userAge)
    TextView mUserAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_profile);


        ButterKnife.bind(this);

        mEmergencyContactOnePhone.setOnClickListener(this);
        mUserPhoneIcon.setOnClickListener(this);
        mUserPhoneICon1.setOnClickListener(this);
        mUserPhoneICon2.setOnClickListener(this);
        mEmergencyContactTwoPhone.setOnClickListener(this);
        mEmergencyContactThreePhone.setOnClickListener(this);

        getProfileData();
    }

    @Override
    public void onClick(View v) {


        if (v == mEmergencyContactOnePhone) {
            getProfileData();
            String dataPhoneNumberOne = mEmergencyContactOnePhone.getText().toString();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:=" + dataPhoneNumberOne));
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(intent);

            }
            if (v == mUserPhoneIcon) {
                getProfileData();
                String dataPhoneNumberOne = mEmergencyContactOnePhone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:=" + dataPhoneNumberOne));
                startActivity(intent);
            }

            if (v == mEmergencyContactTwoPhone) {
                getProfileData();
                String dataPhoneNumberTwo = mEmergencyContactTwoPhone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:=" + dataPhoneNumberTwo));
                startActivity(intent);
            }
            if (v == mUserPhoneICon1) {
                getProfileData();
                String dataPhoneNumberTwo = mEmergencyContactTwoPhone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:=" + dataPhoneNumberTwo));
                startActivity(intent);
            }

            if (v == mEmergencyContactThreePhone) {
                getProfileData();
                String dataPhoneNumberThree = mEmergencyContactThreePhone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:=" + dataPhoneNumberThree));
                startActivity(intent);
            }
            if (v == mUserPhoneICon1) {
                getProfileData();
                String dataPhoneNumberThree = mEmergencyContactThreePhone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:=" + dataPhoneNumberThree));
                startActivity(intent);
            }


        }

    public void getProfileData() {
        FirebaseUser users = FirebaseAuth.getInstance().getCurrentUser();
        String uid = users.getUid();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user").child(uid);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //emergency contact model
                String person1 = dataSnapshot.child("emergencyContacts").child("emergencyContactNameOne").getValue().toString();
                String person1Cont = dataSnapshot.child("emergencyContacts").child("emergencyContactNumberOne").getValue().toString();
                String person2 = dataSnapshot.child("emergencyContacts").child("emergencyContactNameTwo").getValue().toString();
                String person2Cont = dataSnapshot.child("emergencyContacts").child("emergencyContactNumberTwo").getValue().toString();
                String person3 = dataSnapshot.child("emergencyContacts").child("emergencyContactNameThree").getValue().toString();
                String person3Cont = dataSnapshot.child("emergencyContacts").child("emergencyContactNumberThree").getValue().toString();
                mEmergencyContactOne.setText(person1);
                mEmergencyContactOnePhone.setText(person1Cont);
                mEmergencyContactTwo.setText(person2);
                mEmergencyContactTwoPhone.setText(person2Cont);
                mEmergencyContactThree.setText(person3);
                mEmergencyContactThreePhone.setText(person3Cont);

                // medical detail model

                String age = dataSnapshot.child("medicalDetails").child("age").getValue().toString();
                String condition = dataSnapshot.child("medicalDetails").child("condition").getValue().toString();
                String medAllergies = dataSnapshot.child("medicalDetails").child("medAllergies").getValue().toString();
                String name = dataSnapshot.child("medicalDetails").child("name").getValue().toString();
                String phoneNumber = dataSnapshot.child("medicalDetails").child("phoneNumber").getValue().toString();
                String otherAllegies = dataSnapshot.child("medicalDetails").child("userAllergies").getValue().toString();
                String gender = dataSnapshot.child("medicalDetails").child("gender").getValue().toString();
                String bloodType = dataSnapshot.child("medicalDetails").child("bloodGroup").getValue().toString();

                mUserAge.setText(age);
                mConditionsList.setText(condition);
                mListMedicalAllergies.setText(medAllergies);
                mUserName.setText(name);
                mlistOtherAllergies.setText(otherAllegies);
                mGender.setText(gender);
                mBloodType.setText(bloodType);

                //insurance model

                String medCover = dataSnapshot.child("insuranceDetails").child("medCover").getValue().toString();
                String natId = dataSnapshot.child("insuranceDetails").child("natId").getValue().toString();
                String policyNumber = dataSnapshot.child("insuranceDetails").child("policyNumber").getValue().toString();
                String prefHospital = dataSnapshot.child("insuranceDetails").child("prefHospital").getValue().toString();

                mNationalId.setText(natId);
                mPolicyNo.setText(policyNumber);
                mMedCover.setText(medCover);
                mPrefHospital.setText(prefHospital);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
