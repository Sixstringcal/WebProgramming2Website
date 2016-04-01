package sixstringcal.efficientchord;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Arrays;
import static sixstringcal.efficientchord.R.layout.activity_set_chord;

/**
 * This is the class to create the frame/activity for the chord creator page/frame.
 */
public class Main22Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String EXTRA_MESSAGE = "com.sixstringcal.Main22Activity.MESSAGE";
    public int currentChordNumber = 0;
    private boolean sharp = false;
    private String typeOfChord, intervalString = "";
    private int maxNumberOfChords = 10;
    private int[][] chords = new int[3][maxNumberOfChords];
    private int typeInt = 0;
    private String rootString = "A";
    private int rootInt = 0;
    private int intervalInt = 6;
    private LinearLayout chordLayout;
    private TextView[] chordView = new TextView[10];
    private String[] chordName = new String[10];
    private int rootNote = -1;
    private int sharpInt = 0;
    private int stringOfRootNote = -1;
    private int[][] chordsUsed = new int[10][];



    public Main22Activity() {

    }


    @Override
    /**
     * This just creates the frame/activity/window.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_set_chord);
        currentChordNumber = 0;
        Switch sharpSwitch = (Switch) findViewById(R.id.switch1);
        sharpSwitch.bringToFront();
        sharpSwitch.setOnClickListener(this);
        typeOfChord = "major";
        chordLayout = (LinearLayout) findViewById(R.id.linearLayout);
        RadioButton sevenButton = (RadioButton) findViewById(R.id.seven);
        sevenButton.setOnClickListener(this);
        RadioButton major7 = (RadioButton) findViewById(R.id.major7);
        major7.setOnClickListener(this);
        RadioButton noneInterval = (RadioButton) findViewById(R.id.radioButton2);
        noneInterval.setOnClickListener(this);
        RadioButton aButton = (RadioButton) findViewById(R.id.A);
        aButton.setOnClickListener(this);
        RadioButton bButton = (RadioButton) findViewById(R.id.B);
        bButton.setOnClickListener(this);
        RadioButton cButton = (RadioButton) findViewById(R.id.C);
        cButton.setOnClickListener(this);
        RadioButton dButton = (RadioButton) findViewById(R.id.D);
        dButton.setOnClickListener(this);
        RadioButton eButton = (RadioButton) findViewById(R.id.E);
        eButton.setOnClickListener(this);
        RadioButton fButton = (RadioButton) findViewById(R.id.F);
        fButton.setOnClickListener(this);
        RadioButton gButton = (RadioButton) findViewById(R.id.G);
        gButton.setOnClickListener(this);
        RadioButton augmentedButton = (RadioButton) findViewById(R.id.radioButton11);
        augmentedButton.setOnClickListener(this);
        RadioButton diminishedButton = (RadioButton) findViewById(R.id.radioButton10);
        diminishedButton.setOnClickListener(this);
        RadioButton majorButton = (RadioButton) findViewById(R.id.radioButton8);
        majorButton.setOnClickListener(this);
        RadioButton minorButton = (RadioButton) findViewById(R.id.radioButton9);
        minorButton.setOnClickListener(this);
        Button viewChordsButton = (Button) findViewById(R.id.button2);
        viewChordsButton.bringToFront();
        viewChordsButton.setOnClickListener(this);
        RadioGroup typeGroup = (RadioGroup) findViewById(R.id.radioGroups);
        typeGroup.bringToFront();
        RadioGroup rootGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rootGroup.bringToFront();
        Button addChord = (Button) findViewById(R.id.button);
        addChord.setOnClickListener(this);

    }


    /**
     * This returns the current chord number so it can be used outside this application.
     * @return currentChordNumber.
     */
    public int getCurrentChordNumber(){
        return currentChordNumber;
    }


    /**
     * This just makes it so that once the Add Chord button is clicked that the information will be created for the chords.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void addChordClicked(){
        if(currentChordNumber < maxNumberOfChords) {
            Root firstRoot = new Root();
            firstRoot.setRoot(rootInt+sharpInt);
            chordsUsed[currentChordNumber] = firstRoot.majorPosition(rootNote, stringOfRootNote);
            stringOfRootNote = firstRoot.getWhichString();
            rootNote = rootInt+sharpInt;
            Type firstType = new Type();


            firstType.setType(typeOfChord);

            chordsUsed[currentChordNumber] = firstType.findNotes(chordsUsed[currentChordNumber]);
            Interval firstInterval = new Interval();
            firstInterval.setInterval(intervalString);
            chordsUsed[currentChordNumber] = firstInterval.decideIntervalEffect(chordsUsed[currentChordNumber],typeInt,stringOfRootNote);

            switch (typeOfChord) {
                case "major":
                    typeInt = 0;
                    break;
                case "minor":
                    typeInt = 1;
                    break;
                case "diminished":
                    typeInt = 2;
                    break;
                case "augmented":
                    typeInt = 3;
                    break;
            }
            String sharpOrNot;
            if(sharp){
                sharpOrNot = "#";
            }
            else{
                sharpOrNot = "";
            }

            chordName[currentChordNumber] = rootString+sharpOrNot+" "+typeOfChord+intervalString;
            chordView[currentChordNumber] = new TextView(this);
            chordView[currentChordNumber].setText(chordName[currentChordNumber]);
            LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            rightGravityParams.gravity = Gravity.RIGHT;
            chordLayout.addView(chordView[currentChordNumber], rightGravityParams);
            chords[0][currentChordNumber] = intervalInt;
            chords[1][currentChordNumber] = typeInt;
            chords[2][currentChordNumber] = rootInt;
            currentChordNumber++;
        }
    }

    /**
     * This returns the chord's name as a String value so the user knows what chord is being used.
     * @return chordName
     */
    public String[] getChordName(){
        return chordName;
    }


    /**
     * This lets the  program access the chords used in the other classes.
     * @return chordsUsed.
     */
    public int[][] getChordsUsed(){
        return chordsUsed;
    }

    /**
     * This lets the user look at what chords they have created so far and starts the activity to view them.
     */
    private void viewChordsClicked(){
        Intent intent = new Intent(this, ChordDemo.class);
        String length = currentChordNumber+"";
        intent.putExtra(EXTRA_MESSAGE, length);
        if(currentChordNumber > 0) {
            intent.putExtra("0", Arrays.toString(chordsUsed[0]));
        }
        if(currentChordNumber > 1) {
            intent.putExtra("1", Arrays.toString(chordsUsed[1]));
        }
        if(currentChordNumber > 2) {
            intent.putExtra("2", Arrays.toString(chordsUsed[2]));
        }
        if(currentChordNumber > 3) {
            intent.putExtra("3", Arrays.toString(chordsUsed[3]));
        }
        if(currentChordNumber > 4) {
            intent.putExtra("4", Arrays.toString(chordsUsed[4]));
        }
        if(currentChordNumber > 5) {
            intent.putExtra("5", Arrays.toString(chordsUsed[5]));
        }
        if(currentChordNumber > 6) {
            intent.putExtra("6", Arrays.toString(chordsUsed[6]));
        }
        if(currentChordNumber > 7) {
            intent.putExtra("7", Arrays.toString(chordsUsed[7]));
        }
        if(currentChordNumber > 8) {
            intent.putExtra("8", Arrays.toString(chordsUsed[8]));
        }
        if(currentChordNumber > 9) {
            intent.putExtra("9", Arrays.toString(chordsUsed[9]));
        }
        startActivity(intent);
    }

    @Override
    /**
     * This just handles what happens on each button/radioButton/etc.
     * Basically just a bunch of checks to decide what to do.
     */
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                addChordClicked();
                break;
            case R.id.button2:
                viewChordsClicked();
                break;
            case R.id.radioButton9:
                typeOfChord = "minor";
                break;
            case R.id.radioButton8:
                typeOfChord = "major";
                break;
            case R.id.radioButton10:
                typeOfChord = "diminished";
                break;
            case R.id.radioButton11:
                typeOfChord = "augmented";
                break;
            case R.id.A:
                rootInt = 0;
                rootString = "A";
                break;
            case R.id.B:
                rootInt = 2;
                rootString = "B";
                break;
            case R.id.C:
                rootInt = 3;
                rootString = "C";
                break;
            case R.id.D:
                rootInt = 5;
                rootString = "D";
                break;
            case R.id.E:
                rootInt = 7;
                rootString = "E";
                break;
            case R.id.F:
                rootInt = 8;
                rootString = "F";
                break;
            case R.id.G:
                rootInt = 10;
                rootString = "G";
                break;
            case R.id.major7:
                intervalInt = 1;
                intervalString =" major 7";
                break;
            case R.id.seven:
                intervalInt = 0;
                intervalString = " 7";
                break;
            case R.id.switch1:
                sharp = !sharp;
                if(sharp) {
                    sharpInt = 1;
                }
                else{
                    sharpInt = 0;
                }
                break;
            case R.id.radioButton2:
                intervalInt = 6;
                intervalString = "";
        }
    }
}
