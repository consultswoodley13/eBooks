package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWaitUtils {

    private static WebDriverWait wait = null;
    private static Logger log = LogManager.getLogger();

    public static void setDriverWait(WebDriver driver, int timeOutInSeconds) {
        log.debug("Setting WebDriverWait time as " + timeOutInSeconds + " seconds");
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public static WebDriverWait getDriverWait() {
        log.debug("Getting WebDriverWait instance");
        return wait;
    }

    public static WebElement waitForElementToBeClickable(WebElement element) {
        log.debug("Waiting to click on element: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static WebElement waitForElementToBeVisible(WebElement element) {
        log.debug("Waiting for element to be visible: " + element);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitForElementToBeInvisible(WebElement element) {
        log.debug("Waiting for element to be invisible: " + element);
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public static WebElement waitForStalenessOf(WebElement element) {
        log.debug("Waiting for staleness of element: " + element);
        wait.until(ExpectedConditions.stalenessOf(element));
        return element;
    }

    public static WebElement waitForAttributeToContain(WebElement element, String attribute, String value) {
        log.debug("Waiting for html attribute " + attribute + " to contain the value: " + value + "in element "
                + element);
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
        return element;
    }

    public static WebElement waitForTextToBePresentInElement(WebElement element, String string) {
        log.debug("Waiting for text to be present in element: " + element);
        wait.until(ExpectedConditions.textToBePresentInElement(element, string));
        return element;
    }

    public static void waitForAlertToBePresent() {
        log.debug("Waiting for Alert to be present");
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
