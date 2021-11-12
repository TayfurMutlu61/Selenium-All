package tests.day17_exxelAutomation;

import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01_ReadExcel {
    @Test
    public void test() throws IOException {
        //. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(164);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(3);

        System.out.println(cell);
    }

    @Test
    public void test2() throws IOException {
        //. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)


        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
       // Sheet sheet= workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
       // Row row= sheet.getRow(2);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= workbook.getSheet("Sayfa1").getRow(5).getCell(3);

        System.out.println(cell);

        //secilen hiucredeki yazinin Luanda oldugunu tetst edin

        //cell in data turu Cell, "Lunada" ise String
        //data turleri farkli oldugu icin bu ikisi equls edilemez
        //cell data turu yazdirilabilir ancak String metodlari ile kullanilamaz
        //String manupulation yapmak icin cell data turunu Stringe cast yapmaliyiz
        Assert.assertEquals(cell.toString(),"Luanda");
        Assert.assertEquals(cell.getStringCellValue(),"Luanda");

        //index i 3 olan satirdaki indexi 2 olan hucredeki yaziyi buyuk harf ile yazdirin
        Cell cell1= workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase());


        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());//bize indexini verir
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());//fiili olarak kullanilan satir sayisi
        System.out.println(workbook.getSheet("Sayfa1").getFirstRowNum());



        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum());
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());
        System.out.println(workbook.getSheet("Sayfa2").getFirstRowNum());


        System.out.println(workbook.getSheet("Sheet1").getLastRowNum());
        System.out.println(workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        System.out.println(workbook.getSheet("Sheet1").getFirstRowNum());

    }

    @Test
    public void test3() throws IOException{
        //tablodaki 2. sutunu bir liste olarak yazdirin
        List<String> ikinciSutun=new ArrayList<>();

        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";

        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        for (int i = 0; i <=workbook.getSheet("Sayfa1").getLastRowNum() ; i++) {
            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }
        System.out.println(ikinciSutun);
        //a ile baslayan sehirleri liste yapip yazdirin
        List<String> aIleBaslayanSehirler =new ArrayList<>();
        for (String each:ikinciSutun) {
            if (each.startsWith("A")){
                aIleBaslayanSehirler.add(each);
            }
        }
        System.out.println(aIleBaslayanSehirler);

        // eger  tum datayi java da kullanilabilir bir collection a cevirmek istersek
        //en uygun yapi map olur
        //map icin unuiq degerlere sahip bir stunu key
        //geriye kalan tum stunlari ise virgulle ayrilan String ler olarak value yapmaliyiz
        //key=Turkey  value=Ankara , Turkiye, Ankara

        Map<String,String> ulkelerMap=new HashMap<>();
        String key="";
        String value="";
        for (int i = 0; i <=workbook.getSheet("Sayfa1").getLastRowNum() ; i++) {

            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);

        //biz java metodlarini ve collections i kullanarak  excel deki datalari
        //manipule edebilecegimiz Java ortamina alabiliriz.

    }

}
