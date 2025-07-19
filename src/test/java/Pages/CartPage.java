package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    @FindBy(id = "cartur")
    private WebElement cartLink;

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr")
    private List<WebElement> productRows;

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[2]")
    private WebElement productNameCell;

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[3]")
    private WebElement productPriceCell;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        cartLink.click();
    }

    public String getProductName() {
        return productNameCell.getText();
    }

    public String getProductPrice() {
        return productPriceCell.getText();
    }

    public boolean isProductPresent() {
        return !productRows.isEmpty();
    }
}
