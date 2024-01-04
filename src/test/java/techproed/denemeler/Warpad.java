package techproed.denemeler;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Warpad {
    @Test
    public void warPad() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.wondergames.warpath.gp")
                .setAppActivity("com.lilithgames.wgame.internationallibrary.InternationalActivity");

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url,options);
    }
}
