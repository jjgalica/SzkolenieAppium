package Steps;

import Pages.PlayStoreHomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumTest {

    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;
    private PlayStoreHomePage playStoreHomePage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"), getCapabilities());
        wait = new WebDriverWait(driver,30)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);

        playStoreHomePage = new PlayStoreHomePage(driver,wait);
    }

    @Test
    public void testName() throws MalformedURLException {
        playStoreHomePage.searchInStore("Procountor");
        playStoreHomePage.chooseProcountorApp();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "8.0.0");
        capabilities.setCapability("deviceName", "Samsung 8");
        capabilities.setCapability("udid", "ce051715c52da82502");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.vending");
        capabilities.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("automationName", "UiAutomator2");
        return capabilities;
    }
}
