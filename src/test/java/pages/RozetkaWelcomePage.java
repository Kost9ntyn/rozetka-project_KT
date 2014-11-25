package pages;


import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log4Test;

public class RozetkaWelcomePage extends TestBase{

    private String URL = "http://rozetka.com.ua/";

    protected By searchString = By.className("header-search-input-text");

    public void open()
    {

        webDriver.get(URL);
        Log4Test.info("Open WebUrl" + URL);

    }

    public boolean isOpened()
    {
        Log4Test.info("Check if the url equals to " + URL);
        return webDriver.getCurrentUrl().equals(URL);
    }

}
