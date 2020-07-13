package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;



import org.apache.commons.io.FileUtils;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import org.openqa.selenium.support.ui.Select;



public class GenericWrappers implements Wrappers {

	RemoteWebDriver driver;
	int i;
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			  driver=new ChromeDriver();
			}else  if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			 driver=new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")){
			 System.setProperty("webdriver.internetexplorer.driver", "./drivers/IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			}
				driver.get(url);
				driver.manage().window().maximize();
				System.out.println("the browser  "+browser+ "  is launched successfully with url  "+url);
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			System.err.println("the browser " +browser+"  is not launched with url "+url+"due to session not created error");
			
		}catch (UnreachableBrowserException e) {
			// TODO: handle exception
		System.err.println("the browser "+browser+ "is not launched due to browser is crashed" );
		
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the browser " +browser+"  is not launched with url "+url+"due to unknownerror error");
		}finally {
			takeSnap();
		}
			
			
			
	
		
		
		
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("the element with id  "+idValue+" is entered with data "+data+ "successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		System.err.println("The element with id "+idValue+" is not found in dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the element with id "+idValue+ "is not visible in Application");
		}catch (ElementNotInteractableException e)  {
			// TODO: handle exception
			System.err.println("the element wit id "+idValue+ " is not interactable in Dom");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with id "+idValue+ " is not stable in Application");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the elememnt wit id "+idValue+" is invalid in dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the elemennt with id "+idValue+ "is not entered with data "+data+ " due to unknwn error");
		}finally {
			takeSnap();
		}
		
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("the element with Name "+nameValue+" is entered with data "+data+ " succesfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with Name "+nameValue+" is not found in Dom");	
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the element with Name "+nameValue+" is not visible in Application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the elememnt with Name "+nameValue+" is not interactable" );
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with Name " +nameValue+ " is not stable in Application");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the element with Name "+nameValue+" is not valid in Dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with Name  "+nameValue+"  is not entered data" +data+ "due to unknown error");
		}
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("the element with xpath "+xpathValue+"  is entered data "+data+ " is succefully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with xpath "+xpathValue+" is not found in Dom");
	    }catch (ElementNotVisibleException e) {
			// TODO: handle exception
	    	System.err.println("the element with xpath " +xpathValue+ " is not visible in Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpathValue+ " is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpathValue+ " is not stable in Apllication");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the element with xath "+xpathValue+" is not valid in Dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpathValue+"  is not entered data" +data+"  due to unknownerror");
		}finally {
			takeSnap();
		}
		
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		   
			
				   try {
					String actualTitle=driver.getTitle();
					   System.out.println(actualTitle);
					   System.out.println(title);
					   if(actualTitle.equalsIgnoreCase(title)){
						   System.out.println("The title recieved from browser "+actualTitle+"  is mathced with title "+title+"  succefully'");
					   }else{
						   System.err.println("The title recieved from browser "+actualTitle+"  is not mathced with title "+title+" unsuccefully'");
					   }
				} catch (InvalidArgumentException e) {
					// TODO Auto-generated catch block
					System.err.println("The title recieved from browser is not matches with title "+title+" due to invalid ARguement");
				}catch (NoSuchWindowException e) {
					// TODO: handle exception
				System.err.println("Browser window is not found for " +title);
				}catch (UnreachableBrowserException e) {
					// TODO: handle exception
					System.err.println("Browser window is not found for " +title );
				}catch (WebDriverException e) {
					// TODO: handle exception
					System.err.println("The title received from the browser nto matches with"+title+"due to unknownerror");
				}finally {
					takeSnap();
				}
				   
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		
		try {
			String actualText=driver.findElementById(id).getText();
			System.out.println(actualText);
			System.out.println(text);
			if(actualText.equals(text)){
				System.out.println("the text recieved from id "+actualText+" is matched succesfuly with text "+text);
			}else{
				System.out.println("the text recieved from id "+actualText+" is not matched with text "+text);
			}
		} catch (InvalidArgumentException e) {
			// TODO Auto-generated catch block
			System.err.println("the text recieved from id is not matches with tex "+text+" due to invalid argueent error");
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		System.err.println("The element with id "+id+" is not found in dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the element with id "+id+ "is not visible in Application");
		}catch (ElementNotInteractableException e)  {
			// TODO: handle exception
			System.err.println("the element wit id "+id+ " is not interactable in Dom");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with id "+id+ " is not stable in Application");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the elememnt wit id "+id+" is invalid in dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the elemennt with id "+id+ "is not matches with text "+text+ " due to unknwn error");
		}finally {
			takeSnap();
		}
		
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		
		try {
			String actualText =driver.findElementByXPath(xpath).getText();
			System.out.println(actualText);
			if(actualText.equals(text)){
				System.out.println("The text recieves from xpath "+actualText+" is Matches Sucessfully with text "+text);
			}else{
				System.err.println("The text recieves from xpath "+actualText+ " is not Matches  with text "+text+" unsucceful");
			}
		} catch (InvalidArgumentException e) {
			// TODO Auto-generated catch block
			System.err.println("The text recieves from xpath is not mathces with "+text);
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpath+" is not found in Dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not visible in Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not stable in Apllication");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not stable in Apllication");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
		System.err.println("the element with xpath "+xpath+ "is not valid in Dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpath+"  is not matches with text "+text+  "due to unknownerror");
		}finally {
			takeSnap();
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		
	try {
		String actualText =driver.findElementByXPath(xpath).getText();
		System.out.println(actualText);
		System.out.println(text);
		if(actualText.contains(text)){
			System.out.println("the text recived from xpath "+actualText+" is matches succefully with text "+text );
		}else{
			System.err.println("the text recived from xpath "+actualText+" is not matches with text "+text);
		}
	} catch (InvalidArgumentException e) {
		// TODO Auto-generated catch block
		System.err.println("the text recieves from xpath "+xpath+" is not mathces with text "+text);
	}catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println("the element with xpath "+xpath+" is not found in Dom");
	}catch (ElementNotVisibleException e) {
		// TODO: handle exception
		System.err.println("the element with xpath " +xpath+ " is not visible in Application ");
	}catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println("the element with xpath " +xpath+ " is not stable in Apllication");
	}catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println("the element with xpath " +xpath+ " is not stable in Apllication");
	}catch (InvalidElementStateException e) {
		// TODO: handle exception
	System.err.println("the element with xpath "+xpath+ "is not valid in Dom");
	}catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("the element with xpath "+xpath+"  is not matches with text "+text+  "due to unknownerror");
	}finally {
		takeSnap();
	}
}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
			System.out.println("the elememnt with id "+id+" is clicked successfully");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with id "+id+ " is not clicked due to click intercepted error");
			
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("the elememnt with id " +id+ " is found in Dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the elememnt with id " +id+ " is not visible in application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with id " +id+ " is not interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with id " +id+ " is not stable in application");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the elememnt wit id "+id+" is invalid in dom");
		
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the elememnt with id " +id+ " is not clicked due to unknown error");
		}finally {
			takeSnap();
		}
		
		
		
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("the element with classname "+classVal+" isclicked successfuly ");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			System.out.println("the element with classname "+classVal+" is nto clicked due to clickintercepted error");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("the element with classname "+classVal+" is found in dom ");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.out.println("the element with classname "+classVal+" is not visible in Dom");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.out.println("the element with classname "+classVal+" is not interactable In Dom");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.out.println("the element with classname "+classVal+" is not clicked due element is invalid");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.out.println("the element with classname "+classVal+" is not stable in Application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.out.println("the element with classname "+classVal+" is nto clicked due to unknown  error");
		}
		
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			System.out.println("the element with name "+name+" is clicked successfully");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			System.err.println("the elememnt with name "+name+" is not clicked due to click intercepted error");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("the element  with Name " +name+ " is found in Dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the element  with Name " +name+ " is not visible in application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element  with Name " +name+ " is not interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element  with Name " +name+ " is not stable in application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element  with Name " +name+ " is not clicked due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("the element with name "+name+" is clicked succesfully");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			System.out.println("the element with name "+name+" is clicked successfully");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("the element  with Name " +name+ " is found in Dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the element  with Name " +name+ " is not visible in application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element  with Name " +name+ " is not interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element  with Name " +name+ " is not stable in application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element  with Name " +name+ " is not clicked due to unknown error");
		}finally {
			takeSnap();
		}
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					driver.findElementByLinkText(name).click();
					System.out.println("the element with name "+name+" is clicked succesfully");
				} catch (ElementClickInterceptedException e) {
					// TODO Auto-generated catch block
					System.out.println("the element with name "+name+" is clicked successfully");
				}catch (NoSuchElementException e) {
					// TODO: handle exception
					System.err.println("the element  with Name " +name+ " is found in Dom");
				}catch (ElementNotVisibleException e) {
					// TODO: handle exception
					System.err.println("the element  with Name " +name+ " is not visible in application");
				}catch (ElementNotInteractableException e) {
					// TODO: handle exception
					System.err.println("the element  with Name " +name+ " is not interactable");
				}catch (StaleElementReferenceException e) {
					// TODO: handle exception
					System.err.println("the element  with Name " +name+ " is not stable in application");
				}catch (WebDriverException e) {
					// TODO: handle exception
					System.err.println("the element  with Name " +name+ " is not clicked due to unknown error");
				}	
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("the element with xpath "+xpathVal+"  is clicked  succefully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with xpath "+xpathVal+" is not found in Dom");
	    }catch (ElementNotVisibleException e) {
			// TODO: handle exception
	    	System.err.println("the element with xpath " +xpathVal+ " is not visible in Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpathVal+ " is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpathVal+ " is not stable in Apllication");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the element with xath "+xpathVal+" is not valid in Dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpathVal+"  is not clicked  due to unknownerror");
		}finally {
			takeSnap();
		}
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("the element with xpath "+xpathVal+"  is clicked  succefully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with xpath "+xpathVal+" is not found in Dom");
	    }catch (ElementNotVisibleException e) {
			// TODO: handle exception
	    	System.err.println("the element with xpath " +xpathVal+ " is not visible in Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpathVal+ " is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpathVal+ " is not stable in Apllication");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the element with xath "+xpathVal+" is not valid in Dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpathVal+"  is not clicked  due to unknownerror");
		}
		
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String text = null;
		try {
		
            text= driver.findElementById(idVal).getText();
			System.out.println("the element with id "+idVal+ " is recieved text "+text+ "succesfully");
		
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("the elememnt with id " +idVal+ " is found in Dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the elememnt with id " +idVal+ " is not visible in application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with id " +idVal+ " is not interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with id " +idVal+ " is not stable in application");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the elememnt wit id "+idVal+" is invalid in dom");
		
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the elememnt with id " +idVal+ " is not clicked due to unknown error");
		}finally {
			takeSnap();
		}
		
		return text;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String text=null;
		try {
		text=driver.findElementByXPath(xpathVal).getText();
			System.out.println("the element with xpath "+xpathVal+" is recived"
					+ " text " +text+" is successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with xpath "+xpathVal+" is not found in dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the element with Xpath" +xpathVal+ "is not Visible in Application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with Xpath " +xpathVal+ "is not interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with Xpath " +xpathVal+ "is not stable in application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the elememnt with Xpath" +xpathVal+ "is not clicked due to unknown error");
		}finally {
			takeSnap();
		}
		return text;
	
		
		
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		
		try {
			WebElement element=driver.findElementById(id);
			Select select = new Select(element);
			select.selectByVisibleText(value);
			System.out.println("the element with id "+id+" is selected with value "+value+" succesfully");
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with id "+id+" is not selected with value "+value+" due to Not selectableException");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("the elememnt with id " +id+ " is found in Dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the elememnt with id " +id+ " is not visible in application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with id " +id+ " is not interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with id " +id+ " is not stable in application");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the elememnt wit id "+id+" is invalid in dom");
		
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the elememnt with id "+id+ " is not clicked due to unknown error");
		}finally {
			takeSnap();
		}
		 
		
		
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
	try {
		WebElement element=	driver.findElementById(id);
		Select select =new  Select(element);
		select.selectByIndex(value);
		System.out.println("the element with id "+id+" is selected with value "+value+" successfully");
	} catch (ElementNotSelectableException e) {
		// TODO Auto-generated catch block
		System.err.println("the element with id "+id+" is not seleted due to nt selectedException");
		
	}catch (NoSuchElementException e) {
		// TODO: handle exception
		System.err.println("the elememnt with id " +id+ " is found in Dom");
	}catch (ElementNotVisibleException e) {
		// TODO: handle exception
		System.err.println("the elememnt with id " +id+ " is not visible in application");
	}catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println("the element with id " +id+ " is not interactable");
	}catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println("the element with id " +id+ " is not stable in application");
	}catch (InvalidElementStateException e) {
		// TODO: handle exception
		System.err.println("the elememnt wit id "+id+" is invalid in dom");
	
	}catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("the elememnt with id "+id+ " is not clicked due to unknown error");
	}finally {
		takeSnap();
	}
	 
	
}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
	try {
		Set<String>	 winHandle=   driver.getWindowHandles();
		for(String eachWin:winHandle){
			driver.switchTo().window(eachWin);
			break;
		}System.out.println("the driver switched to parentwindow successfully with session id "+winHandle);
	} catch (NoSuchWindowException e) {
		// TODO Auto-generated catch block
		System.err.println("Cannot switch to the parent window because the target window does not exist");
	}catch (SessionNotCreatedException e) {
		// TODO: handle exception
		System.err.println("the window is not switched due to session not created error");
	}catch (UnreachableBrowserException e) {
		// TODO: handle exception
		System.err.println("the window  is not switched ,due to browser is crashed");
	}catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("the window not switched to parentwindow due to unknown error");
	}finally {
		takeSnap();
	}
}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> lastWindow=driver.getWindowHandles();
			   for( String eachId :lastWindow){
			   driver.switchTo().window(eachId);
			   }
			   System.out.println("switched to the last window with session id" +lastWindow);
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("Cannot switch to the last window because the target window does not exist");
		}
		catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Cannot switch to the parent window due to unknown errors");
		}
		finally {
			takeSnap();
		}	
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			System.out.println("the driver accepts the alert present in application successfully");
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
	System.err.println("The driver cannot accept alert due to no alert present in application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the driver cannot accept the alert due to unknown error");
		}
		finally {
			takeSnap();
		}
		
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("the drivver dismiss alert succesfully");
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			System.err.println("the driver cannot dismiss the alert due to no alert present in application");
			e.printStackTrace();
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the driver cannot dismiss the alert due to unknown error");
		}
		finally {
			takeSnap();
		}
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		
	String alertText = null;
	try {
		alertText = driver.switchTo().alert().getText();
		System.out.println("The driver recieves the alert text is"+ alertText+ "successfully");
	} catch (UnhandledAlertException e) {
		// TODO Auto-generated catch block
		System.err.println("the driver cannot recives  the text "+alertText+" due to no alert present in the application");
	}catch (NoAlertPresentException e) {
		// TODO: handle exception
		System.err.println("the driver cannot recives  the text "+alertText+" noalert present exceptions");
	}catch (WebDriverException e) {
		// TODO: handle exception
		System.out.println("the driver cannot recives the alert text due to unknown error");
	}finally {
		takeSnap();
	}
	
		
		return alertText;
	}

	public void takeSnap() {
		// TODO Auto-generated method stub
	long number=	(long) (Math.floor(Math.random()*100000000)+100000);
	try {
		File temp=	driver.getScreenshotAs(OutputType.FILE);
		File dest= new File("./Reports/screenshots/" +number+".png");
		FileUtils.copyFile(temp, dest);
		System.out.println("the driver took screenshot and saved successfully");
	} catch (ScreenshotException e) {
		// TODO Auto-generated catch block
		System.err.println("the driver cannot take screenshot");
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.err.println("the drivver cannottake screenshot due to unknown error");
	}catch (IOException e) {
		// TODO: handle exception
		System.err.println("cannot take screen shot due to io errro");
	}
	i++;

}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			System.out.println("the driver closes browser succesfully");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("the driver cannot close the browser due  not found any window");
			
		}catch (NoSuchSessionException e) {
			// TODO: handle exception
			System.err.println("the driver csnnot close window due to session nto created error");
		
		}catch (WebDriverException e){
			System.err.println("the driver cannot close browser due to unknown error");
		}
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			System.out.println("the driver closes all browsers succesfully");
		 
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("the driver cannot close the browser due  not found any window");
			
		}catch (NoSuchSessionException e) {
			// TODO: handle exception
			System.err.println("the driver csnnot close window due to session nto created error");
		
		}catch (WebDriverException e){
			System.err.println("the driver cannot close browser due to unknown error");
		}
    }

	public void waitProperty(long millisec) {
		// TODO Auto-generated method stub
		
	
			try {
				Thread.sleep(millisec);
				System.out.println("The Browser waited for:"+millisec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}catch (WebDriverException e) {
				// TODO: handle exception
				System.err.println("the driver cannoot wait for "+millisec+" due to unknown error");
			}
			
		
	}

	public void keyboardKeysTabbyxath(String xpath) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpath).sendKeys(Keys.TAB);
			System.out.println("the driver performs Tabout keys succesfully");
		 
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("the element with xpath "+xpath+" is not found in Dom");
    }catch (ElementNotVisibleException e) {
		// TODO: handle exception
    	System.err.println("the element with xpath " +xpath+ " is not visible in Application ");
	}catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println("the element with xpath " +xpath+ " is not Interactable");
	}catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println("the element with xpath " +xpath+ " is not stable in Apllication");
	}catch (InvalidElementStateException e) {
		// TODO: handle exception
		System.err.println("the element with xath "+xpath+" is not valid in Dom");
	}catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("the element with xpath "+xpath+"is not tabout  due to unknownerror");
	}finally {
		takeSnap();
	}
		
	}

	public void keyboardKeysTabbyid(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).sendKeys(Keys.TAB);
		System.out.println("the driver succesfully performed Tabout succsfully");
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		System.err.println("The element with id "+id+" is not found in dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the element with id "+id+ "is not visible in Application");
		}catch (ElementNotInteractableException e)  {
			// TODO: handle exception
			System.err.println("the element wit id "+id+ " is not interactable in Dom");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with id "+id+ " is not stable in Application");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the elememnt wit id "+id+" is invalid in dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the elemennt with id "+id+ "is not taboutdue to unknwn error");
		}finally {
			takeSnap();
		}
		
	}

	public void keyboardkeysArrowDownbyid(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).sendKeys(Keys.ARROW_DOWN);
			System.out.println("the driver perform arrowdown key succesfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("The element with id "+id+" is not found in dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the element with id "+id+ "is not visible in Application");
		}catch (ElementNotInteractableException e)  {
			// TODO: handle exception
			System.err.println("the element wit id "+id+ " is not interactable in Dom");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with id "+id+ " is not stable in Application");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the elememnt wit id "+id+" is invalid in dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the elemennt with id "+id+ "is not arrowdown to unknwn error");
		}finally {
			takeSnap();
		}
		
		
	}

	public void keyboardkeysArrowDownbyxpath(String xpath) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_DOWN);
			driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_DOWN);
			driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_DOWN);
			
			System.out.println("the driver perfrom pagedown successfully");
			} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with xpath " +xpath+ "is not found in dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
	    	System.err.println("the element with xpath " +xpath+ " is not visible in Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not stable in Apllication");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the element with xath "+xpath+" is not valid in Dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpath+"is not tabout  due to unknownerror");
		}finally {
			takeSnap();
		}
	}

	public void keyboardKeysPageDownbyxpath(String xpath) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpath).sendKeys(Keys.PAGE_DOWN);
			System.out.println("the driver succesfuuly perform pagedown ");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with xpath "+xpath+"is not found in Dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
	    	System.err.println("the element with xpath " +xpath+ " is not visible in Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not stable in Apllication");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the element with xath "+xpath+" is not valid in Dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpath+"is not pagedwon  due to unknownerror");
		}finally {
			takeSnap();
		}
		
	}

	public String getAttributebyXpath(String xpath, String value) {
		// TODO Auto-generated method stub
		String attributeText = null;
		try {
		 
 attributeText=driver.findElementByXPath(xpath).getAttribute(value);
 System.out.println("the element with xpath "+xpath+" received text "+attributeText);
		}
			
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with xpath " +xpath+ "is not found in dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
	    	System.err.println("the element with xpath " +xpath+ " is not visible in Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not stable in Apllication");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the element with xath "+xpath+" is not valid in Dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpath+"is not tabout  due to unknownerror");
		}finally {
			takeSnap();
		}
		
		
		
		
		
		
		return attributeText;
	}

	public void verifygetAttributebyxpath(String xpath, String value, String expectedText) {
		// TODO Auto-generated method stub
		
	try {
		String actualText =	driver.findElementByXPath(xpath).getAttribute(value);
		System.out.println(actualText);
			System.out.println(expectedText);
			if(actualText.equals(expectedText)){
				System.out.println("the element with xpath is recieved text "+actualText+" is matches with succesfully text "+expectedText);
			}else{
				System.err.println("the element with xpath is recieved text "+actualText+" isnot matches with text "+expectedText+" unsuccesful");
			}
	
	}catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.err.println("the element with xpath "+xpath+"is not found in Dom");
	}catch (ElementNotVisibleException e) {
		// TODO: handle exception
    	System.err.println("the element with xpath " +xpath+ " is not visible in Application ");
	}catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println("the element with xpath " +xpath+ " is not Interactable");
	}catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println("the element with xpath " +xpath+ " is not stable in Apllication");
	}catch (InvalidElementStateException e) {
		// TODO: handle exception
		System.err.println("the element with xath "+xpath+" is not valid in Dom");
	}catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("the element with xpath "+xpath+"is not pagedwon  due to unknownerror");
	}finally {
		takeSnap();
	}
		
		
	}

	public void selectvisibleTextbyName(String name, String text) {
		// TODO Auto-generated method stub
		
		try {
			Select select=new Select(driver.findElementByName(name));
			select.selectByVisibleText(text);
			System.out.println("selected succefully with name "+name+" text "+text);
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with name "+name+" is selected with text "+text+" succefully");
			e.printStackTrace();
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with name "+name+" isnot selected with text "+text+"due to unknown error");
		}finally {
			takeSnap();
		}
		
		
	}

	public void selectvaluebyName(String name, String value) {
		// TODO Auto-generated method stub
		try {
			Select select=new Select(driver.findElementByName(name));
			select.selectByValue(value);
			System.out.println("selected succefully with name "+name+" value "+value);
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with name "+name+" is selected with text "+value+" succefully");
			e.printStackTrace();
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with name "+name+" isnot selected with text "+value+"due to unknown error");
		}finally {
			takeSnap();
		}
		
		
	}

	
	

	public String gettextbyLink(String name) {
		// TODO Auto-generated method stub
		String text = null;
		try {
			
            text= driver.findElementByLinkText(name).getText();
			System.out.println("the element with name "+name+ " is recieved text "+text+ "succesfully");
		
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("the elememnt with name " +name+ " is not found in Dom");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("the elememnt with name " +name+ " is not visible in application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with name " +name+ " is not interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with name " +name+ " is not stable in application");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the elememnt wit name "+name+" is invalid in dom");
		
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the elememnt with name " +name+ " is not recieved tex unknown errror");
		}finally {
			takeSnap();
		}
		return text;

	}

	public void selectvaluebyXpath(String xpath, String value) {
		// TODO Auto-generated method stub
		
		try {
			WebElement element=driver.findElementByXPath(xpath);
			Select select=new Select( element);
			select.selectByValue(value);
			System.out.println("the element with xpath "+xpath+" select with value "+value+"succesfully");
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			System.err.println("the element with xpath "+xpath+" is not select with value "+value+"due to nt selected error");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
	    	System.err.println("the element with xpath " +xpath+ " is not visible in Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with xpath " +xpath+ " is not stable in Apllication");
		}catch (InvalidElementStateException e) {
			// TODO: handle exception
			System.err.println("the element with xath "+xpath+" is not valid in Dom");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpath+"is not selected  due to unknownerror");
		}finally {
			takeSnap();
		}
		
		
		
		
	}

	public void verifygetattributebyXpath(String xpath, String value, String expectedText) {
		// TODO Auto-generated method stub
		
	try {
		String actualText=	driver.findElementByXPath(xpath).getAttribute(value);
			if(actualText.equals(expectedText)){
				System.out.println("the element with xpath "+xpath+"is recieves text "+actualText+"verified successfullywith text "+expectedText);
			}else{
				System.err.println("not matches with "+actualText+" with expected "+expectedText);
			}
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.err.println("unknown error");
	}
			
	
		
}

	public void keyboardKeysTabbyName(String name, String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByName(name).sendKeys(data,Keys.TAB);
			System.out.println("performed keys.tab success");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("unknownerror");
		}
		
	
	}

	public void selectIndexbyxpath(String xath, int index) {
		// TODO Auto-generated method stub
	try {
		Select sel=new Select(driver.findElementByXPath(xath));
		sel.selectByIndex(index);
			System.out.println("the lememnt with xpath "+xath+" selected with index "+index+"succesfully" );
	}catch (ElementNotVisibleException e) {
		// TODO: handle exception
    	System.err.println("the element with xpath " +xath+ " is not visible in Application ");
	}catch (ElementNotInteractableException e) {
		// TODO: handle exception
		System.err.println("the element with xpath " +xath+ " is not Interactable");
	}catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.err.println("the element with xpath " +xath+ " is not stable in Apllication");
	}catch (InvalidElementStateException e) {
		// TODO: handle exception
		System.err.println("the element with xath "+xath+" is not valid in Dom");
	}catch (WebDriverException e) {
		// TODO: handle exception
		System.err.println("the element with xpath "+xath+"is not selected  due to unknownerror");
	}finally {
		takeSnap();
	}
		
	
	}

	
	
}
