package net.triangletactical.timer.activity;

import android.app.Activity;
import android.media.AudioManager;

public class BaseDrillActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart();
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }
}
