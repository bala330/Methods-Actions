package org.in;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		String homepage = driver.getTitle();
		System.out.println("It has the homepage : " + homepage);
		if (homepage.equals("Facebook – log in or sign up")) {
			System.out.println("It has the home page");

		} else {
			System.out.println("It has not the home page");
		}
		WebElement createaccount = driver.findElement(By.xpath("//a[contains(text(),'Create new account')]"));
		createaccount.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First name']"));
		firstname.sendKeys("Test");

		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.sendKeys("User");

		WebElement emailid = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		emailid.sendKeys("testuser@test.com");

		WebElement reenteremailid = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		reenteremailid.sendKeys("testuser@test.com");

		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		password.sendKeys("Vijakumar234@");

		WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select select = new Select(day);
		select.selectByIndex(10);

		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select select1 = new Select(month);
		select1.selectByVisibleText("May");

		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select select2 = new Select(year);
		select2.selectByValue("1985");

		WebElement radiobutton = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
		radiobutton.click();

		WebElement signup = driver.findElement(By.xpath("(//button[contains(text(),'Sign Up')])[1]"));
		signup.click();
		
	  	  
         String s=  driver.findElement(By.xpath("//div[@id='reg_error_inner']")).getAttribute("innerHTML");
         System.out.println("It will shown the message : " + s);
            if (s.equals("An error occurred. Please try again.")) {
            	System.out.println("The user is successfully registered");
				
			} else {
				System.out.println("The user is not successfully registered");

			}
            driver.navigate().refresh();
            
        	 
         }
	
}
