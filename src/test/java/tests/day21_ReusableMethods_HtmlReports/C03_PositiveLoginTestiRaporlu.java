package tests.day21_ReusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {

    BrcPage brcPage = new BrcPage();

    @Test
    public void positiveLoginTest() {
        extentTest=extentReports.createTest("Pozitif login", "Gecerli username ve password ile giris yapabilmeli");

        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");

        //      login butonuna bas
        brcPage.ilkLoginButonu.click();
        extentTest.info("login butonuna tiklandi");

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("gecerli olan mail yazildi");

        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("gecerli olan password yazildi");

        //login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        extentTest.info("login butonuna ikinci kez basildi");

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        String actualUserName = brcPage.kullaniciProfilIsmi.getText();
        String expectedUserName = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUserName, expectedUserName);
        extentTest.pass("kullanici basarili sekilde giris yapti");

        Driver.closeDriver();

    }
}
