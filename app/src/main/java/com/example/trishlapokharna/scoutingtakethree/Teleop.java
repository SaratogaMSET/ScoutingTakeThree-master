package com.example.trishlapokharna.scoutingtakethree;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;
//Cycle time is the time it takes when they first start shooting till they stop
/**
 * Created by TrishlaPokharna on 1/14/17.
 */
public class Teleop extends Fragment {
    RoboInfo myRobo = RoboInfo.getInstance();

    static ToggleButton none;
    static ToggleButton weak;
    static ToggleButton pro;
    static ToggleButton excel;

    static TextView gearsView;
    ImageButton gearHelp;
    ImageButton gearPosHelp;

    ImageButton timerHelp;
    ImageButton gearPick;
    ImageButton defenseHelp;

    Button one;
    Button zero;
    Button miss;
    Button back;

    ImageButton highGoalHelp;
    ImageButton highCycleHelp;
    ImageButton lowGoalHelp;
    ImageButton lowCycleHelp;

    static TextView highGoalsView;
    Button none1;
    Button one1;
    Button five1;
    Button ten1;
    Button twenty1;
    Button delete1;
    Button sub1;
    int i = 0;
    String display = " ";
    List<Integer> instance1 = new ArrayList<Integer>();
    List <String> addNum1 = new ArrayList <String> ();
    List <String> time1 = new ArrayList <String> ();



    Button interval1H;
    Button interval2H;
    Button interval3H;
    Button interval4H;
    Button interval5H;
    Button intervalDelH;
    static TextView intervalViewH;

    Button far2;
    Button mid2;
    Button boil2;
    Button del2;
    static TextView gearPos2;
    static List <String> time3 = new ArrayList <String> ();

    static TextView lowGoalView;
    Button none2;
    Button one2;
    Button five2;
    Button ten2;
    Button twenty2;
    Button delete2;
    Button sub2;
    int j;
    String display2 = " ";
    List<Integer> instance2 = new ArrayList<Integer>();
    List <String> addNum2 = new ArrayList <String> ();


    List <String> time2 = new ArrayList <String> ();
    Button interval1L;
    Button interval2L;
    Button interval3L;
    Button interval4L;
    Button interval5L;
    Button intervalDelL;
    static TextView intervalViewL;

    Chronometer timer;
    Button timerStart;
    Button timerStop;
    Button timerRestart;

    static ToggleButton pick;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View in = inflater.inflate(R.layout.fragment_teleop, container, false); // FIX THIS -- adds Autonomous tab to input activity
        none = (ToggleButton) in.findViewById(R.id.noneToggle);
        weak = (ToggleButton) in.findViewById(R.id.weakToggle);
        pro = (ToggleButton) in.findViewById(R.id.proToggle);
        excel = (ToggleButton) in.findViewById(R.id.excelToggle);
        none.setOnCheckedChangeListener(changeChecker);
        weak.setOnCheckedChangeListener(changeChecker);
        pro.setOnCheckedChangeListener(changeChecker);
        excel.setOnCheckedChangeListener(changeChecker);


        gearsView = (TextView) in.findViewById(R.id.gearView);
        gearHelp = (ImageButton)in.findViewById(R.id.gearButtonImageButton);
        gearPosHelp = (ImageButton)in.findViewById(R.id.gearPositionImageButton);

        timerHelp = (ImageButton) in.findViewById(R.id.timerImageButton);
        defenseHelp = (ImageButton) in.findViewById(R.id.defenseImageButton);

        one = (Button) in.findViewById(R.id.gearHitButton);
        zero = (Button) in.findViewById(R.id.gearMissButton);
        miss = (Button) in.findViewById(R.id.pilotMiss);
        back = (Button) in.findViewById(R.id.gearBackButton);

        highGoalHelp = (ImageButton) in.findViewById(R.id.highImageButton);
        highGoalsView = (TextView) in.findViewById(R.id.highGoalView);
        none1 = (Button) in.findViewById(R.id.highGoalClearButton);
        one1 = (Button) in.findViewById(R.id.highGoalOneButton);
        five1 = (Button) in.findViewById(R.id.highGoalFiveButton);
        ten1 = (Button) in.findViewById(R.id.highGoalTenButton);
        twenty1 = (Button) in.findViewById(R.id.highGoalTwentyButton);
        delete1 = (Button) in.findViewById(R.id.highGoalUndoButton);
        sub1 = (Button) in.findViewById(R.id.highGoalZeroButton);
        i = 0;

