import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.util.List;

public class Runner extends Setup {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    String userName = "Admin";
    String password = "admin123";

    @Test(priority = 1)
    public void Login(){
        driver.get(baseUrl);
        LoginPage page = new LoginPage(driver);
        page.Dologin(userName,password);
    }

    @Test(priority = 2)
    public void CreateUser() throws InterruptedException{
        driver.get(baseUrl);
        PMI page = new PMI(driver);
        page.CreateUser();

        String actualResult = driver.findElements(By.className("oxd-text")).get(12).getText();
        String expectedResult = "Irfanul Emon";

        Assert.assertEquals(actualResult,expectedResult);
    }
}
