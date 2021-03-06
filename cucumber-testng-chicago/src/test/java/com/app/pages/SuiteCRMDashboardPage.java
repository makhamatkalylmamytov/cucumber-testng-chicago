package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

public class SuiteCRMDashboardPage {
	private WebDriver driver;
	
	public SuiteCRMDashboardPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="SALES")
	public WebElement sales;
	
	@FindBy(linkText="MARKETING")
	public WebElement marketing;
	
	@FindBy(linkText="SUPPORT")
	public WebElement support;
	
	@FindBy(linkText="ACTIVITIES")
	public WebElement activities;
	
	@FindBy(linkText="COLLABORATION")
	public WebElement collaboration;
	
	@FindBy(linkText="ALL")
	public WebElement all;
	
	@FindBy(xpath="//input[contains(@title,'Post Status Update')]")
	public WebElement postField;
	
	@FindBy(xpath="//div[@class='dashletNonTable']//input[@value='Post']")
	public WebElement post;
	
	@FindBy(id="with-label")
	public WebElement profileMenu;
	
	@FindBy(xpath="(//a[@id='logout_link'])[3]")
	public WebElement logoutLink;
	
	@FindBy(xpath = "//div[@class='desktop-bar']//li[@id='quickcreatetop']")
	public WebElement createMenuBtn;
	
	@FindBy(linkText = "Create Contact")
	public WebElement createContactOption;
	
	
	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(profileMenu);
		action.perform();
		BrowserUtils.waitForVisibility(logoutLink, 5);
		logoutLink.click();
	}
	
	public void postNote(String note) {
		postField.sendKeys(note);
		post.click();
	}
	
}
