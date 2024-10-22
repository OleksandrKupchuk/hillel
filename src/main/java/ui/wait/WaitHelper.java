package ui.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class WaitHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    private int TIME_OUT_IN_SECONDS = 10;
    private int POLING_EVERY_IN_SECONDS = 4;

    public WaitHelper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_IN_SECONDS));
    }

    public void waitOfVisibilityElement(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitAndGetOfVisibilityElement(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public Boolean waitOfInvisibilityElement(By element){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public WebElement fluentWaitOnElement(By element){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIME_OUT_IN_SECONDS))
                .pollingEvery(Duration.ofSeconds(POLING_EVERY_IN_SECONDS))
                .ignoring(NoSuchElementException.class);

        return wait.until(driver -> driver.findElement(element));
    }

    public boolean waitForDownloadFile(String filePath){
        return wait.until(webDriver -> {
            return Files.exists(Paths.get(filePath));
        });
    }
}
