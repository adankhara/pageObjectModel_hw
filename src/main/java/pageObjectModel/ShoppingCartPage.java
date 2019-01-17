package pageObjectModel;

import org.openqa.selenium.By;

public class ShoppingCartPage extends Utils
{
    HomePage homePage = new HomePage();

    protected By checkOutButton = By.id("checkout");
    protected By termsOfService = By.xpath("//input[@id='termsofservice']");


    public void clickOnCheckOut()
    {

//   To click on check out button
        clickElement(checkOutButton);
    }

    public void acceptTermsAndConditions()
    {

//   To accept terms and conditions
        clickElement(termsOfService);
    }
}
