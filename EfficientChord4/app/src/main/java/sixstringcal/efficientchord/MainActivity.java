package sixstringcal.efficientchord;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * This is the class that starts the first activity which is the one with the new/load buttons and the settings menu.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button newButton;
    private GoogleApiClient client;


    @Override
    /**
     * This instantiates a few objects, it also starts up the frame/activity.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newButton = (Button) findViewById(R.id.button5);
        newButton.setOnClickListener(this);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    /**
     * This creates the options menu which has the settings option which doesn't work because there is no point for it yet.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    /**
     * This just deals with what happens when the options menu is selected.  Really useless code.
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        // This method creates a settings thing on the side.
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }


    /**
     * This just deals with what happens when you click on the new button.  It opens the chord creator frame/activity.
     */
    private void newButtonClick() {
        startActivity(new Intent(".SetChord"));
    }


    /**
     * This just deals with what happens when you click on the load button.  It opens a currently blank page.
     */
    private void loadButtonClick(){
        startActivity(new Intent("sixstringcal.efficientchord.LoadActivity"));
    }

    @Override
    /**
     * This just listens for the click and decides what method to call when the button is clicked.
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
                newButtonClick();
                break;
        }
    }

    @Override
    /**
     * This is for a google API, it is supposed to be cool, so I donn't know what to do.
     */
    public void onStart() {
        super.onStart();

        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "Main Page",
                Uri.parse("http://host/path"),
                Uri.parse("android-app://sixstringcal.efficientchord/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    /**
     * This is more to do with the google API.  Want to use it.
     */
    public void onStop() {
        super.onStop();

        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "Main Page",
                Uri.parse("http://host/path"),
                Uri.parse("android-app://sixstringcal.efficientchord/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
