package tests.day16_odevler;

import org.testng.annotations.Test;
import pages.QAConcortPage;

public class C01_WebTables {
    @Test
    public void login(){
        //3. https://qa-environment.concorthotel.com/ adresine gidin.
        // 4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        // a. Username : manager  b. Password  : Manager1!
        // 5. Login butonuna tıklayın.
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelRoomsLink.click();

       //○Tüm table body’sinin boyutunu(s utun sayisi ) bulun. /tbody







    }
}