        highCycleHelp = (ImageButton) in.findViewById(R.id.highCycleImageButton);
        interval1H = (Button) in.findViewById(R.id.highFirstIntervalButton);
        interval2H = (Button) in.findViewById(R.id.highSecondIntervalButton);
        interval3H = (Button) in.findViewById(R.id.highThirdIntervalButton);
        interval4H = (Button) in.findViewById(R.id.highFourthIntervalButton);
        interval5H = (Button) in.findViewById(R.id.highFifthIntervalButton);
        intervalDelH = (Button) in.findViewById(R.id.highDelButton);
        intervalViewH = (TextView) in.findViewById(R.id.highCycleView);

        lowGoalHelp = (ImageButton) in.findViewById(R.id.lowImageButton);
        lowGoalView = (TextView) in.findViewById(R.id.lowGoalView);
        none2 = (Button) in.findViewById(R.id.lowGoalClearButton);
        one2 = (Button) in.findViewById(R.id.lowGoalOneButton);
        five2 = (Button) in.findViewById(R.id.lowGoalFiveButton);
        ten2 = (Button) in.findViewById(R.id.lowGoalTenButton);
        twenty2 = (Button) in.findViewById(R.id.lowGoalTwentyButton);
        delete2 = (Button) in.findViewById(R.id.lowGoalUndoButton);
        sub2 = (Button) in.findViewById(R.id.lowGoalZeroButton);
        j = 0;

        lowCycleHelp = (ImageButton) in.findViewById(R.id.lowCycleImageButton);
        interval1L = (Button) in.findViewById(R.id.lowFirstIntervalButton);
        interval2L = (Button) in.findViewById(R.id.lowSecondIntervalButton);
        interval3L = (Button) in.findViewById(R.id.lowThirdIntervalButton);
        interval4L = (Button) in.findViewById(R.id.lowFourthIntervalButton);
        interval5L = (Button) in.findViewById(R.id.lowFifthIntervalButton);
        intervalDelL = (Button) in.findViewById(R.id.lowDelButton);
        intervalViewL = (TextView) in.findViewById(R.id.lowCycleView);

        timer = (Chronometer) in.findViewById(R.id.timer);
        timerStart = (Button) in.findViewById(R.id.timerStartButton);
        timerStop = (Button) in.findViewById(R.id.timerStopButton);
        timerRestart = (Button) in.findViewById(R.id.timerRestartButton);

        far2 = (Button) in.findViewById(R.id.closeButton);
        mid2 = (Button) in.findViewById(R.id.middleButton);
        boil2 = (Button) in.findViewById(R.id.boilButton);
        del2 = (Button) in.findViewById(R.id.DelButton);
        gearPos2 = (TextView) in.findViewById(R.id.gearCycleView);

        gearPick = (ImageButton) in.findViewById(R.id.pickUpImageButton);
        pick = (ToggleButton) in.findViewById(R.id.pickToggle);


        defenseHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Select the skill level of defense. Choose 'None' if the robot does not do defense," +
                        " choose 'Weak' if the robot does not defend well, choose 'Proficient' if the robot defends decently, and " +
                        "choose 'Excellent' if the robot defends extremely well.", Toast.LENGTH_LONG).show();
            }
        });

        gearPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Select yes if the robot can pick up gears from the ground.", Toast.LENGTH_LONG).show();
            }
        });

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

        timerHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Use timer for reference when entering cycle times.", Toast.LENGTH_LONG).show();
            }
        });

        highGoalHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Click 'Add 0' for each new cycle, 'Undo' to remove the last added number" +
                        ", and 'Clear' to remove a cycle.", Toast.LENGTH_LONG).show();
            }
        });

        lowGoalHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Click 'Add 0' for each new cycle, 'Undo' to remove the last added number" +
                        ", and 'Clear' to remove a cycle.", Toast.LENGTH_LONG).show();
            }
        });

        highCycleHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Estimate the time taken for each shooting cycle. Enter a value each time 'Add 0' is used. Feel free to" +
                        " use timer above as reference.", Toast.LENGTH_LONG).show();
            }
        });

        lowCycleHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Estimate the time taken for each shooting cycle. Enter a value each time 'Add 0' is used. Feel free to" +
                        " use timer above as reference.", Toast.LENGTH_LONG).show();
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("1             ");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("0             ");
            }
        });

        miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("X             ");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gearsView.getText().length() > 14) {
                    gearsView.setText(gearsView.getText().subSequence(0, gearsView.getText().length() - 14));
                } else
                    gearsView.setText("");
            }
        });


        instance1.add(0);
        none1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                instance1.clear();
                instance1.add(0);
                if (addNum1.size()>=1)
                    addNum1.remove((addNum1.size() - 1));

                if ((addNum1.size()!=0)) {
                    if (addNum1.get(addNum1.size()-1) == "0")
                        i = 0;
                    else
                        i = Integer.parseInt(addNum1.get(addNum1.size()-1));


                }

                for (String s : addNum1) {
                    if (s.length() == 1)
                        display += s + "           ";
                    if (s.length() == 2)
                        display += s + "         ";
                    if (s.length() == 3)
                        display += s + "        ";
                    if (s.length() > 4)
                        display += s + "       ";
                }

                highGoalsView.setText(display);
                display = "";
            }
        });


        one1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (addNum1.size() == 0 )
                    addNum1.add(String.valueOf(i));

                i += 1;


                instance1.add(i);
                addNum1.set(addNum1.size()-1, String.valueOf(i));

                for (String s : addNum1) {
                    if (s.length() == 1)
                        display += s + "           ";
                    if (s.length() == 2)
                        display += s + "         ";
                    if (s.length() == 3)
                        display += s + "        ";
                    if (s.length()>= 4)
                        display += s + "       ";
                }
                highGoalsView.setText(display);
                display = "";


            }

        });

        five1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (addNum1.size() == 0 )
                    addNum1.add(String.valueOf(i));

                i += 5;


                instance1.add(i);
                addNum1.set(addNum1.size()-1, String.valueOf(i));

                for (String s : addNum1) {
                    if (s.length() == 1)
                        display += s + "           ";
                    if (s.length() == 2)
                        display += s + "         ";
                    if (s.length() == 3)
                        display += s + "        ";
                    if (s.length()>= 4)
                        display += s + "       ";
                }
                highGoalsView.setText(display);
                display = "";


            }

        });
        ten1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (addNum1.size() == 0 )
                    addNum1.add(String.valueOf(i));

                i += 10;
                instance1.add(i);
                addNum1.set(addNum1.size()-1, String.valueOf(i));

                for (String s : addNum1) {
                    if (s.length() == 1)
                        display += s + "           ";
                    if (s.length() == 2)
                        display += s + "         ";
                    if (s.length() == 3)
                        display += s + "        ";
                    if (s.length()>=4)
                        display += s + "       ";
                }
                highGoalsView.setText(display);
                display = "";





            }

        });
        twenty1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (addNum1.size() == 0 )
                    addNum1.add(String.valueOf(i));


                i += 20;

                instance1.add(i);
                addNum1.set(addNum1.size()-1, String.valueOf(i));

                for (String s : addNum1) {
                    if (s.length() == 1)
                        display += s + "           ";
                    if (s.length() == 2)
                        display += s + "         ";
                    if (s.length() == 3)
                        display += s + "        ";
                    if (s.length()>=4)
                        display += s + "       ";
                }

                highGoalsView.setText(display);
                display = "";

            }

        });
