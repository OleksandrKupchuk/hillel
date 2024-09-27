package browserfactory;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(String browserName){
        createWebDriver(browserName);
        return driver.get();
    }

    private static void createWebDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_settings.popups", 0);
//                prefs.put("download.default_directory", "D:\\Homework\\Hillel\\target\\files");
                prefs.put("download.default_directory", Config.FILE_PATH);

                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);

                driver.set(new ChromeDriver(options));
                driver.get().manage().window().maximize();
                driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();

                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.download.folderList", 2);
                profile.setPreference("browser.download.dir", Config.FILE_PATH);

                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.setProfile(profile);

                driver.set(new FirefoxDriver(optionsFirefox));
                driver.get().manage().window().maximize();
                driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }
}
