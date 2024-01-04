package techproed.baseTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MyDemoAppBaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl) //Calistiracagimiz uygulamayi secmek icin
                .setUdid("R58R84FLPBK"); //Bu tanimlamayi iki farkli cihaz kullandigimiz da intelijenin hangi cihaza
                                        // server uzerinden baglanacagini gostermek icin yaptik. Cihazlarin bu id sini
                                        // cmd ye adb devices komutunu yazarak erisiyoruz.

        //Driver:
        URL url = new URL("http://0.0.0.0:4723");  //burasi sabit
        driver = new AndroidDriver(url,options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    // @AfterClass
    // public void afterClass() {
    //    driver.quit();
    // }
}
