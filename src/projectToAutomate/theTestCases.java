package projectToAutomate;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class theTestCases extends parameters {

	@BeforeTest
	public void setup() {
		driver.get(websitePage);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void sinpupTest() {
		WebElement createAccountButton = driver.findElement(By.linkText("Create an Account"));
		createAccountButton.click();
		WebElement firstNameLabel = driver.findElement(By.id("firstname"));
		firstNameLabel.sendKeys(firstNames[randomIndex]);
		WebElement lastNameLabel = driver.findElement(By.id("lastname"));
		lastNameLabel.sendKeys(lastNames[randomIndex2]);
		WebElement email = driver.findElement(By.id("email_address"));
		email.sendKeys(loginEmail);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(loginPassword);
		WebElement confirmPasswordElement = driver.findElement(By.id("password-confirmation"));
		confirmPasswordElement.sendKeys(loginPassword);
		WebElement createAnAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account']"));
		createAnAccountButton.click();

	}

	@Test(priority = 2)
	public void logoutTest() throws InterruptedException {
		driver.get(logoutPage);
		Thread.sleep(8000);
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		WebElement signinButton = driver.findElement(By.linkText("Sign In"));
		signinButton.click();
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(loginEmail);
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(loginPassword);
		WebElement loginButton = driver.findElement(By.id("send2"));
		loginButton.click();
		Thread.sleep(3000);

	}

	@Test(priority = 4)
	public void addFirstThreeItem() throws InterruptedException {
		driver.get(teesLink);
		Thread.sleep(2000);
		WebElement productContiner = driver.findElement(By.className("product-items"));
		WebElement firstItem = productContiner.findElement(By.cssSelector("div[class='column main'] li:nth-child(1)"));
		firstItem.click();
		Thread.sleep(2000);
		WebElement sizeContiner = driver.findElement(By.className("swatch-attribute-options"));
		List<WebElement> allSizesValues = sizeContiner.findElements(By.tagName("div"));
		int randomSizeIndex = rand.nextInt(allSizesValues.size());
		allSizesValues.get(randomSizeIndex).click();
		Thread.sleep(2000);
		WebElement colorContiner = driver
				.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List<WebElement> allColorsValues = colorContiner.findElements(By.tagName("div"));
		int RandomColorIndex = rand.nextInt(allColorsValues.size());
		allColorsValues.get(RandomColorIndex).click();
		WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
		addToCartButton.click();
		Thread.sleep(1000);
		driver.get(teesLink);
		WebElement productContinerItem2 = driver.findElement(By.className("product-items"));
		WebElement seconedItem = productContinerItem2
				.findElement(By.cssSelector("div[class='column main'] li:nth-child(2)"));
		seconedItem.click();
		Thread.sleep(2000);
		WebElement sizeContiner2 = driver.findElement(By.className("swatch-attribute-options"));
		List<WebElement> allSizeValues2 = sizeContiner2.findElements(By.tagName("div"));
		int randomSizeSeconedEle = rand.nextInt(allSizeValues2.size());
		allSizeValues2.get(randomSizeSeconedEle).click();
		Thread.sleep(2000);
		WebElement colorContiner2 = driver
				.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List<WebElement> allColorsValues2 = colorContiner2.findElements(By.tagName("div"));
		int RandomColorIndex2 = rand.nextInt(allColorsValues2.size());
		allColorsValues2.get(RandomColorIndex2).click();
		WebElement addToCartButton2 = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
		addToCartButton2.click();
		Thread.sleep(1000);
		driver.get(teesLink);
		WebElement productContinerItem3 = driver.findElement(By.className("product-items"));
		WebElement thirdItem = productContinerItem3
				.findElement(By.cssSelector("div[class='column main'] li:nth-child(3)"));
		thirdItem.click();
		Thread.sleep(2000);
		WebElement sizeConti = driver
				.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
		List<WebElement> allSizes = sizeConti.findElements(By.tagName("div"));
		int randomNumber = rand.nextInt(allSizes.size());
		allSizes.get(randomNumber).click();
		Thread.sleep(2000);
		WebElement colorConti = driver
				.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List<WebElement> allColors = colorConti.findElements(By.tagName("div"));
		int RandomColors = rand.nextInt(allColors.size());
		allColors.get(RandomColors).click();
		Thread.sleep(3000);
		WebElement addToCart = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
		addToCart.click();
		Thread.sleep(7000);
		String theCart = driver.findElement(By.className("showcart")).getText();
		Assert.assertEquals(theCart.contains("3"), true);
		WebElement cartElement = driver.findElement(By.className("showcart"));
		cartElement.click();
		List<WebElement> allPrices = driver.findElements(By.className("minicart-price"));
		double sum = 0.0;
		for (int i = 0; i < allPrices.size(); i++) {
			double Price = Double.parseDouble(allPrices.get(i).getText().replace("$", " "));
			sum = sum + Price;

		}

		double totalPrice = Double
				.parseDouble(driver.findElement(By.cssSelector(".amount.price-container")).getText().replace("$", ""));
		Assert.assertEquals(totalPrice, sum);

	}

	@Test(priority = 5)
	public void addRandomItem() throws InterruptedException {
		driver.get(teesLink_Men);
		Thread.sleep(1000);

		WebElement itemsContiner = driver.findElement(By.cssSelector(".products.wrapper.grid.products-grid"));
		List<WebElement> allitems = itemsContiner.findElements(By.tagName("li"));
		int randNumber = rand.nextInt(allitems.size());
		allitems.get(randNumber).click();
		Thread.sleep(2000);
		WebElement SizeContainer = driver
				.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));

		List<WebElement> AllSized = SizeContainer.findElements(By.tagName("div"));

		int randomIndex = rand.nextInt(AllSized.size());
		AllSized.get(randomIndex).click();
		Thread.sleep(2000);
		WebElement colorConti = driver
				.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List<WebElement> allColors = colorConti.findElements(By.tagName("div"));
		int RandomColors = rand.nextInt(allColors.size());
		allColors.get(RandomColors).click();
		WebElement addToCart = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
		addToCart.click();
		Thread.sleep(3000);

	}

	@AfterTest
	public void postTest() {
	}

}
