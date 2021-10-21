package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Soru3 {
    //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
    //3. Amazon soyfasina gidelim. https://www.amazon.com/
    //4. Tekrar YouTube’sayfasina donelim
    //5. Yeniden Amazon sayfasina gidelim
    //6. Sayfayi Refresh(yenile) yapalim
    //7
    //. Sayfayi tam ekran yapalim
    //8
    //. Sayfayi kapatalim / Tum sayfalari kapatalim


    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.youtube.com/");

    }@Test
    public void test1() {
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    }
