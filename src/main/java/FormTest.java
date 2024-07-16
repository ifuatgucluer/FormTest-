import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // WebDriver'ın yolu
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // Windows için
        // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // MacOS veya Linux için

        // ChromeDriver'ı başlat
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFormSubmission() {
        // Formun bulunduğu sayfayı aç
        driver.navigate().to("https://www.example.com/form");

        // Form alanlarını doldur
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement messageField = driver.findElement(By.id("message"));

        nameField.sendKeys("John Doe");
        emailField.sendKeys("john.doe@example.com");
        messageField.sendKeys("This is a test message.");

        // Formu gönder
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Başarı mesajını doğrula
        WebElement successMessage = driver.findElement(By.id("success"));
        assert successMessage.isDisplayed();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
