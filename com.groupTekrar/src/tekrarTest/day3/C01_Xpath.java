package tekrarTest.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {
       //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin



        //5- Delete butonunun gorunur olmadigini test edin

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tayfu\\OneDrive\\Belgeler\\selenium dependencies\\drives\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna basin
        Thread.sleep(1000);
       // WebElement addElement= driver.findElement(By.tagName("button"));
        //WebElement addElement= driver.findElement(By.xpath("//button"));
       // WebElement addElement= driver.findElement(By.xpath("//button[@text='Add Element']"));
        //WebElement addElement= driver.findElement(By.xpath("//*[@text='Add Element']"));
        WebElement addElement= driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteElement= driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (deleteElement.isDisplayed()){
            System.out.println("evet delete tusu gorunuyor pass");
        }else{
            System.out.println("gorunmuyor failed");
        }
        //4- Delete tusuna basin
        deleteElement.click();

    }
}
