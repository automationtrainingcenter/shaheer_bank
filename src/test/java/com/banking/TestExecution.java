package com.banking;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.BrowserHelper;

public class TestExecution extends BrowserHelper {


    @Test(priority = 0, groups = {"valid", "branch","role", "employee", "reset", "cancel", "create"})
    public void login() {
        BankHomePage bankHomePageObj = new BankHomePage(driver);
        bankHomePageObj.fillUserName("Admin");
        bankHomePageObj.fillPassword("Admin");
        bankHomePageObj.clickLogin();
    }

    @Test(priority = 1, groups = {"valid", "role", "create"})
    public void roleCreation() {
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        RoleDetailsPage roleDetailsPageObj = adminHomePageObj.clickRoles();
        RoleCreationPage roleCreationPageObj = roleDetailsPageObj.clickNewRole();
        roleCreationPageObj.fillRoleName("Anupriya");
        roleCreationPageObj.selectRoleType("E");
        Alert alert = roleCreationPageObj.clickSubmit();
        System.out.println(alert.getText());
        alert.accept();

    }

    @Test(priority = 25, groups = {"valid", "branch","role", "employee", "reset", "cancel", "create"})
    public void logout() {
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        adminHomePageObj.clickLogout();
    }

    @Test(priority = 2, groups = {"valid", "branch", "create"})
    public void branchCreation() {
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        BranchDetailsPage branchDetailsPageObj = adminHomePageObj.clickBranches();
        BranchCreationPage branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
        branchCreationPageObj.fillBranchName("chandanar");
        branchCreationPageObj.fillAddress1("madinaguda");
        branchCreationPageObj.fillZipCode("50030");
        branchCreationPageObj.selectCountry("INDIA");
        branchCreationPageObj.selectState("Andhra Pradesh");
        branchCreationPageObj.selectCity("Hyderabad");
        Alert alert = branchCreationPageObj.clickSubmit();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test(priority = 3, groups = {"valid", "employee", "create"})
    public void empoloyeeCreation() {
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        EmpoloyeeDetailsPage empoloyeeDetailsPageObj = adminHomePageObj.clickEmployee();
        EmployeeCreationPage employeeCreationPageObj = empoloyeeDetailsPageObj.clickNewEmpoloyee();
        employeeCreationPageObj.fillEmpName("Anupriya");
        employeeCreationPageObj.fillLoginPass("aaravi");
        employeeCreationPageObj.selectRole("clerk");
        employeeCreationPageObj.selectBranch("Golkonda");
        Alert alert = employeeCreationPageObj.clickSubmit();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test(priority = 4, groups = {"branch", "reset"})
    public void branchCreationReset() {
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        BranchDetailsPage branchDetailsPageObj = adminHomePageObj.clickBranches();
        BranchCreationPage branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
        branchCreationPageObj.fillBranchName("chandanar");
        branchCreationPageObj.fillAddress1("madinaguda");
        branchCreationPageObj.fillZipCode("50030");
        branchCreationPageObj.selectCountry("INDIA");
        branchCreationPageObj.selectState("Andhra Pradesh");
        branchCreationPageObj.selectCity("Hyderabad");
        branchCreationPageObj.clickReset();

    }

    @Test(priority = 5, groups = {"branch", "cancel"})
    public void branchCreationCancel() {
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        BranchDetailsPage branchDetailsPageObj = adminHomePageObj.clickBranches();
        BranchCreationPage branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
        branchCreationPageObj.clickCancel();

    }


    @Test(priority = 6, groups = {"employee", "reset"})
    public void employeeCreationReset() {
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        EmpoloyeeDetailsPage empoloyeeDetailsPageObj = adminHomePageObj.clickEmployee();
        EmployeeCreationPage employeeCreationPageObj = empoloyeeDetailsPageObj.clickNewEmpoloyee();
        employeeCreationPageObj.fillEmpName("Anupriya");
        employeeCreationPageObj.fillLoginPass("aaravi");
        employeeCreationPageObj.selectRole("clerk");
        employeeCreationPageObj.selectBranch("Primusbank");
        employeeCreationPageObj.clickReset();

    }

    @Test(priority = 7, groups = {"employee", "cancel"})
    public void employeeCreationCancel() {
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        EmpoloyeeDetailsPage empoloyeeDetailsPageObj = adminHomePageObj.clickEmployee();
        EmployeeCreationPage employeeCreationPageObj = empoloyeeDetailsPageObj.clickNewEmpoloyee();
        employeeCreationPageObj.clickCancel();

    }

    @Test(priority = 8, groups = {"role", "reset"})
    public void roleCreationReset() {
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        RoleDetailsPage roleDetailsPageObj = adminHomePageObj.clickRoles();
        RoleCreationPage roleCreationPageObj = roleDetailsPageObj.clickNewRole();
        roleCreationPageObj.fillRoleName("Anupriya");
        roleCreationPageObj.selectRoleType("E");
        roleCreationPageObj.clickReset();

    }

    @Test(priority = 9, groups = {"role", "cancel"})
    public void roleCreationCancel() {
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        RoleDetailsPage roleDetailsPageObj = adminHomePageObj.clickRoles();
        RoleCreationPage roleCreationPageObj = roleDetailsPageObj.clickNewRole();
        roleCreationPageObj.clickCancel();

    }


}
