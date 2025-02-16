
import Post.SplashPost;
import Post.TestQA;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;

public class TestABC extends SplashPost {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"TestData.json";

    TestQA test;

    @BeforeClass
    public void Setup() throws MalformedURLException, InterruptedException {
        LaunchPostApp();

        test = new TestQA(driver);
    }

    @Test(priority = 1) //plus icon press
    public void testAddPost() {
        test.enter_title();
    }

    @Test(priority = 2) //edit meatb
    public static void testEditPost() {
        var postView = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View"));

        var postToEdit = postView.findElement(By.xpath("//android.widget.Button[1]"));
        postToEdit.click();

        var editButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Edit\"]"));
        editButton.click();

        var edit1 = driver.findElement(By.xpath("//android.view.View[@content-desc='Update Post']/android.widget.EditText[1]"));
        edit1.clear();
        edit1.sendKeys("Sakar Aryal");

        var edit2 = driver.findElement(By.xpath("//android.view.View[@content-desc='Update Post']/android.widget.EditText[2]"));
        edit2.clear();
        edit2.sendKeys("Sakar Aryal");

        var updateButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Update Post']"));
        updateButton.click();
    }

    @Test(priority = 3) //delete meatb
    public static void testDeletePost() {
        var postView = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View"));

        var postToEdit = postView.findElement(By.xpath("//android.widget.Button[1]"));
        postToEdit.click();

        var deleteButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Delete\"]"));
        deleteButton.click();
    }

}
