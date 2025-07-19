package Pages;

import Utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Helper {
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
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        click(loginButton);
        sendKeys(driver, usernameInput, username);
        sendKeys(driver, passwordInput, password);
        click(loginButton);

        waitForElement(driver, loggedInUser);
    }

    public String getLoggedInUsername() {
        waitForElement(driver, loggedInUser);
        return loggedInUser.getText();
    }
}
