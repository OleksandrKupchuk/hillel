package ui.browserfactory;

import ui.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import ui.logger.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    private Logger logger = new Logger();
    private static BrowserFactory instance = new BrowserFactory();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<String> sessionId = new ThreadLocal<>();

    public static BrowserFactory getInstance(){
        return instance;
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    public void createWebDriver(String browserName) {
        if (driver.get() != null){
            return;
        }
        switch (browserName.toLowerCase()) {
            case "chrome":
                createChromeDriver();
                break;

            case "firefox":
                createFirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

    public void createChromeDriver(){
        WebDriverManager.chromedriver().setup();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", Config.FILE_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("sessionTimeout", "15m");
            put("videoFrameRate", 24);
            put("enableVideo", true);
        }});
        options.setExperimentalOption("prefs", prefs);
//        options.setCapability("browserVersion", "127");

        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(Config.URL_REMOTE), options);
            driver.set(remoteWebDriver);
            sessionId.set(remoteWebDriver.getSessionId().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

//        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void createFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", Config.FILE_PATH);

        FirefoxOptions optionsFirefox = new FirefoxOptions();
        optionsFirefox.setProfile(profile);

        driver.set(new FirefoxDriver(optionsFirefox));
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void closeWebDriver(){
        driver.get().quit();
        driver.remove();
    }

    public void addVideoLink(){
        logger.log("http://localhost:4444/video/" + sessionId.get() + ".mp4");
    }
}
