package test.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class TestBase {

    public Logger logger = LogManager.getLogger();

    public static void beforeScenario() {}

    public static void afterScenario() {}


}
