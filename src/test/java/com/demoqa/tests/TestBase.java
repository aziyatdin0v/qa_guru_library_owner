package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.demoqa.config.WebDriverProvider;


public class TestBase {

    @BeforeAll
    public static void setUp() {
        WebDriverProvider.configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if ((!Configuration.browser.equals("firefox")) & (!Configuration.browser.equals("safari"))) {
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
    }
}
