package techproed.homeworks;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.baseTests.ApiDemosBaseTest;

public class HW02_ApiDemos_GetText extends ApiDemosBaseTest {

    //Slayt5 sayfa sekiz homework 2

    @Test
    public void testApiDemosGetText() throws InterruptedException {
        By accessibility = AppiumBy.accessibilityId("Accessibility");
        driver.findElement(accessibility).click();
        By accessibilityNodeProvider =AppiumBy.accessibilityId("Accessibility Node Provider");
        By accessibilityNodeQuerying =AppiumBy.accessibilityId("Accessibility Node Querying");
        By accessibilityService =AppiumBy.accessibilityId("Accessibility Service");
        By customView =AppiumBy.accessibilityId("Custom View");
        System.out.println(driver.findElement(accessibilityNodeProvider).getText());
        System.out.println(driver.findElement(accessibilityNodeQuerying).getText());
        System.out.println(driver.findElement(accessibilityService).getText());
        System.out.println(driver.findElement(customView).getText());

        KeyEvent back = new KeyEvent(AndroidKey.BACK);
        driver.pressKey(back);
        System.out.println("**********");

        By content = AppiumBy.id("android:id/text1");
        driver.findElements(content).get(4).click();
        System.out.println(driver.findElements(content).get(0).getText());
        System.out.println(driver.findElements(content).get(1).getText());
        System.out.println(driver.findElements(content).get(2).getText());
        System.out.println(driver.findElements(content).get(3).getText());
        System.out.println(driver.findElements(content).get(4).getText());
        System.out.println(driver.findElements(content).get(5).getText());

        driver.pressKey(back);
        System.out.println("**********");

        By media = AppiumBy.className("android.widget.TextView");
        driver.findElements(media).get(7).click();
        System.out.println(driver.findElements(media).get(1).getText());
        System.out.println(driver.findElements(media).get(2).getText());
        System.out.println(driver.findElements(media).get(3).getText());

        driver.pressKey(back);
        System.out.println("**********");

        By nfc = AppiumBy.androidUIAutomator("new UiSelector().text(\"NFC\")");
        driver.findElement(nfc).click();
        By foregroundDispatch = AppiumBy.androidUIAutomator("new UiSelector().text(\"ForegroundDispatch\")");
        By foregroundNdefPush = AppiumBy.androidUIAutomator("new UiSelector().text(\"ForegroundNdefPush\")");
        By techFilter = AppiumBy.androidUIAutomator("new UiSelector().text(\"TechFilter\")");
        System.out.println(driver.findElement(foregroundDispatch).getText());
        System.out.println(driver.findElement(foregroundNdefPush).getText());
        System.out.println(driver.findElement(techFilter).getText());

        driver.pressKey(back);
        System.out.println("**********");

        By os = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"OS\"]");
        driver.findElement(os).click();
        By morseCode = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Morse Code\"]");
        By rotationVector = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Rotation Vector\"]");
        By sensors = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Sensors\"]");
        By smsMessaging = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"SMS Messaging\"]");
        System.out.println(driver.findElement(morseCode).getText());
        System.out.println(driver.findElement(rotationVector).getText());
        System.out.println(driver.findElement(sensors).getText());
        System.out.println(driver.findElement(smsMessaging).getText());


    }
}
