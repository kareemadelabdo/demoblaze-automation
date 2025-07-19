package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    @FindBy(id = "nava")
    private WebElement homeTitle;
    @FindBy(linkText = "Phones")
    private WebElement phonesCategory;
    @FindBy(linkText = "Samsung galaxy s6")
    private WebElement samsungGalaxyS6;
    protected WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(){
        driver.get("https://www.demoblaze.com");
    }

    public boolean isHomePageLoaded(WebDriver driver) {
        wait.until(ExpectedConditions.visibilityOf(homeTitle));
        return homeTitle.getText().equals("PRODUCT STORE") ;
    }
    public void selectPhonesCategory() {
        phonesCategory.click();
    }

    public void clickOnSamsungGalaxyS6() throws InterruptedException {
        Thread.sleep(1000);
        samsungGalaxyS6.click();
    }


}
