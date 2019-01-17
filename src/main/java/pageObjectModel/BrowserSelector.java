package pageObjectModel;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils
{
    LoadProp loadProp = new LoadProp();

    public void browser()
    {
        String browser = loadProp.getProperty("browser");
//        String browser = System.getProperty("browser");
        String url =   loadProp.getProperty("url");

        if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

            driver = new FirefoxDriver();
            //driver.manage().window().fullscreen();

        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--incognito");
            options.addArguments("--disable-blink-features-BlockCredentialedSubresources");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        else if(browser.equalsIgnoreCase("ie"))
        {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);

            driver = new InternetExplorerDriver(options);
            //driver.manage().window().fullscreen();
        }
        else
            {
                System.out.println("Browser name is empty of typed wrong" + browser);
            }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }

}
