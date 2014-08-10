package net.triangletactical.timer.activity;

import android.app.Activity;
import android.os.Bundle;

import net.triangletactical.timer.R;
import net.triangletactical.timer.data.TimeDrill;
import net.triangletactical.timer.presenter.TimeDrillPresenter;
import net.triangletactical.timer.presenter.TimeDrillView;

public class TimeDrillActivity extends Activity {

    TimeDrillPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_time_drill);
        presenter = new TimeDrillPresenter(new TimeDrill(15,2),
                new TimeDrillView(this));
    }
}
