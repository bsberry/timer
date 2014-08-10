package net.triangletactical.timer.data;

import java.io.Serializable;

public abstract class Drill implements Serializable {
    protected String title;

    public abstract String getDescription();

    public <D extends Drill> D setTitle(String title) {
        this.title = title;
        return (D) this;
    }
}
