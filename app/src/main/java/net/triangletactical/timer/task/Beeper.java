package net.triangletactical.timer.task;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;

import net.triangletactical.timer.R;
import net.triangletactical.timer.data.Drill;

public abstract class Beeper<D extends Drill, Integer, Void> extends AsyncTask<D, Integer, Void> {

    protected MediaPlayer startBeep, endBeep, standby;
    protected boolean pause;

    public Beeper(Activity activity){
        startBeep = MediaPlayer.create(activity, R.raw.beep);
        startBeep.setAudioStreamType(AudioManager.STREAM_MUSIC);

        endBeep = MediaPlayer.create(activity, R.raw.beep);
        endBeep.setAudioStreamType(AudioManager.STREAM_MUSIC);

        standby = MediaPlayer.create(activity, R.raw.standby);
        standby.setAudioStreamType(AudioManager.STREAM_MUSIC);

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void v) {
        super.onPostExecute(v);

        cleanUp();
    }

    @Override
    protected Void doInBackground(D... params) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        return null;
    }

    protected void play(MediaPlayer player) throws InterruptedException {
        player.start();
        while(player.isPlaying()) {
            Thread.sleep(100);
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();

        cleanUp();
    }

    public boolean isPaused() {
        return pause;
    }

    public void pause() {
        pause = true;
    }

    public void resume() {
        pause = false;
    }

    protected void cleanUp() {
        startBeep.release();
        startBeep = null;
        endBeep.release();
        endBeep = null;
    }
}
