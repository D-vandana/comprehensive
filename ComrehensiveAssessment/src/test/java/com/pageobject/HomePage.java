package com.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='header-icon-link user-profile-icon']")
	WebElement ic;

	@FindBy(linkText = "Log In")
	WebElement li;

	@FindBy(xpath = "//input[@id='search']")
	WebElement sb;

	@FindBy(xpath = "//*[@class='search-icon icofont-search']")
	WebElement ico;
	
	By pop = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	
	
	public WebElement icon()
	{
		return ic;
	}
	public WebElement Login()
	{
		return li;
	}

	public WebElement search()
	{
		return sb;
	}

	public WebElement searchIcon()
	{
		return ico;
	}
	
	public List<WebElement> popUpsize()
	{
		return driver.findElements(pop);
	}
	
	public WebElement popUp()
	{
		return driver.findElement(pop);
	}
}
