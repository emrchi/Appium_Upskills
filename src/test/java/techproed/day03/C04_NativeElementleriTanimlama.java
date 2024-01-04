package techproed.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.baseTests.ApiDemosBaseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C04_NativeElementleriTanimlama extends ApiDemosBaseTest {   //burada BaseTest class ina extend yaparak basetest clasindaki setup() metodunu kullaniyoruz driveri set ediyoruz. bundan sonra yeni tyestlerde driver set etmemiz gerekmiyor her test icin

    @Test
    public void testWebElement() throws MalformedURLException {


        WebElement app = driver.findElement(AppiumBy.accessibilityId("App"));
        app.click(); //burada app butonina tiklamadan alarm butonun webelementini driver.find ile bul dersek no such element exception aliriz. cunku ana ekranda alarm butonu yok app butonuna dokununca aciln ekranda var.
        WebElement alarm = driver.findElement(AppiumBy.accessibilityId("Alarm"));
        alarm.click();
        WebElement alarmController = driver.findElement(AppiumBy.accessibilityId("Alarm Controller"));

    }

    @Test
    public void testBy() throws MalformedURLException {

        By app = AppiumBy.accessibilityId("App");
        By alarm = AppiumBy.accessibilityId("Alarm");  //burada code hata vermez cunku alarm elementini bul demiyoruz yani findElement demiyoruz. Burada sadece adres tanimlamasi yapiyoruz @FindBy daki gibi.
        By alarmController = AppiumBy.accessibilityId("Alarm Controller");

        driver.findElement(app).click();
        driver.findElement(alarm).click();
        driver.findElement(alarmController).click();
    }
}
