package com.example.trishlapokharna.scoutingtakethree;


import android.content.Intent;
import android.os.Bundle;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class EndSecond extends Fragment {
    RoboInfo myRobo = RoboInfo.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View in = inflater.inflate(R.layout.fragment_end_second, container, false);

        TableLayout tl1 = (TableLayout) in.findViewById(R.id.tl1);
        TableLayout tl2 = (TableLayout) in.findViewById(R.id.tl2);


        try {

            String path1 = "/sdcard/Rankings/Average Total Pressure Per Game.txt";
            String path2 = "/sdcard/Rankings/Average Rotors Turning Per Game.txt";

            File f1 = new File(path1);
            File f2 = new File(path2);

            if (!f1.exists()) {
                Toast.makeText(getActivity(), "File does not exist!", Toast.LENGTH_SHORT).show();
            } else {
                BufferedReader reader1 = new BufferedReader(new FileReader(f1));
                String line;

                int num = 1;
                while ((line = reader1.readLine()) != null) {

                    TableRow tr = new TableRow(this.getActivity());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams
                            (TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);

                    TextView tv1 = new TextView(this.getActivity());
                    tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                    tv1.setPadding(0, 5, 0, 5);
                    tv1.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);

                    tv1.setText(num + ". " + line);
                    String[] values = line.split(":");
                    final String string = values[0];

                    tv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String s = string;
                            myRobo.setSingleTeam(s);
                            Intent intent = new Intent(getActivity(), RankingContainer.class);
                            intent.putExtra("fragmentNumber", 5);
                            startActivity(intent);
                        }
                    });

                    tr.addView(tv1);
                    tl1.addView(tr, layoutParams);
                    num++;
                }
            }

            if (!f2.exists()) {
                Toast.makeText(getActivity(), "File does not exist!", Toast.LENGTH_SHORT).show();
            } else {
                BufferedReader reader1 = new BufferedReader(new FileReader(f2));
                String line;

                int num = 1;
                while ((line = reader1.readLine()) != null) {

                    TableRow tr = new TableRow(this.getActivity());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams
                            (TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);

                    TextView tv1 = new TextView(this.getActivity());
                    tv1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                    tv1.setPadding(0, 5, 0, 5);
                    tv1.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);

                    tv1.setText(num + ". " + line);
                    String[] values = line.split(":");
                    final String string = values[0];

                    tv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String s = string;
                            myRobo.setSingleTeam(s);
                            Intent intent = new Intent(getActivity(), RankingContainer.class);
                            intent.putExtra("fragmentNumber", 5);
                            startActivity(intent);
                        }
                    });

                    tr.addView(tv1);
                    tl2.addView(tr, layoutParams);
                    num++;
                }
            }
        } catch(IOException e){
            e.printStackTrace();
            Log.d("file error", "" + e.getMessage());
        }
        return in;
    }

}