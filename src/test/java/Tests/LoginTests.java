package Tests;
import Pages.HomePage;
import Utils.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.LoginPage;
import Utils.BrowserType;
import Utils.JsonUtil;
import Utils.WebDriverFactory;
public class LoginTests extends AbstractTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeTest
    public void setUp() {
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        homePage.open();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        String[] credentials = JsonUtil.getCredentials("src/main/resources/credentials.json");

        loginPage.login(credentials[0], credentials[1]);

        Assert.assertTrue(
                loginPage.getLoggedInUsername().contains(credentials[0]),
                "Login failed or username not displayed correctly.");
    }

}
