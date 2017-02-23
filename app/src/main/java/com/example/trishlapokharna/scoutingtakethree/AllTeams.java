package com.example.trishlapokharna.scoutingtakethree;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllTeams extends Fragment {

    RoboInfo myRobo = RoboInfo.getInstance();
    ListView lv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.fragment_all_teams, container, false);

        lv = (ListView) in.findViewById(R.id.listallteams);
        String[] names = getResources().getStringArray(R.array.RobotNumbers);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this.getActivity(),
                android.R.layout.simple_list_item_1,names
        );

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //get text from list
                String entry = (String) parent.getAdapter().getItem(position);
                myRobo.setSingleTeam(entry);

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
        return in;
    }

}
