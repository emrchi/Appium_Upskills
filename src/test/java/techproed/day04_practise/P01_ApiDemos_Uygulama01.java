package techproed.day04_practise;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.baseTests.ApiDemosBaseTest;

public class P01_ApiDemos_Uygulama01 extends ApiDemosBaseTest {
    /*
        Uygulama: ApiDemos
    1. API Demos uygulamasına gir
    2. Preference seçeneğine tıkla
    3. 3. Preference dependencies seçeneğine tıkla
    4. WiFi kontrol kutusunu seç
    5. WiFi settings seçeneğine tıkla
    6. Açılan ekrandaki başlığın WiFi settings olduğunu
    doğrula
    7. Metin kutusuna adını yaz
    8. Tamam butonuna tıkla
     */

    @Test
    public void testApiDemos() {

        By preference = AppiumBy.accessibilityId("Preference");
        By preferenceDependencies = AppiumBy.accessibilityId("3. Preference dependencies");
        By wifiControlKutusu = AppiumBy.id("android:id/checkbox");
        By wifiSettings = AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")");
        By baslik = AppiumBy.id("android:id/alertTitle");
        By metinKutusu = AppiumBy.id("android:id/edit");
        By tamamButonu = AppiumBy.id("android:id/button1");

        driver.findElement(preference).click();
        driver.findElement(preferenceDependencies).click();
        driver.findElement(wifiControlKutusu).click();
        driver.findElement(wifiSettings).click();
        Assert.assertEquals(driver.findElement(baslik).getText(),"WiFi settings");
        driver.findElement(metinKutusu).sendKeys("Emre YILMAZ");
        driver.findElement(tamamButonu).click();


    }
}
