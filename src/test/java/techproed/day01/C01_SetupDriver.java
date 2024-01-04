package techproed.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetupDriver {

    @Test
    public void testDesiredCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android"); //testlerimizi yapacagimiz platform
        capabilities.setCapability("automationName","uiautomator2"); //testlerimizi yapacagimiz driver tanimladik
        capabilities.setCapability("udid","R58R84FLPBK");//Mobil cihazimizi tanimliyoruz .. value degerini cmd ekranina "adb devices" komutunu yazarak aliyoruz tek cihaz bagli ise tanimlamak zorunda degiliz.
        capabilities.setCapability("app","C:\\Users\\emres\\IdeaProjects\\Appium_Upskills\\src\\test\\resources\\ApiDemos-debug.apk"); // test edecegimiz app'in apk dosya yolunu tanimladik // test edecegimiz apk yi resources altina kaydediyoruz onunda copy path referansindan absolute path kopyaladik
        capabilities.setCapability("appPackage","io.appium.android.apis"); //test edecegimiz app telefonda acik iken cmd'de "adb shell dumpsys window | find "mCurrentFocus" komutu girerek appPackage icin  value degerini / den once buluruz.
        capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos"); //test edecegimiz app telefonda acik iken cmd'de "adb shell dumpsys window | find "mCurrentFocus" komutu girerek appActivity  icin  value degerini / den sonra buluruz.
        //Burada test edecegimiz aplication'i tanimlarken ya "app" tek basina yada "appPackage" ve "appActivity" birlikte tanimlanmalidir
        //Tercih edilen "appPackage" ve "appActivity" birlikte tanimlanmasidir bunlar tanimlanir "app" Tanimlanmaz

        //Driver:
        URL url = new URL("http://0.0.0.0:4723"); //burasi sabit
        AndroidDriver driver = new AndroidDriver(url,capabilities);

    }

    @Test
    public void testUiAutomator2Options() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("uiautomator2")
                .setUdid("R58R84FLPBK")
                .setApp("C:\\Users\\emres\\IdeaProjects\\Appium_Upskills\\src\\test\\resources\\ApiDemos-debug.apk")
                .setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos")
                ;

        //Driver:
        URL url = new URL("http://0.0.0.0:4723");  //burasi sabit
        AndroidDriver driver = new AndroidDriver(url,options);
    }

    //Yukarida gerekli tanimlamalarimizi DesiredCapabilities clasindan yada UiAutomator2Options clasindan obje olusturarak yaptik. Biz bunlardan herhangi birini kullanabiliriz.
    //Tercih edilen UiAutomator2Options clasidir.
}
