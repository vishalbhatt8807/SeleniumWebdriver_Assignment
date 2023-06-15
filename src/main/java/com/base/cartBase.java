package com.base;

import com.pageObjects.cartPO;
import com.pageObjects.loginPO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class cartBase extends cartPO {
    private final Logger log = LogManager.getLogger(cartBase.class.getName());
    cartPO cPO = null;

    public cartBase(WebDriver driver) {
        super(driver);
        cPO = new cartPO(driver);
    }

    public void performRemoveBtnToDeleteAllProducts(int expectedVal){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cPO.removeAllProductFromCartList();
        log.info("Remove all the Items from Cart Page ");
        Assert.assertEquals(cPO.countProductAfterRemovingProduct(),expectedVal);
        log.info("Validate All Product has been Removed or Not.");

    }
    public String clickOnAddToCartBtnAndReturnProductCountNumFromCartIcon(int prodCount){
        cPO.clickOnAddToCartBtn(prodCount);
        log.info("Select a Single Product using 'ADD to CART' button");
        String count = cPO.returnNumOnCartIcon();
        log.info("Get the Count display on Cart Icon");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       return count;
    }

    public void removeSingleProductFromCartAndValidateProductCount(int prodCount){
        cPO.removeSingleProductFromCartList(prodCount);
        log.info("remove the items from Cart section.");
        int prodCount1 = cPO.countSelectedProdOnCartPage();
        Assert.assertEquals(prodCount1,prodCount);
        log.info("Validated Selected Product count's on Cart's Page actual and expected values");
    }
    public void validateCartIconValue(String expectedCount , String actualCount){
        Assert.assertEquals(actualCount,expectedCount);
        log.info("Validated Selected Product count's on Cart Icon actual and expected values");
    }

    public void validateCurrentPageUrl(String expectedValue){
        Assert.assertEquals(cPO.getCurrentUrl(),expectedValue);
    }
    public void navigateToProductPageAndCountSelectedProductsAndValidateCount(int expectedValue){
        cPO.navigateToCartPage();
        log.info("Navigate to Cart Page.");
        int prodCount = cPO.countSelectedProdOnCartPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(prodCount,expectedValue);
        log.info("Validated Selected Product count's on Cart's Page actual and expected values");
    }

}
