package org.example.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // ChromeDriver yolunu sistem özelliklerine ekleyin
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testSearch() {
        // Arama motoru sayfasına git
        driver.get("https://www.google.com");

        // Arama kutusunu bul ve arama terimini gir
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");

        // Arama butonuna tıkla
        searchBox.submit();

        // Sonuçları bekle ve kontrol et
        driver.findElement(By.id("search")).isDisplayed();
        List<WebElement> results = driver.findElements(By.cssSelector("div.g"));

        // Sonuçların 0'dan fazla olduğunu doğrula
        Assert.assertTrue(results.size() > 0, "Arama sonuçları bulunamadı!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
