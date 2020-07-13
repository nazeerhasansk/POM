package testcases;



import org.testng.annotations.Test;

import utils.DP002;
import wrappers.GenericWrappers;

public class TC003 extends GenericWrappers{
	@Test(dataProvider="fetchdata",dataProviderClass=DP002.class)
	public void nationalVoterServicesPortal(String userid,String password,String cpassword,String data,String dob,String email,String fname,String mname,String lname,String fname1,String mname1,String lname1,String fno,String st,String area,String mnum,String pcode,String foffice,String soffice,String aoffice,String phnnum,String pccode){
	
		invokeApp("chrome", "https://irctc.co.in");
	clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div[2]/div/form/div[2]/button");
		clickByLink("STAYS");
		clickByLink("Lounge");
		switchToLastWindow();
		clickByXpath("/html/body/app-root/homeheader/nav/div/div[2]/a[3]/i");
		waitProperty(5000);
		clickByLink("Book Your Coach/Train");
		switchToLastWindow();
		waitProperty(5000);
		clickByLink("New User? Signup");
		waitProperty(5000);
		enterById("userId", userid);
		enterById("password", password);
		enterById("cnfPassword", cpassword);

		selectvaluebyName("secQstn", "0");
	enterByName("secAnswer", data);
	//dateof birth
	  enterById         ("dateOfBirth", dob);
	  waitProperty(5000);
	  clickByLink("31");
		waitProperty(5000);
		clickByXpath("//*[@id='gender0']");
		clickByXpath("//*[@id='maritalStatus0']");
		waitProperty(2000);
		enterById("email",email);
		selectIndexById("occupation",8);
		enterById("fname", fname);
		enterById("mname", mname);
		enterById("lname", lname);
		selectvaluebyName("occupation", "TravelAgent");
		enterById("fname", fname1);
		enterById("mname", mname1);
		enterById("lname", mname1);
		selectVisibileTextById("natinality", "Indian");
		enterById("flatNo", fno);
		enterById("street", st);
		enterById("area", area);
		selectIndexById("country",1);
		waitProperty(5000);
		enterById("mobile", mnum);
		enterByName("pincode", pcode);
		keyboardKeysTabbyid("pincode");
		waitProperty(5000);
		selectIndexById("city", 1);
		waitProperty(5000);
		selectIndexById("state", 1);
		selectIndexById("postOffice", 1);
		clickByXpath("//*[@id='sameAddresses1']");
		enterById("flatNoOffice", foffice);//
		enterById("streetOffice", soffice);
		enterById("areaOffice", aoffice);
		selectIndexById("countryOffice", 1);
		waitProperty(5000);
		enterById("mobileOffice", phnnum);
		enterById("pincodeOffice", pccode);
		keyboardKeysTabbyid("pincode");
		waitProperty(5000);
		selectIndexById("cityOffice", 1);
		waitProperty(5000);
		selectIndexById("stateOffice", 1);
		waitProperty(5000);
		selectIndexById("postOfficeOffice", 1);
		closeAllBrowsers();
		
		
		
	}

}
