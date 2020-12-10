package test.mediaplayer;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import android.view.KeyEvent;
import android.util.Log;
import android.content.Intent;
import android.app.Activity;

public class PlayerActivity extends Activity {
    public static final String TAG = "test.PlayerActivity";

    private VideoView vv = null;
    private String url = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        vv = (VideoView)findViewById(R.id.video_view);

        Intent intent = getIntent();
        url = intent.getStringExtra("filename");
        Log.d(TAG, "url is " + url);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onResume(){
        super.onResume();

        vv.setVideoURI(Uri.parse(url));
        vv.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "on pause");
        //vv.pause();
        vv.stopPlayback();
        url = null;

        this.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent){
        Log.d(TAG, "key " + keyCode + " video progress " + vv.getCurrentPosition() + "/"+ vv.getDuration());
        return super.onKeyDown(keyCode, keyEvent);
    }

}
