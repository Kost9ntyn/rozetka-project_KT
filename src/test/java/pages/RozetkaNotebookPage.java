package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Log4Test;

/**
 * Created by Администратор on 13.11.2014.
 */
public class RozetkaNotebookPage extends TestBase {

    private String URL = "http://rozetka.com.ua/notebooks/c80004/";

    private String PC_NB_link = ".//*[@id='computers-notebooks']/div/a[1]";

    private String NB_link = ".//*[@class='m-main-fat-link3'][@href='http://rozetka.com.ua/notebooks/c80004/']";

    public boolean isOpened() {
        Log4Test.info("Check if the url equals to " + URL);
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void clickOn_NB_link() {
        WebElement Menu1 = webDriver.findElement(By.xpath(PC_NB_link));
        Log4Test.info("Предвинули курсор на закладку");
        new Actions(webDriver).moveToElement(Menu1).perform();

        WebElement pressLink = webDriver.findElement(By.xpath(NB_link));
        Log4Test.info("Click on Ноутбуки");
        pressLink.click();
    }

}