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
    public void questionOneTest(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        String actualValue = "http://www.timconway.com";
        String expectedValue = tableTestPage.firstTableFourthRowFifthColumn.getText();
        System.out.println(expectedValue);
        Assert.assertEquals(actualValue,expectedValue);

    }

    @Test
    public void questionTwoTest(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        List<WebElement> tableOneTitles = Driver.getDriver().findElements(By.xpath("(//body//table//thead//tr)[1]"));
        List<WebElement> tableSecondTitles = Driver.getDriver().findElements(By.xpath("(//body//table//thead//tr)[2]"));
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
    public void questionThreeTest(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        String actualValue = "$100.00";
        String expectedValue = tableTestPage.secondTableThirdRowFourthColumn.getText();
        System.out.println(expectedValue);
        Assert.assertEquals(actualValue,expectedValue);

    }
}
