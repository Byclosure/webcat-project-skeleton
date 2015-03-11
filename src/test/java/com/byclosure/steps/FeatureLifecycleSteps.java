package com.byclosure.steps;

import com.byclosure.ConfigurationsManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;

public class FeatureLifecycleSteps {

    private static WebDriver webDriver;

    public static WebDriver initWebDriverConfigs() {
        if(webDriver == null) {
            final ConfigurationsManager configsManager = new ConfigurationsManager();
            webDriver = configsManager.buildWebDriver();
        }

        return webDriver;
    }

    @After
    public void afterScenario(Scenario scenario) {
        webDriver.quit();
    }
}
