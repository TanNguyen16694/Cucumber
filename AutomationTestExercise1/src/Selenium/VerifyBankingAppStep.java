package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyBankingAppStep {

	WebDriver driver;

	@Given("^A user login system successfully$")
	public void a_user_login_system_successfully() {
		System.setProperty("webdriver.chrome.driver", "D:\\ITS\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/index.php");
		driver.findElement(By.name("uid")).sendKeys("mngr198134");
		driver.findElement(By.name("password")).sendKeys("sEpUreh");
		driver.findElement(By.name("btnLogin")).click();
		WebElement id_number = driver.findElement(By.xpath("//td[text()=\"Manger Id : mngr198134\"]"));
		String validate = id_number.getText();
		if (validate.contains("Manger Id : mngr198134")) {
			System.out.println("A user login system successfully");
		} else {
			System.out.println("A user login system fail");
		}
	}

	@When("^User Click menu Create New Customer$")
	public void user_Click_menu_Create_New_Customer() {
		driver.findElement(By.xpath("//a[text()=\"New Customer\"]")).click();
		System.out.println("User Click menu Create New Customer");
	}

	@Then("^User is taken to Create New Customer Page$")
	public void user_is_taken_to_Create_New_Customer_Page() {
		WebElement lbl_NewCustomer = driver.findElement(By.xpath("//*[text()=\"Add New Customer\"]"));
		String validate = lbl_NewCustomer.getText();
		if (validate.contains("Add New Customer")) {
			System.out.println("User is taken to Create New Customer Page");
		} else {
			System.out.println("User is not taken to Create New Customer Page");
		}
	}

	@When("^User input all valid information of and click button create$")
	public void user_input_all_valid_information_of_and_click_button_create() {
		driver.findElement(By.name("name")).sendKeys("ABC");
		driver.findElement(By.name("rad1")).click();
		driver.findElement(By.name("dob")).sendKeys("10/06/1994");
		driver.findElement(By.name("addr")).sendKeys("49");
		driver.findElement(By.name("city")).sendKeys("Ho Chi Minh");
		driver.findElement(By.name("state")).sendKeys("Tan Binh");
		driver.findElement(By.name("pinno")).sendKeys("16061994");
		driver.findElement(By.name("telephoneno")).sendKeys("0769847942");
		driver.findElement(By.name("emailid")).sendKeys("123abc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("0123456789");
		driver.findElement(By.name("sub")).click();
		System.out.println("User input all valid information and click button create");
	}

	@Then("^New Customer be able to create successfully$")
	public void new_Customer_be_able_to_create_successfully() {
		WebElement lbl_NewCustomerRegistered = driver
				.findElement(By.xpath("//*[text()=\"Customer Registered Successfully!!!\"]"));
		String validate = lbl_NewCustomerRegistered.getText();
		if (validate.contains("Customer Registered Successfully!!!")) {
			System.out.println("New Customer be able to create successfully");
		} else {
			System.out.println("Email Address Already Exist !!");
		}
	}

	String Customer_Id = "";

	@When("^User click menu Create Account$")
	public void user_click_menu_Create_Account() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement customer_id = driver.findElement(By.xpath("//*[text()=\"Customer ID\"]/following-sibling::td"));
		Customer_Id = customer_id.getText();
		WebElement menu_Acconut = driver.findElement(By.xpath("//*[text()=\"New Account\"]"));
		menu_Acconut.click();
	}

	@Then("^User is taken to Create New Account Page$")
	public void user_is_taken_to_Create_New_Account_Page() {
		WebElement lbl_NewAccountForm = driver.findElement(By.xpath("//*[text()=\"Add new account form\"]"));
		String validate = lbl_NewAccountForm.getText();
		if (validate.contains("Add new account form")) {
			System.out.println("User is taken to Create New Account Page");
		} else {
			System.out.println("User is not taken to Create New Account Page");
		}
	}

	@When("^User input all valid information and click button create$")
	public void user_input_all_valid_information_and_click_button_create() {
		driver.findElement(By.name("cusid")).sendKeys(Customer_Id);
		driver.findElement(By.name("inideposit")).sendKeys("123456");
		driver.findElement(By.name("button2")).click();
	}

	String Account_ID = "";

	@Then("^New Account be able to crate successfully$")
	public void new_Account_be_able_to_crate_successfully() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement account_id = driver.findElement(By.xpath("//*[text()=\"Account ID\"]/following-sibling::td"));
		Account_ID = account_id.getText();
		WebElement lbl_NewAccountRegistered = driver
				.findElement(By.xpath("//*[text()=\"Account Generated Successfully!!!\"]"));
		String validate = lbl_NewAccountRegistered.getText();
		if (validate.contains("Customer Registered Successfully!!!")) {
			System.out.println("New Account be able to crate successfully");
		} else {
			System.out.println("New Account be able to crate fail !!");
		}

	}

	@When("^User click menu Deposit$")
	public void user_click_menu_Deposit() {
		WebElement menu_Deposit = driver.findElement(By.xpath("//*[text()=\"Deposit\"]"));
		menu_Deposit.click();
	}

	@Then("^User is taken to Create New Deposit Page$")
	public void user_is_taken_to_Create_New_Deposit_Page() {
		WebElement lbl_NewDepositForm = driver.findElement(By.xpath("//*[text()=\"Amount Deposit Form\"]"));
		String validate = lbl_NewDepositForm.getText();
		if (validate.contains("Amount Deposit Form")) {
			System.out.println("User is taken to Create New Deposit Page");
		} else {
			System.out.println("User is not taken to Create New Deposit Page");
		}
	}

	@When("^User input all valid information of deposit and click button create$")
	public void user_input_all_valid_information_of_deposit_and_click_button_create() {
		driver.findElement(By.name("accountno")).sendKeys(Account_ID);
		driver.findElement(By.name("ammount")).sendKeys("123456");
		driver.findElement(By.name("desc")).sendKeys("abc");
		driver.findElement(By.name("AccSubmit")).click();
	}

	@Then("^New Deposit be able to crate successfully$")
	public void new_Deposit_be_able_to_crate_successfully() {
		WebElement lbl_NewDepositRegistered = driver
				.findElement(By.xpath("//*[text()=\"Transaction details of Deposit for Account 61156\"]"));
		String validate = lbl_NewDepositRegistered.getText();
		if (validate.contains("Transaction details of Deposit!")) {
			System.out.println("New Deposit be able to crate successfully");
		} else {
			System.out.println("New Deposit be able to create fail !!");
		}
	}
}