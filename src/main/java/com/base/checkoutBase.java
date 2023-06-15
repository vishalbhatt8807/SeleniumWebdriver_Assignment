package com.base;

import com.pageObjects.cartPO;
import com.pageObjects.checkoutPO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class checkoutBase extends cartPO {
    private final Logger log = LogManager.getLogger(checkoutBase.class.getName());
    checkoutPO checkPO = null;

    public checkoutBase(WebDriver driver) {
        super(driver);
        checkPO = new checkoutPO(driver);
    }

    public void performCheckoutButtonAndValidateCurrentUrl(String expectedVal){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        checkPO.clickOnCheckoutBtn();
        log.info("Click on Checkout button");
        Assert.assertEquals(checkPO.getCurrentUrl(),expectedVal);
    }

    public void performContinueButtonAndValidateCurrentUrl(String expectedVal){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        checkPO.clickContinueBtn();
        log.info("Click on Continue button");
        Assert.assertEquals(checkPO.getCurrentUrl(),expectedVal);
    }

    public void performContinueButtonAndValidateErrorMessage(String expectedVal){
        checkPO.clickContinueBtn();
        log.info("Click on Continue Button");
        String getError = checkPO.getErrorMessage();
        Assert.assertEquals(getError,expectedVal);
        log.info("Validate Error Message :"+expectedVal);
    }

    public void setFirstName(String name){
        checkPO.setFirstnameTextBox(name);
        log.info("Enter First Name in Text box:"+ name);
    }

    public void setLastName(String name){
        checkPO.setLastnameTextBox(name);
        log.info("Enter First Name in Text box:"+ name);
    }


    public void setPostal(String name){
        checkPO.setPostalcodeBtn(name);
        log.info("Enter First Name in Text box:"+ name);
    }
    public float getTotalPriceOfSelectedProduct(){
        float selectedItemPrice = checkPO.getTotalInventoryProductPrice();
        checkPO.clickOnCheckoutBtn();
        return selectedItemPrice;
    }
    public void validateTotalPriceFromProductPageAndSummaryPage(float selectedItemPrice, float getTotalPriceVal){
        Assert.assertEquals(selectedItemPrice,getTotalPriceVal);

        log.info("Expected Value: "+selectedItemPrice);

        log.info("Actual Value: "+getTotalPriceVal);

        log.info("Validate total price from Cart Page and Step-two page.");

    }
    public float getTotalPriceValueOnSummaryPage(){
       return checkPO.getSummary_Total();
    }
    public void clickOnContinueBtn(){
        checkPO.clickContinueBtn();
        log.info("Click on Continue Button");

    }
    public void clickOnFinishBtnAndValidateSuccessMessage(String expectedVal){
        checkPO.clickFinishBtn();
        log.info("Click on Finish Button");
        String gettingMessage = checkPO.getSuccessMessage();
        Assert.assertEquals(gettingMessage,"Thank you for your order!");
        log.info("Validate  Greeting message after successfully submit order.");
    }
    public void performCancelButtonAndValidateCurrentUrl(String expectedVal){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        checkPO.setClickCancel();
        log.info("Click on Cancel button");
        Assert.assertEquals(checkPO.getCurrentUrl(),expectedVal);
    }

    public void fillTheDetailsOnStepOnePage(String firstName, String Lastname, String postal){

        checkPO.setFirstnameTextBox(firstName);

        log.info("Enter First Name in Text box: "+firstName);

        checkPO.setLastnameTextBox(Lastname);

        log.info("Enter Last Name in Text box: "+Lastname);

        checkPO.setPostalcodeBtn(postal);

        log.info("Enter Postal Code in Text box: "+postal);

    }
}
