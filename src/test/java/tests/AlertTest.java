package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AlertTest {
    private WebDriver driver;

    @Test
    public void checkAlertPrompt(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String alertMessage = "Test alert prompt";

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(alertMessage);
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));

        String expectedResult = String.format("You entered: %s", alertMessage);
        Assert.assertEquals(result.getText(), expectedResult);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
