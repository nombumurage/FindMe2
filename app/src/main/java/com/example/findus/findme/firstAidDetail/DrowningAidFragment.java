package com.example.findus.findme.firstAidDetail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.findus.findme.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrowningAidFragment extends Fragment {


    public DrowningAidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drowning_aid, container, false);
    }

}
