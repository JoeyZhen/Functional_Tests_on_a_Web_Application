import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * This program allow the browser run automatically and find out the information 
 * <p>
 * Name: Joey Zhen
 **/
public class Facebook {

	public WebDriver webDriver; 		
	@BeforeTest
	public void setup()
	{
		webDriver = new ChromeDriver();
        webDriver.get("https://www.facebook.com/");
	}
	@Test(priority=1)
    public void findcolor() {     
	
		WebElement g = webDriver.findElement(By.xpath("//*[text()='Log In']"));	
    	String d = g.getCssValue("background-color").toString();

        	String c= "rgba(24, 119, 242, 1)";
        	Assert.assertEquals(c,d);           	
    }
	
	@Test(priority=2)
    public void click()
    {   	
    	
        webDriver.findElement(By.linkText("Forgot Password?")).click();     
    }
	
	@Test(priority=3)
    public void white()
    {
		WebElement x = webDriver.findElement(By.xpath("//*[text()='Email or Phone']"));
		String w = x.getCssValue("color").toString();
		
		String compare = "rgba(255, 255, 255, 1)";
		Assert.assertEquals(compare,w); 		
    }
	
	@Test(priority=4)
	public void buttonenabled()
	{
		WebElement button = webDriver.findElement(By.xpath("//*[@id=\"loginbutton\"]"));
		boolean r = Boolean.valueOf(true);		
		Assert.assertEquals(r , button.isEnabled()); 
		
	}
	
	@Test(priority=5)
	public void vertifyURL()
	{
		String url = webDriver.getCurrentUrl();
		boolean isWordPresent = url.contains("facebook");
		boolean t = Boolean.valueOf(true);
		Assert.assertEquals(isWordPresent , t); 		
	}
	
	@Test(priority=6)
	public void forgetaccount()
	{
		webDriver.findElement(By.linkText("Forgot account?")).click(); 
		webDriver.findElement(By.cssSelector("input[id='identify_email']")).sendKeys("99999");
		webDriver.findElement(By.xpath("//*[@id=\"did_submit\"]")).click();
				
	}
	
	@Test(priority=7)
	public void vertifytitle()
	{
		String title = webDriver.getTitle();
		Assert.assertEquals(title , "Forgot Password | Can't Log In | Facebook"); 		
	}
	
	@Test(priority=8)
	public void vertifytext()
	{
		WebElement text = webDriver.findElement(By.xpath("//*[@class=\"uiHeaderTitle\"]"));
		String find = text.getText();
		String t = "Find Your Account";
		Assert.assertEquals(find , t); 		
	}
	
	@Test(priority=9)
	public void alert() throws InterruptedException
	{
		Thread.sleep(1000);
		String result = webDriver.findElement(By.xpath("//*[contains(text(), 'No Search Results')]")).getText();
		String noresult = webDriver.findElement(By.xpath("//*[contains(text(), 'Your search did not return any results.  Please try again with other information.')]")).getText();
		Assert.assertEquals(result+" "+noresult , "No Search Results Your search did not return any results. Please try again with other information."); 	
		
	}
	@AfterTest
    public void terminateBrowser(){
        webDriver.quit();
    }
}
