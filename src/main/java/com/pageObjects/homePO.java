package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class homePO {
    public WebDriver driver;

    public homePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }

    @FindBy(id="react-burger-menu-btn")
    private WebElement clickHumberger;

    @FindBy(id="logout_sidebar_link")
    private WebElement clickLogoutLink;

    public void performLogout(){
        clickHumberger.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        clickLogoutLink.click();
    }

}
