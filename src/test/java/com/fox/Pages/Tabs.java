package com.fox.Pages;

import org.openqa.selenium.By;

public interface Tabs {
    By shows_tab = By.xpath("//div[contains(@class, 'Header_navLinks')]/a[text()='Shows']");
    By user_icon = By.id("path-1");


    public ShowsPage navigateShowsTab();
}
