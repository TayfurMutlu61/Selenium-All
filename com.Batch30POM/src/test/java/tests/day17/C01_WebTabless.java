package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C01_WebTabless {

    @Test
    public void Test() {
        //3. https://qa-environment.concorthotel.com/ adresine gidin.
        // 4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        // a. Username : manager  b. Password  : Manager1!
        // 5. Login butonuna tıklayın.
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelRoomsLink.click();


        //1.pages sayfasinda Bir metod oluşturun : printData(int row, int column);
        //    a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        //    hücredeki(cell) veriyi yazdırmalıdır.
        //Thread.sleep(3000);
      String actualData=  qaConcortPage.printData(3, 5);

        //    2 Ve bu metodu printData() methodunu cagirmak icin kullanin.
        //     Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
        //    3 yazdirilan datanin olmasi gereken dataya (USA) esit oldugunu test edin
        //assert u bu class da yapmak istiyorsak istenen data nijn bu class a donmesini saglamaliyiz

        Assert.assertEquals(actualData,"USA","yazilan data istenenden farkli");


        Driver.closeDriver();
    }
}
