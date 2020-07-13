package testcases;



import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class TC010 extends GenericWrappers{
@Test
	public void formC(){
	
	invokeApp("chrome", "https://indianfrro.gov.in/frro/FormC/menuuserreg.jsp");
		
clickByXpath("/html/body/table/tbody/tr[1]/td/center[1]/table/tbody/tr[1]/td/a");
	switchToLastWindow();
	enterByName("u_id", "nazeerhasan22");
	enterById("u_pwd", "Mohammed789");
	enterById("u_repwd", "Mohammed789");
	waitProperty(4000);
		selectVisibileTextById("u_secques"," What is the name of the hospital where you were born?");
		enterById("u_secans", "chinatqalpudi hospital");
		enterById("u_name", "nazee");
		waitProperty(4000);
		selectVisibileTextById("u_gender", " Male");
		enterById("u_dob", "31/10/1990");
		enterById("u_designation", "engineer it");
		enterById("u_emailid", "nazeer@gmail.com");
		enterById("u_mobile","9390577062");
		waitProperty(4000);
		selectVisibileTextById("u_nationality", "INDIA");
	enterById("name", "santinikentan");
	enterById("capacity", "10");
	enterById("address","miyapur");
	waitProperty(3000);
	selectVisibileTextById("state", "ANDHRA PRADESH");
		waitProperty(3000);
		selectvaluebyName("city_distr", "6D");
		waitProperty(3000);
		selectvaluebyName("acco_type", "GH");
		waitProperty(5000);
		selectvaluebyName("star_rat", "5s");
		enterByName("email", "nazee@gmail.com");
		enterById("mcontact", "9390577062");
		enterById("contact", "9390577062");
		enterByName("name_o", "nazeerrrrrrr");	
		enterByName("address_o", "atmakur");
		selectvaluebyName("state_o", "1");
		waitProperty(3000);
		selectvaluebyName("citydistr_o", "1D");
		
		enterByName("emailid_o", "kkkkarimu@gmail.com");
		enterByName("phoneno_o", "9014333318");
		
		enterByName("mobile_o", "9014338818");
		clickByName("add");
		
		enterByName("name_o", "hamamamma");
		enterByName("address_o", "humayunanagr");
		selectVisibileTextById("state_o", " KERALA");
		waitProperty(3000);
		selectvaluebyName("citydistr_o", "6D");
		enterByName("emailid_o", "nn@gmail.com");
		enterByName("phoneno_o", "");
		enterByName("mobile_o", "999012312");
		closeAllBrowsers();
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
