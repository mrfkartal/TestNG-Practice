package tests.day21_ReusableMethods_HtmlReports;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_ScreenShotReusableMethod {
    @Test
    public void test01() throws IOException {
        //amazon sayfasina gidip fotosunu cekelim

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.getScreenshot("Amazon");
        Driver.closeDriver();

    }
}
