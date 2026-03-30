package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
private WebDriver driver;


private final By logoutbutton = By.xpath("//div[text()='S']");
private final By signout = By.xpath("//div[normalize-space()='Sign Out']");

public LogoutPage(WebDriver driver){
    this.driver=driver;
}
public void logout()
{
driver.findElement(logoutbutton).click();
}


public void signout()
{
    driver.findElement(signout).click();
}


}

