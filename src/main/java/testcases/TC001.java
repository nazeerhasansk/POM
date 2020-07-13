package testcases;




import org.testng.annotations.Test;

import utils.DP001;
import wrappers.GenericWrappers;

public class TC001 extends GenericWrappers{
	
	
@Test(dataProvider="fetchingdaata",dataProviderClass=DP001.class)
	public void irctcSignUp(String username,String password,String confmpassword,String SecurityAnswer,String fname,String mname,String lname,String dob,String email,String isdmobile,String flat,String street,String area,String pincode,String resphon,String flatno,String streetno,String areaname,String pincoden,String phonen){
	invokeApp("chrome", "https://www.irctc.co.in");
	
	
	clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div[2]/div/form/div[2]/button");
	
	clickByLink("REGISTER");
	
	enterById("userName", username);
	enterById("usrPwd", password);
	enterById("cnfUsrPwd", confmpassword);
	clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[4]/div[2]/p-dropdown/div/label");
	waitProperty(5000);
	clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[4]/div[2]/p-dropdown/div/div[4]/div/ul/li[3]/span");
	enterByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[4]/div[4]/input", SecurityAnswer);
	clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[5]/div[2]/p-dropdown/div/label");
	clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[5]/div[2]/p-dropdown/div/div[4]/div/ul/li[1]");
	//personal details
	enterById("firstName", fname);
	enterById("middleName",mname);
	enterById("lastname",lname);
	clickById("M");
	clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[9]/div[2]/p-calendar/span/input");
enterByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[9]/div[2]/p-calendar/span/input", dob);
waitProperty(8000);
clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[9]/div[2]/p-calendar/span/div/table/tbody/tr[5]/td[4]/a");
//*[@id="divMain"]/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[9]/div[4]/p-dropdown/div/label
 
	clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[9]/div[4]/p-dropdown/div/label");
	clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[9]/div[4]/p-dropdown/div/div[4]/div/ul/li[4]/span");
	clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[10]/div[2]/label[2]/input");
	selectvaluebyXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[11]/div[2]/select","94");
	enterById("email",email );
	enterById("mobile", isdmobile);
	selectvaluebyXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[12]/div[5]/select", "94");
	//residential address
	enterById("resAddress1",flat);
	enterById("resAddress2", street);
	enterById("resAddress3", area);
	//enterByName(, "500041");
	keyboardKeysTabbyName("resPinCode", pincode);
	
	waitProperty(5000);
	selectIndexbyxpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[16]/div[4]/select", 1);
	waitProperty(5000); //*[@id="divMain"]/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[17]/div[2]/select
	selectvaluebyXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[17]/div[2]/select", "Raj Bhawan S.O (Hyderabad)");
	enterById("resPhone", resphon);
	clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[18]/div[3]/input");
	//office address
	enterByName("offAddress1", flatno);
	enterByName("offAddress2", streetno);
	enterByName("offAddress3", areaname);
	selectvaluebyXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[19]/div[3]/div[4]/select", "94");
	keyboardKeysTabbyName("offPinCode", pincoden);
	waitProperty(5000);
	
	selectIndexbyxpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[19]/div[5]/div[2]/select", 1);
	waitProperty(5000);
	selectIndexbyxpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[19]/div[5]/div[4]/select",6);
	waitProperty(5000);
	enterById("offPhone", phonen);
	clickByXpath("//*[@id='divMain']/div/app-user-registration/div[2]/div/div[2]/div[5]/form/div[22]/div");
	
	closeAllBrowsers();		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


}
	

