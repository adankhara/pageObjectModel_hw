package pageObjectModel;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils
{
    HomePage homePage = new HomePage();
    LoadProp loadProp = new LoadProp();

    protected By genderMale = By.id("gender-male");
    protected By genderFemale = By.id("gender-female");
    protected By firstName = By.id("FirstName");
    protected By lastName = By.id("LastName");
    protected By dateOfBirth = By.xpath("//select[@name='DateOfBirthDay']\n");
    protected By monthOfBirth = By.xpath("//select[@name='DateOfBirthMonth']\n");
    protected By yearOfBirth = By.xpath("//select[@name='DateOfBirthYear']\n");
    protected By email = By.id("Email");
    protected By companyName = By.id("Company");
    protected By newsLetterOption = By.id("Newsletter");
    protected By password = By.id("Password");
    protected By confirmPassword = By.id("ConfirmPassword");
    protected By registerButton = By.id("register-button");

    String name = loadProp.getProperty("firstname");
    String surName = loadProp.getProperty("lastname");
    String birthMonth = loadProp.getProperty("monthofbirth");
    String birthYear = loadProp.getProperty("yearofbirth");
    String company = loadProp.getProperty("companyname");
    String passWord1 = loadProp.getProperty("password");
    String passWord2 = loadProp.getProperty("confirmpassword");


    public void toRegister()
    {
//   1. Click on Register button
        homePage.clickOnRegister();
//   2.	Select gender.
        clickElement(genderMale);
//   3.	Enter your first name in First Name field.
        enterText(firstName,name);
//   4.	Enter your last name in Last Name field
        enterText(lastName,surName);
//   5.	Select your date of birth.
        selectByIndex(dateOfBirth ,20);
        selectByVisibleText(monthOfBirth,birthMonth);
        selectByValue(yearOfBirth,birthYear);
//   6.	Enter your email address in Email field.
        enterText(email,"rajeshparekh"+longTimeStamp()+"@yahoo.com");
//   7.	Enter your company name.
        enterText(companyName,company);
//   8.	Select/deselect Newsletter option.
        clickElement(newsLetterOption);
//   9.	Enter password in Password field.
        enterText(password,passWord1);
//   10.Enter password in Confirm Password field.
        enterText(confirmPassword,passWord2);
//   11.Click on Register button.
        clickElement(registerButton);
        //String actualRegisterMessage = getText(By.xpath("//div[@class='result']"));
//   12.Click on continue button.
//      clickElement(By.linkText("Log out"));
    }
}
