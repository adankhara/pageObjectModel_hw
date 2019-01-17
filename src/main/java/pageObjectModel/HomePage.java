package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Utils
{
    protected  By registerButton = By.linkText("Register");
    protected  By computers = By.linkText("Computers");
    protected  By noteBooks = By.linkText("Notebooks");
    protected  By shoppingCart = By.linkText("Shopping cart");
    protected  By logIn = By.linkText("Log in");
    protected  By jewelry = By.linkText("Jewelry");
    protected  By currency = By.id("customerCurrency");
    protected  By addToCartText = By.xpath("//input[@value='Add to cart']");
    protected  By jewelryPrice = By.xpath("//span[@class='price actual-price']");


    public void clickOnRegister()
    {
        clickElement(registerButton);
    }

    public void clickOnComputers()
    {
       clickElement(computers);
    }

    public void clickOnNotbooks()
    {
        hoverAndClick(computers,noteBooks);
    }

    public void clickOnShoppingCart()
    {
        clickElement(shoppingCart);
    }

    public void clickOnLogIn()
    {
        clickElement(logIn);
    }

    public void clickOnJewelry()
    {
        clickElement(jewelry);
    }

    public List<String> findAddToCartButton()
    {
        toScroll(addToCartText);

        //   To get text from all item on home page
        List<WebElement> allProducts = driver.findElements(addToCartText);

        List<String> buttons = new ArrayList<String>();

        for (WebElement text : allProducts) {
            buttons.add(text.getAttribute("value"));
        }
        return buttons;
    }

    public List<String> changeCurrencyToDollar()
    {
        selectByVisibleText(currency,"US Dollar");

        List<WebElement> allProducts = driver.findElements(jewelryPrice);
        return getTextOfList(allProducts);
    }

    public List<String> changeCurrencyToEuro()
    {
        selectByVisibleText(currency,"Euro");
        List<WebElement> allProducts = driver.findElements(jewelryPrice);

        return getTextOfList(allProducts);
    }

    public List<String> getTextOfList(List<WebElement> allProducts) {
        List<String> prices = new ArrayList<String>();

        for (WebElement text : allProducts) {
            prices.add(text.getText());
        }
        return prices;
    }
}
