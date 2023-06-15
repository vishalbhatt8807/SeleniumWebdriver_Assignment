package com.cases;

import com.base.cartBase;
import com.base.checkoutBase;
import com.base.homeBase;
import com.base.loginBase;
import com.pageObjects.cartPO;
import com.pageObjects.checkoutPO;
import com.pageObjects.homePO;
import com.pageObjects.loginPO;
import com.utils.BrowserFactory;
import com.utils.BrowserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckOutTest {

    WebDriver driver;
    private Logger log = LogManager.getLogger(CartTest.class.getName());

    loginPO lPO = null;
    homePO hPO = null;
    cartPO cPO = null;
    checkoutPO checkPO = null;

    @BeforeTest
    public void setUp(){
        driver= BrowserFactory.selectBrowser(BrowserType.CHROME);
        log.info("Driver is initialized.");
        driver.get("https://www.saucedemo.com");
        log.info("Url is opened in browser :"+ BrowserType.CHROME);
    }

    @Test
    public void TC_09_Checkout_Test(){
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        cartBase cBase = new cartBase(driver);
        checkoutBase checkBase = new checkoutBase(driver);
        lBase.performLoginOperation("standard_user","secret_sauce");
        hBase.validateHomeTitle("Swag Labs");
        String count = cBase.clickOnAddToCartBtnAndReturnProductCountNumFromCartIcon(2);
        cBase.validateCartIconValue(count,"2");
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(2);
        checkBase.performCheckoutButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-one.html");
        checkBase.fillTheDetailsOnStepOnePage("vishal","bhatt","343421");
        checkBase.performContinueButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-two.html");
        checkBase.clickOnFinishBtnAndValidateSuccessMessage("Thank you for your order!");
        hBase.performLogout();
    }

    @Test
    public void TC_10_Checkout_Test() {
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        cartBase cBase = new cartBase(driver);
        checkoutBase checkBase = new checkoutBase(driver);
        lBase.performLoginOperation("standard_user","secret_sauce");
        hBase.validateHomeTitle("Swag Labs");
        String count = cBase.clickOnAddToCartBtnAndReturnProductCountNumFromCartIcon(2);
        cBase.validateCartIconValue(count,"2");
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(2);
        checkBase.performCheckoutButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-one.html");
        checkBase.performCancelButtonAndValidateCurrentUrl("https://www.saucedemo.com/cart.html");
        cBase.removeSingleProductFromCartAndValidateProductCount(1);
        checkBase.performCheckoutButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-one.html");
        checkBase.fillTheDetailsOnStepOnePage("vishal","bhatt","343421");
        checkBase.performContinueButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-two.html");
        checkBase.clickOnFinishBtnAndValidateSuccessMessage("Thank you for your order!");
        hBase.performLogout();
    }


    @Test
    public void TC_11_Checkout_Test() {
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        cartBase cBase = new cartBase(driver);
        checkoutBase checkBase = new checkoutBase(driver);
        lBase.performLoginOperation("standard_user","secret_sauce");
        hBase.validateHomeTitle("Swag Labs");
        String count = cBase.clickOnAddToCartBtnAndReturnProductCountNumFromCartIcon(2);
        cBase.validateCartIconValue(count,"2");
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(2);
        checkBase.performCheckoutButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-one.html");
        checkBase.fillTheDetailsOnStepOnePage("vishal","Bhatt","232321");
        checkBase.performContinueButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-two.html");
        checkBase.performCancelButtonAndValidateCurrentUrl("https://www.saucedemo.com/inventory.html");
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(2);
        cBase.removeSingleProductFromCartAndValidateProductCount(1);
        checkBase.performCheckoutButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-one.html");
        checkBase.fillTheDetailsOnStepOnePage("vishal","Bhatt","232321");
        checkBase.performContinueButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-two.html");
        checkBase.clickOnFinishBtnAndValidateSuccessMessage("Thank you for your order!");
        hBase.performLogout();
    }

    @Test
    public void TC_12_Checkout_Test() {
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        cartBase cBase = new cartBase(driver);
        checkoutBase checkBase = new checkoutBase(driver);
        lBase.performLoginOperation("standard_user","secret_sauce");
        hBase.validateHomeTitle("Swag Labs");
        String count = cBase.clickOnAddToCartBtnAndReturnProductCountNumFromCartIcon(2);
        cBase.validateCartIconValue(count,"2");
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(2);
        checkBase.performCheckoutButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-one.html");
        checkBase.fillTheDetailsOnStepOnePage("vishal","Bhatt","232321");
        checkBase.performContinueButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-two.html");
        checkBase.performCancelButtonAndValidateCurrentUrl("https://www.saucedemo.com/inventory.html");
        checkBase.removeSingleProductFromCartList(1);
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(1) ;
        checkBase.performCheckoutButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-one.html");
        checkBase.fillTheDetailsOnStepOnePage("","","");
        checkBase.performContinueButtonAndValidateErrorMessage("Error: First Name is required");
        checkBase.setFirstName("Vishal");
        checkBase.performContinueButtonAndValidateErrorMessage("Error: Last Name is required");
        checkBase.setLastName("Bhatt");
        checkBase.performContinueButtonAndValidateErrorMessage("Error: Postal Code is required");
        checkBase.setPostal("1222323");
        checkBase.clickOnContinueBtn();
        hBase.performLogout();
    }
    @Test
    public void TC_13_Checkout_Test(){
        loginBase lBase = new loginBase(driver);
        homeBase hBase = new homeBase(driver);
        cartBase cBase = new cartBase(driver);
        checkoutBase checkBase = new checkoutBase(driver);
        lBase.performLoginOperation("standard_user","secret_sauce");
        hBase.validateHomeTitle("Swag Labs");
        String count = cBase.clickOnAddToCartBtnAndReturnProductCountNumFromCartIcon(3);
        cBase.validateCartIconValue(count,"4");
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(4);
        float selectedItemPrice = checkBase.getTotalPriceOfSelectedProduct();
        cBase.navigateToProductPageAndCountSelectedProductsAndValidateCount(4);
        checkBase.performCheckoutButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-one.html");
        checkBase.fillTheDetailsOnStepOnePage("vishal","Bhatt","232321");
        checkBase.performContinueButtonAndValidateCurrentUrl("https://www.saucedemo.com/checkout-step-two.html");
        float getTotalPriceVal = checkBase.getTotalPriceValueOnSummaryPage();
        checkBase.validateTotalPriceFromProductPageAndSummaryPage(selectedItemPrice,getTotalPriceVal);
        checkBase.clickOnFinishBtnAndValidateSuccessMessage("Thank you for your order!");
        hBase.performLogout();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        log.info("Close the driver");
    }
}
