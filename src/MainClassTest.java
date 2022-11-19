import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {

    @Test
    public void testGetLocalNumber(){
        MainClass MainClass = new MainClass();
        int actual_number = MainClass.getLocalNumber();
        int expected_number = 14;

        Assert.assertTrue("Actual number isn't 14", actual_number == expected_number);
    }
}
