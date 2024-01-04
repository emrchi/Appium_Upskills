package techproed.day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C02_Capabilities {

    @Test
    public void testUiAutomator2Options() throws MalformedURLException {

        //.setApp("C:\\Users\\emres\\IdeaProjects\\Appium_Upskills\\src\\test\\resources\\ApiDemos-debug.apk") file separator ile yeniden yaptik asagida.
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("uiautomator2")
                //.setUdid("R58R84FLPBK")    //adv devices - Hangi cihazda test yapacaksak onun udid bilgisini giriyorum
                .setApp(appUrl)   //Calistiracagimiz uygulamayi secmek icin
                //.setAppPackage("io.appium.android.apis")
                //.setAppActivity("io.appium.android.apis.ApiDemos")
                .setAvd("pixel-q")  //Sanal cihaz kullanacak isek burada ismi ile tanimliyoruz kapali emulatoru acmak icin
                //.setAvdLaunchTimeout(Duration.ofMinutes(5)) //Sanal makine acilimi uzun suruyor ise exeption almamak icin sureyi uzatiyoruz.
                ;

        //Driver:
        URL url = new URL("http://0.0.0.0:4723");  //burasi sabit
        AndroidDriver driver = new AndroidDriver(url,options);
    }
}
