package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertion {

    //amazon sayfasina gidin
    //url in amazon icerdigini test edin
    //title in amazon icerdigini test edin
    //java ke3limesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin
    //testi softAssert ile yapin



    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void test(){
        SoftAssert softAssert= new SoftAssert();
        driver.get("https://www.amazon.com");
        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"),"url amazon icermiyor");
        softAssert.assertTrue(driver.getTitle().contains("amazon"),"title amazon icermiyor");


        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);

        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        softAssert.assertTrue(ilkUrun.getText().contains("Java"),"ilk urun java icermiyor");

        softAssert.assertAll();
        //assertion lar pass olsada olmasa da assertion all a kadar tum satirlar calisir
        //ama eger testlerden bir tanesi bile failed olsa assertion all dan sonra execution stops
        System.out.println("burdan oncesinda bir tane bile failed varsa burdan sonrasi calismaz");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
