package br.com.senac;

import static org.junit.Assert.assertTrue;

import java.io.IOException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * SeleniumTest
 */

public class SeleniumTest {

    private String testUrl;
    private WebDriver driver;

    @Before()
    public void prepare() {

        System.setProperty(
                "webdriver.chrome.driver",
                "webdriver/chromedriver.exe");

        testUrl = "https://rafaelcruz.azurewebsites.net";

       
        driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

       
        driver.get(testUrl);

    }

    @Test
    public void testTitle() throws IOException {

      


        assertTrue("The page title should be chagned as expected",
                (new WebDriverWait(driver, 5))
                        .until(new ExpectedCondition<Boolean>() {
                            public Boolean apply(WebDriver d) {
                                return d.getTitle().equals("Rafael Cruz");
                            }
                        })
        );

    }

    @Test
    public void testSearch() {
        WebElement searchText = driver.findElement(By.className("search-field"));
        searchText.sendKeys("oauth");

        WebElement searchBtn = driver.findElement(By.className("search-submit"));
        searchBtn.click();

        assertTrue("Search Result",
                (new WebDriverWait(driver, 5))
                        .until(new ExpectedCondition<Boolean>() {
                            public Boolean apply(WebDriver d) {
                                WebElement result = d.findElement(By.className("page-title"));
                                return result.getText().contains("OAUTH");      
                            }
                        })
        );      

    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}