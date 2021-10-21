package tests.day13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C03_PagesAmazon extends TestBase {
    @Test
    public void Test(){
        //amazon sayfasina gidin
        driver.get("https://www.amazon.com");
        //dropdawn menuden book katagorisini secin
        AmazonPage amazonPage= new AmazonPage(driver);
        Select select = new Select(amazonPage.dropdown);
        select.selectByVisibleText("Books");
        //java icin arama yapin
        amazonPage.aramaKutusu.sendKeys("java"+ Keys.ENTER);
        //bulunan sonuc sayisini yazoin
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        //ilk urun isminde java gectigini test edin
        Assert.assertTrue(amazonPage.ilkUrunIsim.getText().contains("Java"));



    }



}
