package techproed.day04_practise;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.baseTests.GeneralStroreBaseTest;

import java.util.List;

public class P02_GeneralStore_Uygulama02 extends GeneralStroreBaseTest {

    /*
    Uygulama: GeneralStore
1. GeneralStore uygulamasına gir
2. Menüden Angola seçeneğini seç
3. Your Name kutusuna Safinaz yaz
4. Gender bölümünden Female seçeneğini seç
5. Let’s Shop butonuna tıkla
6. Ürün listesindeki iki ürünü sepete ekle
7. Sepete gir
8. Sepette iki ürün olduğunu doğrula
9. Ürün fiyatlarını topla
10. Total Purchase Amount bölümündeki tutarın doğru
olduğunu doğrula
11. Send me e-mails.. kutusunu seç
12. Visit to the website.. butonuna tıkla
     */

    @Test
    public void testGeneralStore() {

        By menu = AppiumBy.id("android:id/text1");
        By angola = AppiumBy.androidUIAutomator("new UiSelector().text(\"Angola\")");
        By yourName = AppiumBy.id("com.androidsample.generalstore:id/nameField");
        By genderFemale = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
        By letsShopButton = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");
        By firstProduct = AppiumBy.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])");
        By secondProduct = AppiumBy.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])");
        By cart = By.id("com.androidsample.generalstore:id/appbar_btn_cart");
        By cartProductList = By.id("com.androidsample.generalstore:id/productPrice");
        By totalPrice = AppiumBy.androidUIAutomator("new UiSelector().text(\"$ 280.97\")");
        By sendMeEmail = AppiumBy.className("android.widget.CheckBox");
        By visitWeb = By.id("com.androidsample.generalstore:id/btnProceed");

        driver.findElement(menu).click();
        driver.findElement(angola).click();
        driver.findElement(yourName).sendKeys("Safinaz");
        driver.findElement(genderFemale).click();
        driver.findElement(letsShopButton).click();
        driver.findElement(firstProduct).click();
        driver.findElement(secondProduct).click();
        driver.findElement(cart).click();
        List<WebElement> products = driver.findElements(cartProductList); //cikan iki urunu listeye price taglari ile aldik ki asagida tekrar locate almadan pricelarini toplayabilelim.
        Assert.assertEquals(products.size(), 2);

        double total = 0;
        for (int i = 0; i <products.size() ; i++) {        //products listesindeki urunleri for dongusu ile get text yapip sonra double'a cevirerek topladik
            double price = Double.parseDouble(products.get(i).getText().replace('$',' '));
            total += price;
        }
        System.out.println(total);
        double TotalPrice = Double.parseDouble(driver.findElement(totalPrice).getText().substring(1));
        System.out.println(TotalPrice);
        Assert.assertEquals(total, TotalPrice);

        driver.findElement(sendMeEmail).click();
        driver.findElement(visitWeb).click();
    }
}
