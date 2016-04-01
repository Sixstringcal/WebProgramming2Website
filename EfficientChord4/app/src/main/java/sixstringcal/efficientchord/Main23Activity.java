package sixstringcal.efficientchord;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

public class Main23Activity extends AppCompatActivity {

    private int length;
    private Main22Activity setChordsClass;
    private TextView[] chordView = new TextView[10];
    private int[][] chords;
    private String[] stringChord = new String[10];
    private LinearLayout layout;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);
        setChordsClass = new Main22Activity();
        stringChord = setChordsClass.getChordName();
        chords = setChordsClass.getChordsUsed();
        length = setChordsClass.getCurrentChordNumber();
        layout = (LinearLayout) findViewById(R.id.linearLayout);
        for (int i = 0; i < length; i++) {
            LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            rightGravityParams.gravity = Gravity.LEFT;
            chordView[i] = new TextView(this);
            chordView[i].setText(chords[i].toString());
            layout.addView(chordView[i], rightGravityParams);
        }


        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
        @Override
        /**
         * Some more Google API code
         */
        public void onStart(){
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
        public void onStop(){
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

