package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class WebDriverFactory {

    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver;

        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case EDGE:
                String driverPath = getDriverPath("msedgedriver.exe");
                System.setProperty("webdriver.edge.driver", driverPath);
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        driver.manage().window().maximize();
        return driver;
    }

    private static String getDriverPath(String driverName) {
        String basePath = new File("src/main/resources/Drivers").getAbsolutePath();
        return basePath + File.separator + driverName;
    }
}
