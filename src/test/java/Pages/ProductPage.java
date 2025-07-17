package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductPage {
    private WebDriver driver;

    private By productTitle = By.className("name");
    private By productPrice = By.className("price-container");
    private By productBody = By.xpath("//*[@id=\"more-information\"]/p");
    private By addToCartButton = By.linkText("Add to cart");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(productTitle).getText();
    }

    public String getProductPrice() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(productPrice).getText();
    }

    public String getProductDescription() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(productBody).getText();
    }
    public void addToCart() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(addToCartButton).click();
    }
}
