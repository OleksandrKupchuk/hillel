package patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SimpleFactory {
    public WebDriver createWebDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();

            case "firefox":
                return new FirefoxDriver();

            case "ie":
                return new InternetExplorerDriver();

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }
}
