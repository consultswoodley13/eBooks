package utils;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BrowserUtils {

    private static Logger log = LogManager.getLogger();

    private BrowserUtils() {
    }

    public static void goToUrl(String url) throws MalformedURLException {
        log.debug("Going to URL " + url);
        DriverUtils.getDriver().get(url);
    }

    public static void navigateToPage(String url) {
        log.debug("Navigating to page " + url);
        DriverUtils.getDriver().navigate().to(url);
    }

    public static void navigateBack() {
        log.debug("Navigating back a page");
        DriverUtils.getDriver().navigate().back();
    }

    public static void navigateForward() {
        log.debug("Navigating forward a page");
        DriverUtils.getDriver().navigate().forward();
    }

    public static void refreshBrowser() {
        log.debug("Refreshing Browser");
        DriverUtils.getDriver().navigate().refresh();
    }

    public static void switchToTab(int tab) {
        ArrayList<String> tabs = getWindowHandles();
        log.debug("Switching tabs to " + tabs.get(tab));
        DriverUtils.getDriver().switchTo().window(tabs.get(tab));
    }

    public static ArrayList<String> getWindowHandles() {
        log.debug("Getting window handles");
        ArrayList<String> windowHandles = new ArrayList<>(DriverUtils.getDriver().getWindowHandles());
        return windowHandles;
    }

    public static String currentUrl() {
        log.debug("Getting current url");
        return DriverUtils.getDriver().getCurrentUrl();
    }

    public static void close() {
        log.debug("Closing WebDriver");
        DriverUtils.getDriver().close();
    }
}
