package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    protected final WebDriver driver;
    protected WebDriverWait wait;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement webElement) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void waitForElement(WebDriver driver, WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void sendKeys(WebDriver webDriver, WebElement webElement, String value) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.sendKeys(value);
    }
}
