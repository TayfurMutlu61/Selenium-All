package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Soru5 {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.google.com");

    }@Test
    public void test1(){
        //1. Yeni bir class olusturun (TekrarTesti)
        //2.
        //Y outube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        //(verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        //3. Sayfa URL'sinin “youtube” içerip içermediğini
        //(contains) doğrulayın, içermiyorsa doğru
        //URL'yi yazdırın.
        //4. Daha sonra
        //Amazon sayfasina gidin https://www.amazon.com/
        //5. Youtube sayfasina geri donun
        //6. Refr
        //Sayfayi yenileyin
        //7. Amazon sayfasina donun
        //8.
        //Sayfayi tamsayfa yapin
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini
        //(contains) doğrulayın, Yoksa
        //doğru başlığı(Actual Title) yazdırın.
        //10.Sayfa URL'sinin
        //https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
        //11.
        //Sayfayi kapatin




    }
}
