package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ui.setup.TestSetup;

public class FramesTest extends TestSetup {

    @Test
    public void checkNestedFrame() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/nested_frames");

        getDriver().switchTo().frame("frame-top");
        getDriver().switchTo().frame("frame-left");
        WebElement body = getDriver().findElement(By.xpath("//body"));
        "LEFT".contains(body.getText());
    }

//    @Test
//    public void checkAmountFrames(){
//        getDriver().get("https://the-internet.herokuapp.com/nested_frames");
//
//        List<WebElement> frames = getDriver().findElements(By.tagName("frame"));
//        System.out.println(frames.size());
//    }
//
//    @Test
//    public void checkFrameByIndex(){
//        getDriver().get("https://the-internet.herokuapp.com/iframe");
//        getDriver().switchTo().frame(0);
//        WebElement paragraph = getDriver().findElement(By.cssSelector("#tinymce p"));
//        Assert.assertEquals(paragraph.getText(), "Your content goes here.");
//
//        getDriver().switchTo().defaultContent();
//        WebElement title = getDriver().findElement(By.xpath("//h3"));
//        Assert.assertEquals(title.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
//    }
}
