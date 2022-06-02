package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass {

    @Test(groups ="grup1")
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");

        /*
        Bugune kadar TestBase class'ina extends ederek kullandigimiz driver
        yerine bundan sonra Driver Class'indan kullanacagimiz getDriver
        static Method'unu kullanacagiz...

        Driver.getDriver()      in
        driver                  out
         */
        Driver.closeDriver();

        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.getDriver().get("https://www.facebook.com");

        Driver.closeDriver();
    }
}
