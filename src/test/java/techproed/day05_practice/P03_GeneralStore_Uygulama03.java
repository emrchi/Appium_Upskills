package techproed.day05_practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import techproed.baseTests.GeneralStroreBaseTest;

public class P03_GeneralStore_Uygulama03 extends GeneralStroreBaseTest {

        /*
        Uygulama: GeneralStore
    1. GeneralStore uygulamasına gir
    2. Menüden Angola seçeneğini seç
    3. Your Name kutusunu boş bırak
    4. Let’s Shop butonuna tıkla
    5. Hata mesajını doğrula (Toast Message)
         */

    @Test
    public void testGeneralStore2() {
        WebElement menu = driver.findElement(AppiumBy.id("android:id/text1"));
        menu.click();
        WebElement angola = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Angola\")"));
        angola.click();
        WebElement letsShopButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
        letsShopButton.click();
        //let's shop buttonuna tikladigimizda please enter your name uyari yazisi (Toast da deniyor) cikip belli bir sure sonra kayboluyor.
        //Biz bu uyari yazisinin locate'ini inspector den alamiyoruz bundan dolayi bu uyari yazisinin her zaman sabit olan tagi
        //yani "android.widget.Toast" tagini kullanarak getAttribute("name") metodu ile mesaji alabiliriz
        String toastMesaj = driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");
        System.out.println(toastMesaj);
        Assert.assertEquals(toastMesaj,"Please enter your name");


    }

}
