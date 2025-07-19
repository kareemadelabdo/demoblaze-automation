package Tests;

import Pages.HomePage;
import Utils.AbstractTest;
import Utils.BrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Utils.WebDriverFactory.createDriver;

public class HomePageTests extends AbstractTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeTest
    public void setUp() {
        driver = createDriver(BrowserType.CHROME);
        homePage.open();
        homePage = new HomePage(driver);
    }

    @Test
    public void HomePageVisualization() throws InterruptedException {

        Assert.assertTrue(homePage.isHomePageLoaded(driver));
    }
}
