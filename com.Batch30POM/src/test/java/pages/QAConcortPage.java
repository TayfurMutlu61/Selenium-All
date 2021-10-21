package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class QAConcortPage {

   public WebDriver driver;

  public   QAConcortPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id="UserName")
    public WebElement userNameKutusu;

    @FindBy(id="Password")
    public WebElement passwordKutusu;

    @FindBy(id="btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement basariliTesti;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement isLoginFailed;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLink;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotelLink;

    @FindBy(id="Code")
    public WebElement addHotelCodeKutusu;


    public void ConcortHotelLogin(){
      Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
      QAConcortPage qaConcortPage=new QAConcortPage();
      qaConcortPage.ilkLoginLinki.click();
      qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("QACHValidUsername"));
      qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("QACHValidPassword"));
      qaConcortPage.loginButonu.click();
    }




}
