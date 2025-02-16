package Post;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
//done and tested
    public class GeneralPage<MobileElement> {
        public WebDriver driver;
        public static AndroidDriver driver1;
        WebDriverWait wait;

        public void WaitForPresenceOfElement(By byLocator, int timeout){
            wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
        }



        public String GetText(By by_locator){
            return driver
                    .findElement(by_locator)
                    .getText();
        }


        public void VerifyElementIsDisplayedAndClick(By byLocator){
            boolean isDispalyed = true;
            try {
                isDispalyed = driver.findElement(byLocator).isDisplayed();
                System.out.println(driver.findElement(byLocator).getText()+ " is displayed");
                driver.findElement(byLocator).click();
            }
            catch (Exception ex){
                System.out.println("Element is not Found:"+ex);
            }
        }
        public GeneralPage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }
        public void clearText(By byLocator){
            driver.findElement(byLocator).clear();
        }

        public void type(By byLocator, String text){
            driver.findElement(byLocator).sendKeys(text);
        }

        public void Click(By byLocator){
            driver.findElement(byLocator).click();
        }

        public void ScrollThePageUp(WebElement element1, WebElement element2) throws InterruptedException {
            Thread.sleep(5000);
            TouchAction<?> action = new TouchAction<>(driver1);
            action.longPress(LongPressOptions.longPressOptions()
                    .withElement(ElementOption.element(element1))
                    .withDuration(Duration.ofMillis(1000))).moveTo(ElementOption.element(element2)).release().perform();
            Thread.sleep(2000);
        }

    }


