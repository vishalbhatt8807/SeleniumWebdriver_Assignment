package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class cartPO {
    public WebDriver driver;

    public cartPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindAll(@FindBy(xpath = "//button[contains(text(),'Add to cart')]"))
    private List<WebElement> addToCartBtn;

    public void clickOnAddToCartBtn(int index){
        for(int i=0;i<= index-1;i++) {
            addToCartBtn.get(i).click();
        }
    }

    @FindBy(css = ".shopping_cart_badge")
    private WebElement numOnCartIcon;

    public String returnNumOnCartIcon(){
        return numOnCartIcon.getText();
    }

    public void navigateToCartPage(){
        numOnCartIcon.click();
    }

    @FindAll(@FindBy(css = ".cart_item"))
    private List<WebElement>SelectedProductOnCartPage;

    public int countSelectedProdOnCartPage(){
      return SelectedProductOnCartPage.size();
    }

    @FindAll(@FindBy(xpath = "//button[contains(text(),'Remove')]"))
    private List<WebElement> listOfRemoveBtn;

    public void removeAllProductFromCartList(){
        for(WebElement item: listOfRemoveBtn){
            item.click();
        }
    }

    public void removeSingleProductFromCartList(int index){
        for(int i=0;i<=index-1;i++){
            listOfRemoveBtn.get(i).click();
        }
    }

    @FindBy(id = "continue-shopping")
    private WebElement continueShopping;

    public void clickOnContinueButton(){
        continueShopping.click();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }


    public String getCurrentPageTitle(){
        return driver.getTitle();
    }

    public int countProductAfterRemovingProduct(){
        return listOfRemoveBtn.size();
    }

}
