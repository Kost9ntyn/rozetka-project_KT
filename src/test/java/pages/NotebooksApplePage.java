package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

/**
 * Created by Администратор on 25.11.2014.
 */
public class NotebooksApplePage extends TestBase {

    private String sortKey = ".//*[@id='sort_view']/a";

    private String fromExpToCheap = ".//*[@href='http://rozetka.com.ua/notebooks/c80004/filter/producer=apple;sort=expansiv/']";

    private String checkBox1 = ".//*[@id='block_with_goods']/div[1]/div[1]/div[3]/div[1]/div/div/div[5]/div[1]/label/input";

    protected By searchPageTitle = By.xpath(".//*[@class='title-page-with-filters']/h1");

    protected WebElement searchLinkElem;

    public String verifyPageTitle () {      //verification if we are on the "Ноутбуки Apple" page
        Log4Test.info("Verify page title");
        searchLinkElem = webDriver.findElement(searchPageTitle);
        return searchLinkElem.getText();
    }

    public void rangeProducts (){       // click on range key to get a list
        Log4Test.info("Click on sort Key");
        webDriver.findElement(By.xpath(sortKey)).click();
    }

    public void selectKindOfRanging (){     // from range list select rank type "fromExpToCheap"
        Log4Test.info("Selection of the rank type");
        webDriver.findElement(By.xpath(fromExpToCheap)).click();
    }

    public void checkCheckbox (){       // check the checkbox
        Log4Test.info("Check a checkbox");
        webDriver.findElement(By.xpath(checkBox1)).click();
    }


}
