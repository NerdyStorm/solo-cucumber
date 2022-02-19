package com.techfios.stepDefinition;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.techfios.pages.CustomerPage;
import com.techfios.pages.LoginPage;
import com.techfios.utils.BrowserFactory;
import com.techfios.utils.DatabaseRequest;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends BrowserFactory{
    WebDriver driver;
    LoginPage loginPage;
    DatabaseRequest databaseRequest;
    ResultSet resultSet;
    CustomerPage customerPage;

    //CustomerInformation
    String name = "";
    String company = "";
    String country = "";



    @Before
    public void initialization(){
        driver = init();

        loginPage = new LoginPage(driver);
        customerPage = new CustomerPage(driver);


        databaseRequest = new DatabaseRequest();
        resultSet = databaseRequest.getData();
        try {
            country = resultSet.getString("country");
            name = resultSet.getString("full_name");
            company = resultSet.getString("company");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @When ("User navigates to \"([^\"]*)\"$")
    public void user_navigates_to(String website){
        driver.get(website);
    }
    @And ("^User enters valid \"([^\"]*)\" as \"([^\"]*)\"$")
    public void user_enters_valid(String field, String credential){
        if (field.equals("username")){
            loginPage.inputUsername(credential);
        }
        else if(field.equals("password")){
            loginPage.inputPassword(credential);
        }

    }
    @And ("^User clicks submit button$")
    public void user_clicks_submit_button(){
        loginPage.clickSubmit();
    }
    @Then ("^User should be redirected to the dashboard page$")
    public void user_should_be_redirected_to_the_dashboard_page(){

    }

    @When("^User clicks on \"([^\"]*)\" Button$")
    public void user_clicks_on_Button(String buttonText){
        // Write code here that turns the phrase above into concrete actions
        if (buttonText.equals("Customers")){
            customerPage.clickOnCustomers();
        }
        else if(buttonText.equals("Add Customer")){
            customerPage.clickOnAddCustomer();
        }
    }
    @Then("^User should be on the \"([^\"]*)\" page$")
    public void user_should_be_on_the_page(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        customerPage.waitForAddContactPage();
    
    }   
    @When ("^User automatically fills in data from DB$")
    public void user_sutomatically_fills_in_data_from_DB(){
        customerPage.fillInformation(name, "Techfios", "Bangladesh");
    }


}
