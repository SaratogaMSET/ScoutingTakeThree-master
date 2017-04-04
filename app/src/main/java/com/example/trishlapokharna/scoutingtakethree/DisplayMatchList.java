package com.example.trishlapokharna.scoutingtakethree;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayMatchList extends Fragment {

    RoboInfo myRobo = RoboInfo.getInstance();
    ListView lv;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View in = inflater.inflate(R.layout.fragment_display_match_list, container, false);

        lv = (ListView) in.findViewById(R.id.listallmatches);
        ArrayList<String> matches = new ArrayList<String>();

        verifyStoragePermissions(this.getActivity());

        File file = new File("/sdcard/TeamsMatches/");
        File[] list = file.listFiles();
        int maxMatchNum = 0;
        if (list != null) {
            for (File f : list) {
                Log.d("TAG", f.getName());
                if (!f.getName().equals(".DS_Store") && f.getName().indexOf('_') != -1) {
                    int beg = f.getName().lastIndexOf('_') + 1;
                    int end = f.getName().lastIndexOf('.');
                    int n = Integer.parseInt(f.getName().substring(beg, end));

                    if (n > maxMatchNum) {
                        maxMatchNum = n;
                        Log.d("TAG1", Integer.toString(n));
                    }
                }
            }
        }

        int counter = 1;

        while (counter <= maxMatchNum) {
            for (File f : list) {
                if (!f.getName().equals(".DS_Store") && f.getName().indexOf('_') != -1) {
                    int beg = f.getName().lastIndexOf('_') + 1;
                    int end = f.getName().lastIndexOf('.');
                    int n = Integer.parseInt(f.getName().substring(beg, end));
                    Log.d("TAG2", Integer.toString(n));
                    Log.d("TAG3", Integer.toString(counter));
                    if (counter == n) {
                        Log.d("TAG4", f.getName());
                        matches.add("Match " + n + ": " + f.getName().substring(0, beg - 1));
                    }
                }
            }
            counter++;
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this.getActivity(), android.R.layout.simple_list_item_1,matches
        );

        lv.setAdapter(arrayAdapter);
        final Intent intent = new Intent(this.getActivity(), DisplaySingleMatchNew.class);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //get text from list
                String entry = (String) parent.getAdapter().getItem(position);
                String[] string = entry.split(":");

                myRobo.setMatchNumber(string[0].substring(6));
                myRobo.setSingleTeam(string[1].substring(1));

                startActivity(intent);

            }
        });

        return in;
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}