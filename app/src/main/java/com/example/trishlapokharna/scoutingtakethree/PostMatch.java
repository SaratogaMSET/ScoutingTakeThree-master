package com.example.trishlapokharna.scoutingtakethree;


/**
 * Results
 */

/**
 * Results
 */

import android.annotation.TargetApi;
import android.content.Intent;
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
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

//part 3 of input activity

public class PostMatch extends Fragment {
    static ToggleButton win;
    static ToggleButton lose;
    static ToggleButton tie;
    static ToggleButton no;
    static ToggleButton succeed;
    static ToggleButton yellowCardY;
    static ToggleButton yellowCardN;
    static ToggleButton red;

    boolean teamMatch = false;

    ImageButton notesHelp;
    ImageButton yellowHelp;
    ImageButton takeoffHelp;
    ImageButton resultsHelp;
    ImageButton redHelp;

    RoboInfo myRobo = RoboInfo.getInstance();
    ToggleButton pilot;

    Button submit;

    String match;
    View fromAuto;

    private RoboInfo postInfo = new RoboInfo();
    String matchT;
    String notesT;

    static EditText notesText;
    static EditText pilotText;
    static EditText penalty;
    static EditText pointsYellow;
    static ToggleButton reach;
    static EditText numPressure;
    static EditText totalPoints;
    static EditText rotors;
    static EditText rankingPoints;
    String pos = "";

