package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends Utils
{
    LoadProp loadProp = new LoadProp();
    HomePage homePage = new HomePage();

    protected  By computers = By.linkText("Computers");
    protected  By deskTops = By.linkText("Desktops");
    protected By firstComputerProduct = By.linkText("Build your own computer");
    protected By emailFriendButton = By.xpath("//input[contains(@onclick,'/productemailafriend/1')]\n");
    protected By friendEmailText = By.id("FriendEmail");
    protected By yourEmailText = By.xpath("//input[@id='YourEmailAddress']\n");
    protected By personalMessageText = By.id("PersonalMessage");
    protected By sendEmailButton = By.xpath("//input[@name='send-email']");
    protected By sortBy = By.id("products-orderby");
    protected By hdd = By.id("product_attribute_3_6");
    protected By addToCartButton = By.id("add-to-cart-button-1");
    protected By noteBookPrice = By.xpath("//span[@class='price actual-price']");

    String sortByPriceHighToLow = loadProp.getProperty("sortbypricehightolow");
    String friendEmail = loadProp.getProperty("friendemail");
    String yourEmail = loadProp.getProperty("youremail");
    String personalMessage = loadProp.getProperty("personalmessage");



    public void toSendEmailWithProduct()
    {
//   1. To select a products
        hoverAndClick(computers, deskTops);
//   2. To click on products
        clickElement(firstComputerProduct);
//   3.	Click on Email a friend.
        clickElement(emailFriendButton);
//   4.	Enter your friend’s email in Friend’s Email field.
        enterText(friendEmailText,friendEmail);
//   5. Enter your email address
        //getTextFromBox(By.xpath("//input[@id='YourEmailAddress']\n"),"type");
        String s1 = (getTextFromBox(yourEmailText, "value"));
        if (s1.isEmpty()) {
            enterText(yourEmailText, yourEmail);
        }
//   6.	Enter personal message in personal message field.
            enterText(personalMessageText,personalMessage);
//   7.	Click on send email button.
            clickElement(sendEmailButton);
    }

    public void productSortByHighToLow()
    {
        selectByVisibleText(sortBy,sortByPriceHighToLow);
    }

    public boolean isPriceHighToLow()
    {
        List<WebElement> allProducts = driver.findElements(noteBookPrice);

        float lastPrice = 0f;
        int count = 0;
        for (String priceText : homePage.getTextOfList(allProducts))
        {
            float newPrice = Float.valueOf(priceText.replaceAll("[$£,Ђ]",  ""));
            if (newPrice > lastPrice && count++> 0)
            {
                return false;
            }
            lastPrice = newPrice;
        }
        return true;
    }

    public void addFirstComputerProductToCart()
    {
//   1.	Click on product(Build your computer).
        clickElement(firstComputerProduct);
//   2. Select hdd.
        clickElement(hdd);
//   3. Click on add to cart button.
        clickElement(addToCartButton);
    }
}
