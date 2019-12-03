package com.banking;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution {

    @BeforeClass(groups = {"dd", "valid", "branch", "role", "employee", "reset", "cancel", "create"})
    @Parameters({"browser", "url", "os", "nodeURL"})
    public void launchBrowser(String browserName, String appUrl, String os, String nodeURL) {
        openBrowser(browserName, appUrl, os, nodeURL);
    }

    @AfterClass(groups = {"dd", "valid", "branch", "role", "employee", "reset", "cancel", "create"})
    public void tearDown() {
        closeBrowser();
    }
}
