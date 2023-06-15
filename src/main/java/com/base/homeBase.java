package com.base;

import com.pageObjects.homePO;
import com.pageObjects.loginPO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class homeBase extends homePO {
    private Logger log = LogManager.getLogger(homeBase.class.getName());
    loginPO lPO = null;
    homePO hPO = null;

    public homeBase(WebDriver driver) {
        super(driver);
        lPO = new loginPO(driver);
        hPO = new homePO(driver);
    }

    public void validateHomeTitle(String title){
        String getTitle = hPO.getHomePageTitle();
        Assert.assertEquals(getTitle,title);
        log.info("Validate User is Landed on Home Screen or via checking Home Page Title");
    }

    public void performLogout(){
        hPO.performLogout();
        log.info("Click on Logout functionality");
    }
}
