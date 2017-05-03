package com.example.findus.findme;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.findus.findme.firstAidDetail.ChockingAidFragment;
import com.example.findus.findme.firstAidDetail.DrowningAidFragment;
import com.example.findus.findme.firstAidDetail.FaintingFragment;
import com.example.findus.findme.firstAidDetail.FireBurnsFragment;
import com.example.findus.findme.firstAidDetail.JointsAidFragment;
import com.example.findus.findme.firstAidDetail.NoseBleedingFragment;
import com.example.findus.findme.firstAidDetail.OpenWoundsFragment;
import com.example.findus.findme.firstAidDetail.SuffocationAidFragment;
import com.example.findus.findme.firstAidDetail.VomitingAidFragment;

public class FirstAidDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid_detail);

        Bundle extras = getIntent().getExtras();
        int i = (int) extras.get("key");
//
//        Toast.makeText(FirstAidDetailActivity.this, ">> "+i,Toast.LENGTH_SHORT).show();

        Fragment fragment = null;
        Class fragmentClass = null;

        if (i == 0 ) {
            fragmentClass = NoseBleedingFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (i == 1 ) {
            fragmentClass = FaintingFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (i == 2 ) {
            fragmentClass = FireBurnsFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (i == 3 ) {
            fragmentClass = SuffocationAidFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (i == 4 ) {
            fragmentClass = ChockingAidFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (i == 5 ) {
            fragmentClass = DrowningAidFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (i == 6 ) {
            fragmentClass = OpenWoundsFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (i == 7 ) {
            fragmentClass = VomitingAidFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (i == 8 ) {
            fragmentClass = JointsAidFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.firstAidFrame, fragment).commit();
    }
}
