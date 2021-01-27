package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TestUtils {

    private TestUtils() {
    }

    public static void elementIsDisplayed(WebElement element) {
        DriverWaitUtils.waitForElementToBeVisible(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public static void elementIsNotDisplayed(WebElement element) {
        DriverWaitUtils.waitForElementToBeInvisible(element);
        Assert.assertFalse(element.isDisplayed());
    }

    public static void assertElementIsSelected(WebElement element) {
        DriverWaitUtils.waitForElementToBeVisible(element);
        Assert.assertTrue(element.isSelected());
    }

    public static void assertElementIsNotSelected(WebElement element) {
        DriverWaitUtils.waitForElementToBeVisible(element);
        Assert.assertFalse(element.isSelected());
    }

    public static void assertElementIsEnabled(WebElement element) {
        DriverWaitUtils.waitForElementToBeVisible(element);
        Assert.assertTrue(element.isEnabled());
    }

    public static void assertElementIsNotEnabled(WebElement element) {
        DriverWaitUtils.waitForElementToBeVisible(element);
        Assert.assertFalse(element.isEnabled());
    }

    //TODO: Create more generic method for asserting a URL without passing in element
    public static void assertURL(WebElement element, String url) {
        DriverWaitUtils.waitForElementToBeVisible(element);
        String currentUrl = BrowserUtils.currentUrl();
        Assert.assertEquals(currentUrl.toLowerCase(), url.toLowerCase());
    }

    public static void assertWebElementText(WebElement element, String expectedText) {
        DriverWaitUtils.waitForElementToBeVisible(element);
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public static void assertAlertText(Alert alert, String expectedText) {
        DriverWaitUtils.getDriverWait().until(ExpectedConditions.alertIsPresent());
        String actualText = alert.getText();
        Assert.assertEquals(actualText, expectedText);
    }

}