//DELETE DOES NOT WORK
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (instance1.size() > 1) {
                    instance1.remove(instance1.size() - 1);
                    i = instance1.get(instance1.size() - 1);
                    addNum1.remove(addNum1.size() - 1);
                    addNum1.add(String.valueOf(i));

                    for (String s : addNum1) {
                        if (s.length() == 1)
                            display += s + "           ";
                        if (s.length() == 2)
                            display += s + "         ";
                        if (s.length() == 3)
                            display += s + "        ";
                        if (s.length()>= 4)
                            display += s + "       ";
                    }
                    highGoalsView.setText(display);
                    display = "";

                }




                if (instance1.size() == 1) {
                    instance1.clear();
                    instance1.add(0);
                    if (addNum1.size()>= 1)

                        addNum1.remove((addNum1.size() - 1));
                    addNum1.add( String.valueOf("0"));

                    for (String s : addNum1) {
                        if (s.length() == 1)
                            display += s + "           ";
                        if (s.length() == 2)
                            display += s + "         ";
                        if (s.length() == 3)
                            display += s + "        ";
                        if (s.length() >=4)
                            display += s + "       ";
                    }

                    highGoalsView.setText(display);
                    display = "";

                }



            }
        });
        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                i = 0;
                instance1.clear();
                instance1.add(i);

                addNum1.add("0");
                for (String s : addNum1) {
                    display += String.valueOf(s) + "         ";
                }

                highGoalsView.setText(display);
                display = "";

            }
        });






        interval1H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intervalViewH.append("00-05    ");
                time1.add("00-05 ");
            }
        });

        interval2H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewH.append("06-10    ");
                time1.add("06-10 ");

            }
        });

        interval3H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewH.append("11-15    ");
                time1.add("11-15 ");

            }
        });

        interval4H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewH.append("16-20    ");
                time1.add("16-20 ");

            }
        });

        interval5H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewH.append("21-25    ");
                time1.add("21-25 ");

            }
        });

        intervalDelH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time1.size() >= 1) {
                    intervalViewH.setText(intervalViewH.getText().subSequence(0, intervalViewH.getText().length() - 9));
                    time1.remove(time1.size()-1);

                }
                if (time1.size() == 0)
                    intervalViewH.setText("");
            }
        });


        instance2.add(0);



        none2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                instance2.clear();
                instance2.add(0);
                if (addNum2.size()>=1)
                    addNum2.remove((addNum2.size() - 1));

                if ((addNum2.size()!=0)) {
                    if (addNum2.get(addNum2.size()-1) == "0")
                        j = 0;
                    else
                        j = Integer.parseInt(addNum2.get(addNum2.size()-1));


                }

                for (String s : addNum2) {
                    if (s.length() == 1)
                        display2 += s + "           ";
                    if (s.length() == 2)
                        display2 += s + "         ";
                    if (s.length() == 3)
                        display2 += s + "        ";
                    if (s.length() >= 4)
                        display2 += s + "       ";
                }

                lowGoalView.setText(display2);
                display2 = "";
            }
        });

        one2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (addNum2.size() == 0 )
                    addNum2.add(String.valueOf(j));

                j += 1;


                instance2.add(j);
                addNum2.set(addNum2.size()-1, String.valueOf(j));

                for (String s : addNum2) {
                    if (s.length() == 1)
                        display2 += s + "           ";
                    if (s.length() == 2)
                        display2 += s + "         ";
                    if (s.length() == 3)
                        display2 += s + "        ";
                    if (s.length()>= 4)
                        display2 += s + "       ";
                }
                lowGoalView.setText(display2);
                display2 = "";


            }

        });


        five2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (addNum2.size() == 0 )
                    addNum2.add(String.valueOf(j));

                j += 5;


                instance2.add(j);
                addNum2.set(addNum2.size()-1, String.valueOf(j));

                for (String s : addNum2) {
                    if (s.length() == 1)
                        display2 += s + "           ";
                    if (s.length() == 2)
                        display2 += s + "         ";
                    if (s.length() == 3)
                        display2 += s + "        ";
                    if (s.length()>= 4)
                        display2 += s + "       ";
                }
                lowGoalView.setText(display2);
                display2 = "";


            }

        });
        ten2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (addNum2.size() == 0 )
                    addNum2.add(String.valueOf(j));

                j += 10;
                instance2.add(j);
                addNum2.set(addNum2.size()-1, String.valueOf(j));

                for (String s : addNum2) {
                    if (s.length() == 1)
                        display2 += s + "           ";
                    if (s.length() == 2)
                        display2 += s + "         ";
                    if (s.length() == 3)
                        display2 += s + "        ";
                    if (s.length()>= 4)
                        display2 += s + "       ";
                }
                lowGoalView.setText(display2);
                display2 = "";





            }

        });
        twenty2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (addNum2.size() == 0 )
                    addNum2.add(String.valueOf(j));


                j += 20;

                instance2.add(j);
                addNum2.set(addNum2.size()-1, String.valueOf(j));

                for (String s : addNum2) {
                    if (s.length() == 1)
                        display2 += s + "           ";
                    if (s.length() == 2)
                        display2 += s + "         ";
                    if (s.length() == 3)
                        display2 += s + "        ";
                    if (s.length()>= 4)
                        display2 += s + "       ";
                }

                lowGoalView.setText(display2);
                display2 = "";

            }

        });
