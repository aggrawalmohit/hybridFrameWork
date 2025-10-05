package utilities;

import java.io.IOException;

public class DataProvider {
	
	@org.testng.annotations.DataProvider(name = "loginData")
	public String[][] LoginData() throws IOException {
		
		ExcelUtilities ex = new ExcelUtilities(
				"/Users/mohitaggrawal/Documents/java/HybridFramework/testData/LoginData.xlsx");
		
	return	ex.getData("LoginData");
		
		
		
	}

}
