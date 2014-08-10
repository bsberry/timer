package net.triangletactical.timer.data;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class TenthsFormatterTest {

    @Test
    public void testFormat() {
        assertThat(TenthsFormatter.toSeconds(110)).isEqualTo("11.0");
        assertThat(TenthsFormatter.toSeconds(65)).isEqualTo("6.5");
    }
}
