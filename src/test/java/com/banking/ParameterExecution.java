package com.banking;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParameterExecution extends TestExecution {

    @BeforeClass(groups = {"valid", "branch", "role", "employee", "reset", "cancel", "create"})
    @Parameters({"browser", "url"})
    public void launchBrowser(String browserName, String appUrl) {
        openBrowser(browserName, appUrl);
    }

    @AfterClass(groups = {"valid", "branch", "role", "employee", "reset", "cancel", "create"})
    public void tearDown() {
        closeBrowser();
    }
}
