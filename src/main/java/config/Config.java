package config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    private static Properties properties = new Properties();
    private final static String fileConfigPath = "src/test/resources/config.properties";
    public static final String BROWSER_NAME = System.getProperty("browser.name", getProperty("browser.name"));
    public static final String FILE_PATH = System.getProperty("file.path", getProperty("file.path"));

    private static String getProperty(String name){
        try{
            InputStream inputStream = Files.newInputStream(Paths.get(fileConfigPath));
            properties.load(inputStream);
        }catch (IOException exception) {
            throw new RuntimeException(String.format("File not exist in the path %s", fileConfigPath));
        }

        return properties.getProperty(name);
    }
}
