package com.cases;

import com.base.homeBase;
import com.base.loginBase;
import com.pageObjects.homePO;
import com.pageObjects.loginPO;
import com.utils.BrowserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.utils.BrowserFactory;

import java.time.Duration;

public class LoginTest  {
    public WebDriver driver;
    private final Logger log = LogManager.getLogger(LoginTest.class.getName());

    @BeforeTest
    public void setUp(){
       driver= BrowserFactory.selectBrowser(BrowserType.CHROME);
        log.info("Driver is initialized.");
        driver.get("https://www.saucedemo.com");
        log.info("Url is opened in browser :"+ BrowserType.CHROME);
    }
    @Test
    public void TC_01_login_Test(){
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        lBase.performLoginOperation("standard_user","secret_sauce");
        hBase.validateHomeTitle("Swag Labs");
        hBase.performLogout();
    }

    @Test
    public void TC_02_login_Test(){
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lBase.performLoginOperation("standard_user","12333434");
        hBase.validateHomeTitle("Swag Labs");
        lBase.validateErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Test()
    public void TC_03_login_Test(){
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lBase.performLoginOperation("","");
        hBase.validateHomeTitle("Swag Labs");
        lBase.validateErrorMessage("Epic sadface: Username is required");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        log.info("Driver is closed");
    }
}
