package sixstringcal.efficientchord;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class ChordDemo extends AppCompatActivity {


    public TextView[] chordView;
    public LinearLayout layout;

    private GoogleApiClient client;

    public ChordDemo() {


    }

    @Override
    /**
     *  Loads the frame for displaying the chords and instantiates necessary variables and objects
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        Intent intent = getIntent();
        int length;
        String lengthString = intent.getStringExtra("com.sixstringcal.Main22Activity.MESSAGE");
        length = Integer.parseInt(lengthString);
        String[] chordsUsed = new String[length];
        if(length > 0) {
            chordsUsed[0] = b.getString("0");
        }
        if(length > 1) {
            chordsUsed[1] = b.getString("1");
        }
        if(length > 2) {
            chordsUsed[2] = b.getString("2");
        }
        if(length > 3) {
            chordsUsed[3] = b.getString("3");
        }
        if(length > 4) {
            chordsUsed[4] = b.getString("4");
        }
        if(length > 5) {
            chordsUsed[5] = b.getString("5");
        }
        if(length > 6) {
            chordsUsed[6] = b.getString("6");
        }
        if(length > 7) {
            chordsUsed[7] = b.getString("7");
        }
        if(length > 8) {
            chordsUsed[8] = b.getString("8");
        }
        if(length > 9) {
            chordsUsed[9] = b.getString("9");
        }
        setContentView(R.layout.activity_main23);

        chordView = new TextView[10];

        chordView[0] = (TextView) findViewById(R.id.textView2);
        chordView[1] = (TextView) findViewById(R.id.textView5);
        chordView[2] = (TextView) findViewById(R.id.textView6);
        chordView[3] = (TextView) findViewById(R.id.textView7);
        chordView[4] = (TextView) findViewById(R.id.textView8);
        chordView[5] = (TextView) findViewById(R.id.textView9);
        chordView[6] = (TextView) findViewById(R.id.textView10);
        chordView[7] = (TextView) findViewById(R.id.textView11);
        chordView[8] = (TextView) findViewById(R.id.textView12);
        chordView[9] = (TextView) findViewById(R.id.textView13);
        for(int i = 0; i < length; i++){
            chordView[i].setText(chordsUsed[i]);
        }


        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }







    @Override
    /**
     * Some more Google API code
     */
    public void onStart() {
        super.onStart();


        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "ChordDemo Page",

                Uri.parse("http://host/path"),

                Uri.parse("android-app://sixstringcal.efficientchord/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    /**
     * More Google API code
     */
    public void onStop() {
        super.onStop();

        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "ChordDemo Page",

                Uri.parse("http://host/path"),

                Uri.parse("android-app://sixstringcal.efficientchord/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}


