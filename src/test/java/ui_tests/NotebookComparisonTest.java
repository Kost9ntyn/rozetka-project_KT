package ui_tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NotebookComparisonTest extends TestBase {

    RozetkaWelcomePage page = new RozetkaWelcomePage();
    RozetkaNotebookPage notebooklist = new RozetkaNotebookPage();
    ManufacturesChecking manCheck = new ManufacturesChecking();
    NotebooksApplePage applePage = new NotebooksApplePage();
    AppleMacBookProRetina15_Z0PU002JE AppleMacBookProRetina15_Z0PU002JE = new AppleMacBookProRetina15_Z0PU002JE();
    AppleMacBookAir11_Z0NY002NA AppleMacBookAir11_Z0NY002NA = new AppleMacBookAir11_Z0NY002NA();
    ComparisonPage compare = new ComparisonPage();

    @Test
    public void setUpPreconditions() {

        page.open();        //open main page rozetka.com.ua

        assertTrue(page.isOpened());    //verification if we are on the target page

        notebooklist.clickOn_NB_link();     //goes to page with Notebooks

        assertTrue(notebooklist.isOpened());        //verification if we are on the target page

        assertEquals(manCheck.manufacturesQty(), 9);     //counting qty of manufactures

        manCheck.manufactures();    //looking for Apple and click on it

        assertEquals(applePage.verifyPageTitle(), TestData.NOTEBOOKS_APPLE);    //verification if we are on the target page

        applePage.rangeProducts();  //set the certain range of products

        applePage.selectKindOfRanging();    //set the certain range of products

        assertTrue(AppleMacBookProRetina15_Z0PU002JE.verifyProductContent().getText().contains(TestData.APPLE_MACBOOK_PRO_RETINA_15_Z0PU002JE)); //searching Z0PU002JE model

        applePage.checkProductForComparisonByName(TestData.APPLE_MACBOOK_PRO_RETINA_15_Z0PU002JE);      //add a product to comparison list

        assertTrue(AppleMacBookAir11_Z0NY002NA.verifyProductContent().getText().contains(TestData.APPLE_MACBOOK_AIR11_Z0NY002NA));  //searching Z0NY002NA model

        applePage.checkProductForComparisonByName(TestData.APPLE_MACBOOK_AIR11_Z0NY002NA);      //add a product to comparison list

        applePage.clickCompare();       //click compare

        assertEquals(compare.verifyPageTitle(), TestData.GOODS_COMPARISON);     //verification if we are on the target page

        compare.clickAddModel();        //click add model

        compare.isProductAddedToComparison(TestData.APPLE_MACBOOK_PRO_RETINA_15_Z0PU002JE);     //Verify if the page contains APPLE_MACBOOK_PRO_RETINA_15_Z0PU002JE on it

        compare.isProductAddedToComparison(TestData.APPLE_MACBOOK_AIR11_Z0NY002NA);     //Verify if the page contains APPLE_MACBOOK_AIR11_Z0NY002NA on it
    }
}
