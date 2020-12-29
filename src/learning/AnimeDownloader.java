package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class AnimeDownloader {

	public static void main(String[] args) throws InterruptedException {
		
		int i = 1;
		long time = 10000;
		System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension=C:/Users/USER/AppData/Local/Google/Chrome/User Data/Default/Extensions/gpbfjnhlnemfnhajnmkjicfmbagfbejm/1.1.10_0");
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(capabilities);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
        	
            driver.get("https://www.anbient.com/");
            driver.findElement(By.id("edit-search-api-views-fulltext")).sendKeys("hajime no ippo" + Keys.ENTER);
            
            wait.until(presenceOfElementLocated(By.xpath("//a[text()='Hajime no Ippo']")));
            driver.findElement(By.xpath("//a[text()='Hajime no Ippo']")).click();
            
            while(i < 77) {
            	
            	Thread.sleep(time);
            	
            	if(i == 6) {
            		
		            wait.until(presenceOfElementLocated(By.xpath("//a[text()='06-07']")));
		            driver.findElement(By.xpath("//a[text()='06-07']")).click();
		            
		            wait.until(presenceOfElementLocated(By.className("download")));
		            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		            
		            driver.switchTo().window(tabs2.get(1));
		            
		            WebElement element = driver.findElement(By.className("download"));
		            Actions actions = new Actions(driver);
		            actions.moveToElement(element).click().perform();
		            
		            driver.close();
		            driver.switchTo().window(tabs2.get(0));
		            
		            i = i + 2;
		            
		            continue;
            	}
            	
            	if(i < 10) {
            		
		            wait.until(presenceOfElementLocated(By.xpath("//a[text()='0"+i+"']")));
		            driver.findElement(By.xpath("//a[text()='0"+i+"']")).click();
		            
		            wait.until(presenceOfElementLocated(By.className("download")));
		            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		            
		            driver.switchTo().window(tabs2.get(1));
		            
		            WebElement element = driver.findElement(By.className("download"));
		            Actions actions = new Actions(driver);
		            actions.moveToElement(element).click().perform();
		            
		            driver.close();
		            driver.switchTo().window(tabs2.get(0));
            	}
            	
            	if(i >= 10) {
            		
		            wait.until(presenceOfElementLocated(By.xpath("//a[text()='"+i+"']")));
		            driver.findElement(By.xpath("//a[text()='"+i+"']")).click();
		            
		            wait.until(presenceOfElementLocated(By.className("download")));
		            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		            
		            driver.switchTo().window(tabs2.get(1));
		            
		            WebElement element = driver.findElement(By.className("download"));
		            Actions actions = new Actions(driver);
		            actions.moveToElement(element).click().perform();
		            
		            driver.close();
		            driver.switchTo().window(tabs2.get(0));
            	}
            	
	            i = i + 1;
            }
        } finally {
            
        }

	}

}
