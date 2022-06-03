package tests.day22_crossBrowser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
public class C04_NegativeLoginDataProvider {
    BrcPage brcPage;
    @DataProvider
    public static Object[][] kullaniciListesi() {
        Object[][] kullaniciBilgileri={{"firuze@nehaber.com","54678"},
                {"murat@benbuisibilirim.com","65874"},
                {"ilyas@hollandadanselam.com","85967"}};
        return kullaniciBilgileri;
    }
    @Test(dataProvider = "kullaniciListesi")
    public void yanlisSifre(String userEmail, String password) throws InterruptedException {
        brcPage=new BrcPage();
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        Thread.sleep(2000);
        brcPage.ilkLoginButonu.click();
        // test data user email: dataprovider'dan alalim,
        brcPage.emailTextBox.sendKeys(userEmail);
        // test data password : dataprovider'dan alalim
        brcPage.passwordTextBox.sendKeys(password);
        // login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Driver.closeDriver();
    }
}
