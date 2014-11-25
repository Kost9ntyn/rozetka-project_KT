package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui_tests.TestData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private static final int timeout = 20;

    protected static WebDriver webDriver;

    protected static WebDriverWait wait;

    @BeforeSuite
    public static void setUp() throws IOException

    {

        webDriver = WebDriverFactory.getWebDriver(TestData.BROWSER_NAME);

        wait = new WebDriverWait(webDriver, timeout);

        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        webDriver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);

        webDriver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void tearDown()

    {
        webDriver.close();

        try
        {
            Thread.sleep(5000);
            webDriver.quit();
        }
        catch(Exception e)
        {
        }
    }

}


