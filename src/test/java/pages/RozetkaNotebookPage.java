package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

/**
 * Created by Администратор on 13.11.2014.
 */
public class RozetkaNotebookPage extends TestBase {

    private String URL = "http://rozetka.com.ua/notebooks/c80004/";

    private String PC_NB_link = ".//*[@id='computers-notebooks']/div/a[1]";

    private String NB_link =".//*[@id='head_banner_container']/div[3]/div/div/div[2]/div[3]/ul/li[1]/ul/li[1]/a";

    protected By searchString = By.className("header-search-input-text");

    public void open()
    {

        webDriver.get(URL);
        Log4Test.info("Open WebUrl " + URL);

    }

    public void clickOnPC_NB_link()
    {
       WebElement pressLink = webDriver.findElement(By.xpath(PC_NB_link));
       pressLink.click();
    }

    public void clickOn_NB_link()
    {
        WebElement pressLink = webDriver.findElement(By.xpath(NB_link));
        pressLink.click();
    }

    public boolean isOpened()
    {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void searchProduct(String productName)
    {
        Log4Test.info("Search product " + productName);
        webDriver.findElement(searchString).clear();
        webDriver.findElement(searchString).sendKeys(productName);
        webDriver.findElement(searchString).sendKeys(Keys.RETURN);
    }
}