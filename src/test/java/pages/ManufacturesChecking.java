package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Администратор on 14.11.2014.
 */
public class ManufacturesChecking extends TestBase {

    WebElement table = webDriver.findElement(By.xpath("//h4[contains(text(),'Производители')]"));
    List<WebElement> rows = table.findElements(By.tagName("m-cat-subl")); // ???????
    java.util.Iterator<WebElement> i = rows.iterator();
    while(i.hasNext()) {
        WebElement row = i.next();
        System.out.println(row.getText());
    }
}
