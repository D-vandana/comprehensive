package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage
{
	WebDriver driver;

	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Wallace Study Desk (Wenge Finish)']")
	WebElement sd;

	@FindBy(xpath = "//*[@id='store-availability']/div/h2/text()")
	WebElement vos;

	@FindBy(xpath = "//*[@class='topnav_item studyunit']")
	WebElement sa;

	@FindBy(xpath = "//li[@class='subnav_item 13057']")
	WebElement ot;
	
	@FindBy(xpath = "//h2[@class='withsubtext']")
	WebElement sv;
	
	public WebElement study()
	{
		return sa;
	}

	public WebElement table()
	{
		return sd;
	}

	public WebElement officeTable()
	{
		return ot;
	}

	public WebElement visitOurStores()
	{
		return vos;
	}
	public WebElement studyVerify()
	{
		return sv;
	}
}