package com.example.trishlapokharna.scoutingtakethree;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//Cycle time is the time it takes when they first start shooting till they stop
/**
 * Created by TrishlaPokharna on 1/14/17.
 */
public class Teleop extends Fragment {
    RoboInfo myRobo = RoboInfo.getInstance();

    static TextView gearsView;

    Button one;
    Button zero;
    Button back;


    static TextView highGoalsView;
    Button none1;
    Button five1;
    Button ten1;
    Button twenty1;
    Button delete1;
    Button sub1;
    int i = 0;
    String display = " ";
    List<Integer> instance1 = new ArrayList<Integer>();
    static  List <String> addNum1 = new ArrayList <String> ();

    static List <String> time1 = new ArrayList <String> ();
    Button interval1H;
    Button interval2H;
    Button interval3H;
    Button interval4H;
    Button interval5H;
    Button intervalDelH;
    static TextView intervalViewH;

    static TextView lowGoalView;
    Button none2;
    Button five2;
    Button ten2;
    Button twenty2;
    Button delete2;
    Button sub2;
    int j;
    String display2 = " ";
    List<Integer> instance2 = new ArrayList<Integer>();
    static List <String> addNum2 = new ArrayList <String> ();


    static List <String> time2 = new ArrayList <String> ();
    Button interval1L;
    Button interval2L;
    Button interval3L;
    Button interval4L;
    Button interval5L;
    Button intervalDelL;
    static TextView intervalViewL;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View in = inflater.inflate(R.layout.fragment_teleop, container, false); // FIX THIS -- adds Autonomous tab to input activity

        gearsView = (TextView) in.findViewById(R.id.gearView);

        one = (Button) in.findViewById(R.id.gearHitButton);
        zero = (Button) in.findViewById(R.id.gearMissButton);
        back = (Button) in.findViewById(R.id.gearBackButton);


        highGoalsView = (TextView) in.findViewById(R.id.highGoalView);
        none1 = (Button) in.findViewById(R.id.highGoalClearButton);
        five1 = (Button) in.findViewById(R.id.highGoalFiveButton);
        ten1 = (Button) in.findViewById(R.id.highGoalTenButton);
        twenty1 = (Button) in.findViewById(R.id.highGoalTwentyButton);
        delete1 = (Button) in.findViewById(R.id.highGoalUndoButton);
        sub1 = (Button) in.findViewById(R.id.highGoalZeroButton);
        i = 0;

        interval1H = (Button) in.findViewById(R.id.highFirstIntervalButton);
        interval2H = (Button) in.findViewById(R.id.highSecondIntervalButton);
        interval3H = (Button) in.findViewById(R.id.highThirdIntervalButton);
        interval4H = (Button) in.findViewById(R.id.highFourthIntervalButton);
        interval5H = (Button) in.findViewById(R.id.highFifthIntervalButton);
        intervalDelH = (Button) in.findViewById(R.id.highDelButton);
        intervalViewH = (TextView) in.findViewById(R.id.highCycleView);


        lowGoalView = (TextView) in.findViewById(R.id.lowGoalView);
        none2 = (Button) in.findViewById(R.id.lowGoalClearButton);
        five2 = (Button) in.findViewById(R.id.lowGoalFiveButton);
        ten2 = (Button) in.findViewById(R.id.lowGoalTenButton);
        twenty2 = (Button) in.findViewById(R.id.lowGoalTwentyButton);
        delete2 = (Button) in.findViewById(R.id.lowGoalUndoButton);
        sub2 = (Button) in.findViewById(R.id.lowGoalZeroButton);
        j = 0;

        interval1L = (Button) in.findViewById(R.id.lowFirstIntervalButton);
        interval2L = (Button) in.findViewById(R.id.lowSecondIntervalButton);
        interval3L = (Button) in.findViewById(R.id.lowThirdIntervalButton);
        interval4L = (Button) in.findViewById(R.id.lowFourthIntervalButton);
        interval5L = (Button) in.findViewById(R.id.lowFifthIntervalButton);
        intervalDelL = (Button) in.findViewById(R.id.lowDelButton);
        intervalViewL = (TextView) in.findViewById(R.id.lowCycleView);



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("1 ");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("0 ");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gearsView.getText().length() > 0) {
                    gearsView.setText(gearsView.getText().subSequence(0, gearsView.getText().length() - 2));
                }
            }
        });


        //my button clic

//instnace1
    //instance1.add(0);
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
                display = " ";





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
                    if (s.length()> 4)
                        display += s + "       ";
                }
                highGoalsView.setText(display);
                display = " ";


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
                    if (s.length()> 4)
                        display += s + "       ";
                }
                highGoalsView.setText(display);
                display = " ";





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
                    if (s.length()> 4)
                        display += s + "       ";
                }

                highGoalsView.setText(display);
                display = " ";

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
                        if (s.length()> 4)
                            display += s + "       ";
                    }
                    highGoalsView.setText(display);
                    display = " ";

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
                        if (s.length() > 4)
                            display += s + "       ";
                    }

                    highGoalsView.setText(display);
                    display = " ";

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
                display = " ";

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
                        if (s.length() > 4)
                            display2 += s + "       ";
                    }

                    lowGoalView.setText(display2);
                    display2 = " ";





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
                    if (s.length()> 4)
                        display2 += s + "       ";
                }
                lowGoalView.setText(display2);
                display2 = " ";


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
                    if (s.length()> 4)
                        display2 += s + "       ";
                }
                lowGoalView.setText(display2);
                display2 = " ";





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
                    if (s.length()> 4)
                        display2 += s + "       ";
                }

                lowGoalView.setText(display2);
                display2 = " ";

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
                        if (s.length()> 4)
                            display2 += s + "       ";
                    }
                    lowGoalView.setText(display2);
                    display2 = " ";

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
                        if (s.length() > 4)
                            display2 += s + "       ";
                    }

                    lowGoalView.setText(display2);
                    display2 = " ";

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
                display2 = " ";

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



        return in;



    }

}


