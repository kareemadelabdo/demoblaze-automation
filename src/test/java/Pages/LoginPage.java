package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginLink = By.id("login2");
    private By usernameInput = By.id("loginusername");
    private By passwordInput = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By loggedInUser = By.id("nameofuser");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        driver.findElement(loginLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUser));
    }

    public String getLoggedInUsername() {
        return driver.findElement(loggedInUser).getText();
    }
}
