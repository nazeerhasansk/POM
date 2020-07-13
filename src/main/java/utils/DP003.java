package utils;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP003 {
	@DataProvider(name="fetchdata")
public static String[][]getdata() throws IOException{
	
	String[][] testdata;
	
	FileInputStream fis=new FileInputStream("./testData/TC003.xlsx");
	          XSSFWorkbook wb=new XSSFWorkbook(fis);
	          XSSFSheet sheet=  wb.getSheetAt(0);
	        		  int rowcount= sheet.getLastRowNum();
	        		  int columncount=sheet.getRow(0).getLastCellNum();
	testdata=new String[rowcount][columncount];
	System.out.println("rowcount "+rowcount+" columncount "+columncount);
	
	for(int i=1; i<=rowcount; i++){
		
		XSSFRow row= sheet.getRow(i);
		for(int j=0; j<columncount; j++){
	String celldata= row.getCell(j).getStringCellValue();
	
	System.out.println("the value of row "+(i-1)+ "value of column "+j+ "is celldata "+celldata);
	
	testdata[i-1][j]=celldata;
		}
		
	}
		
		
		
		
	
	
	

	
	return testdata;
	
	
}
}
