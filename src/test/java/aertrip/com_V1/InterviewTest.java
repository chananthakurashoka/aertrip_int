package aertrip.com_V1;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InterviewTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chandan\\eclipse-workspace\\aertrip.com_V1\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://aertrip.com/");
		
		
		
		WebElement hotels = driver.findElement(By.xpath("//div[@class='header']/div[2]/ul/li[3]"));
		hotels.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement location = driver.findElement(By.xpath("//jq-autocomplete[@id='autocomplete-tag']//input[@id='autocomplete-js']"));
		wait.until(ExpectedConditions.elementToBeClickable(location));
		location.clear();
		location.sendKeys("Delhi");
		wait.until(ExpectedConditions.elementToBeClickable(location));		
		List<WebElement> list = location.findElements(By.tagName("li"));
		for(WebElement x:list)
		{
			String locationlist = x.getText();
			if(locationlist.contains("Delhi"))
			{
				x.click();
				x.sendKeys(Keys.ARROW_DOWN.ENTER);
				break;
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(location));
		//location.sendKeys(Keys.ARROW_DOWN.ENTER);
		//as.moveToElement(location).sendKeys(Keys.ARROW_DOWN.ENTER).click().build().perform();
		
		Actions as = new Actions(driver);
		
		WebElement checkIn = driver.findElement(By.xpath("//input[@placeholder='Check-in']"));
		as.moveToElement(checkIn).click().build().perform();
		
		
		WebElement checkindate = driver.findElement(By.xpath("//td[@class='datepickerSunday']//span[contains(text(),'29')]"));
		as.moveToElement(checkindate).click().build().perform();
		
		
		WebElement nights = driver.findElement(By.xpath("//div[@class='hotel-calender']//span[contains(text(),'Night')]"));
		as.moveToElement(nights).click().build().perform();
		
		WebElement nightCount = driver.findElement(By.xpath("//ul[@class='ui-flightCountBox css-hotel-nights dropdown-js']//span[@class='plus']"));
		for(int i = 0; i<3; i++)
		{
			as.moveToElement(nightCount).click().build().perform();
		}
		
		WebElement rooms = driver.findElement(By.xpath("//div[@class='icon-left']//i//i[@class='icon icon_home']"));
		as.moveToElement(rooms).click().build().perform();
		
		WebElement room1adult = driver.findElement(By.xpath("//div[@class='roomsGuestBox css-rooms-add dropdown-js rooms-dd-normal-js']//div[2]//div[2]//i[2]"));
		as.moveToElement(room1adult).click().build().perform();
		
		WebElement room1child = driver.findElement(By.xpath("//div[@class='roomsGuestBox css-rooms-add dropdown-js rooms-dd-normal-js']//div[2]//div[3]//div[1]//i[1]"));
		as.moveToElement(room1child).click().build().perform();
		
		WebElement room1childAge = driver.findElement(By.xpath("//div[@class='roomsGuestBox css-rooms-add dropdown-js rooms-dd-normal-js']//div[2]//div[3]//div[2]//span[1]//input[1]"));
		room1childAge.clear();
		room1childAge.sendKeys("10");
		//Thread.sleep(6000);
		
		WebElement room2 = driver.findElement(By.xpath("//div[@class='css-addRooms addRooms addRooms-js']"));
		as.moveToElement(room2).click().build().perform();

		WebElement room2adult = driver.findElement(By.xpath("//div[@class='formBar formBarTop']//div[3]//div[2]//i[3]"));
		as.moveToElement(room2adult).click().build().perform();

		WebElement room2child = driver.findElement(By.xpath("//body//div[3]//div[3]//div[3]//i[1]"));
		as.moveToElement(room2child).click().build().perform();
		
		WebElement room2child1Age = driver.findElement(By.xpath("//body//div[3]//div[3]//div[2]//span[1]//input[1]"));
		//as.moveToElement(room2child1Age).sendKeys("10").build().perform();
		//room2child1Age.sendKeys("10");
		room2child1Age.clear();
		room2child1Age.sendKeys("10");
		//Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(room2child1Age));
		WebElement room2child2Age = driver.findElement(By.xpath("//body//div[3]//div[3]//div[4]//span[1]//input[1]"));
		//as.moveToElement(room2child2Age).sendKeys("12").build().perform();
		//room2child2Age.sendKeys("12");
		room2child2Age.clear();
		room2child2Age.sendKeys("12");
		Thread.sleep(6000);
		
		wait.until(ExpectedConditions.elementToBeClickable(room2child2Age));
		WebElement searchHotel = driver.findElement(By.xpath("//button[@id='searchHotelButton']"));
		as.moveToElement(searchHotel).click().build().perform();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement sort = driver.findElement(By.xpath("//div[@class='css-hotel-sorting css-sort-wrapper']//i[@class='icon icon_down-small-arrow']"));
		sort.click();
		
		WebElement lowPrice = driver.findElement(By.xpath("//li[contains(text(),'Price - Low to High')]"));
		//as.moveToElement(lowPrice).click().build().perform();
		lowPrice.click();
		
		
		
		WebElement near = driver.findElement(By.xpath("//*[@id='index-page']/body/view/view/view[2]/div[2]/view/div[1]/div[1]/div[3]/div/ul/li[3]/span"));
		Thread.sleep(5000);
		as.moveToElement(near).click().build().perform();
		
		WebElement price = driver.findElement(By.xpath("//*[@id='nearby-hotels-js']/div[2]/div/figcaption"));
		//as.moveToElement(price).click().build().perform();
		price.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement book = driver.findElement(By.xpath("//button[@class='button line scrollto-rates-js']"));
		book.click();
		
		WebElement finalbook = driver.findElement(By.xpath("//button[@class='button line bookingConfirmation-js']"));
		finalbook.click();
	}

}
