package Pages;

import Utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Helper {
    private WebDriver driver;

    @FindBy(className = "name")
    private WebElement productTitle;

    @FindBy(className = "price-container")
    private WebElement productPrice;

    @FindBy(xpath = "//*[@id='more-information']/p")
    private WebElement productBody;

    @FindBy(linkText = "Add to cart")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductTitle() {
        waitForElement(driver, productTitle);
        return productTitle.getText();
    }

    public String getProductPrice() {
        waitForElement(driver, productPrice);
        return productPrice.getText();
    }

    public String getProductDescription() {
        waitForElement(driver, productBody);
        return productBody.getText();
    }

    public void addToCart() {
        click(addToCartButton);
    }
}
