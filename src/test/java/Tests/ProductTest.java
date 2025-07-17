package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Utils.BrowserType;
import Utils.WebDriverFactory;
import Utils.JsonUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private ProductPage productPage;

    @BeforeTest
    public void setUp() {
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        loginPage = new LoginPage(driver);

        homePage.open();
        String[] credentials = JsonUtil.getCredentials("src/main/resources/credentials.json");
        loginPage.login(credentials[0], credentials[1]);
    }

    @Test
    public void testProductDetailsExtraction() throws InterruptedException {
        homePage.selectPhonesCategory();
        homePage.clickOnSamsungGalaxyS6();

        String title = productPage.getProductTitle();
        String price = productPage.getProductPrice();
        String description = productPage.getProductDescription();

        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);

        Assert.assertTrue(title.contains("Samsung"), "Product title is incorrect.");
        Assert.assertTrue(price.contains("$"), "Product price not found.");
        Assert.assertFalse(description.isEmpty(), "Description is missing.");
    }

    @AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
