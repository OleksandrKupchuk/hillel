package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import setup.TestSetup;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends TestSetup {

    @Test
    public void takeElementScreenshot(){
        getDriver().get("https://the-internet.herokuapp.com/challenging_dom");

        WebElement element = getDriver().findElement(By.cssSelector(".large-10.columns"));

        File elementScreenshot = element.getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(elementScreenshot, new File("target/newFolder/table.png"));//для того щоб автоматично створювалася папка використати FileUtils.copyFile(elementScreenshot, file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
