package com.banking;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.BrowserHelper;
import utilities.ExcelHelper;
import utilities.TestNGListeners;

@Listeners(TestNGListeners.class)
public class TestExecution extends BrowserHelper {


    @Test(priority = 0, groups = {"dd","valid", "branch","role", "employee", "reset", "cancel", "create"})
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

    @Test(priority = 25, groups = {"dd","valid", "branch","role", "employee", "reset", "cancel", "create"})
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
        employeeCreationPageObj.selectBranch("Golkonda");
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


    /*
     employee creation with multiple sets of data without using @DataProvider
     but by using ExcelHelper class
      */
    @Test(priority = 10, groups = {"employee", "dd"})
    public void employeeCreationResetWithDDwihoutUsingDP(){
        AdminHomePage adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
        EmpoloyeeDetailsPage empoloyeeDetailsPage = adminHomePage.clickEmployee();
        EmployeeCreationPage employeeCreationPage = empoloyeeDetailsPage.clickNewEmpoloyee();
        // create an object of ExcelHelper
        ExcelHelper excel = new ExcelHelper();
        excel.openExcel("resources", "testdata.xls", "empData");
        int nor = excel.rowCount();
        int noc = excel.columnCount();
        for(int r = 1; r < nor; r++){
            String empName = excel.readData(r, 0);
            String loginPass = excel.readData(r, 1);
            String role = excel.readData(r, 2);
            String branch = excel.readData(r, 3);
            employeeCreationPage.fillEmpName(empName);
            employeeCreationPage.fillLoginPass(loginPass);
            employeeCreationPage.selectRole(role);
            employeeCreationPage.selectBranch(branch);
            employeeCreationPage = employeeCreationPage.clickReset();
            Assert.assertTrue(employeeCreationPage.isFormReset());
        }
    }

    // role creation with multiple data using data provider
    @Test(priority = 11, groups = {"role" , "dd"}, dataProviderClass = DataProvideUtility.class, dataProvider = "roleData")
    public void roleCreationResetWithDP(String roleName, String roleType){
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        RoleDetailsPage roleDetailsPageObj = adminHomePageObj.clickRoles();
        RoleCreationPage roleCreationPageObj = roleDetailsPageObj.clickNewRole();
        roleCreationPageObj.fillRoleName(roleName);
        roleCreationPageObj.selectRoleType(roleType);
        roleCreationPageObj.clickReset();
    }

    // branch creation reset with multiple data using data provider
    @Test(priority = 12, groups = {"branch", "dd"}, dataProviderClass = DataProvideUtility.class, dataProvider = "branchData")
    public void branchCreationResetWithDP(String branchName, String add, String zip, String country, String state, String city){
        AdminHomePage adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
        BranchDetailsPage branchDetailsPageObj = adminHomePageObj.clickBranches();
        BranchCreationPage branchCreationPageObj = branchDetailsPageObj.clickNewBranch();
        branchCreationPageObj.fillBranchName(branchName);
        branchCreationPageObj.fillAddress1(add);
        branchCreationPageObj.fillZipCode(zip);
        branchCreationPageObj.selectCountry(country);
        branchCreationPageObj.selectState(state);
        branchCreationPageObj.selectCity(city);
        branchCreationPageObj.clickReset();
    }

}
