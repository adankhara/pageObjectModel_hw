package pageObjectModel;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTest extends Utils
{
    BrowserSelector browserSelector = new BrowserSelector();

    private final static String expectedRegisterMessage = "Your registration completed";
    @BeforeMethod
     public void setUp()
    {
        browserSelector.browser();
    }
    @AfterMethod
     public void tearDown(ITestResult result)
    {
        if (ITestResult.FAILURE==result.getStatus())
        {
            Results.captureSctreenShotWhenTestFail(driver,result.getName());
        }
        driver.quit();
    }
}
