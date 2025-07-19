package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "login2")
    private WebElement loginLink;

    @FindBy(id = "loginusername")
    private WebElement usernameInput;

    @FindBy(id = "loginpassword")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(id = "nameofuser")
    private WebElement loggedInUser;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        loginLink.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(loggedInUser));
    }

    public String getLoggedInUsername() {
        return loggedInUser.getText();
    }
}
