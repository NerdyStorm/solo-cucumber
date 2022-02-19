package com.techfios.stepDefinition;

import com.techfios.pages.LoginPage;
import com.techfios.utils.BrowserFactory;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends BrowserFactory{
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void initialization(){
        driver = init();

        loginPage = new LoginPage(driver);

    }

    @When ("User navigates to \"([^\"]*)\"$")
    public void User_navigates_to(String website){
        driver.get(website);
    }
    @And ("^User enters valid \"([^\"]*)\" as \"([^\"]*)\"$")
    public void User_enters_valid(String field, String credential){
        if (field.equals("username")){
            loginPage.inputUsername(credential);
        }
        else if(field.equals("password")){
            loginPage.inputPassword(credential);
        }

    }
    @And ("^User clicks submit button$")
    public void User_clicks_submit_button(){
        loginPage.clickSubmit();
    }
    @Then ("^User should be redirected to the dashboard page$")
    public void t(){

    }

}
