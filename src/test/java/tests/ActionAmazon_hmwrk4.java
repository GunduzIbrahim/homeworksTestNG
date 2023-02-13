package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;


public class ActionAmazon_hmwrk4 extends TestBase {

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

//        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open(https://www.ebay.de/)");
//        Set<String> handles = Driver.getDriver().getWindowHandles();
//        Driver.getDriver().switchTo().window(handles.toArray()[1].toString());

//        WebElement page = Driver.getDriver().findElement(By.cssSelector("body"));
//        page.sendKeys(Keys.CONTROL+"t");
//        actions.keyDown(page, Keys.CONTROL).sendKeys("t").keyUp(page, Keys.CONTROL).build().perform();

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://www.ebay.de");
        Driver.wait(2);

        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys(giftForEveryone);
        Driver.wait(2);

        WebElement searchButton = Driver.getDriver().findElement(By.id("gh-btn"));
        searchButton.click();

        String actualPrice = "EUR 19,23";
        String expectedPrice = Driver.getDriver().findElement(By.xpath("(//*[@class='s-item__price'])[2]")).getText();

        Assert.assertTrue(expectedPrice.contains(actualPrice));

    }

}
