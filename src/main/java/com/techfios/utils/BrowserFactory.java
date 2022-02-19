package com.techfios.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    WebDriver driver;
    String chromeDriverLocation = "src/drivers/chromedriver.exe";
    String chromeSystemProperty = "webdriver.chrome.driver";
    
    public WebDriver init(){
        
        System.setProperty(chromeSystemProperty, chromeDriverLocation);
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        return driver;

    }

}
