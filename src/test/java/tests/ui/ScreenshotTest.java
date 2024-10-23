package tests.ui;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ui.setup.TestSetup;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends TestSetup {

    @Test
    public void takeElementScreenshot(){
        getDriver().get("https://the-internet.herokuapp.com/challenging_dom");

        WebElement element = getDriver().findElement(By.cssSelector(".large-10.columns"));

        File elementScreenshot = element.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(elementScreenshot, new File("target/newFolder/table.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
