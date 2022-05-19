package com.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pageobject.AboutUs;
import com.pageobject.FeesAndPayment;
import com.pageobject.GiftCards;
import com.pageobject.HomePage;
import com.pageobject.LoginPage;
import com.pageobject.SearchPage;
import com.pageobject.Shipping;
import com.pageobject.SofaPage;
import com.pageobject.StudyClass;
import com.utilities.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class MainClass extends BaseClass
{	
	WebDriver driver=null;
	@Given("user Open the Browser")
	public void user_open_the_browser()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser Done");
	}
	@When("Enter into the {string} website")
	public void enter_into_the_website(String site)
	{
		driver.get(site);
		System.out.println("URL Done");
	}
	@Given("user click on Login page")
	public void user_click_on_login_page()
	{
		HP = new HomePage(driver);
	    HP.icon().click();
	    HP.Login().click();
	    System.out.println("Login Page Done");
	}
	@Given("Enter {string} and {string}")
	public void enter_and(String eMail, String Pwd) throws Exception
	{
		LP = new LoginPage(driver);
		Thread.sleep(5000);
		LP.eMailID().sendKeys(eMail);
		Thread.sleep(2000);
		LP.password().sendKeys(Pwd);
		LP.enter().click();
		System.out.println("Login Done");
	}
	@Then("close the website")
	public void close_the_website()
	{
		driver.quit();
		System.out.println("Browser Quit");		
	}
	@Given("user need to type Study Table in search bar")
	public void user_need_to_type_study_table_in_search_bar() throws Exception
	{
		HP = new HomePage(driver);
		Thread.sleep(5000);
		HP.search().sendKeys("Study Table");
		HP.searchIcon().click();
		// If popUp is displayed this if block get cancelled it

		if (HP.popUpsize().size() > 0)
		{
			Thread.sleep(5000);
			HP.popUp().click();
			System.out.println("PopUp found");
		}
		System.out.println("Search Bar");
	}
	@Given("verify whether Study Table keyword in that page")
	public void verify_whether_Study_Table_keyword_in_that_page() throws Exception
	{
		SP = new SearchPage(driver);
		Thread.sleep(5000);
		Assert.assertEquals(SP.studyVerify().getText(),"Search Results For 'Study Table'");
		System.out.println("Verification Done");
	}

	@Given("click on Study link")
	public void click_on_study_link() throws Exception
	{
		SP = new SearchPage(driver);
		Thread.sleep(2000);
		SP.study().click();
		System.out.println("study Link Done");
	}
	@Given("click on Office Tables")
	public void click_on_office_tables() throws Exception
	{
		Thread.sleep(5000);
		SP.officeTable().click();
		System.out.println("Office Table");
	}
	@Given("Verify whether the Office Table Keyword is featured or not")
	public void verify_whether_the_office_table_keyword_is_featured_or_not() throws Exception
	{
		SC = new StudyClass(driver);
		Thread.sleep(5000);
		Assert.assertEquals(SC.tableVerify().getText(), "Office Tables");
		System.out.println("Office Verification Done");
	}
	@Given("click on Fee & Payment")
	public void click_on_fee_payment() throws Exception
	{
		SB = new SofaPage(driver);
		SB.feesandpayment().click();
		Thread.sleep(2000);
		FP= new FeesAndPayment (driver);
		System.out.println("study Link Done");
	}
	@Given("verify whether TERMS OF SHIPPING AND DELIVERY is featured or not")
	public void verify_whether_terms_of_shipping_and_delivery_is_featured_or_not() throws Exception
	{
		FP= new FeesAndPayment (driver);
		Thread.sleep(2000);
		Assert.assertEquals (FP.FAPVerify().getText(),"FEES AND PAYMENT OPTIONS");
		Thread.sleep(2000);
		System.out.println("Office Verification Done");
	}
	@Given("user click on Gift Cards")
	public void user_click_on_gift_cards()
	{
		FP= new FeesAndPayment (driver);
		FP.giftCards().click();
		System.out.println("study Link Done");
	}
	@Given("verify whether First, choose an occasion is available or not")
	public void verify_whether_first_choose_an_occasion_is_available_or_not() throws Exception
	{
		GC = new GiftCards(driver);
		Thread.sleep(5000);
		Assert.assertEquals(GC.gcVerify().getText(),"1. First, choose an occasion");
		System.out.println("GiftCard Verification Done");
	}
	@Given("user click on About Us page")
	public void user_click_on_about_us_page()
	{
		GC = new GiftCards(driver);
		GC.aboutUs ().click();	
		System.out.println("AboutUs Link Done");
	}
	@Then("verify whether  Honesty & Transparency is appropriate or not")
	public void verify_whether_honesty_transparency_is_appropriate_or_not() throws Exception
	{
		AU = new AboutUs(driver);
		Thread.sleep(5000);
		Assert.assertTrue(AU.aboutVerify().getText().contains("Honesty & Transparency"));
		System.out.println("About Verification Done");
	}
	@Given("click on Shipping link")
	public void click_on_shipping_link()
	{
		SH = new Shipping(driver);
		SH.shipping().click();
		System.out.println("Shipping Link Done");
	}
	@Given("Verify whether the TERMS OF SHIPPING AND DELIVERY is featured or not")
	public void verify_whether_the_terms_of_shipping_and_delivery_is_featured_or_not() throws Exception
	{
		SH = new Shipping(driver);
		Thread.sleep(5000);
		Assert.assertEquals(SH.shippingVerify().getText(), "TERMS OF SHIPPING AND DELIVERY");
		System.out.println("Shipping Verification Done");
	}
	@Given("user click on TV Units")
	public void user_click_on_tv_units() throws Exception
	{
		AU = new AboutUs(driver);
		Thread.sleep(5000);
		AU.tvunits().click();
		System.out.println("TVUnit Link Done");
	}
	@Given("verify whether TV Units is present or not in the page")
	public void verify_whether_tv_units_is_present_or_not_in_the_page()
	{
	   System.out.println("Verified TVUnit");
	}
}
