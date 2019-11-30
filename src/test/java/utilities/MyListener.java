package utilities;
/*
 * Selenium provides WebDriverEventListener interface 
 * which we can use to generate automation logs
 * In Selenium there is no class which will implement this interface
 * we have to create a class which will implement this interface abstract methods
 * 
 */

import com.aventstack.extentreports.Status;
import com.banking.TestExecution;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class MyListener extends BrowserHelper implements WebDriverEventListener {

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		Reporter.log("alert accepted", true);
		test.log(Status.INFO, "alert accepted");
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		Reporter.log("alert dismissed", true);
		test.log(Status.INFO, "alert dismissed");
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		JavascriptExecutor js = (JavascriptExecutor)arg1;
		String text = js.executeScript("return arguments[0].value", arg0).toString();
		Reporter.log("element value changed to "+text, true);
		test.log(Status.INFO, "element value changed to "+text);
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		Reporter.log("clicked on element", true);
		test.log(Status.INFO, "clicked on element");
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		Reporter.log("element located successfully", true);
		test.log(Status.INFO, "element located successfully using "+arg0);
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		Reporter.log("browser navigated to "+arg1.getCurrentUrl()+" successfully", true);
//		test.log(Status.INFO, "");
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		Reporter.log("alert came with alert text as "+arg0.switchTo().alert().getText(), true);
		test.log(Status.INFO, "alert came with alert text as "+arg0.switchTo().alert().getText());
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		Reporter.log("changing element value",true);
		test.log(Status.INFO, "changing element value");


	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		Reporter.log("clicking on element", true);
		test.log(Status.INFO, "clicking on element");
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		Reporter.log("locating an element using "+arg0, true);
//		test.log(Status.INFO, "locating an element using "+arg0);
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		Reporter.log("browser is navigating to "+arg0, true);
//		test.log(Status.INFO, "browser is navigation to "+arg0);
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

}
