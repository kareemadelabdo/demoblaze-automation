package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AbstractTest {

    private WebDriver driver;

    public void takeScreenShot(){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File destFile = new File("screenshots/confirmation_" + timestamp + ".png");
        destFile.getParentFile().mkdirs();
        screenshot.renameTo(destFile);
    }
    @AfterTest
    public void quit() {

        if (this.driver == null) throw new AssertionError();
        this.driver.quit();
    }
}
