package Tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.*;
import Utils.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckoutTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    // Test data
    private final String name = "Kareem Adel";
    private final String country = "Egypt";
    private final String city = "Cairo";
    private final String card = "1234123412341234";
    private final String month = "07";
    private final String year = "2025";

    @BeforeTest
    public void setUp() {
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        homePage.open();

        String[] credentials = JsonUtil.getCredentials("src/main/resources/credentials.json");
        loginPage.login(credentials[0], credentials[1]);
    }

    @Test
    public void testFullCheckoutFlowWithValidation() throws InterruptedException, IOException {

        homePage.selectPhonesCategory();
        homePage.clickOnSamsungGalaxyS6();


        String productPrice = productPage.getProductPrice();

        String expectedAmount = productPrice
                .replace("$", "")
                .replace("*includes tax", "")
                .trim() + " USD";

        productPage.addToCart();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();


        cartPage.openCart();
        Thread.sleep(3000);

        checkoutPage.clickPlaceOrder();
        checkoutPage.fillOrderForm(name, country, city, card, month, year);
        checkoutPage.clickPurchase();

        Thread.sleep(3000);
        Assert.assertTrue(checkoutPage.isConfirmationDisplayed(), "Confirmation popup not displayed.");

        String confirmation = checkoutPage.getConfirmationText();
        System.out.println("Confirmation:\n" + confirmation);
        String[] lines = confirmation.split("\n");

        String orderId = lines[0].replace("Id: ", "").trim();
        String amountText = lines[1].replace("Amount: ", "").trim();
        String nameInPopup = lines[3].replace("Name: ", "").trim();

        Assert.assertFalse(orderId.isEmpty(), "Order ID is missing.");
        Assert.assertEquals(amountText, expectedAmount, "Amount does not match product price.");
        Assert.assertEquals(nameInPopup, name, "Name does not match input.");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File destFile = new File("screenshots/confirmation_" + timestamp + ".png");
        destFile.getParentFile().mkdirs();
        screenshot.renameTo(destFile);

        checkoutPage.clickOk();
    }

    @AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
