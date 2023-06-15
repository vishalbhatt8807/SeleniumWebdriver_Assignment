package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class checkoutPO {

    public WebDriver driver;
    float count =0;
    public checkoutPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "first-name")
    private WebElement firstnameTextBox;

    @FindBy(id = "last-name")
    private WebElement lastnameTextBox;

    @FindBy(id = "postal-code")
    private WebElement postalcodeBtn;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(css = "h2.complete-header")
            private WebElement successMessage;

    @FindBy(id = "cancel")
    private WebElement clickCancel;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    @FindAll
    (@FindBy(css = ".inventory_item_price"))
    private List<WebElement> inventoryTotalPrice;

    @FindBy(css = ".summary_subtotal_label")
    private WebElement summary_total;

    public float getSummary_Total(){
        String[] item1 = summary_total.getText().split(":");
        String t = item1[1].replaceAll("\\s","").substring(1);
        float totalPriceAmount = Float.parseFloat(t);

        return totalPriceAmount;
    }
    public float getTotalInventoryProductPrice(){
        for(WebElement item: inventoryTotalPrice){
            String t = item.getText().substring(1);
            float j = Float.parseFloat(t);
            count = count + j;
        }
        return count;
    }

    public String getErrorMessage(){
      return   errorMessage.getText();
    }
    public void setClickCancel(){
        clickCancel.click();
    }
    public void clickOnCheckoutBtn(){
         checkoutButton.click();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }


    public String getCurrentPageTitle(){
        return driver.getTitle();
    }

    public void setFirstnameTextBox(String fistname) {
        firstnameTextBox.sendKeys(fistname);
    }

    public void setLastnameTextBox(String lastname) {
        lastnameTextBox.sendKeys(lastname);
    }

    public void setPostalcodeBtn(String postal) {
        postalcodeBtn.sendKeys(postal);
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    public void clickFinishBtn() {
        finishBtn.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

}
