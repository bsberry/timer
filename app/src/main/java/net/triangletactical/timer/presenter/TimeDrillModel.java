package net.triangletactical.timer.presenter;

import net.triangletactical.timer.data.TenthsFormatter;
import net.triangletactical.timer.data.TimeDrill;
import net.triangletactical.timer.util.TimeUtil;

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
        return TimeUtil.getMinSecondsLeft(drill.duration * 60 * 1000);
    }

    public String getParTimeString() {
        return TenthsFormatter.toSeconds(drill.parTime);
    }

    public int getParTimeTenths() {
        return drill.parTime;
    }
}
