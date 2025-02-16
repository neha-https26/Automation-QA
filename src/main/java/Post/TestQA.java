package Post;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.io.File;


    public class TestQA extends GeneralPage {
        String path = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "TestData.json";
        public static AndroidDriver driver;

        public TestQA(AndroidDriver driver) {
            super(driver);
            this.driver = driver;
        }


        public void enter_title() {
            By addBtn = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button");
            WaitForPresenceOfElement(addBtn, 10);
            Click(addBtn);

            By addField = By.xpath("//android.view.View[@content-desc='Add Post']/android.widget.EditText[1]");
            Click(addField);
            type(addField, "This is Title");

            By contentField = By.xpath("//android.view.View[@content-desc='Add Post']/android.widget.EditText[2]");
            Click(contentField);
            type(contentField, "This is Content");

            By submitBtn = By.xpath("//android.widget.Button[@content-desc='Add Post']");
            Click(submitBtn);
        }
    }

