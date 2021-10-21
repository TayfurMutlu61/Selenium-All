package tekrarTest.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_CSSselector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tayfu\\OneDrive\\Belgeler\\selenium dependencies\\drives\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ////1. Bir class oluşturun : Locators_css
        ////2. Main method oluşturun ve aşağıdaki görevi tamamlayın.

        ////a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
Thread.sleep(2000);
        ////b. Locate email textbox
        

        ////c. Locate password textbox



        ////d. Locate signin button

        ////e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini
        ////tıklayın
        ////i. Username : testtechproed@gmail.com
        ////ii. Password : Test1234!
        ////NOT: cssSelector kullanarak elementleri locate ediniz.


    }
}
