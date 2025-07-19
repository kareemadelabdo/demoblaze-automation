package Pages;

import Utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends Helper {

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
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCart() {
        click(cartLink);
    }

    public String getProductName() {
        waitForElement(driver, productNameCell);
        return productNameCell.getText();
    }

    public String getProductPrice() {
        waitForElement(driver, productPriceCell);
        return productPriceCell.getText();
    }

    public boolean isProductPresent() {
        waitForElement(driver, productRows.getFirst());
        return !productRows.isEmpty();
    }
}
