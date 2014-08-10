package net.triangletactical.timer.data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TenthsFormatter {
    static DecimalFormat formatter = new DecimalFormat("##.0");

    public static String toSeconds(int tenths) {
        BigDecimal seconds = BigDecimal.valueOf(tenths).divide(new BigDecimal(10));
        return formatter.format(seconds);
    }
}
