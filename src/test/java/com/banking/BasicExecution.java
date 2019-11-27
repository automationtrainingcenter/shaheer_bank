package com.banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution {

    @BeforeClass(groups = {"valid", "branch", "role", "employee", "reset", "cancel", "create"})
    public void launchBrowser() {
        openBrowser("chrome", "http://primusbank.qedgetech.com/");
    }

    @AfterClass(groups = {"valid", "branch", "role", "employee", "reset", "cancel", "create"})
    public void tearDown() {
        closeBrowser();
    }
}
