package Pages;

import Utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Helper {

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
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickPlaceOrder() {
        click(placeOrderButton);
    }

    public void fillOrderForm(String name, String country, String city, String card, String month, String year) throws InterruptedException {

        sendKeys(driver, nameInput, name);
        sendKeys(driver, countryInput, country);
        sendKeys(driver, cityInput, city);
        sendKeys(driver, cardInput, card);
        sendKeys(driver, monthInput, month);
        sendKeys(driver, yearInput, year);
    }

    public void clickPurchase() {
        click(purchaseButton);
    }

    public String getConfirmationText() {
        waitForElement(driver, confirmationDetails);
        return confirmationDetails.getText();
    }

    public boolean isConfirmationDisplayed() {
        waitForElement(driver, confirmationPopup);
        return confirmationPopup.isDisplayed();
    }

    public void clickOk() {
        click(okButton);
    }
}
