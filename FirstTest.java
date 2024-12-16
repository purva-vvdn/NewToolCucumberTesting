package com.hyr.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class FirstTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TestGoogle() {
        try {
            driver.get("https://www.google.co.in/");
            System.out.println("Navigated to Google");

            // Explicit wait for the search bar
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='APjFqb']")));
            searchBox.sendKeys("HYR Tutorials", Keys.ENTER);

            // Log the title
            wait.until(ExpectedConditions.titleContains("HYR Tutorials"));
            System.out.println("Page title is: " + driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestYouTube() {
        try {
            driver.get("https://www.youtube.com/");
            System.out.println("Navigated to YouTube");

            // Explicit wait for the search bar
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
            searchBox.sendKeys("HYR Tutorials", Keys.ENTER);

            // Log the title
            wait.until(ExpectedConditions.titleContains("YouTube"));
            System.out.println("Page title is: " + driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}
