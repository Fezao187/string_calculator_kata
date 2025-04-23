import org.example.stringCalc.StringCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    StringCalculator sc = new StringCalculator();

    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0, sc.add(""));
    }

    @Test
    public void shouldReturnOneIfOneIsPassed(){
        assertEquals(1, sc.add("1"));
    }
}