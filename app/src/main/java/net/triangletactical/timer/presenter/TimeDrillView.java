package net.triangletactical.timer.presenter;

import android.widget.Button;
import android.widget.TextView;

import net.triangletactical.timer.R;
import net.triangletactical.timer.activity.TimeDrillActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

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
        Crouton.showText(activity, "Start!", Style.ALERT);
    }
}
