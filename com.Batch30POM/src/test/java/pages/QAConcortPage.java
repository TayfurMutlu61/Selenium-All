package pages;

import org.openqa.selenium.By;
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

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsLink;

    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addHotelRommButton;

    @FindBy(id="IDHotel")
    public WebElement addRoomIdDropdown;

    @FindBy(id="IDGroupRoomType")
    public WebElement addRoomType;

    @FindBy(id="btnSubmit")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[@class='bootbox-body9")
    public WebElement addRoomSuccesfullYazisi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addRoomAlertOkButonu;

    @FindBy(linkText = "Hotelrooms")
    public WebElement addRoomHotelRoomsLinki;

    @FindBy(xpath = "//span[@text()='List Of Hotelrooms']")
    public WebElement addRoomListOfHotelRoomsYazisi;





    public void ConcortHotelLogin(){
      Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
      QAConcortPage qaConcortPage=new QAConcortPage();
      qaConcortPage.ilkLoginLinki.click();
      qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("QACHValidUsername"));
      qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("QACHValidPassword"));
      qaConcortPage.loginButonu.click();
    }

  public String printData(int satir, int sutun) {
      //ornektedi haliyle 3.satir, 5.sutundaki elemani yazdiralim
    //  String xpath= //tbady//tr[3]//td[5]

    //degismeyecek kisimlari string olaraka degisecek kisimlari ise parametre olarak yazdik
    String xpath="//tbady//tr["+satir+"]//td["+sutun+"]";
    //System.out.println(xpath);

    //satir no:3 sutun no:5
   // System.out.println("satir no: "+satir + "sutun no: " +sutun);

    //@Findyby notasyonu parametreli caliusmadigi icin onceki yontemle locateedelim

    String istenenData=Driver.getDriver().findElement(By.xpath(xpath)).getText();
    System.out.println("satir no: "+ satir + "sutun no: " + sutun + "daki data= "+istenenData);

    return istenenData;
  }
}
