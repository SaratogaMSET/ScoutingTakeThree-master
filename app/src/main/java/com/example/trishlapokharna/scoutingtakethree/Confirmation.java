package com.example.trishlapokharna.scoutingtakethree;



/**
 * Created by TrishlaPokharna on 1/23/17.
 */

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Confirmation extends AppCompatActivity {

    TextView matchD;
    TextView teamD;
    TextView scouterD;
    TextView positionView;
    TextView baseline;
    TextView gears;
    TextView gearPosAuto;
    TextView highGoals;
    TextView lowGoals;


    TextView defense;
    TextView defenseDisplay;
    TextView pick;
    TextView pickUpDisplay;
    TextView gears2;
    TextView gear2PosTele;
    TextView highGoals2;
    TextView highGoalsCT;
    TextView lowGoals2;
    TextView lowGoalsCT;




    TextView notes;
    TextView reachedPressure;
    TextView numPressure;
    TextView takeOff;
    TextView rotor;
    TextView result;
    TextView totalPoints;
    TextView rankingPoints;



    RoboInfo myRobo = RoboInfo.getInstance();
    String matchT;


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);




        matchD = (TextView) findViewById(R.id.matchNumberDisplay);
        teamD = (TextView) findViewById(R.id.teamNumberDisplay);
        scouterD = (TextView) findViewById(R.id.scouterNameDisplay);
        positionView = (TextView) findViewById(R.id.positionView);
        gearPosAuto = (TextView) findViewById(R.id.positionViewGear);
        baseline = (TextView) findViewById(R.id.baselineDisplay);
        gears = (TextView) findViewById(R.id.gearsDisplay);
        highGoals = (TextView) findViewById(R.id.highGoalsDisplay);
        lowGoals = (TextView) findViewById(R.id.lowGoalDisplay);

        defense = (TextView) findViewById(R.id.defense);
        defenseDisplay = (TextView) findViewById (R.id.defenseDisplay);
        pick = (TextView) findViewById(R.id.pickUp);
        pickUpDisplay = (TextView) findViewById(R.id.pickUpGear);
        gears2 = (TextView) findViewById(R.id.gearsDisplay2);
        gear2PosTele = (TextView) findViewById(R.id.positionViewGearTele);
        highGoals2 = (TextView) findViewById(R.id.highGoalDisplay1);
        highGoalsCT = (TextView) findViewById(R.id.highGoalConsistencyDisplay1);
        lowGoals2 = (TextView) findViewById(R.id.lowGoalDisplay1);
        lowGoalsCT = (TextView) findViewById(R.id.lowGoalConsistencyDisplay1);



        notes = (TextView) findViewById(R.id.notesDisplay);
        reachedPressure = (TextView) findViewById (R.id.pressureDisplay);
        numPressure = (TextView)  findViewById (R.id.kpaDisplay);
        takeOff = (TextView) findViewById(R.id.takeoffDisplay);
        rotor = (TextView) findViewById (R.id.rotDisplay);
        result = (TextView) findViewById(R.id.resultDisplay);
        totalPoints = (TextView) findViewById(R.id.totalPointsDisplay);
        rankingPoints = (TextView) findViewById(R.id.rankPointsDisplay);

        Bundle bundle = new Bundle();
        final String name = bundle.getString("a");
        matchD.setText(name);

        // final List<String> num = bundle.

        matchD.setText(Autonomous.matchText.getText().toString());
        teamD.setText(Autonomous.teamText.getText().toString());
        scouterD.setText(Autonomous.scouterText.getText().toString());
        positionView.setText(myRobo.getPosition().toString());
        gearPosAuto.setText(Autonomous.gearPos.getText().toString());
        baseline.setText(Autonomous.baselineButton.getText().toString());
        gears.setText(Autonomous.gearView.getText().toString());
        highGoals.setText(Autonomous.highGoalView.getText().toString());
        lowGoals.setText(Autonomous.lowGoalView.getText().toString());

        defenseDisplay.setText(myRobo.getDefense().toString());
        pickUpDisplay.setText(Teleop.pick.getText().toString());
        gears2.setText(Teleop.gearsView.getText().toString());
        gear2PosTele.setText(Teleop.gearPos2.getText().toString());
        highGoals2.setText(Teleop.highGoalsView.getText().toString());
        highGoalsCT.setText(Teleop.intervalViewH.getText().toString());
        lowGoals2.setText(Teleop.lowGoalView.getText().toString());
        lowGoalsCT.setText(Teleop.intervalViewL.getText().toString());


        notes.setText(PostMatch.notesText.getText().toString());
        reachedPressure.setText(PostMatch.reach.getText().toString());
        numPressure.setText(PostMatch.numPressure.getText().toString());
        rotor.setText(PostMatch.rotors.getText().toString());
        takeOff.setText(myRobo.getTakeoff().toString());
        totalPoints.setText(PostMatch.totalPoints.getText().toString());
        rankingPoints.setText(PostMatch.rankingPoints.getText().toString());
        result.setText(myRobo.getResult().toString());



    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    // write text to file
    public void Export(View v) {
        try {
            verifyStoragePermissions(this);
            File root = new File(Environment.getExternalStorageDirectory(), "Notes-SAC");
            // if external memory exists and folder with name Notes
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }
            String text = "r2.txt";
            File filepath = new File(root, text);  // file path to save
            FileWriter writer = new FileWriter(filepath, true);

            if(filepath.length() != 0) {
                writer.append("\n");
            }

            writer.append("Team Number, " + Autonomous.teamText.getText().toString() + "\n");
            writer.append("Match Number, " + Autonomous.matchText.getText().toString() + "\n");
            writer.append("Scouter Name, " + Autonomous.scouterText.getText().toString() + "\n");
            writer.append("Cross Baseline, " + Autonomous.baselineButton.getText().toString() + "\n");
            writer.append("Starting Position, " + myRobo.getPosition().toString() + "\n");
            writer.append("Auto Gears, " + delSpaces(Autonomous.gearView.getText().toString()) + "\n");

            if (Autonomous.gearPos.getText().toString().equals("None"))
                writer.append("Auto Gears Positions, "  +  "\n");
            else
                writer.append("Auto Gears Positions, " + delSpaces(Autonomous.gearPos.getText().toString()) +  "\n");

            if (Autonomous.highGoalView.getText().toString().equals("0"))
                writer.append("Auto High Goal, " + "\n");
            else
                writer.append("Auto High Goal, " + (Autonomous.highGoalView.getText().toString()) + "\n");

            if (Autonomous.lowGoalView.getText().toString().equals("0"))
                writer.append("Auto Low Goal, " + "\n");
            else
                writer.append("Auto Low Goal, " + Autonomous.lowGoalView.getText().toString() + "\n");

            writer.append("Defense, " + getTf(myRobo.getDefense().toString()) + "\n");
            writer.append("Teleop High Goal Shots Per Cycle, " + delSpaces(Teleop.highGoalsView.getText().toString()) + "\n");
            writer.append("Teleop High Goal Shots Cycle Time, " + delSpaces(Teleop.intervalViewH.getText().toString()) + "\n");
            writer.append("Teleop Low Goal Shots Per Cycle, " + delSpaces(Teleop.lowGoalView.getText().toString()) + "\n");
            writer.append("Teleop Low Goal Shots Cycle Time, " + delSpaces(Teleop.intervalViewL.getText().toString()) + "\n");
            writer.append("Teleop Pickup Gear, "+ Teleop.pick.getText().toString() + "\n" );
            if (Teleop.gearsView.getText().toString().equals(0))
                writer.append("Teleop Gears, " +  "\n" );
            else
                writer.append("Teleop Gears, " + delSpaces(Teleop.gearsView.getText().toString()) + "\n" );
            writer.append("Teleop Gears Positions, " + delSpaces(Teleop.gearPos2.getText().toString()) + "\n");
            writer.append("Reached 40 kPa, " + (PostMatch.reach.getText().toString()) + "\n");
            writer.append("Total Pressure, " + (PostMatch.numPressure.getText().toString()) + "\n");
            writer.append("Rotors Turning, " + PostMatch.rotors.getText().toString() + "\n");
            writer.append("Takeoff, " + getTakeoff(myRobo.getTakeoff().toString()) + "\n");
            writer.append("Total Points, " + PostMatch.totalPoints.getText().toString() + "\n");
            writer.append("Ranking Points, "+ PostMatch.rankingPoints.getText().toString() + "\n");
            writer.append("Result, " + myRobo.getResult().toString() + "\n");
            writer.append("Notes, " + PostMatch.notesText.getText().toString()+ "\n" );
            if (text.equals("r3.txt")||text.equals("r1.txt")|| text.equals("r2.txt"))
                writer.append("Alliance, Red");
            if (text.equals("b1.txt")||text.equals("b2.txt")|| text.equals("b3.txt"))
                writer.append("Alliance, Blue");


            writer.flush();
            writer.close();
            Toast.makeText(getBaseContext(), "File updated!", Toast.LENGTH_SHORT).show();
            Intent toHome = new Intent(this, MainActivity.class);
            // Teleop.addNum1.clear();
            // Teleop.addNum2.clear();
            startActivity(toHome);

        } catch (IOException e) {
            e.printStackTrace();
            Log.d("file error", "" + e.getMessage());
        }
    }


    public String getTf(String str) {
        switch (str) {
            case "None":
                return "0";
            case "Weak":
                return "1";
            case "Proficient":
                return "2";
            case "Excellent":
                return "3";
            default:
                return " ";
        }

    }

    public String getTakeoff(String str) {
        switch (str) {
            case "No Attempt":
                return "No";
            case "Success":
                return "Yes";
            default:
                return " ";
        }

    }


    public static String delSpaces(String str){    //custom method to remove multiple space
        StringBuilder sb=new StringBuilder();
        for(String s: str.split(" ")){

            if(!s.equals(""))        // ignore space
                sb.append(s+" ");       // add word with 1 space

        }
        return new String(sb.toString());
    }



}
