package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.Set;


public class ActionAmazon_Homework4 extends TestBase {

    @Test
    public void comboTest() throws InterruptedException{
        Driver.getDriver().get("https://www.amazon.de");
        Driver.wait(2);

        WebElement acceptButton = Driver.getDriver().findElement(By.id("sp-cc-accept"));
        acceptButton.click();
        WebElement continueButton = Driver.getDriver().findElement(By.xpath("(//input[@class='a-button-input'])[1]"));
        continueButton.click();

        WebElement accountMenu = Driver.getDriver().findElement(By.xpath("//*[@class='nav-line-2 ']"));
        actions.moveToElement(accountMenu).perform();
        Driver.wait(2);

        WebElement findGift = Driver.getDriver().findElement(By.partialLinkText("Find a Gift"));
        findGift.click();
        Driver.wait(2);

        String giftForEveryone = Driver.getDriver().findElement(By.xpath("(//*[@class='ktemvl-1 hSsmQw'])[2]")).getText();
        Driver.wait(2);
        System.out.println(giftForEveryone);

//        WebElement page = Driver.getDriver().findElement(By.xpath("//div[@id='a-page']"));
//        actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
//        Driver.wait(2);

//        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
//        Driver.getDriver().get("https://www.ebay.de");
//        Driver.wait(2);

        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://www.ebay.de', '_blank');");
        Set<String> tabs = Driver.getDriver().getWindowHandles();
        Driver.getDriver().switchTo().window(tabs.toArray()[1].toString());
        Driver.wait(2);

        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        searchBox.sendKeys(giftForEveryone);
        Driver.wait(2);

        WebElement searchButton = Driver.getDriver().findElement(By.xpath("//input[@id='gh-btn']"));
        searchButton.click();

        String expectedPrice = "EUR 19,23";
        String actualPrice = Driver.getDriver().findElement(By.xpath("(//*[@class='s-item__price'])[2]")).getText();

        Assert.assertTrue(actualPrice.contains(expectedPrice));

    }

}