//DELETE DOES NOT WORK
        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (instance2.size() > 1) {
                    instance2.remove(instance2.size() - 1);
                    j = instance2.get(instance2.size() - 1);
                    addNum2.remove(addNum2.size() - 1);
                    addNum2.add(String.valueOf(j));


                    for (String s : addNum2) {
                        if (s.length() == 1)
                            display2 += s + "           ";
                        if (s.length() == 2)
                            display2 += s + "         ";
                        if (s.length() == 3)
                            display2 += s + "        ";
                        if (s.length()>= 4)
                            display2 += s + "       ";
                    }
                    lowGoalView.setText(display2);
                    display2 = "";

                }



                if (instance2.size() == 1) {
                    instance2.clear();
                    instance2.add(0);
                    if (addNum2.size()>= 1)

                        addNum2.remove((addNum2.size() - 1));
                    addNum2.add( String.valueOf("0"));

                    for (String s : addNum2) {
                        if (s.length() == 1)
                            display2 += s + "           ";
                        if (s.length() == 2)
                            display2 += s + "         ";
                        if (s.length() == 3)
                            display2 += s + "        ";
                        if (s.length() >= 4)
                            display2 += s + "       ";
                    }

                    lowGoalView.setText(display2);
                    display2 = "";

                }



            }
        });
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                j = 0;
                instance2.clear();
                instance2.add(j);

                addNum2.add("0");
                for (String s : addNum2) {
                    display2 += String.valueOf(s) + "         ";
                }

                lowGoalView.setText(display2);
                display2 = "";

            }
        });


        interval1L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewL.append("00-05    ");
                time2.add("00-05 ");
            }
        });

        interval2L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewL.append("06-10    ");
                time2.add("06-10 ");

            }
        });

        interval3L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewL.append("11-15    ");
                time2.add("11-15 ");
            }
        });

        interval4L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewL.append("16-20    ");
                time2.add("16-20 ");

            }
        });

        interval5L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewL.append("21-25    ");
                time2.add("21-25 ");

            }
        });

        intervalDelL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time2.size() >= 1) {
                    intervalViewL.setText(intervalViewL.getText().subSequence(0, intervalViewL.getText().length() - 9));
                    time2.remove(time2.size()-1);
                }
                if (time2.size()==0) {
                    intervalViewL.setText("");
                }
            }
        });

        timerStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stoppedMilliseconds = 0;

                String chronoText = timer.getText().toString();
                String array[] = chronoText.split(":");
                if (array.length == 2) {
                    stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000
                            + Integer.parseInt(array[1]) * 1000;
                } else if (array.length == 3) {
                    stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000
                            + Integer.parseInt(array[1]) * 60 * 1000
                            + Integer.parseInt(array[2]) * 1000;
                }

                timer.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);
                timer.start();
            }
        });

        timerStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();
            }
        });

        timerRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setBase(SystemClock.elapsedRealtime());
            }
        });

        far2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearPos2.append("Close      ");
                time3.add("Close ");
            }
        });

        mid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearPos2.append("Middle     ");
                time3.add("Middle ");

            }
        });

        boil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearPos2.append("Boiler     ");
                time3.add("Boiler ");
            }
        });

        del2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time3.size() >= 1) {
                    gearPos2.setText(gearPos2.getText().subSequence(0, gearPos2.getText().length() - 11));
                    time3.remove(time3.size()-1);
                }
                if (time3.size()==0) {
                    gearPos2.setText("");
                }
            }
        });

        if (none.isChecked()) {
            String str = "None";
            myRobo.setDefense(str);
        }
        else if (weak.isChecked()) {
            String str = "Weak";
            myRobo.setDefense(str);
        }
        else if (pro.isChecked()) {
            String str = "Proficient";
            myRobo.setDefense(str);
        }

        else if (excel.isChecked()) {
            String str = "Excellent";
            myRobo.setDefense(str);
        }

        return in;

    }

    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView != none) {
                    none.setChecked(false);
                }
                if (buttonView != weak) {
                    weak.setChecked(false);
                }
                if (buttonView != pro) {
                    pro.setChecked(false);
                }

                if (buttonView != excel) {
                    excel.setChecked(false);
                }
                if (buttonView == none){
                    String str = "None";
                    myRobo.setDefense(str);
                }
                if (buttonView == weak){
                    String str = "Weak";
                    myRobo.setDefense(str);
                }
                if (buttonView == pro){
                    String str = "Proficient";
                    myRobo.setDefense(str);
                }
                if (buttonView == excel){
                    String str = "Excellent";
                    myRobo.setDefense(str);
                }
            }
        }
    };

}