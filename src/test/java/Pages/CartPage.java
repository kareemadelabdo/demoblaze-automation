package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By cartLink = By.id("cartur");
    private By productRow = By.xpath("//tbody[@id='tbodyid']/tr");
    private By productNameCell = By.xpath("//tbody[@id='tbodyid']/tr/td[2]");
    private By productPriceCell = By.xpath("//tbody[@id='tbodyid']/tr/td[3]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }

    public String getProductName() {
        return driver.findElement(productNameCell).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPriceCell).getText();
    }

    public boolean isProductPresent() {
        return !driver.findElements(productRow).isEmpty();
    }
}
