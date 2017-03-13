package com.example.trishlapokharna.scoutingtakethree;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

//part 1 of input activity
public class Autonomous extends Fragment{

    RoboInfo myRobo = RoboInfo.getInstance();

    ImageButton gearHelp;
    ImageButton gearPosHelp;
    ImageButton highHelp;
    ImageButton lowHelp;

    static EditText matchText;
    static EditText teamText;
    static EditText scouterText;

    static ToggleButton far;
    static ToggleButton mid;
    static ToggleButton boil;

    Button far2;
    Button mid2;
    Button boil2;
    Button del2;
    static TextView gearPos;
    static List <String> time = new ArrayList <String> ();

    static ToggleButton baselineButton;

    static TextView gearView;
    Button gearHitButton;
    Button gearMissButton;
    Button gearBackButton;

    static TextView highGoalView;
    Button highGoalOneButton;
    Button highGoalFiveButton;
    Button highGoalTenButton;
    Button highGoalTwentyButton;
    Button highGoalDelButton;

    static TextView lowGoalView;
    Button lowGoalOneButton;
    Button lowGoalFiveButton;
    Button lowGoalTenButton;
    Button lowGoalTwentyButton;
    Button lowGoalDelButton;

    int i;
    int j;
    static List<Integer> instanceHigh = new ArrayList<Integer>();
    static List<Integer> instanceLow = new ArrayList<Integer>();

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.fragment_autonomous, container, false); // adds Autonomous tab to input activity

        gearHelp = (ImageButton)in.findViewById(R.id.gearButtonImageButton);
        gearPosHelp = (ImageButton)in.findViewById(R.id.gearPositionImageButton);
        highHelp = (ImageButton)in.findViewById(R.id.highImageButton);
        lowHelp = (ImageButton)in.findViewById(R.id.lowImageButton);

        matchText = (EditText)in.findViewById(R.id.matchText);
        teamText = (EditText)in.findViewById(R.id.teamText);
        scouterText = (EditText)in.findViewById(R.id.scouterText);


        far = (ToggleButton) in.findViewById(R.id.farToggle);
        mid = (ToggleButton) in.findViewById(R.id.middleToggle);
        boil = (ToggleButton) in.findViewById(R.id.broilerToggle);


        far.setOnCheckedChangeListener(changeChecker);
        mid.setOnCheckedChangeListener(changeChecker);
        boil.setOnCheckedChangeListener(changeChecker);

        far2 = (Button) in.findViewById(R.id.closeButton);
        mid2 = (Button) in.findViewById(R.id.middleButton);
        boil2 = (Button) in.findViewById(R.id.boilButton);
        del2 = (Button) in.findViewById(R.id.DelButton);
        gearPos = (TextView) in.findViewById(R.id.gearCycleView);

        baselineButton = (ToggleButton) in.findViewById(R.id.baselineToggleButton);

        gearView = (TextView) in.findViewById(R.id.gearView);
        gearHitButton = (Button) in.findViewById(R.id.gearHitButton);
        gearMissButton = (Button) in.findViewById(R.id.gearMissButton);
        gearBackButton = (Button) in.findViewById(R.id.gearBackButton);

        highGoalView = (TextView) in.findViewById (R.id.highGoalView);
        highGoalOneButton = (Button) in.findViewById(R.id.highGoalOneButton);
        highGoalFiveButton = (Button) in.findViewById(R.id.highGoalFiveButton);
        highGoalTenButton = (Button) in.findViewById(R.id.highGoalTenButton);
        highGoalTwentyButton = (Button) in.findViewById(R.id.highGoalTwentyButton);
        highGoalDelButton = (Button) in.findViewById(R.id.highGoalDelButton);

        lowGoalView = (TextView) in.findViewById (R.id.lowGoalView);
        lowGoalOneButton = (Button) in.findViewById(R.id.lowGoalOneButton);
        lowGoalFiveButton = (Button) in.findViewById(R.id.lowGoalFiveButton);
        lowGoalTenButton = (Button) in.findViewById(R.id.lowGoalTenButton);
        lowGoalTwentyButton = (Button) in.findViewById(R.id.lowGoalTwentyButton);
        lowGoalDelButton = (Button) in.findViewById(R.id.lowGoalDelButton);

        gearHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Click '1' when the robot successfully installs a gear. " +
                        "Click '0' when the robot unsuccessfully tries to install a gear. " +
                        "Click 'Back' to delete the last input.", Toast.LENGTH_LONG).show();
            }
        });

        gearPosHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Enter a position for each '1' or '0' entered above.", Toast.LENGTH_LONG).show();
            }
        });

        highHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Enter the approximate number of balls (fuel) the robot scores.", Toast.LENGTH_LONG).show();
            }
        });

        lowHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Enter the approximate number of balls (fuel) the robot scores.", Toast.LENGTH_LONG).show();
            }
        });

        matchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                String  str = matchText.getText().toString();
                myRobo.setMatchT(str);
            }
        });


        teamText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                String  str = teamText.getText().toString();
                myRobo.setTeamT(str);
            }
        });

        scouterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                String  str = scouterText.getText().toString();
                myRobo.setScouterT(str);
            }
        });

        //gear buttons
        gearHitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearView.append("1 ");
            }
        });

        gearMissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearView.append("0 ");
            }
        });

        gearBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gearView.getText().length() > 0) {
                    gearView.setText(gearView.getText().subSequence(0, gearView.getText().length() - 2));
                }
            }
        });

        //high goal buttons
        highGoalOneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i = Integer.parseInt(highGoalView.getText().toString()) + 1;
                highGoalView.setText(String.valueOf(i));
                instanceHigh.add(i);
            }
        });

        highGoalFiveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i = Integer.parseInt(highGoalView.getText().toString()) + 5;
                highGoalView.setText(String.valueOf(i));
                instanceHigh.add(i);
            }
        });

        highGoalTenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i = Integer.parseInt(highGoalView.getText().toString()) + 10;
                highGoalView.setText(String.valueOf(i));
                instanceHigh.add(i);
            }
        });

        highGoalTwentyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i = Integer.parseInt(highGoalView.getText().toString()) + 20;
                highGoalView.setText(String.valueOf(i));
                instanceHigh.add(i);
            }
        });

        highGoalDelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (instanceHigh.size() > 1 ) {
                    instanceHigh.remove(instanceHigh.size() - 1);
                    i = instanceHigh.get(instanceHigh.size() - 1);
                    highGoalView.setText(String.valueOf(i));
                }



                if (instanceHigh.size() <= 1){
                    instanceHigh.clear();
                    i = 0;
                    highGoalView.setText(String.valueOf(i));
                }
            }
        });

        //low goal buttons
        lowGoalOneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j = Integer.parseInt(lowGoalView.getText().toString()) + 1;
                lowGoalView.setText(String.valueOf(j));
                instanceLow.add(j);
            }
        });

        lowGoalFiveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j = Integer.parseInt(lowGoalView.getText().toString()) + 5;
                lowGoalView.setText(String.valueOf(j));
                instanceLow.add(j);
            }
        });

        lowGoalTenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j = Integer.parseInt(lowGoalView.getText().toString()) + 10;
                lowGoalView.setText(String.valueOf(j));
                instanceLow.add(j);
            }
        });

        lowGoalTwentyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j = Integer.parseInt(lowGoalView.getText().toString()) + 20;
                lowGoalView.setText(String.valueOf(j));
                instanceLow.add(j);
            }
        });

        lowGoalDelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (instanceLow.size()> 1) {
                    instanceLow.remove(instanceLow.size() - 1);
                    j = instanceLow.get(instanceLow.size() - 1);
                    lowGoalView.setText(String.valueOf(j));
                }
                if (instanceLow.size() <= 1){
                    instanceLow.clear();
                    j = 0;
                    lowGoalView.setText(String.valueOf(j));
                }
            }
        });

        far2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gearPos.getText().toString().equals("None")){
                    gearPos.setText("");
                }
                gearPos.append("Close      ");
                time.add("Close ");
            }
        });

        mid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gearPos.getText().toString().equals("None")){
                    gearPos.setText("");
                }
                gearPos.append("Middle     ");
                time.add("Middle ");

            }
        });

        boil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (gearPos.getText().toString().equals("None")){
                    gearPos.setText("");
                }
                gearPos.append("Boiler     ");
                time.add("Boiler ");
            }
        });





        del2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time.size() >= 1) {
                    gearPos.setText(gearPos.getText().subSequence(0, gearPos.getText().length() - 11));
                    time.remove(time.size()-1);
                }
                if (time.size()==0) {
                    gearPos.setText("None");
                }
            }
        });

        return in;
    }

    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView != far) {
                    far.setChecked(false);
                }
                if (buttonView != mid) {
                    mid.setChecked(false);
                }
                if (buttonView != boil) {
                    boil.setChecked(false);
                }

                if (buttonView == far) {
                    String str = "Close";
                    myRobo.setPosition(str);
                }
                else if (buttonView == mid) {
                    String str = "Middle";
                    myRobo.setPosition(str);
                }
                else if (buttonView == boil) {
                    String str = "Boiler";
                    myRobo.setPosition(str);
                }
            }
        }
    };




}
