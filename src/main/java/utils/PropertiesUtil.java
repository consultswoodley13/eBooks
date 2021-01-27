package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    /**
     * This method will load a properties file from the default root directory.
     *
     * @param fileName Name of the file including extension
     * @return Properties object with filepath loaded
     */
    public static Properties loadFile(String fileName) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String fullPath = rootPath.concat(fileName);
        return load(fullPath);
    }

    /**
     * This method will load a properties file from a specified root directory.
     *
     * @param rootPath Name of the root directory
     * @param fileName Name of the file including extension
     * @return Properties object with filepath loaded
     */
    public static Properties loadFile(String rootPath, String fileName) {
        String fullPath = rootPath.concat(fileName);
        return load(fullPath);
    }

    private static Properties load(String filePath) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}