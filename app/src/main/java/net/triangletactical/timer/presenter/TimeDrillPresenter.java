package net.triangletactical.timer.presenter;

import com.squareup.otto.Subscribe;

import net.triangletactical.timer.data.TimeDrill;
import net.triangletactical.timer.presenter.TimeDrillView.StartButtonPressedEvent;
import net.triangletactical.timer.task.TimeDrillBeeper;
import net.triangletactical.timer.task.TimeDrillBeeper.TimePublishedEvent;

public class TimeDrillPresenter {

    TimeDrillModel model;
    TimeDrillView view;
    TimeDrillBeeper beeper;

    public TimeDrillPresenter(TimeDrillModel model, TimeDrillView view) {
        this.model = model;
        this.view = view;

        beeper = new TimeDrillBeeper(view.activity);

        setupViews();
    }

    private void setupViews() {
        view.displayDrill(model.getDurationString(), model.getParTimeString());
    }

    @Subscribe
    public void onTimePublished(TimePublishedEvent event) {
        view.setRemainingTime(event.time);
    }

    @Subscribe
    public void onStartButton(StartButtonPressedEvent event) {
        switch(beeper.getStatus()) {
            case PENDING:
                view.setButtonText("Pause");
                beeper.execute((TimeDrill) model.getDrill());
                break;
            case RUNNING:
                if(beeper.isPaused()) {
                    view.setButtonText("Pause");
                    beeper.resume();
                } else {
                    view.setButtonText("Resume");
                    beeper.pause();
                }
                break;
            default:
                //no-op

        }

    }


}
