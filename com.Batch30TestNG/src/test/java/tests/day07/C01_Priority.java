package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {

    //3 test metodu olusturalim
    //1. amazona gitsin
    //2.techproeducatinon a
    //3. facebook ana sayfaya gitsin
    // ve sayfa titlr larini yazdirin


    //priority yazmadigimiz methodlar sifir kabul eder ve isim siralamsina gore hareket ederler
    //priority si olanlar de eger eksi ise once onlar sonr apriorty si olmayanlar sonra priorty si sifirdan buyuk olanlar
    //sirasi ile calisir
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test//yanina rakam vermedigimiz zaman sifir kabul eder
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test(priority = 1)//oncelikli oldugunu belli etmek icin rajkamlarla siralayabiliriz
    public void techProTest(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }

    @Test(priority = 2)
    public void facebookTest(){
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void yahooTest(){
        driver.get("https://www.yahoo.com");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
