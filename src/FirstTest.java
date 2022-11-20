import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceModel","pixel4a");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("app","/Users/pavelbulic/Documents/GitHub/JavaAppiumAutomation/apks/Wikipedia_r_2.7.50422-r-2022-10-24_apkcombo.com.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void firstTest()
    {
        System.out.println("First test run");
    }
}
