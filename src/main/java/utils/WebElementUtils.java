package utils;

import java.util.List;
import java.util.ListIterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementUtils {



    private static Logger log = LogManager.getLogger();

    public static void clickElement(WebElement element) {
        log.debug("Clicking on WebElement: " + element);
        DriverWaitUtils.waitForElementToBeClickable(element);
        element.click();
    }

    public static void enterNumber(WebElement element, long number) {
        log.debug("Entering number(s) \"" + number + "\" on WebElement: " + element);
        DriverWaitUtils.waitForElementToBeClickable(element);
        element.sendKeys(String.valueOf(number));
    }

    public static void overwriteText(WebElement element, String text) {
        log.debug("Overwriting text on WebElement: " + element);
        deleteText(element);
        enterText(element, text);
    }

    public static void enterText(WebElement element, String text) {
        log.debug("Entering text \"" + text + "\" on WebElement: " + element);
        DriverWaitUtils.waitForElementToBeClickable(element);
        element.sendKeys(text);
    }

    public static void deleteText(WebElement element) {
        log.debug("Clearing any existing values from WebElement: " + element);
        DriverWaitUtils.waitForElementToBeClickable(element);
        element.clear();
    }

    public static void selectFromDropdown(WebElement element, String text) {
        log.debug("Selecting " + text + " from dropdown");
        DriverWaitUtils.waitForElementToBeClickable(element);
        Select selectValue = new Select(element);
        selectValue.selectByVisibleText(text);
    }

    public static void uploadFile(WebElement element, String filePath) {
        log.debug("Clearing any existing values from WebElement: " + element);
        element.sendKeys(filePath);
    }

    public static void enterItemList(WebElement element, List<String> items) {
        ListIterator<String> itemList = items.listIterator();
        while (itemList.hasNext()) {
            log.debug("Entering value(s) \"" + itemList.next() + "\" on WebElement: " + element);
            element.sendKeys(itemList.next());
        }
    }
}