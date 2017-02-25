package com.example.trishlapokharna.scoutingtakethree;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class AutoRanking extends Fragment {
    RoboInfo myRobo = RoboInfo.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View in = inflater.inflate(R.layout.fragment_auto_ranking, container, false);

        TableLayout tl1 = (TableLayout) in.findViewById(R.id.tl1);
        TableLayout tl2 = (TableLayout) in.findViewById(R.id.tl2);
        TableLayout tl3 = (TableLayout) in.findViewById(R.id.tl3);
        TableLayout tl4 = (TableLayout) in.findViewById(R.id.tl4);

        try {

            String path1 = "/sdcard/Rankings/Cross Baseline Ratio.txt";
            String path2 = "/sdcard/Rankings/Auto Gears Ratio.txt";
            String path3 = "/sdcard/Rankings/Auto High Goal Total.txt";
            String path4 = "/sdcard/Rankings/Auto Low Goal Total.txt";


            File f1 = new File(path1);
            File f2 = new File(path2);
            File f3 = new File(path3);
            File f4 = new File(path4);

            if (!f1.exists()) {
                Toast.makeText(getActivity(), "File does not exist!", Toast.LENGTH_SHORT).show();
            } else {
                BufferedReader reader1 = new BufferedReader(new FileReader(f1));
                String line;

                while ((line = reader1.readLine()) != null) {

                    TableRow tr = new TableRow(this.getActivity());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams
                            (TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);

                    TextView tv1 = new TextView(this.getActivity());
                    tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                    tv1.setPadding(0, 5, 0, 5);
                    tv1.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);

                    tv1.setText(line);
                    String[] values = line.split(":");
                    final String string = values[0];

                    tv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String s = string;
                            myRobo.setSingleTeam(s);
                            Class fragmentClass = DisplaySingleTeam.class;
                            Fragment fragment = null;
                            try {
                                fragment = (Fragment) fragmentClass.newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.wheretheshitgoes, fragment).commit();
                        }
                    });

                    tr.addView(tv1);
                    tl1.addView(tr, layoutParams);
                }
            }

            if (!f2.exists()) {
                Toast.makeText(getActivity(), "File does not exist!", Toast.LENGTH_SHORT).show();
            } else {
                BufferedReader reader1 = new BufferedReader(new FileReader(f2));
                String line;

                while ((line = reader1.readLine()) != null) {

                    TableRow tr = new TableRow(this.getActivity());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams
                            (TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);

                    TextView tv1 = new TextView(this.getActivity());
                    tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                    tv1.setPadding(0, 5, 0, 5);
                    tv1.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);

                    tv1.setText(line);
                    String[] values = line.split(":");
                    final String string = values[0];

                    tv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String s = string;
                            myRobo.setSingleTeam(s);
                            Class fragmentClass = DisplaySingleTeam.class;
                            Fragment fragment = null;
                            try {
                                fragment = (Fragment) fragmentClass.newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.wheretheshitgoes, fragment).commit();
                        }
                    });

                    tr.addView(tv1);
                    tl2.addView(tr, layoutParams);
                }
            }

            if (!f3.exists()) {
                Toast.makeText(getActivity(), "File does not exist!", Toast.LENGTH_SHORT).show();
            } else {
                BufferedReader reader1 = new BufferedReader(new FileReader(f3));
                String line;

                while ((line = reader1.readLine()) != null) {

                    TableRow tr = new TableRow(this.getActivity());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams
                            (TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);

                    TextView tv1 = new TextView(this.getActivity());
                    tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                    tv1.setPadding(0, 5, 0, 5);
                    tv1.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);

                    tv1.setText(line);
                    String[] values = line.split(":");
                    final String string = values[0];

                    tv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String s = string;
                            myRobo.setSingleTeam(s);
                            Class fragmentClass = DisplaySingleTeam.class;
                            Fragment fragment = null;
                            try {
                                fragment = (Fragment) fragmentClass.newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.wheretheshitgoes, fragment).commit();
                        }
                    });

                    tr.addView(tv1);
                    tl3.addView(tr, layoutParams);
                }
            }

            if (!f4.exists()) {
                Toast.makeText(getActivity(), "File does not exist!", Toast.LENGTH_SHORT).show();
            } else {
                BufferedReader reader1 = new BufferedReader(new FileReader(f4));
                String line;

                while ((line = reader1.readLine()) != null) {

                    TableRow tr = new TableRow(this.getActivity());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams
                            (TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);

                    TextView tv1 = new TextView(this.getActivity());
                    tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                    tv1.setPadding(0, 5, 0, 5);
                    tv1.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);

                    tv1.setText(line);
                    String[] values = line.split(":");
                    final String string = values[0];

                    tv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String s = string;
                            myRobo.setSingleTeam(s);
                            Class fragmentClass = DisplaySingleTeam.class;
                            Fragment fragment = null;
                            try {
                                fragment = (Fragment) fragmentClass.newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.wheretheshitgoes, fragment).commit();
                        }
                    });

                    tr.addView(tv1);
                    tl4.addView(tr, layoutParams);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
            Log.d("file error", "" + e.getMessage());
        }

        return in;
    }


}
