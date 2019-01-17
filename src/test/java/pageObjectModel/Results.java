package pageObjectModel;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Results
{

    public static void captureSctreenShotWhenTestFail(WebDriver driver,String screenshot)
    {
        try
        {
            TakesScreenshot takesScreenshot =(TakesScreenshot)driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File("src\\screenshots\\"+screenshot+".png"));
            System.out.println("Screenshot taken");
        }
        catch (Exception e)
        {
            System.out.println("Exception while taking screenshot" +" " + e.getMessage());
        }
    }
}
