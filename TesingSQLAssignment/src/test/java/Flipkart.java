import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

    public WebDriver driver;

    @Given("Launch Flipkart application.")
    public void launch_flipkart_application() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
    }

    @And("Search for {string} laptop.")
    public void search_for_laptop(String laptopName) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(laptopName);
    }

    @And("Click on search button.")
    public void clickOnSearchButton() {
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
    }

    @When("Find 3rd result of C programming book.")
    public void find_3rd_result_of_hp_laptop() {
        WebElement laptopList = driver.findElement(By.xpath("(//span[@data-component-type='s-search-results']//div[@data-index='3'])[1]//a"));
        laptopList.click();
    }

    @Then("Display laptop Details.")
    public void display_laptop_details() {
        WebElement laptopTitle = driver.findElement(By.id("productTitle"));
        WebElement company = driver.findElement(By.xpath("//*[@id='bylineInfo']/span/a"));
        WebElement MRP = driver.findElement(By.xpath("//*[@id='corePriceDisplay_desktop_feature_div']//span[contains(text(), 'M.R.P.:')]"));
        WebElement price = driver.findElement(By.xpath("//*[@id='corePriceDisplay_desktop_feature_div']//span[contains(@class, 'a-price')]/span[2]"));
        System.out.println("Book Details: ");
        System.out.println("The title of the Book : " + laptopTitle.getText());
        System.out.println("Author Name           : " + company.getText());
        System.out.println("MRP (including taxes) : " + MRP.getText());
        System.out.println("Price (After Discount): ₹" + price.getText());
    }
}
