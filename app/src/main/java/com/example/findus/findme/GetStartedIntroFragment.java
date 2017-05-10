package com.example.findus.findme;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class GetStartedIntroFragment extends Fragment implements View.OnClickListener{
    private String vidUrl = "https://firebasestorage.googleapis.com/v0/b/findme-99505.appspot.com/o/20170510091022.mp4?alt=media&token=0a409b21-304f-41e4-a269-be2a5a4146a6";
    Uri uri = Uri.parse(vidUrl);

    @Bind(R.id.videoView)
    VideoView mVideoView;

    @Bind(R.id.btn_get_started) TextView mGetStarted;

    public GetStartedIntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_started_intro, container, false);
        ButterKnife.bind(this, view);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();

        mGetStarted.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        Class fragmentClass = null;

        if (v == mGetStarted){
            fragmentClass = MedicalDetailFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mainFrame, fragment).commit();
        }
    }
}
