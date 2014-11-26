package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4Test;

import java.util.List;

/**
 * Created by Администратор on 14.11.2014.
 */
public class ManufacturesChecking extends TestBase {
    String manufacturesListClass = "//*[@name='menu_categories_left']/li[2]/ul";    // Manufactures block place
    String manufacturesItemClass = "m-cat-subl-i";                                  // link to the each Manufacture

    public void manufactures() {
        WebElement formElement = webDriver.findElement(By.xpath(manufacturesListClass)); // definition of the manufactures block
        List<WebElement> allFormChildElements = formElement.findElements(By.className(manufacturesItemClass)); // filling an array by manufactures names

        for (WebElement manufacture : allFormChildElements) {       //go through the list
            if (manufacture.getText().equals("Apple")) {            //if manufacture is "Apple"
                Log4Test.info("Step 6. click Apple manufacture");
                manufacture.findElement(By.xpath(".//a")).click();
                break;
            }
        }
    }

    public int manufacturesQty() {
        WebElement formElement = webDriver.findElement(By.xpath(manufacturesListClass)); // definition of the manufactures block
        List<WebElement> allFormChildElements = formElement.findElements(By.className(manufacturesItemClass)); // filling an array by manufactures names

        int qtyOfManufactures = allFormChildElements.size();        //getting number of manufactures
        Log4Test.info("Step 5. Verify that all 9 manufactures are present");
        return qtyOfManufactures;
    }
}