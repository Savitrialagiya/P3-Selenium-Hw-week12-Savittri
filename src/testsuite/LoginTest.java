package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilties.Utility;

public class LoginTest extends Utility {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        browserSetUp(baseUrl);
    }
    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “tomsmith” username
        sendTextToElement(By.name("username"), "tomsmith");
        //Enter “SuperSecretPassword!” password
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[@class=\"fa fa-2x fa-sign-in\"]"));
        //Verify the text “Welcome to the Secure Area. When you are done click logout below.”
        String expectedText = "Secure Area";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),\"Secure Area\")]"));
        //Validate actual and expected Message
        Assert.assertEquals(expectedText, actualText);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter “tomsmith1” username
        sendTextToElement(By.name("username"),"tomsmith1");
        //Enter “SuperSecretPassword!” password
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[@class=\"fa fa-2x fa-sign-in\"]"));
        //Verify the text “Your username is invalid!\n" + "×"”
        String expectedText = "Your username is invalid!\n" + "×";
        String actualText = getTextFromElement(By.xpath("//div[@class=\"flash error\"]"));
        //Validate actual and expected Message
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username
        sendTextToElement(By.name("username"),"tomsmith");
        //Enter “SuperSecretPassword!” password
        sendTextToElement(By.id("password"), "SuperSecretPassword");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[@class=\"fa fa-2x fa-sign-in\"]"));
        //Verify the error message “Your password is invalid!”
        String expectedText = "Your password is invalid!\n" + "×";
        String actualText = getTextFromElement(By.xpath("//div[@class=\"flash error\"]"));
        //Validate actual and expected Message
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
    }
