package utils;

import org.openqa.selenium.Alert;

public class AlertUtils {

    private AlertUtils() {
    }

    private static Alert alert;

    public static Alert getAlert() {
        return alert;
    }

    public static void switchToAlert() {
        DriverWaitUtils.waitForAlertToBePresent();
        alert = DriverUtils.getDriver().switchTo().alert();
    }

    public static void acceptAlert() {
        alert.accept();
    }

}
