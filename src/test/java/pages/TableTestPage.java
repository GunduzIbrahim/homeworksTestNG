package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TableTestPage {
    public TableTestPage(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy (xpath = "//body//table//tr[4]//td[5]")
    public WebElement firstTableFourthRowFifthColumn;

    @FindBy (xpath = "//table[2]//tbody//tr[3]//td[4]")
    public WebElement secondTableThirdRowFourthColumn;

    @FindBy (xpath = "(//body//table//thead//tr)[1]")
    public List<WebElement> tableOneTitles;

    @FindBy (xpath = "(//body//table//thead//tr)[2]")
    public List<WebElement> tableSecondTitles;
}
