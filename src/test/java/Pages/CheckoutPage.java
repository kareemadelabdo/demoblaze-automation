package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By placeOrderButton = By.xpath("//button[text()='Place Order']");
    private By nameInput = By.id("name");
    private By countryInput = By.id("country");
    private By cityInput = By.id("city");
    private By cardInput = By.id("card");
    private By monthInput = By.id("month");
    private By yearInput = By.id("year");

    private By purchaseButton = By.xpath("//button[text()='Purchase']");
    private By confirmationPopup = By.className("sweet-alert");
    private By confirmationDetails = By.cssSelector(".sweet-alert > p");
    private By okButton = By.xpath("//button[text()='OK']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public void fillOrderForm(String name, String country, String city, String card, String month, String year) throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(countryInput).sendKeys(country);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(cardInput).sendKeys(card);
        driver.findElement(monthInput).sendKeys(month);
        driver.findElement(yearInput).sendKeys(year);
    }

    public void clickPurchase() {
        driver.findElement(purchaseButton).click();
    }

    public String getConfirmationText() {
        return driver.findElement(confirmationDetails).getText();
    }

    public boolean isConfirmationDisplayed() {
        return driver.findElement(confirmationPopup).isDisplayed();
    }

    public void clickOk() {
        driver.findElement(okButton).click();
    }
}
