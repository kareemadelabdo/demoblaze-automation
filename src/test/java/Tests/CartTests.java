package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.*;
import Utils.*;

public class CartTests {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeTest
    public void setUp() {
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        homePage.open();

        String[] credentials = JsonUtil.getCredentials("src/main/resources/credentials.json");
        assert credentials != null;
        loginPage.login(credentials[0], credentials[1]);
    }

    @Test
    public void testAddToCartAndVerify() throws InterruptedException {
        homePage.selectPhonesCategory();
        homePage.clickOnSamsungGalaxyS6();

        productPage.addToCart();

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Product added"), "Unexpected alert message.");
        alert.accept();

        cartPage.openCart();
        Thread.sleep(3000);

        Assert.assertTrue(cartPage.isProductPresent(), "Product not found in cart.");
        Assert.assertTrue(cartPage.getProductName().contains("Samsung"), "Incorrect product in cart.");
        Assert.assertTrue(cartPage.getProductPrice().matches("\\d+"), "Invalid product price.");
    }

    @AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
