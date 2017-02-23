package com.example.trishlapokharna.scoutingtakethree;


import android.os.Bundle;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View in = inflater.inflate(R.layout.fragment_display_match_list, container, false);

        lv = (ListView) in.findViewById(R.id.listallmatches);
        ArrayList<String> matches = new ArrayList<String>();


        File file = new File("/sdcard/TeamsMatches");
        File[] list = file.listFiles();

        for (File f : list) {
            Log.d("TAG1", f.getName());
        }
        int maxMatchNum = 0;
        if (list != null) {
                for (File f : list) {
                    Log.d("TAG", f.getName());
                    if (!file.getName().equals(".DS_Store")) {

                        int beg = f.getName().lastIndexOf('_') + 1;
                        int end = f.getName().lastIndexOf('.');

                        int n = Integer.parseInt(f.getName().substring(beg, end));

                        if (n > maxMatchNum) {
                            maxMatchNum = n;
                            Log.d("TAG", Integer.toString(n));

                        }
                    }
            }
        }

        int counter = 1;

        while (counter < maxMatchNum) {
            for (File f : list) {
                int beg = f.getName().lastIndexOf('_')+1;
                int end = f.getName().lastIndexOf('.');
                int n = Integer.parseInt(f.getName().substring(beg, end));
                if(counter == n) {
                    matches.add("Match " + n + ": " + f.getName().substring(0, beg - 1));
                }
            }
            counter++;
        }
        for (String s : matches) {
            Log.d("TAGg", s);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, matches);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //get text from list
                String entry = (String) parent.getAdapter().getItem(position);
                String[] string = entry.split(":");

                myRobo.setMatchNumber(string[0].substring(6));
                myRobo.setSingleTeam(string[1].substring(1));

                Class fragmentClass = DisplaySingleMatch.class;
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

        return in;
    }


}
