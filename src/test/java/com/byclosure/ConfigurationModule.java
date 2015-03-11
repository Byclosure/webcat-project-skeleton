package com.byclosure;

import com.byclosure.steps.FeatureLifecycleSteps;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;

public class ConfigurationModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    WebDriver getWebDriver(){
        return FeatureLifecycleSteps.initWebDriverConfigs();
    }
}
