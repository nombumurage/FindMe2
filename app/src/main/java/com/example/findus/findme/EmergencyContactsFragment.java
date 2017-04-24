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

import com.example.findus.findme.models.EmergencyContacts;
import com.example.findus.findme.models.medicalDetails;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmergencyContactsFragment extends Fragment  implements  View.OnClickListener{
    @Bind(R.id.emergencyContact) EditText mEmergencyContactName;
    @Bind(R.id.emergencyNumber) EditText mEmergencyNumber;
    @Bind(R.id.emergencyContactAddBtn) Button mEmergencyAdd;
    @Bind(R.id.emergencyContactBtn) Button mEmergencyContactBtn;


    public EmergencyContactsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEmergencyAdd.setOnClickListener(this);
        mEmergencyContactBtn.setOnClickListener(this);


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
        if(v ==mEmergencyAdd){

            saveToFirebase();
        }

        if(v==mEmergencyContactBtn){

            mEmergencyNumber.setVisibility(View.INVISIBLE);
            mEmergencyContactName.setVisibility(View.INVISIBLE);

            saveToFirebase();
        }


    }

    public void saveToFirebase(){

        String emergencyContactName = mEmergencyContactName.getText().toString();
        String emergencyContactNumber = mEmergencyNumber.getText().toString();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("phoneNumber");

        EmergencyContacts emergencyContact = new EmergencyContacts (emergencyContactName,emergencyContactNumber);

        reference.child("emergencyContacts").setValue(emergencyContact);

        Toast.makeText(getActivity(), " Details Saved", Toast.LENGTH_SHORT).show();
    }

}
