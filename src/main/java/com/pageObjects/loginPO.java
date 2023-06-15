package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPO {
    public WebDriver driver;

    public loginPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    private WebElement username;


    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement loggingBtn;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessageOnLoginPage;


    public void setUsername(String user) {
        username.sendKeys(user);
    }

    public String getErrorMessage() {
       return errorMessageOnLoginPage.getText();
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }


    public void clickLoggingBtn() {
        loggingBtn.click();
    }



}
