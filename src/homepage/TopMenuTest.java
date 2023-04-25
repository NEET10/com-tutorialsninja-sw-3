package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        clickOnElement(By.linkText(menu));
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.linkText("Desktops"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Desktops')]"),"Desktops");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
       mouseHoverToElementAndClick(By.linkText("Laptops & Notebooks"));
       //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
       //2.3 Verify the text ‘Laptops & Notebooks’
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"),"Laptops & Notebooks");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElementAndClick(By.linkText("Components"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
        //3.3 Verify the text ‘Components’
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Components')]"),"Components");


    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
