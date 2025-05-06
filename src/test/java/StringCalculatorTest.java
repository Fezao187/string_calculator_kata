import org.example.stringCalc.NegativesNotAllowedException;
import org.example.stringCalc.StringCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {
    StringCalculator sc = new StringCalculator();

    @Test
    public void shouldReturnZeroOnEmptyString() {
        assertEquals(0,sc.add("") );
    }

    @Test
    public void shouldReturnOneIfOneIsEntered() {
        assertEquals(1,sc.add("1") );
    }

    @Test
    public void shouldReturnSumOfTwoNumbers() {
        assertEquals(3,sc.add("1,2") );
    }

    @Test
    public void shouldHandleUnknownAmountOfNumbers() {
        assertEquals(6,sc.add("1,2,3") );
    }

    @Test
    public void shouldHandleNewLinesBetweenNumbers() {
        assertEquals(6,sc.add("1\n2,3") );
    }

    @Test
    public void shouldHandleCustomDelimiters() {
        assertEquals(3,sc.add("//;\n1;2") );
    }

    @Test
    public void shouldThrowNegativesNotAllowedException() {
        assertThrows(NegativesNotAllowedException.class,
                () -> sc.add("1,-2,-3,4"));
    }

    @Test
    public void shouldHandleNumbersBiggerThanThousandByIgnoringThem() {
        assertEquals(2,sc.add("2,10000,100000") );
    }

    @Test
    public void shouldHandleDelimitersOfAnyLength() {
        assertEquals(6,sc.add("//[***]\n1***2***3"));
    }

    @Test
    public void shouldHandleDifferentTypesOfDelimiters() {
        assertEquals(6,sc.add("//[*][%]\n1*2%3") );
    }

    @Test
    public void shouldHandleDifferentDelimitersOfAnyLength() {
        assertEquals(6,sc.add("//[***][%%%]\n1***2%%%3") );
    }
}