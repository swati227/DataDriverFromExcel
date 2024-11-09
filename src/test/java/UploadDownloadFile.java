import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UploadDownloadFile {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
        driver.manage().window().maximize();

//        Download
        driver.findElement(By.xpath("//button[@id='downloadButton']")).click();

//        Edit Excel

//        Upload
        WebElement uploadElement = driver.findElement(By.cssSelector("input[type='file']"));
        uploadElement.sendKeys("/Users/nikhilpatil/Downloads/download_1.xlsx");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement successToastElement = driver.findElement(By.cssSelector("div[class='Toastify__toast-body'] :nth-child(2)"));
        WebElement successToastElement = driver.findElement(By.cssSelector("div.Toastify__toast-body div:nth-child(2)"));
        wait.until(ExpectedConditions.visibilityOf(successToastElement));
        String toastText = successToastElement.getText();
        Assert.assertEquals(toastText, "Updated Excel Data Successfully.");
        wait.until(ExpectedConditions.invisibilityOf(successToastElement));

//        Wait for success message to show up and disappear
//        Verify that the updated data is displayed in the web table

        driver.close();

    }
}
