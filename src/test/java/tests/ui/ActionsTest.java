package tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActionsTest {

    @Test
    public void dragAndDrop() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(source, target).build().perform();

        driver.quit();
    }

    @Test
    public void dragAndDropWithMouse() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        actions.clickAndHold(source)
                .moveToElement(target)
                .release()
                .build()
                .perform();

        driver.quit();
    }

    @Test
    public void checkImitationKeyboardWithoutActions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String inputValue = "value";

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement inputField = driver.findElement(By.id("username"));
        inputField.sendKeys(inputValue);
        inputField.click();
        inputField.sendKeys(Keys.chord(Keys.CONTROL, "A"));
        inputField.sendKeys(Keys.chord(Keys.CONTROL, "C"));
        inputField.click();

        inputField.sendKeys(Keys.chord(Keys.CONTROL, "V"));

        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void checkContextMenu() throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        Actions actions = new Actions(driver);

        WebElement inputField = driver.findElement(By.linkText("A/B Testing"));
        actions.contextClick(inputField).build().perform();

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void checkScroll() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com");

        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.linkText("WYSIWYG Editor"));

        actions.scrollToElement(target)
                .build()
                .perform();

        Thread.sleep(1000);
        driver.quit();
    }
}
