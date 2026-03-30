package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By email = By.xpath("//input[@placeholder='Enter Email']");
    private final By next = By.xpath("//button[.//*[contains(text(),'Next')]]");
    //private By next = By.xpath("//button[.//div[text()='Next']])");// update if needed
    private final By password = By.xpath("//input[@placeholder='Enter your password']");
    //private By checkbox=By.xpath("//div[@step='password']/div/div[1]");
    private final By checkbox =By.xpath("/descendant::*[local-name()='svg'][5]");
    private final By loginBtn = By.xpath("//button[.//div[normalize-space(text())='Sign In']]");
    private final By organization = By.xpath("//div[text()='Zeliot Test Organization']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass) {
        type(email, user);
        click(next);
        type(password, pass);
        //wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
        // jsClick(terms);
        click(checkbox);
       click(loginBtn);
       click(organization);
    }

    //private void jsClick(By terms) {
    //}
}