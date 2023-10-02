import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHW {

    HomeWork hw = new HomeWork();

    @Test
    public void test () {

        assertTrue(hw.evenOddNumber(2));
        assertTrue(hw.evenOddNumber(26));
        assertTrue(hw.evenOddNumber(-26));
        assertTrue(hw.evenOddNumber( 0));
        assertFalse(hw.evenOddNumber(3));
        assertFalse(hw.evenOddNumber(17));

        assertTrue(hw.numberInInterval(99));
        assertTrue(hw.numberInInterval(26));
        assertFalse(hw.numberInInterval(25));
        assertFalse(hw.numberInInterval(100));
        assertFalse(hw.numberInInterval(0));
        assertFalse(hw.numberInInterval(-101));
    }
}