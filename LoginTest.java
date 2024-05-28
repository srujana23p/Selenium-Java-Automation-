package com.example.Tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srujana P\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Open the web browser and navigate to the login page
            driver.get("https://app.logyxps.com/");

            // Locate the email field using CSS selector
            WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
            //Enter Email
            emailField.sendKeys("demomail@gmail.com");
            System.out.println("Entered Username Successfully");

            // Locate the password field using CSS selector
            WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']")); 
            //Enter password 
            passwordField.sendKeys("demomail");
            System.out.println("Entered Password Successfully");

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            System.out.println("Clicked LOGIN Button Successfully");
            
            //Locate 'OK' button of Successful Login Message Using Xpath 
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
            WebElement successButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='You are Successfully Logged In']//following::button[text()='OK']")));
            //Click 'OK' button
            successButton.click();    
            System.out.println("Clicked OK Button Successfully");

            // Wait for the landing page to load and verify the login is successful
            WebElement dashboardElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("navbarScrollingDropdown")));
        
            // Check if the 'demomail' element is displayed to confirm successful login
            if (dashboardElement.isDisplayed()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
