package net.triangletactical.timer;

import android.app.Application;

public class TimerApplication extends Application {
    protected static TimerApplication instance;

    public static TimerApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
