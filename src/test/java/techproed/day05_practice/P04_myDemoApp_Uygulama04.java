package techproed.day05_practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.baseTests.MyDemoAppBaseTest;

import java.util.List;

public class P04_myDemoApp_Uygulama04 extends MyDemoAppBaseTest {
        /*
        Uygulama: MyDemoApp
    1. MyDemoApp uygulamasına gir
    2. Menüyü aç
    3. Login ol (bob@example.com, 10203040)
    4. Login butonuna tıkla
    5. İlk ürünü seç
    6. Renk olarak mavi seç
    7. Add To Cart butonuna tıkla
    8. Renk olarak kırmızı seç
    9. Add To Cart butonuna tıkla
    10. Sepete git
    11. Listede iki ürün olduğunu doğrla
    12. Listedeki ürünlerin mavi ve kırmızı olduğunu doğrula
        */

    @Test
    public void testMyDemoApp() {
        WebElement menu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        menu.click();
        WebElement loginMenu = driver.findElement(AppiumBy.accessibilityId("menu item log in"));
        loginMenu.click();
        WebElement username = driver.findElement(AppiumBy.accessibilityId("Username input field"));
        username.sendKeys("bob@example.com");
        WebElement password = driver.findElement(AppiumBy.accessibilityId("Password input field"));
        password.sendKeys("10203040");
        driver.hideKeyboard();  // bazen icine birsey yazacagimiz kutucuga tiklamasak da sendkey() yapsak klavye acilir ve loginbutton bu klavyenin altinda kaldigi icin gorunmez ve no such element exp. aliriz onun icin driver.hidekeyboard ile klavyeyi kapatiriz.
        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("Login button"));
        loginButton.click();
        WebElement productTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));
        productTitle.click();
        //WebElement  blueCircle = driver.findElement(AppiumBy.accessibilityId("blue circle"));
        // Sayfa degistiginde ayni elementi kullanmak istiyorum. Stale element almamak icin By ile tanimladim.(element bayatlamasin diye)
        By blueCircle = AppiumBy.accessibilityId("blue circle");
        driver.findElement(blueCircle).click();
        WebElement addToCartButton = driver.findElement(AppiumBy.accessibilityId("Add To Cart button"));
        addToCartButton.click();
        //WebElement redCircle = driver.findElement(AppiumBy.accessibilityId("red circle"));
        By redCircle = AppiumBy.accessibilityId("red circle");
        driver.findElement(redCircle).click();
        addToCartButton.click();
        WebElement cartBadge = driver.findElement(AppiumBy.accessibilityId("cart badge"));
        cartBadge.click();
        List<WebElement> productRow = driver.findElements(AppiumBy.accessibilityId("product row"));
        Assert.assertEquals(productRow.size(), 2);

        Assert.assertTrue(driver.findElement(blueCircle).isDisplayed());
        Assert.assertTrue(driver.findElement(redCircle).isDisplayed());

        WebElement blueCircle2 = driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"product row\"])[1]//android.view.ViewGroup[contains(@content-desc,'blue circle')]"));
        //burada xpath ile aldik locate'i bunuda kullanabiliriz.
    }
}
