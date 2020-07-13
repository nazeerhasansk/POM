package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP007 {
	@DataProvider(name="fetchdata")
	public static String[][]getdata() throws IOException{
		String[][] textdata;
		
		FileInputStream fil=new FileInputStream("./testData/TC007.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fil);
		
		XSSFSheet sh= wb.getSheet("Sheet1");
	   int rowcount   =	sh.getLastRowNum();
	   int columncount =sh.getRow(0).getLastCellNum();
		System.out.println("rowcount "+rowcount+" columncount "+columncount);
		textdata=new String[rowcount][columncount];
		
		for(int i=1;i<=rowcount;i++){
			XSSFRow row=sh.getRow(i);
			for(int j=0;j<columncount;j++){
	      String celldata=	row.getCell(j).getStringCellValue();
	      
	      System.out.println("the value of i "+(i-1)+" thevalue of j " +j+ "is celldata "+celldata);
	      
	      textdata[i-1][j]=celldata;
	      
			}
			
		}
		
		return textdata;
		
	}

}
