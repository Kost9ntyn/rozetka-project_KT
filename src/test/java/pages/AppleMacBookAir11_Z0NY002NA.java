package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

/**
 * Created by Администратор on 12.11.2014.
 */
public class AppleMacBookAir11_Z0NY002NA extends TestBase {
    protected By productDescription = By.xpath(".//a[contains(text(),'Apple MacBook Air 11\" (Z0NY002NA) Официальная гарантия!')]");

    protected WebElement productContent;

    public WebElement verifyProductContent() {

        Log4Test.info("Verify product content");

        return productContent = webDriver.findElement(productDescription);

    }

}
