package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.AllPages;
import utilities.Driver;
import utilities.TestBase;
import java.util.ArrayList;
import java.util.List;

public class DragAndDrop_Tables_Homework06 extends TestBase {

    /*
    Soru 1:
        Kullanıcı https://demo.guru99.com/test/drag_drop.html  sayfasına gider
        Kullanıcı BANK objesini Debit Side Sol Account kutusuna taşıyarak yerleştirir.
        Kullanıcı SALES objesini Credit Side Sol Account kutusuna taşıyarak yerleştirir.
        Kullanıcı 5000 objesini Debit Side Sağ Account kutusuna taşıyarak yerleştirir.
        Kullanıcı 5000 objesini Credit Side Sağ Account kutusuna taşıyarak yerleştirir.
        Aşağıda çıkan Ek Tablo içerisinden 5000 objeleri SoftAssert ile Valide edilir.
        Doğru yerleştirme sonucu tablo altında ortaya çıkan Perfect yazısı Hard Assert ile teyit edilir.

    Soru 2:
        https://the-internet.herokuapp.com/tables  sayfasına gidiniz
        1.Tablonun 4 üncü sütunudaki tüm değerleri bir listeye alınız. (Başına $ işareti olmadan double değer  olarak.)
        Değerler içinden 50.00’den fazla olanları ayrı bir listeye ekleyiniz.
        Bu liste içinde 100.00 değeri olup olmadığını doğrulayınız. (Assertion)
     */

    AllPages allPages = new AllPages();
    @Test
    public void QuestionOne() throws InterruptedException {
        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
        Driver.getDriver().switchTo().frame("gdpr-consent-notice");
        allPages.dragAndDropPage.rejectAllButton.click();
        Driver.wait(1);
        allPages.dragAndDropPage.rejectButton.click();
        Driver.wait(1);
        actions.dragAndDrop(allPages.dragAndDropPage.sourceValueBank, allPages.dragAndDropPage.targetInDebitSideAccountLeft).build().perform();
        Driver.wait(1);
        actions.dragAndDrop(allPages.dragAndDropPage.sourceValueSales, allPages.dragAndDropPage.targetInCreditSideAccountLeft).build().perform();
        Driver.wait(1);
        actions.dragAndDrop(allPages.dragAndDropPage.sourceValue5000, allPages.dragAndDropPage.targetInDebitSideAmountLeft).build().perform();
        Driver.wait(1);
        actions.dragAndDrop(allPages.dragAndDropPage.sourceValueSecond5000, allPages.dragAndDropPage.targetInDebitSideAmountRight).build().perform();
        Driver.wait(1);
        String expectedValue1 = "500";
        String expectedValue2 = "5000";
        String actualValue1 = allPages.dragAndDropPage.savedValueInTableDebitMovementResult.getText();
        String actualValue2 = allPages.dragAndDropPage.savedValueInTableCreditMovementResult.getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualValue1,expectedValue1,"Value1 hatali");
        softAssert.assertEquals(actualValue2,expectedValue2, "Value2 hatali");
        softAssert.assertAll();
        Driver.wait(1);

        String expectedResult = "Perfect!";
        String actualResult = allPages.dragAndDropPage.dragAndDropFinallyResult.getText();
        Assert.assertEquals(actualResult,expectedResult);
        Driver.wait(1);

    }

    @Test
    public void QuestionTwo() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        Driver.wait(1);
        List<WebElement> tableOneColumnFourData = new ArrayList<>();
        List<Double> tableRowsColumnFourData = new ArrayList<>();
        List<Double> tableRowsColumnFourOverFiftyData = new ArrayList<>();
        for (int i=1; i<=4;i++){
            tableOneColumnFourData.add(Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(i))));
            tableRowsColumnFourData.add(Double.parseDouble(tableOneColumnFourData.get(i-1).getText().substring(1)));
        }
        for (Double columnFourValues :tableRowsColumnFourData ){
            if (columnFourValues>50)
                tableRowsColumnFourOverFiftyData.add(columnFourValues);
        }
        System.out.println(tableRowsColumnFourData);
        System.out.println(tableRowsColumnFourOverFiftyData);

        Double expectedValue = 100.0;
        boolean result = false;
        if (tableRowsColumnFourOverFiftyData.contains(expectedValue)){
            result = true;
        }
        Assert.assertTrue(result);
        System.out.println(result);
    }
}
