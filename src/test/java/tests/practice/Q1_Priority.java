package tests.practice;

import org.testng.annotations.Test;

public class Q1_Priority {

    /*
      ●TestNG (default ) olarak @Test methodları ni alfabetik sıraya gore run eder ..(Yukardan asagi degil)
      ●priority annotation Testlere öncelik vermek icin kullanilir, Kucuk olan Numara daha once calisir.
      priority:  TestNG testlerinde, testler konsola alfabetik sira ile yazdirilir.
      priority-> default sifirdir..

      enabled = false  methodu : Testi gormezden gelmek icin @Test in yanina    '(enabled = false)' fonksiyonunu kullaniriz.
     */

    @Test(priority =3000)
    public void b (){
        System.out.println("b");
    }

    @Test(priority=2001, enabled = false)
    public void a (){
        System.out.println("a");
    }

    @Test(priority=2000)
    public void c (){
        System.out.println("c");
    }

/* ilk etapta cikti:
    c
    a
    b
 enabled = false kullandigimda o test gormezden gelinir

    c
    b
 */
    @Test
    public void test01() {
        System.out.println("test01");
    }

    @Test
    public void test02() {
        System.out.println("test02");
    }


    @Test( enabled = false)
    public void test03() {
        System.out.println("test03");
    }

    @Test ( enabled = false)
    public void test04() {
        System.out.println("test04");
    }

    @Test ( enabled = false)
    public void test05() {
        System.out.println("test05");
    }

    @Test
    public void test06() {
        System.out.println("test06");
    }

    /*
    test01
    test02
    test06
    c
    b
     */
    }


