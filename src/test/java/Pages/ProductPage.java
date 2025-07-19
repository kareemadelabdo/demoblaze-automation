package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
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
        this.driver = driver;
    }

    public String getProductTitle() throws InterruptedException {
        Thread.sleep(1000);
        return productTitle.getText();
    }

    public String getProductPrice() throws InterruptedException {
        Thread.sleep(1000);
        return productPrice.getText();
    }

    public String getProductDescription() throws InterruptedException {
        Thread.sleep(2000);
        return productBody.getText();
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(2000);
        addToCartButton.click();
    }
}
