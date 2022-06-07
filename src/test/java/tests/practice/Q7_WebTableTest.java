package tests.practice;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebtablePage;
import utilities.Driver;
import utilities.TestBaseRapor;
public class Q7_WebTableTest extends TestBaseRapor {
    /*
  go to url : https://en.wikipedia.org/wiki/Dell
  go to table which name is 'List of companies acquired by Dell Inc.'
  print row 4 of the table on console
  also print on console the 2nd and 3rd elements (middle 2 elements) in line 5
  ( 2nd and 3rd elements : November 2, Cloud integration leader)
    Verify that Compellent appears in the first cell of line 6
  url'ye gidin: https://en.wikipedia.org/wiki/Dell
   'List of companies acquired by Dell Inc.' isimli tabloya gidin,
   tablonun 4. satırını konsolda yazdırın
   ayrıca 5. satırdaki 2. ve 3. öğeleri (ortadaki 2 öğe) konsola yazdırın
   ( 2nd and 3rd ogeler : November 2, Cloud integration leader)
   6. satirin ilk hucresinde Compellent yazisinin goruntulendigini dogrulayin
   */
    @Test
    public void test(){
        extentTest = extentReports.createTest("wikipedia webtable test", "table test");
        Driver.getDriver().get(" https://en.wikipedia.org/wiki/Dell");

        extentTest.info("istenilen url e gidildi");
        WebtablePage webtablePage = new WebtablePage();

        JavascriptExecutor jse  = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",webtablePage.nameOfList);
        System.out.println("4.satir : " + webtablePage.fourthRow.getText());

        extentTest.info("4. satir console da yazildi");
        System.out.println("5.satir 2.element :" + webtablePage.secondElement.getText());

        extentTest.info("5. satir 2.element console da yazildi");
        System.out.println("5.satir 3.element : " + webtablePage.thirdElement.getText());

        extentTest.info("5. satir 3.element console da yazildi");
        Assert.assertTrue(webtablePage.sixthElement.isDisplayed());
        extentTest.pass("Compellent yazi goruldu");
    }
}
