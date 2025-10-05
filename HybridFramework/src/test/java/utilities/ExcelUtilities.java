package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	
	public String filePath;
	public FileInputStream in=null;
	public XSSFWorkbook wb = null;
	public XSSFSheet sheet = null;
	DataFormatter df = null;
	String[][]  data = null;
	ExcelUtilities(String filePath){
		this.filePath=filePath;
	}
	
	
	public String[][] getData(String SheetName) throws IOException{
		
		try {
		
      in = new FileInputStream(filePath);
	  wb = new XSSFWorkbook(in);
	  sheet = wb.getSheet(SheetName);
	  df = new DataFormatter();
	  int rows =sheet.getLastRowNum();
	  int cols = sheet.getRow(0).getLastCellNum();
	  String[][] data = new String[rows][cols];
	
	  for(int i=1;i<=rows;i++) {
		  for(int j =0;j<cols;j++) {
			 
			  data[i-1][j]= df.formatCellValue(sheet.getRow(i).getCell(j));
			  
		  }
	  }
	  
		return data;}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			in.close();
			wb.close();
		}
		return null;
	}

}
