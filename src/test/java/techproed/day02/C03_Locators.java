package techproed.day02;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.baseTests.ApiDemosBaseTest;

import java.net.MalformedURLException;
import java.net.URL;

public class C03_Locators  {


    @Test
    public void testLocators() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("C:\\Users\\emres\\IdeaProjects\\Appium_Upskills\\src\\test\\resources\\ApiDemos-debug.apk");

        //Driver:
        URL url = new URL("http://0.0.0.0:4723");  //burasi sabit
        AndroidDriver driver = new AndroidDriver(url, options);

        //1- accessibilityId
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("Accessibility ID = " + element.getText());
        //2- id
        element = driver.findElements(AppiumBy.id("android:id/text1")).get(1); //Ayni id ile birden cok element oldugu icin list dondurur bizde get(indexno) ile istedigimiz elementi aliriz
        System.out.println("ID = " + element.getText());
        //3- className
        element = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("ClassName = " + element.getText());
        //4- androidUiAutomator
        element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("Android Ui Automator = " + element.getText());
        //5 xpath
        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Accessibility\"]"));
        System.out.println("xpath = " + element.getText());
    }
}
