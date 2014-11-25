package ui_tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.*;

public class NotebookComparisonTest extends TestBase {

    RozetkaWelcomePage page = new RozetkaWelcomePage();

    RozetkaNotebookPage notebooklist = new RozetkaNotebookPage();

    ManufacturesChecking manCheck = new ManufacturesChecking();

    NotebooksApplePage applePage = new NotebooksApplePage();

    AppleMacBookProRetina15_Z0PU002JE AppleMacBookProRetina15_Z0PU002JE = new AppleMacBookProRetina15_Z0PU002JE();

    CoparisonListChecking compare = new CoparisonListChecking();

    @Test
    public void setUpPreconditions(){

        page.open();        //open main page rozetka.com.ua

        assertTrue(page.isOpened());    //verification if we are on the target page

        notebooklist.clickOn_NB_link();     //goes to page with Notebooks

        assertTrue(notebooklist.isOpened());        //verification if we are on the target page

        assertEquals(manCheck.manufacturesQty(),9);     //counting qty of manufactures

        manCheck.manufactures();    //looking for Apple and click on it

        assertEquals(applePage.verifyPageTitle(), TestData.NOTEBOOKS_APPLE);    //verification if we are on the target page

        applePage.rangeProducts();  //set the certain range of products

        applePage.selectKindOfRanging();    //set the certain range of products

        assertTrue(AppleMacBookProRetina15_Z0PU002JE.verifyProductContent().getText().contains(TestData.APPLE_MACBOOK_PRO_RETINA_15_Z0PU002JE)); //searching Z0PU002JE model

        applePage.checkCheckbox(); //I don't know how to check this box :(

        compare.comparison();
    }


//    @Test(dependsOnMethods = {"setUpPreconditions"})
//
//    public void VerifyingComparisonFunctionality(){
//
//
//        page.searchProduct(TestData.APPLE_MACBOOK_AIR11_MD712UA_A);
//
//        assertEquals(searchPage.verifyProductLink(), TestData.APPLE_MACBOOK_AIR11_MD712UA_A);
//
//        page.searchProduct(TestData.APPLE_MACBOOK_PRO_RETINA_15_Z0PU002JE);
//
//        assertEquals(searchPage.verifyProductLink(), TestData.APPLE_MACBOOK_PRO_RETINA_15_Z0PU002JE);
//
//
//
//
//    }

}
