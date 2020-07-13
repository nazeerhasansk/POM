package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP006 {
	@DataProvider(name="fetchdata")
	public static String[][]getdata() throws IOException{
		
		String[][] testdata;
		
		FileInputStream fid=new FileInputStream("./testData/TC006.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fid);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowcount =sheet.getLastRowNum();
		int columncount=sheet.getRow(0).getLastCellNum();
		
		System.out.println("rowcount "+rowcount+" columncount "+columncount);
		
		testdata=new String [rowcount][columncount];
		
		for(int i=1;i<=rowcount;i++){
			XSSFRow rw=sheet.getRow(i);
			for(int j=0;j<columncount;j++){
				String celldata =rw.getCell(j).getStringCellValue();
				System.out.println("the value of i "+(i-1)+"  value of j "+j+" celldata "+celldata);
				
				testdata[i-1][j]=celldata;
			}
		}
			
		
		return testdata;
	}

}
