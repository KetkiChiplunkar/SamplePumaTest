
package pumaSampleTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class PumaAppFeature {
	WebDriver driver = new FirefoxDriver();
	@Given("^Navigate to Puma website$")
	public void navigateToPage(){
		driver.get("https://in.puma.com/");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}
	
	@Given("^Navigate to MEN category$")
	public void navigateToMenCategory(){
		
		WebElement menCategory = driver.findElement(By.xpath("//ul/li/a[@data-subnav='men-subnav']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menCategory).build().perform();
	}
	
	@Given("^Click on Running Shoes$")
	public void clickOnRunningShoes(){
		//driver.findElement(By.linkText("Running")).click();
		if(driver.findElement(By.xpath("//li/p/a[contains(text(),'Shoes')]")).isDisplayed()){
		    WebDriverWait wait = new WebDriverWait(driver, 120);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/ul/li/a[@href='https://in.puma.com/men/shoes/running.html?dir=asc&order=position&in-stock=1']")));
			driver.findElement(By.xpath("//div/ul/li/a[@href='https://in.puma.com/men/shoes/running.html?dir=asc&order=position&in-stock=1']")).click();		
	} else {
		System.out.println("link not found");
	}
	
	}
	@Given("^Select shoe from listing page$")
	public void selectShoe(){
		driver.findElement(By.xpath("//h2/a[contains(text(),'IGNITE evoKNIT NC Men's Running Shoes')]")).click();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
	}
	
	@When("^Click on Add to Cart button$")
	public void AddProduct(){
	driver.findElement(By.xpath("//div[@class='add-to-cart-buttons']")).click();
	}
	
	@Then("^Verify that the cart has the correct shoe selected in previous step$")
	public void verifyShoe(){
		driver.getTitle();
		String getTitle = driver.getTitle();
		boolean containsString = getTitle.contains("IGNITE evoKNIT NC Men's Running Shoes");
	Assert.assertTrue(containsString);
		
	}
	
	}
	
