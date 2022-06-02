package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {

    /*
    SoftAssertion baslangic ve bitis satirlari arasindaki
    tum Assertionlari yapip bitis satirina geldiginde
    bize buldugu tum hatalari rapor eder
     */

    //softAssert baslangici obje olusturmaktir
    SoftAssert softAssert=new SoftAssert();




    @Test(groups ="grup2")
    public void test01() {

        // 1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // 2- title'in Amazon icerdigini test edin
        String expectedTitle="amazon";
        String actualTitle= driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");


        // 3- Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erisilemiyor");

        // 4- arama kutusuna nutella yazip aratin
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // 5- arama yapildigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed(),"arama yapilamadi");

        // 6- arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Kutella"),"sonuc yazisi Kutella icermiyor");

        //softAssert e bitis satirini soylemek icin assertAll kullanilir.
        //bu satir yazilmazsa assertion gorevi yapilmamis olur
        softAssert.assertAll();

        //softassert in hata bulsa bule calismaya devam etme ozelligi
        //assertAll() a kadardir.
        //eger assertAll()'da fariled rapor edilirse calisma durur
        //ve clasin kalan kismi calistirilmaz
        //(Yani assertAll hardassert deki herb ir assert gibidiir hatayi yakalarsa calisma durur)
        System.out.println("assertionlardan fail olan olursa burasi calismaz");
    }
}
