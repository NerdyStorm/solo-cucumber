package com.techfios.pages;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage {

    WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElement library
    @FindBy(how = How.XPATH, using = "//span[text()='Customers']")
    WebElement customersButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]")
    WebElement addCustomerButton;
    @FindBy(how = How.XPATH, using = "//h5[contains(text(), 'Add Contact')]")
    WebElement addContactText;

    @FindBy(how = How.XPATH, using = "//input[@name='account']")
    WebElement fullName;
    @FindBy(how = How.XPATH, using = "//select[@id='cid']//*")
    List<WebElement> companyList;
    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    WebElement randomEmail;
    @FindBy(how = How.XPATH, using = "//input[@id='phone']")
    WebElement randomPhone;
    @FindBy(how = How.XPATH, using = "//input[@id='address']")
    WebElement randomAddress;
    @FindBy(how = How.XPATH, using = "//input[@id='city']")
    WebElement randomCity;
    @FindBy(how = How.XPATH, using = "//input[@id='state']")
    WebElement randomState;
    @FindBy(how = How.XPATH, using = "//input[@id='zip']")
    WebElement randomZipCode;
    @FindBy(how = How.XPATH, using = "//select[@name='country']//*")
    List<WebElement> countryList;
    @FindBy(how = How.XPATH, using = "//button[@id='submit']")
    WebElement submit;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'List Customers')]")
    WebElement listCustomers;

    public void waitForDashboardPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Dashboard']")));
        System.out.println("Dashboard Loaded!");
    }

    public void clickOnCustomers() {
        customersButton.click();
    }

    public void clickOnAddCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Add Customer')]")));
        addCustomerButton.click();

    }

    public void waitForAddContactPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'Add Contact')]")));

        Assert.assertEquals("Not on Add Contact page!", addContactText.getText(), "Add Contact");

    }

    public void fillInformation(String name, String company, String country) {

        fullName.sendKeys(name + "_from_mysql_database" + (1000 + (new Random()).nextInt(10000)));
        findCompany(company).click();
        findCountry(country).click();
        submit.click();

    }

    public WebElement findCountry(String c) {
        WebElement k = null;

        for (WebElement e : countryList) {
            if (e.getText().equalsIgnoreCase(c)) {
                return e;
            }
        }
        return k;
    }

    public WebElement findCompany(String c) {
        WebElement k = null;

        for (WebElement e : companyList) {
            if (e.getText().equalsIgnoreCase(c)) {
                return e;
            }
        }
        return k;
    }

}
