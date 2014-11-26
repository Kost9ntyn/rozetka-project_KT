package pages;


import core.TestBase;
import org.openqa.selenium.By;
import utils.Log4Test;

public class RozetkaWelcomePage extends TestBase {

    protected By searchString = By.className("header-search-input-text");
    private String URL = "http://rozetka.com.ua/";

    public void open() {

        webDriver.get(URL);
        Log4Test.info("Open WebUrl" + URL);

    }

    public boolean isOpened() {
        Log4Test.info("Check if the url equals to " + URL);
        return webDriver.getCurrentUrl().equals(URL);
    }

}
