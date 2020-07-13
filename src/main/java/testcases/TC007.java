package testcases;


import org.testng.annotations.Test;

import utils.DP005;
import wrappers.GenericWrappers;

public class TC007 extends GenericWrappers{
       @Test (dataProvider="fetchdata",dataProviderClass=DP005.class)
    		   
    		   
	public void bookhillRails(String mail,	String numb,String name,String mname,String nname,String age,String wname,String wcname,String wage,String rel,String pnumb ,String cnumb,String dnumbr,String loc,String mnc,String ppp){

		
		invokeApp("chrome", "https://irctc.co.in");
	clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div[2]/div/form/div[2]/button");
		clickByLink("STAYS");
		clickByLink("Lounge");
		switchToLastWindow();
		clickByXpath("/html/body/app-root/homeheader/nav/div/div[2]/a[3]/i");
		clickByLink("Hill Railways");
		switchToLastWindow();
		clickByXpathNoSnap("//*[@id='test2']/div[1]/h3/a[3]");
		switchToLastWindow();
		clickByXpathNoSnap("/html/body/app-root/ng-component/div/div/div/div/a");
		switchToLastWindow();
		
		keyboardkeysArrowDownbyxpath("//html/body");
		waitProperty(3000);
	selectvisibleTextbyName("country", "18-JUN-20");
		waitProperty(5000);
		selectvisibleTextbyName("boardst", "SALEM JN");
		waitProperty(3000);
		clickByXpath("/html/body/app-root/tourpackagebooking/main/div/section/div/div/div/div[3]/form/div[3]/button");
		
		selectvaluebyXpath("//*[@id='selectID0']", "1: Object");
		waitProperty(5000);
		clickByXpath("/html/body/app-root/tourpackagebooking/main/div/section/div/div/div/div[3]/form/div[4]/button");
		waitProperty(5000);
		clickByLink("Guest User Login");
		waitProperty(5000);
		enterByName("email", mail);
		enterByName("mobileNo", numb);
		waitProperty(3000);
		clickByXpath("//*[@id='gulogin-form']/div/div[3]/button");
		keyboardkeysArrowDownbyxpath("//html/body");
		keyboardkeysArrowDownbyxpath("//html/body");
		enterByName("item.firstName", name);
		enterByName("item.lastName", mname);
		enterByXpath("/html/body/app-root/passangers/main/div/section/div/div/form/div/div[3]/table/tbody/tr[1]/td[3]/span/input", age);
		selectvaluebyName("item.gender", "Male");
		waitProperty(2000);
		enterByXpath("/html/body/app-root/passangers/main/div/section/div/div/form/div/div[3]/table/tbody/tr[2]/td[2]/div/div[1]/input", wname);
		enterByXpath("/html/body/app-root/passangers/main/div/section/div/div/form/div/div[3]/table/tbody/tr[2]/td[2]/div/div[2]/input", wcname);
		enterByXpath("/html/body/app-root/passangers/main/div/section/div/div/form/div/div[3]/table/tbody/tr[2]/td[3]/span/input", wage);
	selectvaluebyXpath("/html/body/app-root/passangers/main/div/section/div/div/form/div/div[3]/table/tbody/tr[2]/td[4]/select", "Female");
		keyboardkeysArrowDownbyxpath("//html/body");
		keyboardkeysArrowDownbyxpath("//html/body");
		enterByName("nomineeName", nname);
		enterByName("RelationwithPassenger", rel);
		enterByName("contactNo", pnumb);
		selectvaluebyName("gstFlag", "No");
		waitProperty(3000);
		keyboardkeysArrowDownbyxpath("//html/body");
		keyboardkeysArrowDownbyxpath("//html/body");
		keyboardkeysArrowDownbyxpath("//html/body");
		enterByName("phoneNo", cnumb);
		enterByName("faxNo", dnumbr);
		enterByName("address", loc);
		enterByName("street", mnc);
		selectvaluebyName("country", "India");
		waitProperty(5000);
		selectvaluebyName("state", "ANDHRA PRADESH");
		waitProperty(3000);
		selectvaluebyName("idcardType", "6");
		
		enterByName("idcardno", ppp);
		clickByXpathNoSnap("/html/body/app-root/passangers/main/div/section/div/div/form/div/div[7]/button[2]");
		waitProperty(5000);

keyboardkeysArrowDownbyxpath("//html/body");
keyboardkeysArrowDownbyxpath("//html/body");
keyboardkeysArrowDownbyxpath("//html/body");
String amount=		getTextByXpath("/html/body/app-root/summery/main/div/section/div/div/form/div/div[5]/div[2]/div/table/tbody/tr[4]/td[2]");
System.out.println("Amount: "+amount);	
		clickByXpath("/html/body/app-root/summery/main/div/section/div/div/form/div/div[6]/div/div/label/span");
		waitProperty(3000);
		clickByXpath("/html/body/app-root/summery/main/div/section/div/div/form/div/div[7]/button[2]");
		waitProperty(5000);
	String attribute=	getAttributebyXpath("//*[@id='payform']/div/div/div/div/div[2]/input", "value");
	System.out.println("Transaction: "+attribute);
	
	verifygetattributebyXpath("//*[@id='payform']/div/div/div/div/div[2]/input", "value", "1250");
	closeAllBrowsers();
	
	
		
	}
}
