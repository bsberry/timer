package net.triangletactical.timer.data;

import net.triangletactical.timer.R;
import net.triangletactical.timer.TimerApplication;

public class TimeDrill extends Drill{

    public final int parTime; //in tenths
    public final int duration; //in minutes

    public TimeDrill(int parTime, int duration) {
        this.parTime = parTime;
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return TimerApplication.getInstance().getResources()
                .getString(R.string.time_drill_description,
                        TenthsFormatter.toSeconds(parTime), duration);
    }
}
