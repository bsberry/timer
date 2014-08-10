package net.triangletactical.timer.activity;

import android.app.Activity;
import android.os.Bundle;

import net.triangletactical.timer.R;
import net.triangletactical.timer.data.TimeDrill;
import net.triangletactical.timer.presenter.TimeDrillModel;
import net.triangletactical.timer.presenter.TimeDrillPresenter;
import net.triangletactical.timer.presenter.TimeDrillView;

public class TimeDrillActivity extends Activity {



    TimeDrillPresenter presenter;
    public static final String EXTRA_DRILL = "drill";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_time_drill);
        TimeDrill drill = (TimeDrill) getIntent().getSerializableExtra(EXTRA_DRILL);
        presenter = new TimeDrillPresenter(new TimeDrillModel(drill),
                new TimeDrillView(this));
    }
}
