package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping
{
	WebDriver driver;

	public Shipping(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Shipping & Delivery")
	WebElement fp;

	public WebElement shipping() 
	{
		return fp;
	}
	
	@FindBy(xpath="//div[@id='page_content']/ol/li")
	WebElement fpv;

	public WebElement shippingVerify()
	{
		return fpv;
	}
	

}
