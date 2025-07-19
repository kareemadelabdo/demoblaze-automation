package Pages;

import Utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Helper {

    private WebDriver driver;
    @FindBy(id = "nava")
    private WebElement homeTitle;
    @FindBy(linkText = "Phones")
    private WebElement phonesCategory;
    @FindBy(linkText = "Samsung galaxy s6")
    private WebElement samsungGalaxyS6;
    protected WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.demoblaze.com");
    }

    public boolean isHomePageLoaded(WebDriver driver) {
        waitForElement(driver, homeTitle);
        return homeTitle.getText().equals("PRODUCT STORE");
    }

    public void selectPhonesCategory() {
        click(phonesCategory);
    }

    public void clickOnSamsungGalaxyS6() {
        click(samsungGalaxyS6);
    }


}
