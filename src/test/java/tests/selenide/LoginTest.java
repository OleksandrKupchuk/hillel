package tests.selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest {

    @Test
    public void login(){
        Selenide.open("https://the-internet.herokuapp.com/login");
        WebDriverRunner.getWebDriver().manage().window().maximize();

        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $(".radius").click();

        SelenideElement subTitle = $(By.xpath("//h4"));

        Assert.assertEquals(subTitle.getText(), "Welcome to the Secure Area. When you are done click logout below.");
    }
}
