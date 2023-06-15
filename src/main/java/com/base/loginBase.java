package com.base;

import com.pageObjects.loginPO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class loginBase extends loginPO {
    private Logger log = LogManager.getLogger(loginBase.class.getName());
    loginPO lPO = null;

    public loginBase(WebDriver driver) {
        super(driver);
        lPO = new loginPO(driver);
    }

    public void validateErrorMessage(String err){
        log.info("User entered Invalid Credential - Check Error message");
        String getTitle = lPO.getErrorMessage();
        Assert.assertEquals(getTitle,err);

    }
    public void performLoginOperation(String user, String pass){
        log.info("User is on Login Page");

        lPO.setUsername(user);

        log.info("Entered Username: "+user);

        lPO.setPassword(pass);

        log.info("Entered Username: "+pass);

        lPO.clickLoggingBtn();

        log.info("Clicked Login Button");

    }
}
