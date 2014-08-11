package net.triangletactical.timer.task;

import android.app.Activity;
import android.util.Log;

import net.triangletactical.timer.data.TimeDrill;

public class TimeDrillBeeper extends Beeper<TimeDrill, String, Void > {

    private static final String TAG = TimeDrillBeeper.class.getSimpleName();
    private long millisLeft;

    public TimeDrillBeeper(Activity activity) {
        super(activity);
    }

    protected Void doInBackground(TimeDrill... params) {

        boolean firstRep = true;
        TimeDrill drill = params[0];
        millisLeft = System.currentTimeMillis() + ( drill.duration * 60 * 1000 );

        try {

            do {
                while(pause){
                    Thread.sleep(1000); //Busy waiting... I know...
                }

                if(firstRep) {
                    sleep(1000); //Give the shooter a second
                    firstRep = false;
                } else {
                    sleep(100 * drill.recoveryTime);
                    if (pause) { continue; }
                }


                play(standby);

                sleep((long) ((Math.random() * 3) + 1) * 1000); //1-4 seconds
                if(pause) { continue; }

                startBeep.start();
                sleep(100 * drill.parTime); //parTime is tenths
                if(pause) { continue; }

                endBeep.start();


            } while (millisLeft > (drill.duration + 2500));
        } catch (InterruptedException ex) {
            Log.e(TAG, ex.getMessage());
        }

        //TODO: Don't start next rep if it won't complete in time
        return null;
    }

    private void sleep(long millis) throws InterruptedException {
        int timeSlept = 0;
        while(timeSlept < millis) {
            Thread.sleep(100);
            publishProgress(getTimeRemainingString());
            timeSlept += 100;
            millisLeft -= 100;
        }
    }

    private String getTimeRemainingString() {
        int minutes = (int) (millisLeft / 60);
        int seconds = (int) (millisLeft % 60);
        return String.format("%1$d:%2$2d", minutes, seconds);
    }

    public static class TimePublishedEvent {
        public String time;
        public TimePublishedEvent(String time) {
            this.time = time;
        }
    }
}
