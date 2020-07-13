package testcases;



import org.testng.annotations.Test;

import utils.DP003;
import wrappers.GenericWrappers;

public class TC004 extends GenericWrappers{
 @Test(dataProvider="fetchdata",dataProviderClass=DP003.class)
	public void saloonmandatoryCheck(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l){

		invokeApp("chrome", "https://irctc.co.in");
	clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div[2]/div/form/div[2]/button");
		clickByLink("STAYS");
		clickByLink("Lounge");
		switchToLastWindow();
		clickByXpath("/html/body/app-root/homeheader/nav/div/div[2]/a[3]/i");
		waitProperty(5000);
		clickByXpath("//*[@id='slide-out']/ul/li/ul/li[14]/a");
				switchToLastWindow();
		clickByLink("Enquiry Form");
		enterByXpath("//*[@id='Enquiry-just']/div/form/div/div[3]/input", a);
		  
		 enterByName("organization", b);
		  
		  enterByName("address", c);
		  
		  enterByName("mobile", d);
		  
		  enterByName("email",e);
		selectvaluebyName("requestFor","Saloon Charter");
		
		  
		 enterByName("originStation", f);
		 
		 enterByName("destnStation",g);
		 
		 clickByName("checkInDate");
		 waitProperty(5000);
		 clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[11]/div/div/table/thead/tr[1]/th[3]/span[1]");
		 waitProperty(5000);
		 clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[11]/div/div/table/tbody/tr[5]/td[7]/span");
		 int z;
	for(z=1;z<=2;z++){
		
keyboardkeysArrowDownbyxpath("//html/body");
	}
		
	clickByName("checkOutDate"); 

	clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[12]/div/div/table/thead/tr[1]/th[3]/span[1]/i");	
	waitProperty(5000);	
	clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[12]/div/div/table/tbody/tr[6]/td[1]/span");
	 
	  enterByName("durationPeriod", h);
	  
	  enterByName("coachDetails", i);
	  
	  enterByName("numPassenger", j);
	  
	  enterByName("charterPurpose", k);
	  
	  enterByName("services", l);
	clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[19]/button");
	verifyTextByXpath("//*[@id='Enquiry-just']/div/form/div/div[6]/span", "Mobile no. not valid");
	
	closeAllBrowsers();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
