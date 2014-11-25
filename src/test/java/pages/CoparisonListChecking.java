package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

import java.util.List;

/**
 * Created by Администратор on 25.11.2014.
 */
public class CoparisonListChecking extends TestBase{
    String comparisonListClass = ".//*[@class='list-compare']/div/div/ul";    // Manufactures block place
    String comparisonItemClass = "li";                                  // link to the each Manufacture

    public void comparison() {
        WebElement formElement = webDriver.findElement(By.xpath(comparisonListClass)); // definition of the manufactures block
        List<WebElement> allFormChildElements = formElement.findElements(By.className(comparisonItemClass)); // filling an array by manufactures names

        for (WebElement compare : allFormChildElements) {       //go through the list
            if (compare.getText().equals("Apple MacBook Pro Retina 15\" (Z0PU002JE) Официальная гарантия!")) {   //if manufacture is "Apple"
                break;
            }

        }
    }
}
