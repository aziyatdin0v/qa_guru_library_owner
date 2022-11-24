package com.demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
})

public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();
}