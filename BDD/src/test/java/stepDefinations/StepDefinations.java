package stepDefinations;


import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
public class StepDefinations {

    @Given("^User is on Net banking Landing page$")
    public void user_is_on_net_banking_landing_page() {
       //one
    	System.out.println("One");
    }

    @When("^User logs into application with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_logs_into_application_with_username_and_password(String arg1 , String arg2)  {
      //two
    	System.out.println("Two "+ arg1 + " " + arg2);
    }

    @Then("^Home page is loaded$")
    public void home_page_is_loaded()  {
        System.out.println("Three");
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed()  {
        System.out.println("Four");
    }

}