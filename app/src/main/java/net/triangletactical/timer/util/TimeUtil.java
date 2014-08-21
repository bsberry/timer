package net.triangletactical.timer.util;

public class TimeUtil {

    public static String getMinSecondsLeft(long millisLeft) {
        int minutes = (int) (millisLeft / 60000);
        int seconds = (int) (millisLeft % 60000) / 1000;
        return String.format("%1$01d:%2$02d", minutes, seconds);
    }
}
