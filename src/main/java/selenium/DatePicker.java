package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
    public static void main(String[] args) {
        
      

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();
            // Navigate to the jQuery UI datepicker page
            driver.get("https://jqueryui.com/datepicker/");

            // Switch to the iframe containing the datepicker
            WebElement iframe = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(iframe);

            // Click the date picker input field to open the calendar
            WebElement dateInput = driver.findElement(By.id("datepicker"));
            dateInput.click();

            // Click the "Next" button to go to the next month
            WebElement nextButton = driver.findElement(By.className("ui-datepicker-next"));
            nextButton.click();

            // Select the date "22"
            WebElement dateToSelect = driver.findElement(By.xpath("//a[text()='22']"));
            dateToSelect.click();
            

            // Retrieve the selected date from the input field
            String selectedDate = dateInput.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);
             Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
