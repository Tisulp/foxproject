package com.fox.Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage implements Tabs{

    public HomePage(WebDriver driver){
        super(driver);

    }

    public AccountPage navigateToUserAccounts(){
        clickOn(user_icon);
        return new AccountPage(driver);
    }

    public ShowsPage navigateShowsTab(){
        clickOn(shows_tab);
        return new ShowsPage(driver);
    }



}
