package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


    @Test
    public void test01() {
        AmazonPage amazonpage=new AmazonPage();
        //amazon anasayfa gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella icin arama yapalim
        amazonpage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        String expectedKelime="Nutella";
        String actualSonucYazisi=amazonpage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        Driver.closeDriver();
    }


    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][]  arananKelimeArrayi= {{"Nutella"}, {"Java"}, {"Cigdem"},  {"Netherland"}};
        return arananKelimeArrayi;
    }
    @Test (dataProvider = "AranacakKelimeler")
    //arayacagimiz kelimeleri bir liste gibi tutup
    //bana yollayacak bir veri saglayicisi olusturacagiz

    public void dataProviderTesti(String arananKelime) {
        AmazonPage amazonpage=new AmazonPage();
        //amazon anasayfa gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella Java Cigdem ve Netherland icin arama yapalim
        amazonpage.aramaKutusu.sendKeys("arananKelimeArrayi"+ Keys.ENTER);

        //sonuclarin aradigimiz kelime icerdigini test edelim
        String expectedKelime="arananKelime";
        String actualSonucYazisi=amazonpage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        //sayfayi kapatalim
        Driver.closeDriver();
    }
}
