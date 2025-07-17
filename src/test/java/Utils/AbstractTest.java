package Utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;


public class AbstractTest {

    private WebDriver driver;
    @AfterTest
    public void quit() {

        if (this.driver == null) throw new AssertionError();
        this.driver.quit();
    }
}
