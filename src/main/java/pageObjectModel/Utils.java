package pageObjectModel;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils extends BasePage
{
    //to click on element
    public static void clickElement(By by)
    {
        driver.findElement(by).click();
    }
    // to enter text
    public static void enterText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    // To clear and enter text
    public static void clearAndEnter(By by,String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    // To scroll to view element
    public static void toScroll(By by)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(by));
    }
    // To scroll to view element and click
    public static void toScrollAndClick(By by)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(by));
        driver.findElement(by).click();
    }
    // select from visible text
    public static void selectByVisibleText(By by, String text)
    {
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }
    // Select from dropdown
    public static String getValueOfFirstSelectedFromDropDown(By by)
    {
        driver.findElement(by).isDisplayed();
//        Select select = new Select(driver.findElement(by));
//        return select.getFirstSelectedOption().getText();
        return new Select(driver.findElement(by)).getFirstSelectedOption().getText();
    }
    //Select from index
    public static void selectByIndex(By by, int number)
    {
        new Select(driver.findElement(by)).selectByIndex(number);
    }
    //Select from visible number
    public static void selectByVisibleNumber(By by,int number)
    {
        new Select(driver.findElement(by)).selectByIndex(number);
    }
    //Select from value
    public static void selectByValue(By by, String text)
    {
        new Select(driver.findElement(by)).selectByValue(text);
    }
    //To get plain text from
    public static String getText(By by)
    {
        driver.findElement(by).isDisplayed();
        return driver.findElement(by).getText();
    }

    public static String getCssProperty(By by, String propertyName)
    {
        return driver.findElement(by).getCssValue(propertyName);
    }
    // To get text from input box or text box
    public static String getTextFromBox(By by,String text)
    {
        driver.findElement(by).isDisplayed();
        return driver.findElement(by).getAttribute(text);
    }
    //To generate long timestamp
    public static String longTimeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    //To generate short timestamp
    public static String shortTimeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("ddHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    // Wait for element and click
    public static void waitAndClick(By by , int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        driver.findElement(by).click();
    }
    // Try to click element three times if not available in first go
    public static boolean retryAndClickAgain(By by , int second)
    {
        boolean result = false;
        int attemp =0;
        while (attemp < 3)
        {
           try {
               Thread.sleep(1000);
               driver.findElement(by).click();
               result = true;
               break;
           }
           catch (Exception e)
           {
               attemp++;
           }
        }
        return result;
    }
    // To find dropdown
    public static boolean isDropDown(By by, String field)
    {
        if (driver.findElement(by).getTagName().contains(field))
        {
            return true;
        }
        else
            {
                System.out.println(field + "should be a dropdown but there is no dropdown");
                return false;
            }
    }
    //Wait for element to visible for fix time
    public static void waitForElement(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
    //    wait for element to invisible for given time
    public static void waitForElementToBeInvisible(By by,int time)
    {
       WebDriverWait wait = new WebDriverWait(driver,time);
       wait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
     }
    // Wait for element to be visible for given time
    public static void waitForElementToBeVisible(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
    //wait for locator to be clickable
    public static void waitForLocatorToBeClickable(By by, int time){

        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }
    //wait for element to be clickable
    public static void waitForElementToBeClickable(WebElement element,By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    // To check element is displayed on web page
    public static boolean elementIsDisplayed(By by)
    {
        try {
            return driver.findElement(by).isDisplayed();
        }
        catch (NoSuchElementException e) {
            System.out.println("Element is not displayed");
        }
        return false;
    }
    //To check element is present on dom
    public static boolean elementIsPresent(By by)
    {
        try {
            return driver.findElement(by) != null ;
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Element is not present in dom");
        }
        return false;
    }
    // To check element is enable on web page
    public static boolean elementIsEnabled(By by)
    {
        return driver.findElement(by).isEnabled();
    }
    //To check element is selected
    public static boolean elementIsSelected(By by)
    {
        return driver.findElement(by).isSelected();
    }
    //To do hoover effect
    public static void hoverAndClick(By by1, By by2)
    {
        Actions action = new Actions(driver);
        WebElement webElement = driver.findElement(by1);
        action.moveToElement(webElement).perform();
        clickElement(by2);
    }
    //wait for specific text to present on given location
    public static void waitForTextToBePresent(By by, String text, int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by,text));
    }
    //wait for alert to be present
    public static void isAlertPresent( int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    // To take screenshot of current display
    public static void browserScreenshot()
    {
        TakesScreenshot takesScreenshot =(TakesScreenshot)driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source,new File("src\\screenshots\\"+"browser"+shortTimeStamp()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//To take screenshot of fullpage
    public static void fullPageScreenShot()
    {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
          try
          {
               ImageIO.write(screenshot.getImage(), "PNG", new File("src\\screenshots\\" + "fullpagescreenshot" + ".png"));
          }
          catch (IOException e)
          {
              e.printStackTrace();
          }
    }
    public static void toFindNumersOfElements(By  by)
    {
         driver.findElements(by).size() ;
    }



}
