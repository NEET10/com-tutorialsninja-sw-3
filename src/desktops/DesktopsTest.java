package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBeticalOrder(){
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.linkText("Desktops"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.linkText("Show AllDesktops"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
       verifyExpectedAndActual(By.xpath("//option[contains(text(),'Model (Z - A)')]"), "Model (Z - A)");
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.linkText("Desktops"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.linkText("Show AllDesktops"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"), "https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=ASC");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.linkText("HP LP3065"));
        //2.5 Verify the Text "HP LP3065"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'HP LP3065')]"), "HP LP3065");
        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";
        String mothYear;
        Thread.sleep(2000);
        //open the date picker
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        while (true) {
            String monthYear = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
            // Nov 2022
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }
        }
        //Select Date
        List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
        //2.7.Enter Qty "1” using Select class.
        clearText(By.xpath("//input[@id='input-quantity']"));
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(2000);
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
       verifyExpectedAndActual(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have added HP LP3065 to your shopping cart!\n" +
               "×");
       //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("shopping cart"));
        Thread.sleep(2000);
        //2.11 Verify the text "Shopping Cart  (1.00kg)"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Shopping Cart')]"),"Shopping Cart  (1.00kg)");
       //2.12 Verify the Product name "HP LP3065"
        verifyExpectedAndActual(By.linkText("HP LP3065"),"HP LP3065");
        Thread.sleep(2000);
        //2.13 Verify the Delivery Date "2022-11-30"
       verifyExpectedAndActual(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"),"Delivery Date:2022-11-30");
        Thread.sleep(2000);
        //2.14 Verify the Model "Product21"
        verifyExpectedAndActual(By.xpath("//td[normalize-space()='Product 21']"),"Product 21");
        // 2.15 Verify the Total "$122.00"
       verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]"),"$122.00");
    }
    @After
        public void tearDown () {
           // closeBrowser();
        }

    }