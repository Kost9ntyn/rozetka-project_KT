package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

/**
 * Created by Администратор on 12.11.2014.
 */
public class AppleMacBookProRetina15_Z0PU002JE extends TestBase{

    protected By productDescription = By.xpath(".//*[@id='block_with_goods']/div[1]/div[1]/div[3]/div[1]/div/div/div[3]/a");

    protected WebElement productContent;

    public WebElement verifyProductContent(){

        Log4Test.info("Verify product content");

        return  productContent = webDriver.findElement(productDescription);

    }

}
