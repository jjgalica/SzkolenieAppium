package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class PlayStoreHomePage {

    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;

    private final By searchBox = By.id("search_box_idle_text");
    private final By searchBoxInput = By.id("search_box_text_input");
    private final By icon = By.id("icon");
    private final By procountorApp = By.xpath("//*[contains(@resource-id,'li_title')][@text='Procountor Key']");

    public PlayStoreHomePage(AndroidDriver<AndroidElement> driver, FluentWait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void searchInStore(String apkToFind) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).click();
        driver.findElement(searchBoxInput).sendKeys(apkToFind);
    }

    public void chooseProcountorApp() {
        driver.findElement(icon).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(procountorApp));
        driver.findElement(procountorApp).click();
    }
}
