package projectToAutomate;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {
	WebDriver driver = new ChromeDriver();
	String websitePage = "https://magento.softwaretestingboard.com/";
	String[] firstNames = { "Ali", "Omar", "Leen", "Sadeen", "Reem" };
	String[] lastNames = { "Ahmad", "Mohammad", "Odai", "Naser", "Jamal" };

	Random rand = new Random();
	int randomIndex = rand.nextInt(firstNames.length);
	int randomIndex2 = rand.nextInt(lastNames.length);
	int randomEmailNumber = rand.nextInt(77880);
	String loginEmail = firstNames[randomIndex] + lastNames[randomIndex2] + randomEmailNumber + "@gmail.com";
	String loginPassword = "abcABC4321";
	String logoutPage = "https://magento.softwaretestingboard.com/customer/account/logout/";
	String topLink = "https://magento.softwaretestingboard.com/women/tops-women.html";
	String teesLink = "https://magento.softwaretestingboard.com/women/tops-women/tees-women.html";
	String men_TopLink = "https://magento.softwaretestingboard.com/men/tops-men.html";
	String teesLink_Men = "https://magento.softwaretestingboard.com/men/tops-men/tees-men.html";

}
