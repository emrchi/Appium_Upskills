package techproed.homeworks;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.baseTests.CalculatorBaseTest;

public class HW03_Calculator_Test extends CalculatorBaseTest {

    //Slayt 5 sayfa 13 deki homework

    @Test
    public void test2PozToplama() {
        By bir = AppiumBy.accessibilityId("1");
        By dort = AppiumBy.accessibilityId("4");
        By toplama = AppiumBy.accessibilityId("Plus");
        By result = AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_tv_result");
        driver.findElement(bir).click();
        driver.findElement(toplama).click();
        driver.findElement(dort).click();
        int toplam = 1+4;
        Assert.assertEquals(toplam,Integer.parseInt(driver.findElement(result).getText()));
    }

    @Test
    public void test1Poz1NegToplama() {
        By iki = AppiumBy.accessibilityId("2");
        By dort = AppiumBy.accessibilityId("4");
        By negatif = AppiumBy.accessibilityId("Switch between plus and minus");
        By toplama = AppiumBy.accessibilityId("Plus");
        By result = AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_tv_result");
        driver.findElement(iki).click();
        driver.findElement(toplama).click();
        driver.findElement(negatif).click();
        driver.findElement(dort).click();
        int toplam = 2+(-4);
        String strToplam = Integer.toString(toplam);
        Assert.assertEquals(strToplam,driver.findElement(result).getText());
    }

    @Test
    public void test2NegToplama() {
        By iki = AppiumBy.accessibilityId("2");
        By dort = AppiumBy.accessibilityId("4");
        By negatif = AppiumBy.accessibilityId("Switch between plus and minus");
        By toplama = AppiumBy.accessibilityId("Plus");
        By result = AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_tv_result");
        driver.findElement(negatif).click();
        driver.findElement(iki).click();
        driver.findElement(toplama).click();
        driver.findElement(negatif).click();
        driver.findElement(dort).click();
        int toplam = (-2)+(-4);
        String strToplam = Integer.toString(toplam);
        Assert.assertEquals(strToplam,driver.findElement(result).getText());
    }
}
