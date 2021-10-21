package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private  Driver(){

    }

    private static WebDriver driver;
    //driver i baska klaslardan sadece Driver class ismi ile cagirabiomek icin Static yaptik
    //henuz bu driver ile ilgili ayarlar yapmadigim icin baska classlar bunu yanlislikla kullanmasin diye
    //erisimi private yaptik(sadecee bu class in kullanima acik yaptik9

    public static WebDriver getDriver() {

        if (driver == null) {
            //if i bu method her calistiginda yeni bir driver olusturmmamasi icin yapilir
            //if driveri kontrol eder eger bir diger atamasi yapildiysa yeni bir driver olusturmayacak
            switch (ConfigReader.getProperty("browser")) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;


                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();


            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {

            driver.quit();
        }
        driver = null;

    }
}
