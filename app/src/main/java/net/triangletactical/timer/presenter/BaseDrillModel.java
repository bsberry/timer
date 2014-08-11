package net.triangletactical.timer.presenter;

import net.triangletactical.timer.data.Drill;

public abstract class BaseDrillModel {
    private Drill drill;

    public BaseDrillModel(Drill drill) {
        this.drill = drill;
    }

    public <D extends Drill> D getDrill() {
        return (D) drill;
    }
}
