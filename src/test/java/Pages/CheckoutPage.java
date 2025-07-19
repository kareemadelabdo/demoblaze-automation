package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "country")
    private WebElement countryInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "card")
    private WebElement cardInput;

    @FindBy(id = "month")
    private WebElement monthInput;

    @FindBy(id = "year")
    private WebElement yearInput;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    @FindBy(className = "sweet-alert")
    private WebElement confirmationPopup;

    @FindBy(css = ".sweet-alert > p")
    private WebElement confirmationDetails;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okButton;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlaceOrder() {
        placeOrderButton.click();
    }

    public void fillOrderForm(String name, String country, String city, String card, String month, String year) throws InterruptedException {
        Thread.sleep(4000);
        nameInput.sendKeys(name);
        countryInput.sendKeys(country);
        cityInput.sendKeys(city);
        cardInput.sendKeys(card);
        monthInput.sendKeys(month);
        yearInput.sendKeys(year);
    }

    public void clickPurchase() {
        purchaseButton.click();
    }

    public String getConfirmationText() {
        return confirmationDetails.getText();
    }

    public boolean isConfirmationDisplayed() {
        return confirmationPopup.isDisplayed();
    }

    public void clickOk() {
        okButton.click();
    }
}
