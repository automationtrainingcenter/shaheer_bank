package com.banking;

import org.testng.annotations.DataProvider;
import utilities.ExcelHelper;

public class DataProvideUtility {

    private ExcelHelper excel;

    @DataProvider(name = "roleData")
    public Object[][] getRoleData(){
        excel = new ExcelHelper();
        return excel.getSheetData("resources", "testdata.xls", "roleData");
    }

    @DataProvider(name="branchData")
    public Object[][] getBranchData(){
        excel = new ExcelHelper();
        return excel.getSheetData("resources", "testdata.xls", "branchData");
    }


}
