package com.example.findus.findme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FirstAidActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.nose_bleeding)
    CardView mNoseBleeding;
    @Bind(R.id.fainting)
    CardView mFainting;
    @Bind(R.id.fire_burns)
    CardView mFireBurns;
    @Bind(R.id.suffocation)
    CardView mSuffocation;
    @Bind(R.id.choking)
    CardView mChoking;
    @Bind(R.id.drowning)
    CardView mDrowning;
    @Bind(R.id.open_wounds)
    CardView mOpenWounds;
    @Bind(R.id.vomiting)
    CardView mVomiting;
    @Bind(R.id.joints)
    CardView mJoints;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);
        ButterKnife.bind(this);

        mNoseBleeding.setOnClickListener(this);
        mChoking.setOnClickListener(this);
        mDrowning.setOnClickListener(this);
        mFainting.setOnClickListener(this);
        mFireBurns.setOnClickListener(this);
        mSuffocation.setOnClickListener(this);
        mOpenWounds.setOnClickListener(this);
        mVomiting.setOnClickListener(this);
        mJoints.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mNoseBleeding) {
            Intent aidIntent = new Intent(this, FirstAidDetailActivity.class);
            aidIntent.putExtra("key", 0);
            startActivity(aidIntent);

        } else if (v == mFainting) {
            Intent aidIntent = new Intent(this, FirstAidDetailActivity.class);
            aidIntent.putExtra("key", 1);
            startActivity(aidIntent);

        } else if (v == mFireBurns) {
            Intent aidIntent = new Intent(this, FirstAidDetailActivity.class);
            aidIntent.putExtra("key", 2);
            startActivity(aidIntent);

        } else if (v == mSuffocation) {
            Intent aidIntent = new Intent(this, FirstAidDetailActivity.class);
            aidIntent.putExtra("key", 3);
            startActivity(aidIntent);


        } else if (v == mChoking) {
            Intent aidIntent = new Intent(this, FirstAidDetailActivity.class);
            aidIntent.putExtra("key", 4);
            startActivity(aidIntent);

        } else if (v == mDrowning) {
            Intent aidIntent = new Intent(this, FirstAidDetailActivity.class);
            aidIntent.putExtra("key", 5);
            startActivity(aidIntent);

        } else if (v == mOpenWounds) {
            Intent aidIntent = new Intent(this, FirstAidDetailActivity.class);
            aidIntent.putExtra("key", 6);
            startActivity(aidIntent);

        } else if (v == mVomiting) {
            Intent aidIntent = new Intent(this, FirstAidDetailActivity.class);
            aidIntent.putExtra("key", 7);
            startActivity(aidIntent);

        } else if (v== mJoints) {
            Intent aidIntent = new Intent(this, FirstAidDetailActivity.class);
            aidIntent.putExtra("key", 8);
            startActivity(aidIntent);
        }

    }
}