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

	@When("User enter the userName password login button")
	public void user_enter_the_user_name() throws IOException {
		Row row = getSheet("credential").getRow(0);
		String cell1 = row.getCell(0).toString();
		String cell2 = row.getCell(1).toString();
		login(cell1, cell2);
	}

	@Then("Login is success")
	public void login_is_success() {
	  System.out.println("Login is Success");
	}

	@Then("User close the browser")
	public void user_close_the_browser() {
	 closeBrowser();
	}

	}


