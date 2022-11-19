import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClassTest {

    @Test
    public void testGetClassString(){

        MainClass MainClass = new MainClass();
        String source_string = MainClass.getClassString();
        String first_word = "hello";
        String second_word = "Hello";
        Assert.assertTrue("There are no words 'Hello' and 'hello' in the string", source_string.contains(first_word));
        Assert.assertTrue("There are no words 'Hello' and 'hello' in the string", source_string.contains(second_word));

    }

    @Test
    public void testGetClassNumber(){
        int expected_number = 45;

        MainClass MainClass = new MainClass();
        int actual_number = MainClass.getClassNumber();

        Assert.assertTrue("Actual number lower or equal 45", actual_number > expected_number);
    }

    @Test
    public void testGetLocalNumber(){
        MainClass MainClass = new MainClass();
        int actual_number = MainClass.getLocalNumber();
        int expected_number = 14;

        Assert.assertTrue("Actual number isn't 14", actual_number == expected_number);
    }
}
