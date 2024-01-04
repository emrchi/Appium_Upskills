package techproed.baseTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorBaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.sec.android.app.popupcalculator")
                .setAppActivity("com.sec.android.app.popupcalculator.Calculator");

        URL url = new URL("http://0.0.0.0:4723");
        driver = new AndroidDriver(url,options);

    }
    /*
    @AfterClass
    public void afterClass() {

        driver.quit();
    }

     */
}

