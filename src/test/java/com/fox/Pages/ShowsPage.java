package com.fox.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShowsPage extends BasePage {
    By showElements = By.xpath("//div[contains(@class, 'Tile_info')]");
    By pagefooter = By.xpath("(//div[contains(@class, 'Footer_listsContainer')])[2]");

    public ShowsPage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getAllShows(){
        sleepSeconds(2);
        scrollToPageFooter();
        List<WebElement> all = driver.findElements(showElements);
        return all;
    }

    public List<WebElement> getLastShows(int howmany){
        List<WebElement> all = getAllShows();
        if(all.size() > howmany){
            return all.subList(all.size()-howmany, all.size());
        }else {
            return null;
        }
    }
    public ArrayList<String> getShowTitles(List<WebElement> shows){
        ArrayList<String> titles = new ArrayList<String>();
        for(WebElement show : shows){
           titles.add(show.getText());
        }
        return titles;
    }

    private void scrollToPageFooter(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(pagefooter);
        js.executeScript("arguments[0].scrollIntoView();", element );
        sleepSeconds(2);
    }
}
