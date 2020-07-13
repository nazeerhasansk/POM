package testcases;


import org.testng.annotations.Test;

import utils.DP006;
import wrappers.GenericWrappers;

public class TC008 extends GenericWrappers{

	@Test (dataProvider="fetchdata",dataProviderClass=DP006.class)
	public void bookHotels(String email,String mobilno,String loc,String firstnam,String lastname,String companyname,String companyaddress){
		
		invokeApp("chrome", "https://www.irctc.co.in");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div[2]/div/form/div[2]/button");
		clickByLink("STAYS");
		
		clickByLink("Lounge");
		switchToLastWindow();
		clickByXpath("/html/body/app-root/accommodation/div/div/div/div/div/div/div[3]/a[3]/div");
		
		switchToLastWindow();
		clickByLink("Login");
		waitProperty(3000);
		clickByXpath("//*[@id='LoginFormPopup']/app-loginmodal/div/div/div/ul/li[2]/a");
		waitProperty(3000);
		enterByName("email",email);
		enterByName("mobileNo", mobilno);
		clickByXpath("//*[@id='panel8']/div[1]/form/div[3]/button");
		enterByXpath("//*[@id='TravellerEconomydropdown']/div[1]/searchbox/input", loc);
	waitProperty(2000);
		//clickByName("Hyderabad");
	clickByXpath("//*[@id='TravellerEconomydropdown']/div[1]/searchbox/div/ul/li/a/div[2]/strong");
		waitProperty(5000);
		clickByName("dt12");
		waitProperty(3000);//*[@id="owl-dt-picker-0"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[5]/td[5]/span
		clickByXpath("//*[@id='owl-dt-picker-0']/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[5]/td[5]/span");
		waitProperty(3000);
		clickByName("dt13");
		waitProperty(3000);
		clickByXpath("//*[@id='owl-dt-picker-1']/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[4]/td[1]/span");
		
		clickByName("guest");
		waitProperty(3000);
		selectvaluebyName("hotelRoom", "1");
		selectvaluebyName("hotelAdult", "3");
		clickByXpath("//*[@id='user-data-wrapper']/div[2]/button");
		clickByXpath("//*[@id='TravellerEconomydropdown']/div[5]/button");
		waitProperty(2000);
		clickByXpath("/html/body/app-root/app-fulllayout/div/app-hotellist/main/div/div[2]/div/div[2]/div/div/div[3]/button");
		
waitProperty(2000);
  getTextByXpath("/html/body/app-root/app-fulllayout/div/app-hoteldetail/main/div/div/div[2]/h3/a");
       
		getTextByXpath("//*[@id='hotel-dtl-sticky-photo']/div[1]/div[1]/div[2]/div/div/p");
	
		waitProperty(5000);
		clickByXpath("//*[@id='hotel-dtl-sticky-photo']/div[1]/div[1]/div[2]/div/div/div[4]/button");
		
		waitProperty(3000);
		selectvaluebyName("title","2");
		enterByName("firstName", firstnam);
		enterByName("lastName", lastname);
		
		selectvaluebyName("gst", "Yes");
		enterByName("companyName", companyname);
		enterByName("companyAddress", companyaddress);
		clickByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[10]/button[2]");
		
		
		
		verifyTextByXpath("/html/body/app-root/app-fulllayout/div/app-paxdetail/main/div/div[1]/form/div/div[7]/div/span", "gstNumber field is required.");
		
		closeAllBrowsers();
		
		
		
		
		
		
		
	}

}
