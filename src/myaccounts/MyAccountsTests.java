package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class MyAccountsTests extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option) {
        //1.2 This method should click on the options whatever name is passed as parameter.
        //(Hint: Handle List of Element and Select options)
        List<WebElement> options = new ArrayList<>();
        clickOnElement(By.linkText(option));
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        clickOnElement(By.linkText("My Account"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Register Account')]"), "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        clickOnElement(By.linkText("My Account"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Returning Customer')]"), "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        clickOnElement(By.linkText("My Account"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendTextToElement(By.id("input-firstname"), "James");
        //3.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"), "Bond");
        //3.5 Enter Email
        sendTextToElement(By.id("input-email"), "James1@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.id("input-telephone"), "01254 3456");
        //3.7 Enter Password
        sendTextToElement(By.id("input-password"), "James@123");
        //3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "James@123");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.name("agree"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"), "Your Account Has Been Created!");
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Click on My Account Link.
        clickOnElement(By.linkText("My Account"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        clickOnElement(By.linkText("My Account"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"), "James1@gmail.com");
        //4.4 Enter Last Name
        //4.5 Enter Password
        sendTextToElement(By.id("input-password"), "James@123");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        verifyExpectedAndActual(By.linkText("My Account"), "My Account");
        //4.8 Click on My Account Link.
        clickOnElement(By.linkText("My Account"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
