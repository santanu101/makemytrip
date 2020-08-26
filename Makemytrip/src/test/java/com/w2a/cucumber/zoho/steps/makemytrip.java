package com.w2a.cucumber.zoho.steps;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.w2a.zoho.utilities.DriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class makemytrip {
	WebDriver driver = null;
	
	 @Given("^Launch the chrome browser$")
	 
	 public void userhomepage() throws InterruptedException{
		// System.setProperty("webdriver.chrome.driver","E:\\Jars\\chrome\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		 driver = DriverManager.getDriver();
		 driver.navigate().to("https://www.makemytrip.com/");
		 Thread.sleep(10000);
	 }
	 @Then("^user enter '(.*?)' and '(.*?)'$")
		 public void user_enter (String arg1, String arg2) throws InterruptedException 
		 {
		 driver = DriverManager.getDriver();
		 System.out.println(arg1+arg2);
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//input[@id='fromCity']")).click();
			Thread.sleep(5000);
			WebElement src = driver.findElement(By.xpath("//input[@placeholder='From']"));
			src.sendKeys(arg1);
			Thread.sleep(5000);
			src.sendKeys(Keys.DOWN);
		      Thread.sleep(5000);
		      src.sendKeys(Keys.ENTER);
		      WebElement src1= driver.findElement(By.xpath("//input[@placeholder='To']"));
		      Thread.sleep(5000);
		      src1.sendKeys(arg2);
		      src1.sendKeys(Keys.DOWN);
		      Thread.sleep(5000);
		      src1.sendKeys(Keys.ENTER);
		      //User will enter the date
		      driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		      driver.findElement(By.xpath("//div[@class='DayPicker-wrapper']//div[1]//div[3]//div[3]//div[4]")).click();
		      //driver.findElement(By.xpath("//*[@id='departureCalendar']")).sendKeys(arg3);
		      
		      
		  
		 }
	 @Then("^user click on the search$")
		public void user_click_on_search() throws Throwable {
			
		 driver.findElement(By.xpath("//a[contains(@class,'primaryBtn font24 latoBold widgetSearchBtn')]")).click();
	      Thread.sleep(5000);
		   
		}
	 @Then("^user click on the Evening Flight$")
		public void user_click_on_Evening() throws Throwable {
			
		//User will scroll down
	      JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(5000);
			//User will click on evening flight
			driver.findElement(By.xpath("//div[contains(@class,'filtersCollapsOuter append_bottom20')]//div[2]//div[1]//div[1]//div[3]")).click();
		   
	 }

@Then("^user will get all the prices from the table$")
public void user_will_get_all_the_prices_from_the_table()throws Throwable {
	
	//User will find lowest price of the flight
	List<WebElement> price = driver.findElements(By.xpath("//*[@class='actual-price']"));
	List<Integer> list=new ArrayList<Integer>();
    for(WebElement value:price) {
        String money=value.getText();
        String arrmon[]=money.split(" ");

        for(int i=1;i<arrmon.length;i++) {
            String text =arrmon[i];

            NumberFormat india  = NumberFormat.getInstance();
            Number number = india.parse(text);
            String conversion =number.toString();

            int lowprice = Integer.parseInt(conversion);


            list.add(lowprice);

        }
    }
    System.out.println("The cheaper price is:"+Collections.min(list));
}


@Then("^user will get non-stop flight$")
public void user_will_get_fastest_flight()throws Throwable {
	Thread.sleep(5000);
	driver.findElement(By.xpath("//body/div[@id='root']/div/div[@id='root-element']/div[@id='body--wraper']/div[@id='section--wrapper']/div[contains(@class,'fli-intl-rhs pull-left end')]/div[contains(@class,'filtersCollapsOuter append_bottom20')]/div[contains(@class,'fli-items-wrapper collapse in')]/div[contains(@class,'filtersOuter append_bottom20')]/div[contains(@class,'fli-filter-items')]/span[1]/label[1]/span[1]")).click();
    Thread.sleep(5000);
	
}

@Then("^user will click on Book$")
public void user_will_click_on_Book()throws Throwable {
	Thread.sleep(5000);
	//User will click on view price
    driver.findElement(By.xpath("//*[@class='pull-left make_relative']")).click();
  //User will click on book button
    driver.findElement(By.xpath("(//*[@class='make_relative'])[2]")).click();
    System.out.println("User click on book button");
}
}
   