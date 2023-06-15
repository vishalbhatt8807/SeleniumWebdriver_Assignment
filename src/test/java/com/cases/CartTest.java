package com.cases;

import com.base.cartBase;
import com.base.homeBase;
import com.base.loginBase;
import com.pageObjects.cartPO;
import com.pageObjects.homePO;
import com.pageObjects.loginPO;
import com.utils.BrowserFactory;
import com.utils.BrowserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest {

    WebDriver driver;

    private final Logger log = LogManager.getLogger(CartTest.class.getName());

    @BeforeTest
    public void setUp(){
        driver= BrowserFactory.selectBrowser(BrowserType.CHROME);
        log.info("Driver is initialized.");
        driver.get("https://www.saucedemo.com");
        log.info("Url is opened in browser :"+ BrowserType.CHROME);

    }
    @Test
    public void TC_04_Cart_Test(){
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        cartBase cBase = new cartBase(driver);
        lBase.performLoginOperation("standard_user","secret_sauce");
        hBase.validateHomeTitle("Swag Labs");
        String count = cBase.clickOnAddToCartBtnAndReturnProductCountNumFromCartIcon(1);
        cBase.validateCartIconValue("1",count);
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(1);
    }

    @Test
    public void TC_05_Cart_Test() {
        homeBase hBase = new homeBase(driver);
        cartBase cBase = new cartBase(driver);
        cBase.performRemoveBtnToDeleteAllProducts(0);
        hBase.performLogout();
    }

    @Test
    public void TC_06_Cart_Test(){
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        cartBase cBase = new cartBase(driver);
        lBase.performLoginOperation("standard_user","secret_sauce");
        hBase.validateHomeTitle("Swag Labs");
        String count = cBase.clickOnAddToCartBtnAndReturnProductCountNumFromCartIcon(2);
        cBase.validateCartIconValue(count,"2");
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(2);

    }
    @Test
    public void TC_07_Cart_Test() {
        homeBase hBase = new homeBase(driver);
        cartBase cBase = new cartBase(driver);
        cBase.performRemoveBtnToDeleteAllProducts(0);
        hBase.performLogout();
    }

    @Test
    public void TC_08_Cart_Test(){
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        cartBase cBase = new cartBase(driver);
        lBase.performLoginOperation("standard_user","secret_sauce");
        hBase.validateHomeTitle("Swag Labs");
        String count = cBase.clickOnAddToCartBtnAndReturnProductCountNumFromCartIcon(2);
        cBase.validateCartIconValue(count,"2");
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(2);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cBase.validateCurrentPageUrl("https://www.saucedemo.com/cart.html");
        hBase.validateHomeTitle("Swag Labs");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        log.info("Close the Driver");
    }
}
