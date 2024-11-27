package selenium;
import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.interactions.Actions;

		public class DragAndDropAutomation {
		    public static void main(String[] args) {
		      
		       
		        // Initialize WebDriver
		        WebDriver driver = new ChromeDriver();

		        try {
		            // Maximize the browser window
		            driver.manage().window().maximize();
		          // Navigate to the jQuery UI draggable demo page
		            driver.get("https://jqueryui.com/droppable/");

		            // Switch to the iframe containing the draggable and droppable elements
		            WebElement iframe = driver.findElement(By.className("demo-frame"));
		            driver.switchTo().frame(iframe);

		            // Locate the source element (drag me to my target)
		            WebElement sourceElement = driver.findElement(By.id("draggable"));

		            // Locate the target element (drop here)
		            WebElement targetElement = driver.findElement(By.id("droppable"));

		            // Perform the drag-and-drop operation
		            Actions actions = new Actions(driver);
		            actions.dragAndDrop(sourceElement, targetElement).perform();

		            // Verify the drag-and-drop operation
		            // Check if the target element's text has changed to "Dropped!"
		            String targetText = targetElement.getText();
		            if (targetText.equals("Dropped!")) {
		                System.out.println("Drag and Drop was successful. Target text is: " + targetText);
		            } else {
		                System.out.println("Drag and Drop failed. Target text is: " + targetText);
		            }

		            // Check the CSS color property of the target element
		            String targetCssColor = targetElement.getCssValue("background-color");
		            System.out.println("Target element background color after drop: " + targetCssColor);
		            Thread.sleep(3000);

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // Close the browser
		            driver.quit();
		        }
		    }
		


	}


