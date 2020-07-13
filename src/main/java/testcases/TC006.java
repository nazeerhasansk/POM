package testcases;



import org.testng.annotations.Test;

import utils.DP004;
import wrappers.GenericWrappers;

public class TC006 extends GenericWrappers {
	
	@Test(dataProvider="fetchdata",dataProviderClass=DP004.class)
	public void bookhotels(String mail, String phn,String state,String name,String lname)
	{
		invokeApp("chrome", "https://www.irctc.co.in");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div[2]/div/form/div[2]/button");
		waitProperty(5000);
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[5]/a");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[5]/ul/li[3]/a/span");
		switchToLastWindow();
		clickByXpath("/html/body/app-root/homeheader/nav/div/div[2]/a[3]/i");
		clickByXpath("//*[@id='slide-out']/ul/li/ul/li[4]/a");
		switchToLastWindow();
		waitProperty(5000);
		clickByLink("Login");
		waitProperty(5000);
		clickByXpath("//*[@id='LoginFormPopup']/app-loginmodal/div/div/div/ul/li[2]/a");
		waitProperty(5000);
		enterById("modalLRInput12",mail);
		enterById("modalLRInput13", phn);
		waitProperty(5000);
		clickByXpath("//*[@id='panel8']/div[1]/form/div[3]/button");
		waitProperty(5000);
		enterByXpath("//*[@id='TravellerEconomydropdown']/div[1]/searchbox/input",state);
		waitProperty(5000);
		clickByXpath("//*[@id='TravellerEconomydropdown']/div[1]/searchbox/div/ul/li/a/div[1]/span");
		waitProperty(5000);
		clickByName("dt12");
		
		waitProperty(5000);
		clickByXpath("//*[@id='owl-dt-picker-0']/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[5]/td[2]/span");
		
		waitProperty(5000);
		clickByName("dt13");
		waitProperty(5000);
		clickByXpath("//*[@id='owl-dt-picker-1']/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[5]/td[5]/span");
		waitProperty(5000);
		clickById("user-data-wrapper-id");
		waitProperty(5000);
		selectvaluebyName("hotelAdult","3");
		clickByXpath("//*[@id='user-data-wrapper']/div[2]/button");
		waitProperty(5000);
		clickByXpath("//*[@id='TravellerEconomydropdown']/div[5]/button");
		waitProperty(5000);
		clickByXpath("/html/body/app-root/app-fulllayout/div/app-hotellist/main/div/div[2]/div/div[2]/div/div/div[3]/button");
		String hotelname = getTextByXpath("/html/body/app-root/app-fulllayout/div/app-hoteldetail/main/div/div/div[2]/h3/a");
		System.out.println(hotelname);
		String hotelamount = getTextByXpath("//*[@id='hotel-dtl-sticky-photo']/div[1]/div[1]/div[2]/div/div/p");
		System.out.println(hotelamount);
		waitProperty(5000);
		clickByXpath("//*[@id='hotel-dtl-sticky-photo']/div[1]/div[1]/div[2]/div/div/div[4]/button");
		waitProperty(5000);
	
		selectvaluebyName("title", "1");
		enterByName("firstName",name);
		enterByName("lastName", lname);
		selectvaluebyName("gst","No");
		
		verifyTextByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[2]/div/div/div[2]/span", "OYO Townhouse 237 Kovilambakkam ");
		verifyTextByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[2]/div/div/div[5]/span/b", "2151.00");
       waitProperty(5000);
       
       clickByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[7]/button[2]");
			keyboardkeysArrowDownbyxpath("//html/body");
			keyboardkeysArrowDownbyxpath("//html/body");
			clickByXpath("/html/body/app-root/app-fulllayout/div/app-summary/main/div/div[1]/div[6]/label");
		waitProperty(3000);	
			clickByXpath("/html/body/app-root/app-fulllayout/div/app-summary/main/div/div[1]/div[7]/button[2]");
			
			waitProperty(3300);
			clickByXpath("//*[@id='OTPModal']/div/div/form/div[2]/button");
			verifyTextByXpath("//*[@id='OTPModal']/div/div/form/div[1]/span", "otp field is required.");
			
			closeAllBrowsers();
			
	}
}


