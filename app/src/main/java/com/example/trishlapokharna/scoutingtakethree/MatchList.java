package com.example.trishlapokharna.scoutingtakethree;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MatchList extends Fragment {

    ImageView matchList;


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.fragment_match_list, container, false); // adds Autonomous tab to input activity

        matchList = (ImageView) in.findViewById(R.id.robopicture);
        matchList.setImageResource(R.drawable.les);

        return in;

    }
    }


