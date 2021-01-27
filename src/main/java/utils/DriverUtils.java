package utils;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {

    private static WebDriver driver;
    private static FirefoxOptions fireFoxOptions;
    private static ChromeOptions chromeOptions;
    private static Logger log = LogManager.getLogger();

    private DriverUtils() {
    }

    //TODO: Rework setup process
    public static void driverSetUp(Browser browser, String options) throws InterruptedException {
        log.info("Setting up the WebDriver instance");
        setBrowser(browser);
        setBrowserOptions(browser, options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        DriverWaitUtils.setDriverWait(driver, 15);
        log.info("WebDriver set-up completed");
    }

    //TODO: Change switch to if-else statement
    public static void setBrowser(Browser browser) {
        log.debug("Setting default browser as " + browser);
        try {
            switch (browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new RuntimeException("Invalid Browser");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO: Change switch to if-else statement
    //TODO: Create an impl that assures Driver is instantiated beforehand
    public static void setBrowserOptions(Browser browser, String options) {
        log.debug("Setting browser options for " + browser);
        Assert.assertNotNull(driver);
        try {
            switch (browser) {
                case FIREFOX:
                    fireFoxOptions = new FirefoxOptions().addArguments(options);
                    driver = new FirefoxDriver(fireFoxOptions);
                    break;
                case CHROME:
                    chromeOptions = new ChromeOptions().addArguments(options);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                default:
                    throw new RuntimeException("Invalid Browser");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        log.debug("Getting WebDriver instance");
        return driver;
    }

    public static void goToUrl(String url) throws MalformedURLException {
        log.debug("Going to URL " + url);
        driver.get(url);
    }

    public static void driverTearDown() {
        log.info("Quitting the WebDriver");
        driver.quit();
    }

}
