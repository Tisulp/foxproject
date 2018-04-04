package Testscripts;

import com.fox.Pages.ShowsPage;
import com.fox.excel.ExcelWriter;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ShowTabsTest extends BaseTest {


    @Test
    public void validateShowTabs(){
        ShowsPage shows = homePage.navigateShowsTab();
        ArrayList<String> titles = shows.getShowTitles(shows.getLastShows(4));
        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.WriteToExcelSheet(titles);



    }
}


