package com.example.findus.findme;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findus.findme.models.EmergencyContacts;
import com.example.findus.findme.models.InsuranceDetails;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment  implements View.OnClickListener {

    private static final String TAG = ProfileFragment.class.getSimpleName();

    @Bind(R.id.header_cover_image)
    ImageView mLogoImage;
    @Bind(R.id.user_profile_photo)
    ImageButton mUserProfilePhoto;
    @Bind(R.id.editProfile)
    ImageView mEditProfile;
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
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_profile, container, false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this, view);

        mUserProfilePhoto.setOnClickListener(this);
        mEditProfile.setOnClickListener(this);
        mEmergencyContactOnePhone.setOnClickListener(this);
        mUserPhoneIcon.setOnClickListener(this);
        mUserPhoneICon1.setOnClickListener(this);
        mUserPhoneICon2.setOnClickListener(this);
        mEmergencyContactTwoPhone.setOnClickListener(this);
        mEmergencyContactThreePhone.setOnClickListener(this);

        getProfileData();


        return view;

    }

    @Override
    public void onClick(View v) {

    }

    public void getProfileData() {
        FirebaseUser users = FirebaseAuth.getInstance().getCurrentUser();
        String uid = users.getUid();

        Toast.makeText(getActivity(), uid, Toast.LENGTH_SHORT).show();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user").child(uid);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                EmergencyContacts emgContacts = new EmergencyContacts(dataSnapshot.child("emergencyContacts"));

//                EmergencyContacts emgContacts = dataSnapshot.getChildrenCount().getValue(EmergencyContacts.class);
                ArrayList<String> arr = new ArrayList<String>();
                String i = dataSnapshot.child("emergencyContacts").getValue().toString();

                Log.d(TAG, ">>> " + i);

//
//                mEmergencyContactOne.setText( emgContacts.getEmergencyContactNameOne());
//                mEmergencyContactOnePhone.setText( emgContacts.getEmergencyContactNumberOne());
//                mEmergencyContactTwo.setText( emgContacts.getEmergencyContactNameTwo());
//                mEmergencyContactTwoPhone.setText( emgContacts.getEmergencyContactNumberTwo());
//                mEmergencyContactThree.setText( emgContacts.getEmergencyContactNameThree());
//                mEmergencyContactThreePhone.setText( emgContacts.getEmergencyContactNameThree());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        reference.addValueEventListener(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                    EmergencyContacts emgContacts = dataSnapshot.child("emergencyContacts").getValue(EmergencyContacts.class);
//
//                Log.d("log this statement",emgContacts.getEmergencyContactNameOne());
//                mEmergencyContactOne.setText( emgContacts.getEmergencyContactNameOne());
//                mEmergencyContactOnePhone.setText( emgContacts.getEmergencyContactNumberOne());
//                mEmergencyContactTwo.setText( emgContacts.getEmergencyContactNameTwo());
//                mEmergencyContactTwoPhone.setText( emgContacts.getEmergencyContactNumberTwo());
//                mEmergencyContactThree.setText( emgContacts.getEmergencyContactNameThree());
//                mEmergencyContactThreePhone.setText( emgContacts.getEmergencyContactNameThree());
//
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                //System.out.println("The read failed: " + databaseError.getCode());
//            }
//        });
//    }

    }
}
