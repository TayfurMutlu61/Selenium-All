package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Soru4 {



    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.google.com");

    }@Test
    public void test1() {
        //1Yeni bir Class olusturalim. (VerifyTitle)
        //2.Google ana sayfasina gidelim . https://www.google.com/
        //3.Sayfa basliginin (title) “google” oldugunu dogrulayin. (verify)

        driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();
        Assert.assertEquals("sonucTitle: ","google",driver.getTitle());

    }
    @Test
    public void test2(){
        //1.Yeni bir class olusturalim : (VerifyURLTest)
        //2.Youtube ana sayfasina gidelim https://www.youtube.com/
        //3.Sayfa URL’inin www.youtube.com oldugunu dogrulayin

        driver.navigate().to("https://www.youtube.com/");
        Assert.assertEquals("sonucurl: ","www.youtube.com",driver.getCurrentUrl());
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
