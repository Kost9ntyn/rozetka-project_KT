package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Log4Test;

import java.util.List;

/**
 * Created by Администратор on 25.11.2014.
 */
public class NotebooksApplePage extends TestBase {

    protected By searchPageTitle = By.xpath(".//*[@class='title-page-with-filters']/h1");
    protected WebElement searchLinkElem;
    private String sortKey = ".//*[@id='sort_view']/a";
    private String fromExpToCheap = ".//*[@href='http://rozetka.com.ua/notebooks/c80004/filter/producer=apple;sort=expansiv/']";

    public String verifyPageTitle() {      //verification if we are on the "Ноутбуки Apple" page
        Log4Test.info("Verify page title");
        searchLinkElem = webDriver.findElement(searchPageTitle);
        return searchLinkElem.getText();
    }

    public void rangeProducts() {       // click on range key to get a list
        Log4Test.info("Click on sort Key");
        webDriver.findElement(By.xpath(sortKey)).click();
    }

    public void selectKindOfRanging() {     // from range list select rank type "fromExpToCheap"
        Log4Test.info("Selection of the rank type");
        webDriver.findElement(By.xpath(fromExpToCheap)).click();
    }

    public void checkProductForComparisonByName(String productTitlesTocompare) {

        String checkBoxPath = ".//descendant::div[@class='g-tools']/descendant::input";

        List<WebElement> products = webDriver.findElements(By.xpath("//*[@class='gtile-i-wrap']"));
        for (WebElement product : products) {
            String title = product.findElement(By.xpath(".//descendant::div[@class='gtile-i-title']")).getText();
            if (title.equals(productTitlesTocompare)) {
                new Actions(webDriver).moveToElement(product.findElement(By.xpath(checkBoxPath))).perform();
                product.findElement(By.xpath(checkBoxPath)).click();

                isProductAddedToComparison(productTitlesTocompare);
            }
        }
    }

    public void clickCompare() {
        Log4Test.info("click 'Сравнить'");
        String compareButtonXpath = "//descendant::div[@class='g-tools']/descendant::a[contains(@class,'lightblue underline')]";
        new Actions(webDriver).moveToElement(webDriver.findElement(By.xpath(compareButtonXpath))).perform();
        webDriver.findElement(By.xpath(compareButtonXpath)).click();
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
        Assert.assertTrue(productIsAdded, "Product is not added. Expected: '" + productTitlesTocompare + "'" +
                " Actual: '" + actualTile + "'");
    }
}
