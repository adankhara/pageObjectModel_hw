package pageObjectModel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Utils
{
    BrowserSelector browserSelector = new BrowserSelector();

    private final static String expectedRegisterMessage = "Your registration completed";
    @BeforeMethod
     public void setUp()
    {
        browserSelector.browser();

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().window().fullscreen();
//        driver.get("https://demo.nopcommerce.com/");
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
