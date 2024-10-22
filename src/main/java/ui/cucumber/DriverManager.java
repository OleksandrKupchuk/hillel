package ui.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static DriverManager instance = new DriverManager();

    public static DriverManager getInstance(){
        return instance;
    }

    public void createWebDriver(){
        driver.set(new ChromeDriver());
    }

    public WebDriver getDriver(){
        return driver.get();
    }
}
