package pageObjectModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProp
{
    static Properties _prop;
    static FileInputStream input;
    static String fileName = "TestDataConfig.properties";
    static String fileLocation="src\\test\\Resources\\Properties\\";

    public LoadProp()
    {
        _prop = new Properties();
        try {
            input = new FileInputStream(fileLocation + fileName);
            _prop.load(input);
            input.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getProperty(String key)
    {
        return _prop.getProperty(key);
    }

    public String getRegisterEmail(){
        return getProperty("loginemail");
    }
}
