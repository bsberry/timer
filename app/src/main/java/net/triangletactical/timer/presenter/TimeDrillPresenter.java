package net.triangletactical.timer.presenter;

import net.triangletactical.timer.data.TimeDrill;

public class TimeDrillPresenter {

    TimeDrill drill;
    TimeDrillView view;

    public TimeDrillPresenter(TimeDrill drill, TimeDrillView view) {
        this.drill = drill;
        this.view = view;
    }


}
