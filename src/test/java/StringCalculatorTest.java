import org.example.stringCalc.NegativesNotAllowedException;
import org.example.stringCalc.StringCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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

    @Test
    public void shouldReturnThreeIfSeparatedByACommaDelimiter(){
        assertEquals(3, sc.add("1,2"));
    }

    @Test
    public void shouldReturnSixIfThreeNumbersArePassed(){
        assertEquals(6, sc.add("1,2,3"));
    }

    @Test
    public void shouldReturnSixWhenNewLinesAreIncluded(){
        assertEquals(6, sc.add("1\n2,3"));
    }

    @Test
    public void shouldReturnThreeWithCustomDelimiter(){
        assertEquals(3,sc.add("//;\n1;2"));
    }

    @Test
    public void shouldReturnANegativesException(){
        assertThrows(NegativesNotAllowedException.class,
                ()->{
            sc.add("1,-2,-10");
                });
    }

    @Test
    public void shouldIgnoreNumbersGreaterThanAThousand(){
        assertEquals(2,sc.add("1,1001,1"));
    }

    @Test
    public void shouldAllowCustomDelimitersOfAnyLength(){
        assertEquals(6,sc.add("//[***]\n1***2***3"));
    }

    @Test
    public void shouldAllowMultipleDelimiters(){
        assertEquals(7,sc.add("//[*][%]\n1*2%3\n1"));
    }

    @Test
    public void shouldAllowAnyLengthOfMultipleDelims(){
        assertEquals(6,sc.add("//[***][;;;]\n1***2;;;3"));
    }
}