package practice;

 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.findElementByXPath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div[2]/div/form/div[2]/button").click();
		Thread.sleep(5000);
		Actions builder =new Actions(driver);	
		WebElement target =driver.findElementByLinkText("STAYS");
		builder.moveToElement(target).perform();
		//builder.click(
		
		
		
		
		
		
		
		
		
		
		

	}

}
