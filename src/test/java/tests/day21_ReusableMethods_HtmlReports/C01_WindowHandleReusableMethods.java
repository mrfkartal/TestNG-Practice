package tests.day21_ReusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01() {
    //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilksayfaWH=Driver.getDriver().getWindowHandle();

        //Click Here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> windowHandleSeti=Driver.getDriver().getWindowHandles();

        String ikinciSayfaWH="";
        for (String each: windowHandleSeti){
            if (each.equals(ilksayfaWH)){
                ikinciSayfaWH=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWH);
        System.out.println(Driver.getDriver().getTitle());
        //acilan yeni tab in title'in "New Window" oldugunu test edin

        String expectedTitle="New Window";
        String actualTitle="Driver.getDriver().getTitle()";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void test02() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        //Click Here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        //acilan yeni tab in title'in "New Window" oldugunu test edin
        ReusableMethods.switchToWindow("New Window");

        String expectedTitle="New Window";
        String actualTitle="Driver.getDriver().getTitle()";
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.closeDriver();
    }

    public String returnuOgren(int p1){
        if (p1>65){
            return"emekli olabilirsin";
        }else {
            return "emekli olamassin";
        }
    }

}
