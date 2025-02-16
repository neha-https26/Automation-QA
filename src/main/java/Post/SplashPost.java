package Post;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class SplashPost {

    public static AndroidDriver driver;
    public WebDriver driver1;
    DesiredCapabilities cap;

    //launching the postapp right way

    public void LaunchPostApp() throws MalformedURLException, InterruptedException {
        cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "MyDevice");
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "uiautomator2");
        cap.setCapability("appPackage", "com.example.post_app");
        cap.setCapability("appActivity", "com.example.post_app.MainActivity");

        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        driver = new AndroidDriver(url, cap);
        System.out.println("Application is started");
        Thread.sleep(5000);


    }
}
