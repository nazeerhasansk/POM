package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP002 {

	
	@DataProvider(name="fetchdata")
	public static String[][]getdata() throws IOException{
		
		
		String[][] textdata;
		
		FileInputStream fis=new FileInputStream("./testData/TC002.xlsx");
		XSSFWorkbook wb  =new XSSFWorkbook(fis);
	    XSSFSheet sheet    =wb.getSheetAt(0);
        int rowcount       =sheet.getLastRowNum();
	int columncount	       =sheet.getRow(0).getLastCellNum();
		
		System.out.println("rowcount "+rowcount);
		System.out.println("columncount "+columncount);
		
		 textdata = new String[rowcount][columncount];
		for(int i=1; i<=rowcount; i++){
			
			XSSFRow row= sheet.getRow(i);
			for(int j=0; j<columncount; j++){
		String celldata= row.getCell(j).getStringCellValue();
		
		System.out.println("the value of row "+(i-1)+ "value of column "+j+ "is celldata "+celldata);
		
		textdata[i-1][j]=celldata;
			}
			
		}
		return textdata;
		
		
		
	}
	

}