    private RelativeLayout mLayout;


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.fragment_post_match, container, false); // adds PostMatch tab to input activity

        mLayout = (RelativeLayout) in.findViewById(R.id.relativeLayout);
        notesHelp = (ImageButton) in.findViewById(R.id.notesImageButton);
        redHelp = (ImageButton) in.findViewById(R.id.redImageButton);
        yellowHelp = (ImageButton) in.findViewById(R.id.yellowImageButton);
        takeoffHelp = (ImageButton) in.findViewById(R.id.takeoffImageButton);
        resultsHelp = (ImageButton) in.findViewById(R.id.resultsImageButton);

        penalty = (EditText) in.findViewById(R.id.penaltyEdit);
        notesText = (EditText) in.findViewById(R.id.notesEdit);
        pilotText = (EditText) in.findViewById(R.id.pilotEdit);
        reach = (ToggleButton) in.findViewById(R.id.reachToggle);
        numPressure = (EditText) in.findViewById(R.id.pressurerEdit);
        rotors = (EditText) in.findViewById(R.id.editRotors);
        totalPoints = (EditText) in.findViewById(R.id.totalPointsEdit);
        rankingPoints = (EditText) in.findViewById(R.id.rankingPointsEdit);

        win = (ToggleButton) in.findViewById(R.id.winToggle);
        lose = (ToggleButton) in.findViewById(R.id.loseToggle);
        tie = (ToggleButton) in.findViewById(R.id.tieToggle);

        win.setOnCheckedChangeListener(changeChecker);
        lose.setOnCheckedChangeListener(changeChecker);
        tie.setOnCheckedChangeListener(changeChecker);


        no = (ToggleButton) in.findViewById(R.id.noTakeToggle);
        succeed = (ToggleButton) in.findViewById(R.id.successTakeToggle);

        no.setOnCheckedChangeListener(changeChecker2);
        succeed.setOnCheckedChangeListener(changeChecker2);

        yellowCardY = (ToggleButton) in.findViewById(R.id.yellowToggle);
        yellowCardN = (ToggleButton) in.findViewById(R.id.noneToggle);
        red = (ToggleButton) in.findViewById(R.id.redToggle);

        yellowCardY.setOnCheckedChangeListener(changeChecker3);
        yellowCardN.setOnCheckedChangeListener(changeChecker3);
        red.setOnCheckedChangeListener(changeChecker3);





        notesHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Enter any additional information (For example: if the robot " +
                        "died, if the robot is especially good at something, if the robot fell apart, etc).", Toast.LENGTH_LONG).show();
            }
        });
        yellowHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Enter if your respective team received a yellow card", Toast.LENGTH_LONG).show();
            }
        });
        redHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Enter how many points were taken off for penalties.", Toast.LENGTH_LONG).show();
            }
        });

        takeoffHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Enter whether or not the robot climbed the rope successfully.", Toast.LENGTH_LONG).show();
            }
        });

        resultsHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Enter official results for the team.", Toast.LENGTH_LONG).show();
            }
        });

        String[] teamArray = getResources().getStringArray(R.array.RobotNumbers);
        for (int i = 0; i < teamArray.length; i++) {
            if (Autonomous.teamText.getText().toString().equals(teamArray[i])) {
                teamMatch = true;
            }
        }

        if (!Autonomous.gearPos.getText().toString().equals("None"))
            pos = Autonomous.gearPos.getText().toString();


        submit = (Button) in.findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Autonomous.noShow.isChecked()) {
                    if (Autonomous.matchText.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Match Number! :/", Toast.LENGTH_SHORT).show();
                    } else if (Autonomous.teamText.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Team Number! :(", Toast.LENGTH_SHORT).show();
                    } else if (teamMatch == false) {
                        Toast.makeText(getActivity(), "Team Is Not In This Tournament! ¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show();
                    } else if (Autonomous.scouterText.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Scouter Name! :o", Toast.LENGTH_SHORT).show();
                    } else if (Autonomous.noShow.isChecked() == false && Autonomous.far.isChecked() == false && Autonomous.mid.isChecked() == false && Autonomous.boil.isChecked() == false) {
                        Toast.makeText(getActivity(), "Select No Show, Far Side, Middle Side, or Boiler Side! >.<", Toast.LENGTH_SHORT).show();
                    } else if (Autonomous.baselineButton.isChecked() || Autonomous.gearView.getText().length() > 0 || Autonomous.gearPos.getText().equals("None") == false || Autonomous.highGoalView.getText().equals("0") == false || Autonomous.lowGoalView.getText().equals("0") == false) {
                        Toast.makeText(getActivity(), "You indicated action (in Autonomous) from a no show robot!? ಠ_ಠ", Toast.LENGTH_SHORT).show();
                    } else if (Teleop.none.isChecked() == false || Teleop.gearsView.getText().length() > 0 || Teleop.gearPos2.getText().length() > 0) {
                        Toast.makeText(getActivity(), "You indicated action (in Teleop: defense or gears) from a no show robot!? (ಥ﹏ಥ)", Toast.LENGTH_SHORT).show();
                    } else if ((Teleop.highGoalsView.getText().length() > 0 && Teleop.highGoalsView.getText().equals(" ") == false) || Teleop.intervalViewH.getText().length() > 0 || (Teleop.lowGoalView.getText().length() > 0 && Teleop.lowGoalView.getText().equals(" ") == false) || Teleop.intervalViewL.getText().length() > 0) {
                        Toast.makeText(getActivity(), "You indicated action (in Teleop: goals) from a no show robot!? (>ლ)", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.no.isChecked() == false) {
                        Toast.makeText(getActivity(), "You indicated action (takeoff) from a no show robot!? (ง'̀-'́)ง", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.pointsYellow.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Points Lost For Yellow Card or 0!", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.numPressure.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add kPa! ^^", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.rotors.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Rotor #! :|", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.win.isChecked() == false && PostMatch.lose.isChecked() == false && PostMatch.tie.isChecked() == false) {
                        Toast.makeText(getActivity(), "Select win, lose, or tie! >:D", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.totalPoints.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Total Points! D:", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.rankingPoints.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Ranking Points! B-)", Toast.LENGTH_SHORT).show();
                    } else if ((Integer.parseInt(PostMatch.rankingPoints.getText().toString()) < 2 || Integer.parseInt(PostMatch.rankingPoints.getText().toString()) > 3) && PostMatch.win.isChecked() == true) {
                        Toast.makeText(getActivity(), "Ranking Points entry is WRONG!", Toast.LENGTH_SHORT).show();
                    } else if ((Integer.parseInt(PostMatch.rankingPoints.getText().toString()) < 1 || Integer.parseInt(PostMatch.rankingPoints.getText().toString()) > 2) && PostMatch.tie.isChecked() == true) {
                        Toast.makeText(getActivity(), "Ranking Points entry is WRONG!", Toast.LENGTH_SHORT).show();
                    } else if ((Integer.parseInt(PostMatch.rankingPoints.getText().toString()) < 0 || Integer.parseInt(PostMatch.rankingPoints.getText().toString()) > 1) && PostMatch.lose.isChecked() == true) {
                        Toast.makeText(getActivity(), "Ranking Points entry is WRONG!", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent toConfirmation = new Intent(getActivity(), Confirmation.class);
                        startActivity(toConfirmation);
                    }
                } else {
                    if (Autonomous.teamText.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Team Number! :(", Toast.LENGTH_SHORT).show();
                    } else if (Autonomous.matchText.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Match Number! :/", Toast.LENGTH_SHORT).show();
                    } else if (teamMatch == false) {
                        Toast.makeText(getActivity(), "Team Is Not In This Tournament! ¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show();
                    } else if (Autonomous.scouterText.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Scouter Name! :o", Toast.LENGTH_SHORT).show();
                    } else if (Autonomous.noShow.isChecked() == false && Autonomous.far.isChecked() == false && Autonomous.mid.isChecked() == false && Autonomous.boil.isChecked() == false) {
                        Toast.makeText(getActivity(), "Select No Show, Far Side, Middle Side, or Boiler Side! >.<", Toast.LENGTH_SHORT).show();
                    } else if (numSpaces(pos) != numSpaces(Autonomous.gearView.getText().toString())) {
                        Toast.makeText(getActivity(), "Auto Gear Position and Number of Gears Do Not Match! :)", Toast.LENGTH_SHORT).show();
                    } else if ((numSpaces(Teleop.gearsView.getText().toString()) != numSpaces(Teleop.gearPos2.getText().toString()))) {
                        Toast.makeText(getActivity(), "Teleop Gear Position and Number of Gears Do Not Match! :)", Toast.LENGTH_SHORT).show();
                    } else if (numSpaces(Teleop.highGoalsView.getText().toString()) != numSpaces(Teleop.intervalViewH.getText().toString())) {
                        Toast.makeText(getActivity(), "Cycle Time and Number of High Goals Do Not Match! :)", Toast.LENGTH_SHORT).show();
                    } else if (numSpaces(Teleop.lowGoalView.getText().toString()) != numSpaces(Teleop.intervalViewL.getText().toString())) {
                        Toast.makeText(getActivity(), "Cycle Time and Number of Low Goals Do Not Match! :P", Toast.LENGTH_SHORT).show();
                    } else if (myRobo.getYellow().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Yellow Cards! :(", Toast.LENGTH_SHORT).show();

                    }    else if (PostMatch.penalty.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Points Taken off For Penalty! :/", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.numPressure.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add kPa! ^^", Toast.LENGTH_SHORT).show();
                    } else if ((Integer.parseInt(PostMatch.numPressure.getText().toString()) < 40 && reach.getText().toString().equals("Yes")) ||
                            (Integer.parseInt(PostMatch.numPressure.getText().toString()) > 40 && reach.getText().toString().equals("No"))) {
                        Toast.makeText(getActivity(), "Either kPa or Reached 40kPa Have Not Been Entered Correctly! :|", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.rotors.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Rotor #! :|", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.win.isChecked() == false && PostMatch.lose.isChecked() == false && PostMatch.tie.isChecked() == false) {
                        Toast.makeText(getActivity(), "Select win, lose, or tie! >:D", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.no.isChecked() == false && PostMatch.succeed.isChecked() == false) {
                        Toast.makeText(getActivity(), "Add Takeoff! D:", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.totalPoints.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Total Points! D:", Toast.LENGTH_SHORT).show();
                    } else if (PostMatch.rankingPoints.getText().toString().length() == 0) {
                        Toast.makeText(getActivity(), "Add Ranking Points! B-)", Toast.LENGTH_SHORT).show();
                    } else if ((Integer.parseInt(PostMatch.rankingPoints.getText().toString()) < 2 || Integer.parseInt(PostMatch.rankingPoints.getText().toString()) > 3) && PostMatch.win.isChecked() == true) {
                        Toast.makeText(getActivity(), "Ranking Points entry is WRONG!", Toast.LENGTH_SHORT).show();
                    } else if ((Integer.parseInt(PostMatch.rankingPoints.getText().toString()) < 1 || Integer.parseInt(PostMatch.rankingPoints.getText().toString()) > 2) && PostMatch.tie.isChecked() == true) {
                        Toast.makeText(getActivity(), "Ranking Points entry is WRONG!", Toast.LENGTH_SHORT).show();
                    } else if ((Integer.parseInt(PostMatch.rankingPoints.getText().toString()) < 0 || Integer.parseInt(PostMatch.rankingPoints.getText().toString()) > 1) && PostMatch.lose.isChecked() == true) {
                        Toast.makeText(getActivity(), "Ranking Points entry is WRONG!", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent toConfirmation = new Intent(getActivity(), Confirmation.class);
                        startActivity(toConfirmation);
                    }
                }
            }
        });

        notesText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = notesText.getText().toString();
                postInfo.setNotesT(str);
            }
        });

        return in;


    }

    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView != win) {
                    win.setChecked(false);
                }
                if (buttonView != lose) {
                    lose.setChecked(false);
                }
                if (buttonView != tie) {
                    tie.setChecked(false);
                }
                if (buttonView == win) {
                    String str = "Win";
                    myRobo.setResult(str);
                } else if (buttonView == lose) {
                    String str = "Lose";
                    myRobo.setResult(str);
                } else if (buttonView == tie) {
                    String str = "Tie";
                    myRobo.setResult(str);
                }
            }
        }
    };

    CompoundButton.OnCheckedChangeListener changeChecker2 = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView != no) {
                    no.setChecked(false);
                }
                if (buttonView != succeed) {
                    succeed.setChecked(false);
                }
                if (buttonView == no) {
                    String str = "No";
                    myRobo.setTakeoff(str);

                }
                if (buttonView == succeed) {
                    String str = "Yes";
                    myRobo.setTakeoff(str);
                }
            }
        }
    };


    CompoundButton.OnCheckedChangeListener changeChecker3 = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                    if (buttonView != yellowCardY) {
                        yellowCardY.setChecked(false);
                    }
                    if (buttonView != yellowCardN) {
                        yellowCardN.setChecked(false);
                    }
                    if (buttonView != red) {
                        red.setChecked(false);
                    }
                    if (buttonView == yellowCardN) {
                        String str = "None";
                        myRobo.setYellow(str);
                    } else if (buttonView == yellowCardY) {
                        String str = "Yellow";
                        myRobo.setYellow(str);
                    } else if (buttonView == red) {
                        String str = "Red";
                        myRobo.setYellow(str);
                    }
                }
            }

    };


    public static int numSpaces(String str) {
        int spaces = 0; //custom method to remove multiple space
        StringBuilder sb = new StringBuilder();
        for (String s : str.split(" ")) {

            if (!s.equals("")) {       // ignore space
                sb.append(s + " ");
                // add word with 1 space
                spaces++;
            }
        }
        return spaces;
    }

}




