package script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javafx.scene.text.Text;

public class SearchTestClass {

	static String URL="https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_csharp_search/862b0faa506b8487c25a3384cfde8af4/static/attachments/reference_page.html";
	static WebDriver driver=null;

	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		
	}
	@Before
	public void Openapp()
	{
		driver=new ChromeDriver();
		driver.get(URL);
	}
	
	@After
	public void closeApp()
	{
		driver.quit();
	}

	@Test
	
	public void test_MainScreen()
	{
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).sendKeys("ABC");
		WebElement SearcHResult = driver.findElement(By.xpath("//div[@id='search-form']/div//div[text()='Provide some query']"));
		String typetext = driver.findElement(By.xpath("//div[@id='search-form']/div/input")).getAttribute("type");
			
			if(typetext.equals("text")) {
				
				System.out.println("Text fields are validated");
				}else 
				{
					
					System.out.println("Text fields validations are failed...!");					
				
			}
			driver.findElement(By.xpath("//div[@id='search-form']/div/input")).sendKeys("ABC");
			
			WebElement searchbutton = driver.findElement(By.xpath("//div[@id='search-form']/div/button"));
			if(searchbutton.isDisplayed()) {
				
				System.out.println("Search button is dispalyed..!");
			}
			else {
				
				System.out.println("Search button is NOT dispalyed..!");
			}
			searchbutton.click();
	}
	@Test
	public void test_Emptyscreen()
	{
		
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).clear();
	driver.findElement(By.xpath("//div[@id='search-form']/div/button")).click();
	
	WebElement SearcHResult = driver.findElement(By.xpath("//div[@id='search-form']/div//div[text()='Provide some query']"));
		
		String str = SearcHResult.getText();
		
		if(str.equals("Provide some query")) {
			
			System.out.println("Enter a valid query in the text field...!");
			
		}
		else {
			System.out.println("Valid query in PRESENT in the text field...!");
		}
	}
	
	@Test
	public void test_Searchisland()
	{
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).sendKeys("isla");
		driver.findElement(By.xpath("//div[@id='search-form']/div/button")).click();
	List<WebElement> Searchresult	= driver.findElements(By.xpath("//div[@id='search-form']/div/ul[@id='search-results']"));
	int size= Searchresult.size();
	System.out.println(size);
	for(WebElement we : Searchresult)
	{
		String name= we.getText();
		System.out.println(we);
	}
	
	for(int i=1;i<=size;i++)
	{
	List<WebElement> result=	driver.findElements(By.xpath("//div[@id='search-form']/div/ul[@id='search-results']/li[i]"));
	for(WebElement we : result)
	{
		String text= we.getText();
		System.out.println(text);
	
	if (text.contains("Isla")) 
	{
		
		System.out.println("Search successfull");
		}
	
	else {
		System.out.println("Search not successful");
		}
	}	
}
	}
	
	@Test
	public void test_Feedback()
	{
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).clear();
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).sendKeys("castle");
		driver.findElement(By.xpath("//div[@id='search-form']/div/button")).click();
		WebElement SearcHResult = driver.findElement(By.xpath("	//div/div[2]/ul/div[text()='No results']"));
String str = SearcHResult.getText();
		
		if(str.equals("No results")) {
			
			System.out.println("No results displayed for Castle");
			
		}
		else {
			System.out.println("result diplayed for castle search");
		}
	}
	@Test
	public void test_PortRoyl()
	{
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).clear();
		driver.findElement(By.xpath("//div[@id='search-form']/div/input")).sendKeys("Port Royal");
		driver.findElement(By.xpath("//div[@id='search-form']/div/button")).click();
		
		List<WebElement> Searchresult	= driver.findElements(By.xpath("//div[@id='search-form']/div/ul[@id='search-results']"));
		int size= Searchresult.size();
		System.out.println(size);
		
		if(size==1) {
		
			for(WebElement we : Searchresult)
			{
				String name= we.getText();
				System.out.println(we);
			}
		}
		else
			System.out.println(" Search  size is more than 1");
		}
}
