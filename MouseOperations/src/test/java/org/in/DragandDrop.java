package org.in;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);

		WebElement source = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
		WebElement targetElement = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, targetElement).build().perform();

		String color = targetElement.getCssValue("background");
		System.out.println("The drag and drop after the colour is : " + color);
		if (color.equals("rgb(255, 250, 144) 50% 0%")) {
			System.out.println("After the drag and drop the colour change is yellow");
		} else {
			System.out.println("After the drag and drop the colour is not yellow");
		}

		String text = targetElement.getText();
		System.out.println("The drag and drop after the text is : " + text);
		if (text.equals("Dropped!")) {
			System.out.println("After the drag and drop the target element is changed ");
		} else {
			System.out.println("After the drag and drop the target elemnt is not changed");

		}
		driver.close();

	}

}
