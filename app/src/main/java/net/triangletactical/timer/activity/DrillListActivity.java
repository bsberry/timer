package net.triangletactical.timer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import net.triangletactical.timer.R;
import net.triangletactical.timer.data.Drill;
import net.triangletactical.timer.data.DrillAdapter;
import net.triangletactical.timer.data.RepDrill;
import net.triangletactical.timer.data.TimeDrill;

import java.util.ArrayList;
import java.util.List;

public class DrillListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.drill_list);

        List<Drill> drills = new ArrayList<Drill>(2);
        drills.add(new RepDrill(15, 5, 1, 5));
        drills.add(new TimeDrill(20, 5));

        ListView listView = (ListView) findViewById(R.id.drill_list);
        DrillAdapter adapter = new DrillAdapter(this, R.layout.item_drill_list, R.id.drill_title, R.id.drill_description, drills);
        listView.setAdapter(adapter);
    }
}
