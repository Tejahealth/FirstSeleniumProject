package ctaf.accelerators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GenericMethods extends TestDriver{
	WebDriverWait wait = null;
	boolean flag = false;
	
	public static boolean click(By byLocator, String locator){
		boolean flag = false;
		try{
			driver.findElement(byLocator).click();
			flag = true;
			System.out.println("Successfully clicked on the Element: "+ locator.toString());
		}
		catch(Exception oExp){			
		}
		finally{
			if(!flag){
				System.out.println("Failed to click on the Element: "+ locator.toString());				
			}			
		}
		return flag;
	}
	
	public static boolean type(By byLocator, String text2enter, String locator){
		boolean flag = false;
		try{
			driver.findElement(byLocator).sendKeys(text2enter);
			flag = true;
			System.out.println("Text entered successfully: "+ locator);
		}
		catch(Exception oExp){			
		}
		finally{
			if(!flag){
				System.out.println("Failed to enter the text in an element: "+ locator);				
			}			
		}
		return flag;
	}
	
	public static String getAttribute(By byLocator, String strAttribute, String locator){
		String attributeValue = "";
		boolean flag = false;
		try{
			attributeValue = driver.findElement(byLocator).getAttribute(strAttribute);			
			System.out.println("Text entered successfully: "+ locator);
			flag = true;
		}
		catch(Exception oExp){			
		}
		finally{
			if(!flag){
				System.out.println("Failed to get the attribute value for an element: "+ locator);				
			}			
		}		
		return attributeValue;
	}
	
	public static String getText(By byLocator, String strAttribute, String locator){
		String text = "";
		boolean flag = false;
		try{
			text = driver.findElement(byLocator).getText();			
			System.out.println("Text entered successfully: "+ locator);
			flag = true;
		}
		catch(Exception oExp){			
		}
		finally{
			if(!flag){
				System.out.println("Failed to get the text value for an element: "+ locator);				
			}			
		}		
		return text;
	}
	
	public static boolean presenceOfElement(By byLocator, String strAttribute, String locator){
		boolean flag = false;
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
		return flag;
	}
	
	public static boolean isElementPresent(By by, String locator)
			throws Throwable {
		boolean flag = false;
		try {
			driver.findElement(by);
			flag = true;
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (!flag) {
				System.out.println("Element is not present: "+ locator);	
			}
		}
	}
	
	public static boolean waitForElementPresent(By by, String locator)
			throws Throwable {
		boolean flag = false;
		try {
			for (int i = 0; i < 300; i++) {
				if (driver.findElement(by).isDisplayed()) {
					flag = true;
					return true;
				} else {
					Thread.sleep(100);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				System.out.println("Element is not present");
			} 
		}
		return flag;
	}
	
	
	
	

}
