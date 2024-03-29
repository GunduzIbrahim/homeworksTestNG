package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TableTestPage;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class WebTables_Homework5 extends TestBase {

    TableTestPage tableTestPage = new TableTestPage();
    @Test
    public void questionOneTest() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        String expectedValue = "http://www.timconway.com";
        String actualValue = tableTestPage.firstTableFourthRowFifthColumn.getText();
        System.out.println(actualValue);
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test
    public void questionTwoTest() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        List<WebElement> tableOneTitles = tableTestPage.tableOneTitles; //Driver.getDriver().findElements(By.xpath("(//body//table//thead//tr)[1]"));
        List<WebElement> tableSecondTitles = tableTestPage.tableSecondTitles; //Driver.getDriver().findElements(By.xpath("(//body//table//thead//tr)[2]"));
        for (WebElement tableOneTitle:tableOneTitles) {
            for (WebElement tableSecondTitle:tableSecondTitles) {
                System.out.println(tableOneTitle.getText());
                System.out.println(tableSecondTitle.getText());
                String expectedTitles = tableOneTitle.getText();
                String actualTitles = tableSecondTitle.getText();
                Assert.assertEquals(actualTitles,expectedTitles);
            }
       }

    }

    @Test
    public void questionThreeTest() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        String expectedValue = "$100.00";
        String actualValue = tableTestPage.secondTableThirdRowFourthColumn.getText();
        System.out.println(actualValue);
        Assert.assertEquals(actualValue,expectedValue);
    }
}
