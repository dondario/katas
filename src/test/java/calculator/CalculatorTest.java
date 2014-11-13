package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {
//    https://github.com/garora/TDD-Katas

//    Create a simple String calculator with a method int Add(string numbers). The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0). For example "" or "1" or "1,2"
//    Start with the simplest test case of an empty string and move to 1 and two numbers
//    Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
//    Remember to refactor after each passing test
//    Allow the Add method to handle an unknown amount of numbers
//    Allow the Add method to handle new lines between numbers (instead of commas).
//    the following input is ok: "1\n2,3" (will equal 6)
//    the following input is NOT ok: "1,\n" (not need to prove it - just clarifying)
//    Support different delimiters. To change a delimiter, the beginning of the string will contain a separate line that looks like this: [delimiter]\n[numbers...], for example ;\n1;2 should return three where the default delimiter is ; .
//    he first line is optional. all existing scenarios should still be supported
//    Calling Add with a negative number will throw an exception "negatives not allowed" - and the negative that was passed.
//            if there are multiple negatives, show all of them in the exception message


    private Calculator underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new Calculator();
    }

    @Test
    public void emptyStringShouldReturnZero(){
        assertThat(0, equalTo(underTest.add("")));
    }

    @Test
    public void addShouldSumNumbersInString(){
        assertThat(1, equalTo(underTest.add("1,0")));
    }

    @Test
    public void addShouldSumNumbersForUnknownAmountOfValues(){
        assertThat(15, equalTo(underTest.add("1,2,3,4,5")));
    }

    @Test
    public void addShouldHandleNewLinesAsWellAsCommas(){
        assertThat(6, equalTo(underTest.add("1\n2,3")));
    }

    @Test
    public void addShouldHandleOptionalDelimiter(){
        assertThat(3, equalTo(underTest.add(";\n1;2")));
    }

    @Test(expected = Exception.class)
    public void addShouldThrowExceptionIfNumberIsNegative(){
     underTest.add("-1,-2");
    }
}