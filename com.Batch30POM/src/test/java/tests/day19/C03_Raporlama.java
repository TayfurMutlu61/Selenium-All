package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_Raporlama extends TestBaseRapor {


    @Test
    public void test1(){
        extentTest=extentReports.createTest("Nutella testi","sonuc sayisi 1000 edn az olmali");
        //amazon sayfasina gidip nutella icin arama yapoalim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasina gidildi");

        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+ Keys.ENTER);
        extentTest.info("nutella icin arama yapildi");

        //sonuc sayisinin 1000 den az oldugunu test edelim
        WebElement sonucSayisiElementi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        //148 of 130 results for

        String sonucYazisi=sonucSayisiElementi.getText();
        String sonucArrayi[]=sonucYazisi.split(" ");
        int sonucSayisi=Integer.parseInt(sonucArrayi[2]);

        extentTest.info("sonuc yazisi integer hale getirildi");
        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc yazisinin 1000 den az oldugu test edildi");



    }
    @Test
    public void test2(){
        //amazon sayfasina gidip samsung icin arama yapoalim
        //sonuc sayisinin 1000 den az oldugunu test edelim
        extentTest=extentReports.createTest("Samsung testi","sonuc sayisi 1000 edn az olmali");
        //amazon sayfasina gidip nutella icin arama yapoalim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasina gidildi");

        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung"+ Keys.ENTER);
        extentTest.info("Samsung icin arama yapildi");

        //sonuc sayisinin 1000 den az oldugunu test edelim
        WebElement sonucSayisiElementi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        //148 of 130 results for

        String sonucYazisi=sonucSayisiElementi.getText();
        String sonucArrayi[]=sonucYazisi.split(" ");
        String sonucAdeti=sonucArrayi[3];
        sonucAdeti=sonucAdeti.replace(","," ");
        int sonucSayisi=Integer.parseInt(sonucAdeti);

        extentTest.info("sonuc yazisi integer hale getirildi");
        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc yazisinin 1000 den az oldugu test edildi");

    }
    @Test
    public void test3(){
        //amazon sayfasina gidip
        // electronic katagorisinde java icin arama yapoalim

        extentTest=extentReports.createTest("java testi","ilk urunde java olmali");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasina gidildi");

        Select select=new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Electronics");
        extentTest.info("dropdown dan electronics secildi");


        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        extentTest.info("java kelimesi aratildi");

        //cikan sonuclardan ilkinin isminde java oldugunu test edelim
        String ilkElementYazisi=Driver.getDriver().findElement(By.xpath("(//span[@class='a-size-base a-color-base a-text-normal'])[1] ")).getText();
        Assert.assertTrue(ilkElementYazisi.contains("Java"));
        extentTest.pass("ilk urunde java oldugu test edildi");
    }
}
