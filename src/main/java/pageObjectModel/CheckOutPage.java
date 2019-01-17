package pageObjectModel;

import org.openqa.selenium.By;

public class CheckOutPage extends Utils
{
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LoadProp loadProp = new LoadProp();

    protected By continue1 = By.xpath("//input[@onclick='Billing.save()']");
    protected By nextDayAir = By.id("shippingoption_1");
    protected By continue2 = By.xpath("//input[@class='button-1 shipping-method-next-step-button']");
    protected By creditCard = By.id("paymentmethod_1");
    protected By continue3 = By.xpath("//input[@class='button-1 payment-method-next-step-button']");
    protected By cardHolderName = By.id("CardholderName");
    protected By cardNumber = By.id("CardNumber");
    protected By cardExpiryMonth = By.id("ExpireMonth");
    protected By cardExpiryYear = By.id("ExpireYear");
    protected By cardCvvCode = By.id("CardCode");
    protected By continue4 = By.xpath("//input[@class='button-1 payment-info-next-step-button']");
    protected By confirmOrder = By.xpath("//input[@class='button-1 confirm-order-next-step-button']");

    String name = loadProp.getProperty("cardholdername");
    String card = loadProp.getProperty("cardnumber");
    String month = loadProp.getProperty("cardexpirymonth");
    String year = loadProp.getProperty("cardexpiryyear");
    String code = loadProp.getProperty("cardcvvcode");

    public void toPurchase()
   {

//  1. Click on continue on check out page.
       clickElement(continue1);
//  2. Select shipping speed as "Next day Air".
       clickElement(nextDayAir);
//  3. Click on continue.
       clickElement(continue2);
//  4. Select Credit card as payment option.
       clickElement(creditCard);
//  5. Click on continue
       clickElement(continue3);
//  6. Enter card holder's name
       enterText(cardHolderName,name);
//  7. Enter card number
       enterText(cardNumber,card);
//  8.Select card expiry date
       selectByValue(cardExpiryMonth,month);
       selectByValue(cardExpiryYear,year);
//  9.Enter card cvv code.
       enterText(cardCvvCode,code);
//  10.Click on continue
       clickElement(continue4);
//  11.Click on confirm order.
       clickElement(confirmOrder);
   }
}
