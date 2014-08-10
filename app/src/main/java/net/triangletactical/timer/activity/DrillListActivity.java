package net.triangletactical.timer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
        drills.add(new RepDrill(15, 5, 1, 5).setTitle("Reps drill"));
        drills.add(new TimeDrill(20, 5).setTitle("Timed drill"));

        ListView listView = (ListView) findViewById(R.id.drill_list);
        DrillAdapter adapter = new DrillAdapter(this, R.layout.item_drill_list, R.id.drill_title, R.id.drill_description, drills);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new DrillItemClickListener(drills));
    }

    private class DrillItemClickListener implements OnItemClickListener{
        private List<Drill> drills;

        private DrillItemClickListener(List<Drill> drills) {
            this.drills = drills;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            startActivity(new Intent(view.getContext(), TimeDrillActivity.class)
                    .putExtra(TimeDrillActivity.EXTRA_DRILL, drills.get(position)));
        }
    }
}
