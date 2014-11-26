package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Log4Test;

import java.util.List;

/**
 * Created by Администратор on 25.11.2014.
 */
public class ComparisonPage extends TestBase {

    protected By searchPageTitle = By.className("comparison-title");
    protected WebElement searchLinkElem;
    private String addModel = "//*[@class='comparison-add-i']/a";

    public String verifyPageTitle() {      //verification if we are on the "Сравнение товаров" page
        Log4Test.info("Verify page title \"Сравнение товаров\"");
        searchLinkElem = webDriver.findElement(searchPageTitle);
        return searchLinkElem.getText();
    }

    public void clickAddModel() {
        Log4Test.info("click 'add model'");
        webDriver.findElement(By.xpath(addModel)).click();
    }

    public void isProductAddedToComparison(String productTitlesTocompare) {
        String actualTile = null;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean productIsAdded = false;
        List<WebElement> productsAdded = webDriver.findElements(By.xpath(".//*[@class='list-compare']/div/div/ul/li"));
        for (WebElement productAdded : productsAdded) {
            actualTile = productAdded.getText();
            if (actualTile.equals(productTitlesTocompare)) {
                productIsAdded = true;
                break;
            }
        }
        Assert.assertTrue(productIsAdded);
    }
}
