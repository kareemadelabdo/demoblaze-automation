package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By homeTitle = By.id("nava");
    private By phonesCategory = By.linkText("Phones");
    private By samsungGalaxyS6 = By.linkText("Samsung galaxy s6");
    protected WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(){
        driver.get("https://www.demoblaze.com");
    }

    public boolean isHomePageLoaded(WebDriver driver) throws InterruptedException {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(homeTitle, "PRODUCT STORE"));
    }
    public void selectPhonesCategory() {
        driver.findElement(phonesCategory).click();
    }

    public void clickOnSamsungGalaxyS6() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(samsungGalaxyS6).click();
    }


}
