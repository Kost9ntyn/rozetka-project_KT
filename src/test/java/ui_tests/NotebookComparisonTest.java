package ui_tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.NoteBooksPage;
import pages.RozetkaNotebookPage;
import pages.RozetkaWelcomePage;
import pages.ResultPage;

import static org.testng.Assert.*;

public class NotebookComparisonTest extends TestBase {

    RozetkaWelcomePage page = new RozetkaWelcomePage();

    RozetkaNotebookPage notebooklist = new RozetkaNotebookPage();

    NoteBooksPage noteBooksPage = new NoteBooksPage();

    ResultPage searchPage = new ResultPage();

    @Test
    public void setUpPreconditions(){


        page.open();

        assertTrue(page.isOpened());

        notebooklist.clickOnPC_NB_link();

        notebooklist.clickOn_NB_link();

        assertTrue(notebooklist.isOpened());

    }


    @Test(dependsOnMethods = {"setUpPreconditions"})

    public void VerifyingComparisonFunctionality(){


        page.searchProduct(TestData.APPLE_MACBOOK_AIR11_MD712UA_A);

        assertEquals(searchPage.verifyProductLink(), TestData.APPLE_MACBOOK_AIR11_MD712UA_A);

        page.searchProduct(TestData.APPLE_MACBOOK_PRO_RETINA_15_Z0PU002JE);

        assertEquals(searchPage.verifyProductLink(), TestData.APPLE_MACBOOK_PRO_RETINA_15_Z0PU002JE);




    }

}
