package stepDefinition;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;

import Project.Adactinmvn.BaseMethodAdactin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdactinLoginSD extends BaseMethodAdactin {
	@Given("User Open the browser")
	public void user_open_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		browser("edge");
	}

	@Given("User load the url")
	public void user_load_the_url() {
		driver.get("http://adactinhotelapp.com/");
	}

	@When("User enter the userName")
	public void user_enter_the_user_name() throws IOException {
		Row row = getSheet("credential").getRow(0);
		String cell1 = row.getCell(0).toString();
		userName(cell1);
	}

	@When("User enter the password")
	public void user_enter_the_password() throws IOException {
		Row row = getSheet("credential").getRow(0);
		String cell2 = row.getCell(1).toString();
		passWord(cell2);
	}

	@When("user click on login")
	public void user_click_on_login() {
		login();
	}
	@When("User enter the userName {string}")
	public void user_enter_the_user_name(String string) {
	    userName(string);
	}

	@When("User enter the password {string}")
	public void user_enter_the_password(String string) {
	   passWord(string);
	}

	@Then("Login is success")
	public void login_is_success() {
		System.out.println("Login is Success");
	}

	@Then("User close the browser")
	public void user_close_the_browser() {
		closeBrowser();
	}


@Given("User Open the firefox browser")
public void user_open_the_firefox_browser() {
    browser("firefox");
}




}
