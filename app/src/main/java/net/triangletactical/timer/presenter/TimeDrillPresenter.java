package net.triangletactical.timer.presenter;

public class TimeDrillPresenter {

    TimeDrillModel model;
    TimeDrillView view;

    public TimeDrillPresenter(TimeDrillModel model, TimeDrillView view) {
        this.model = model;
        this.view = view;

        setupViews();
    }

    private void setupViews() {
        view.displayDrill(model.getDurationString(), model.getParTimeString());
    }


}
