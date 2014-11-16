package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4Test;


public class NoteBooksPage extends TestBase {

    protected By productDescription = By.xpath(".//*[@id='tab_content']/div/div[1]/div[1]/section[1]/div[3]/div[2]");

    protected WebElement productContent;

    public WebElement verifyProductContent(){

        Log4Test.info("Verify product content");

        return  productContent = webDriver.findElement(productDescription);

    }
}
