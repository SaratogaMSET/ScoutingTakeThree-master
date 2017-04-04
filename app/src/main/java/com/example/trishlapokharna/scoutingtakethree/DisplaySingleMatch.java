package com.example.trishlapokharna.scoutingtakethree;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class DisplaySingleMatch extends Fragment {


    RoboInfo myRobo = RoboInfo.getInstance();

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.fragment_display_single_match, container, false);

        TableLayout tl = (TableLayout) in.findViewById(R.id.tablelayoutsinglematch);
        TextView name = (TextView) in.findViewById(R.id.matchnumberteamname);

        try {
            verifyStoragePermissions(this.getActivity());

            String yourFilePath = "/sdcard/TeamsMatches/" + myRobo.getSingleTeam() + "_"
                    + myRobo.getMatchNumber() + ".txt";
            name.setText(myRobo.getSingleTeam() + " - Match " + myRobo.getMatchNumber());

            File yourFile = new File(yourFilePath);
            if (!yourFile.exists()) {
                Toast.makeText(getActivity(), "File does not exist!", Toast.LENGTH_SHORT).show();
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(yourFile));
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] values = line.split(",");

                    TableRow tr = new TableRow(this.getActivity());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams
                            (TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);

                    TextView tv1 = new TextView(this.getActivity());
                    tv1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 0.65f));
                    tv1.setPadding(0, 5, 20, 5);
                    tv1.setText(values[0]);

                    TextView tv2 = new TextView(this.getActivity());
                    tv2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 0.35f));
                    tv2.setPadding(30, 5, 5, 5);
                    tv2.setText(values[1]);

                    tr.addView(tv1);
                    tr.addView(tv2);
                    tl.addView(tr, layoutParams);
                }
            }
        }catch(IOException e) {
            e.printStackTrace();
            Log.d("file error", "" + e.getMessage());
        }
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
