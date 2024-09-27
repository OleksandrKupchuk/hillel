package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.TestSetup;

import java.util.ArrayList;

public class WindowsTest extends TestSetup {

    @Test
    public void checkSwitchToSecondWindow(){
        getDriver().get("https://the-internet.herokuapp.com/windows");

        getDriver().findElement(By.linkText("Click Here")).click();

        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));

        WebElement title = getDriver().findElement(By.xpath("//h3"));
        Assert.assertEquals(title.getText(), "New Window");
    }
}
