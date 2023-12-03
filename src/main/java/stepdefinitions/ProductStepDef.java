package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import pageobjects.HomePage;
import pageobjects.ProductDetailsPage;
import utils.BrowserFactory;
import utils.GenericMethods;

import java.util.Properties;

public class ProductStepDef {
   public static Properties prop = new Properties();
   WebDriver driver= null;
   HomePage homePage;
   ProductDetailsPage productDetailsPage;
   @Before
   public void tearUp(){
         driver = BrowserFactory.launchGivenBrowser("chrome");
         homePage = new HomePage(driver);
         productDetailsPage = new ProductDetailsPage(driver);

   }


 @Given("I am on the login page")
    public void verifyUserIsOnLoginPage(){

       System.out.println("I am on the login page");

 }


    @When("I enter my valid username {string}")
    public void enterUserName(String userName){
        System.out.println("I enter my valid username  " + userName);

    }

    @When("I enter my valid password {string}")
    public void enterPassword(String password){
        System.out.println("I enter my valid password  " + password);

    }

    @Then("click the login button")
    public void clickOnLoginButton(){
        System.out.println("click the login button");

    }

    @Then("I should be redirected to the dashboard")
    public void verifyUserRedirectedToLoginPage(){
        System.out.println("I should be redirected to the dashboard");
    }

    @Given("I should see a welcome message")
    public void verifyUserSeeWelcomeMessage(){
        System.out.println("I should see a welcome message");
    }


    @When("I am on shopping website")
    public void launchWebsite(){
        driver.get("https://magento.softwaretestingboard.com/");
        Assert.assertTrue(homePage.verifyIfSearchBarIsAvailable());
    }

    @When("I select a product from list of product")
    public void selectProduct(){
        homePage.clickOnProduct();
        Assert.assertTrue(productDetailsPage.verifyAddToCartButtonShowsWithProduct());
    }

    @Then("I select color of same product")
    public void selectColorOfProduct(){
       productDetailsPage.clickOnColor();
    }

    @Then("I select my size in same product")
    public void selectSizeOfProduct(){
        productDetailsPage.clickOnSize();
    }

    @Given("I add product into cart")
    public void addProductIntoCart(){
       productDetailsPage.clickOnCartButton();
       GenericMethods.pauseExecutionFor(3);
       Assert.assertTrue(productDetailsPage.verifyProductAddedSuccessfully());
    }

    @After
   public void tearDown(){
        driver.quit();
    }

}
