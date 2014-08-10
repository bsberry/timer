package net.triangletactical.timer.presenter;

import net.triangletactical.timer.data.TenthsFormatter;
import net.triangletactical.timer.data.TimeDrill;

public class TimeDrillModel extends BaseDrillModel {
    private TimeDrill drill;
    public TimeDrillModel(TimeDrill drill) {
        super(drill);
        this.drill = drill;
    }

    public int getDurationMinutes() {
        return drill.duration;
    }

    public String getDurationString() {
        return Integer.toString(drill.duration) + "minutes";
    }

    public String getParTimeString() {
        return TenthsFormatter.toSeconds(drill.parTime) + "seconds";
    }

    public int getParTimeTenths() {
        return drill.parTime;
    }
}
