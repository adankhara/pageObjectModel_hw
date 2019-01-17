package pageObjectModel;

import org.openqa.selenium.By;

public class LogInPage extends Utils
{
    HomePage homePage = new HomePage();
    LoadProp loadProp = new LoadProp();

    String loginPassword = loadProp.getProperty("loginpassword");

    protected By registeredEmail = By.id("Email");
    protected By password = By.id("Password");
    protected By logIn = By.xpath("//input[@value='Log in']");

    public void toLogIn()
    {
//   1. To click on Log in button
        homePage.clickOnLogIn();
//   2. Enter your registered email Id in email field.
        enterText(registeredEmail, loadProp.getRegisterEmail());
//   3.	Enter your password in password field.
        enterText(password,loginPassword);
//   4.	Click on Login button.
        clickElement(logIn);
    }
}
