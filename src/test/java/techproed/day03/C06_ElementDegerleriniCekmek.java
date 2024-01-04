package techproed.day03;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.baseTests.ApiDemosBaseTest;


public class C06_ElementDegerleriniCekmek extends ApiDemosBaseTest {

    @Test
    public void testElementDegerleriniCekme() {

        By accessibility = AppiumBy.accessibilityId("Accessibility");
        System.out.println("getText() = " + driver.findElement(accessibility).getText());

        System.out.println("getAttribute() = " + driver.findElement(accessibility).getAttribute("package"));
        System.out.println("getAttribute() = " + driver.findElement(accessibility).getAttribute("checkable"));

        System.out.println("isSelected() = " + driver.findElement(accessibility).isSelected());

        System.out.println("isEnabled() = " + driver.findElement(accessibility).isEnabled());

        System.out.println("isDisplayed() = " + driver.findElement(accessibility).isDisplayed());

        System.out.println("getSize() = " + driver.findElement(accessibility).getSize());
        System.out.println("getSize(width) = " + driver.findElement(accessibility).getSize().getWidth());

        System.out.println("getLocation() = " + driver.findElement(accessibility).getLocation());
        System.out.println("getLocation(x) = " + driver.findElement(accessibility).getLocation().getX());


    }
}
