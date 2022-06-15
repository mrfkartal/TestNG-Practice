package tests.day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {

    //JUnit te @BeforeClass ve @AfterClass notasyonuna sahip
    // methodlar static olmak zorundaydı
   //testNG de bu zorunluluktan bizi kurtarıyor

    /*
    TestNg bize daha fazla before ve after notasyonlari sunar diger
    before/afte notasyonlari tanimlyacagimiz grup  test ve suit den once ve sonra calisirlar
    ilerdie xml dosyalari ile birlikte bunu gorecegiz
     */



    @BeforeClass
    public void beforeClassMehod() {
        System.out.println("Before Class");
    }

    @AfterClass
         public void afterClassMehod() {
        System.out.println("After Class");

    }

    @Test
     public void test01() {

        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test02() {

        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test03() {

        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }
}
