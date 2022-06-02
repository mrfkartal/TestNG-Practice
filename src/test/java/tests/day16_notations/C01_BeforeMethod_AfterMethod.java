package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeMethod_AfterMethod extends TestBase {


    //@BeforeMethod  @AfterMethod notasyonlari
    //Junit deki @Before VE @After GIBIDIR
    //her test methodundan once ve sonra calisirlar
    @Test
    public void test01() {

        driver.get("https://www.amazon.com");

    }
    @Test
    public void test02() {

        driver.get("https://www.bestbuy.com");
}
    @Test
    public void test03() {

        driver.get("https://www.techproeducation.com");


        //testleri junit random calistirirken testNg alfabetik sirayla calistirir
    }
}