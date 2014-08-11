package net.triangletactical.timer.presenter;

import android.widget.Button;
import android.widget.TextView;

import net.triangletactical.timer.R;
import net.triangletactical.timer.activity.TimeDrillActivity;
import net.triangletactical.timer.util.BusProvider;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TimeDrillView {
    @InjectView(R.id.par_time)      TextView txtParTime;
    @InjectView(R.id.timer)         TextView txtTimer;
    @InjectView(R.id.start_button)  Button btnStart;
    TimeDrillActivity activity;

    public TimeDrillView(TimeDrillActivity activity) {
        this.activity = activity;
        ButterKnife.inject(this, activity);

        btnStart.setText("Start");
    }


    @OnClick(R.id.start_button)
    public void onClick() {
        BusProvider.post(new StartButtonPressedEvent());
    }

    public void displayDrill(String duration, String parTime) {
        txtParTime.setText(parTime);
        txtTimer.setText(duration);
    }

    public void setRemainingTime(String time) {
        txtTimer.setText(time);
    }

    public void setButtonText(String text) {
        btnStart.setText(text);
    }

    public static class StartButtonPressedEvent { }
}
