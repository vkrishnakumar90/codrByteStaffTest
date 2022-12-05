package stepDefs;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import util.excelReader;

public class staffSteps {
	WebDriver driver;
	@Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
	 System.setProperty("webdriver.chrome.driver","C:\\\\selenium\\\\chromedriver_win32\\\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https://staging3-akes.nexquare.io/nexquare/");
	 }
	
	 @Then("^user enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password){
	 driver.findElement(By.name("username")).sendKeys(username);
	 driver.findElement(By.name("password")).sendKeys(password);
	 }
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() {
	 WebElement loginBtn =
	 driver.findElement(By.id("log-btn"));
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", loginBtn);
	 }
	
	
	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page(){
	 String title = driver.getTitle();
	 System.out.println("Home Page title ::"+ title);
	 assertEquals("Aga Khan Education Service", title);
	 driver.quit();
	 }
	 
	 @When("^user enters \"([^\"]*)\" and \"([^\"]*)\" from dataSheet$")
	 public void user_enters_and_from_testData(String sheetName, int rowNumber) throws Throwable {
		 excelReader reader = new excelReader();
			List<Map<String,String>> testData = 
					reader.getData("C:\\Users\\HP\\OneDrive\\Documents\\GitHub\\codrByteStaffTest1\\StaffManagmntSys\\java\\TestData\\testData.xlsx", sheetName);
			
			String userName = testData.get(rowNumber).get("userName");
			String password = testData.get(rowNumber).get("password");
			driver.findElement(By.name("username")).sendKeys(userName);
			 driver.findElement(By.name("password")).sendKeys(password);
			
	 }
	 
	 @Given("^user is on Home Page$")
	 public void user_is_on_Home_Page() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @Given("^user selects Staff Profile Management$")
	 public void user_selects_Staff_Profile_Management() throws Throwable {
		 WebDriverWait wait = new WebDriverWait(driver,10000);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id=\"hr\"]//span[@class='link-name-newui']")));
	     driver.findElement(By.xpath("//a[@id=\"hr\"]//span[@class='link-name-newui']")).click();
	 }

	 @Given("^user enters the staff details from staffData in (\\d+) sheet$")
	 public void user_enters_the_staff_details_from_staffData_in_sheet(int arg1) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 WebDriverWait wait = new WebDriverWait(driver,5000);
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("link_addStaff")));
	    
	    driver.findElement(By.id("link_addStaff")).click();
	 }

	 @Then("^user is added$")
	 public void user_is_added() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }
	 
	 @Given("^lands on the dashboard$")
	 public void lands_on_the_dashboard() throws Throwable {

			WebDriverWait wait = new WebDriverWait(driver,1000);
		 wait.until(ExpectedConditions.presenceOfElementLocated (By.className("app-title")));
		 String title = driver.getTitle();
		 System.out.println("Home Page title ::"+ title);
		 assertEquals("Diamond Jubilee High School, Mumbai (ICSE)", title);
	 }

	 @When("^edits the staff details from staffData in (\\d+) sheet$")
	 public void edits_the_staff_details_from_staffData_in_sheet(int arg1) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @Then("^user details are updated suuceesfully$")
	 public void user_details_are_updated_suuceesfully() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }
	

}
