package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import setup.TestSetup;

public class ShadowRootTest extends TestSetup {

    @Test
    public void checkFindElementInShadowRoot() {
        Actions actions = new Actions(getDriver());

        getDriver().get("https://selectorshub.com/xpath-practice-page/");

        actions.moveByOffset(0, 500).build().perform();

        WebElement shadowHost = getDriver().findElement(By.cssSelector("#userName"));

        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement userNameInput = shadowRoot.findElement(By.id("kils"));

        actions.moveToElement(userNameInput);

        userNameInput.sendKeys("Some name");
    }
}
