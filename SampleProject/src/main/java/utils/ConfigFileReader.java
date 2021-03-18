package utils;

import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    static Properties properties;
    static String propertyFilePath= "src/main/java/config/data.properties";

    public static Properties loadProperties() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
        return properties;
    }

    public static String getReportConfigPath()
    {
            String reportConfigPath = properties.getProperty("reportConfigPath");
        System.out.println("--- reportConfigPath -- "+ reportConfigPath);

        if(reportConfigPath!= null)
                return reportConfigPath;
            else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }


    public static String getBrowser()
    {
        String browser = properties.getProperty("browser");
        if(browser!= null)
            return browser;
        else
            return "chrome";
    }
    public static String getApplicationUrl()
    {
        String url = properties.getProperty("url");

        if(url!= null)
            return url;
        else
            return "https://www.gumtree.com/";
    }

/*
    public static DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }
*/
    public static EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }
}




