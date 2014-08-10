package net.triangletactical.timer.data;

import net.triangletactical.timer.R;
import net.triangletactical.timer.TimerApplication;

public class RepDrill extends Drill {
    int startTime;
    int sets;
    int deltaTime;
    int repsPerSet;

    public RepDrill(int startTime, int sets, int deltaTime, int repsPerSet) {
        this.startTime = startTime;
        this.deltaTime = deltaTime;

        this.sets = sets;
        this.repsPerSet = repsPerSet;
    }

    @Override
    public String getDescription() {
        return TimerApplication.getInstance().getResources()
                .getString(R.string.rep_drill_description,
                        sets,
                        repsPerSet,
                        TenthsFormatter.toSeconds(startTime),
                        TenthsFormatter.toSeconds(getMinTime())
                );
    }

    private int getMinTime() {
        return startTime - sets * deltaTime;
    }
}
