package com.byclosure;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigurationsManager {
    private static Logger logger = Logger.getLogger(ConfigurationsManager.class.getName());

    private static final String localGridURL = "http://<selenium_grid_hub_address>:4444/wd/hub";

    private WebDriver webDriver;

    public WebDriver buildWebDriver() {
        buildRemoteWebDriver();

        ((RemoteWebDriver)webDriver).setLogLevel(Level.FINEST);
        Augmenter augmenter = new Augmenter();
        webDriver = augmenter.augment(webDriver);

        return webDriver;
    }

    private void buildRemoteWebDriver() {
        try {
            webDriver = new RemoteWebDriver(new URL(localGridURL), this.getDesiredCapabilities());
        } catch(RuntimeException e) {
            logger.log(Level.SEVERE, e.getMessage());
            logger.log(Level.FINEST, e.getMessage(), e);
            throw e;
        } catch (MalformedURLException e) {
            logger.log(Level.SEVERE, e.getMessage());
            logger.log(Level.FINEST, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    private DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("chrome.switches", Arrays.asList("--v=1", "--kiosk www.google.com"));

        return capabilities;
    }
}
