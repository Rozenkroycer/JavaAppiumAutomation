import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {

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
