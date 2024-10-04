package tests.selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;

public class TableTest {

    @Test
    public void checkLastName(){
        Selenide.open("https://the-internet.herokuapp.com/tables");
        WebDriverRunner.getWebDriver().manage().window().maximize();

        ElementsCollection firstTableLine = $$(By.xpath("//tr//td")).first(5);

        Assert.assertEquals(firstTableLine.get(0).getText(), "Smith");
        Assert.assertEquals(firstTableLine.get(1).getText(), "John");
        Assert.assertEquals(firstTableLine.get(2).getText(), "jsmith@gmail.com");
        Assert.assertEquals(firstTableLine.get(3).getText(), "$50.00");
        Assert.assertEquals(firstTableLine.get(4).getText(), "http://www.jsmith.com");
    }

    @Test
    public void checkAmountEditAndDeleteButton(){
        Selenide.open("https://the-internet.herokuapp.com/tables");
        WebDriverRunner.getWebDriver().manage().window().maximize();

        ElementsCollection amountEditAndDeleteButtons = $$(By.xpath("//td/a"))
                .should(CollectionCondition.size(16));

        Assert.assertEquals(amountEditAndDeleteButtons.size(), 16);
    }
}
