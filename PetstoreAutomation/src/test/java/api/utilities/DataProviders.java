package api.utilities;

import java.io.IOException;

import org.testng.annotations.*;

public class DataProviders {
	
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		
		XLUtility.loadExcel("Sheet1");
		
		
		String apiData[][]=new String[XLUtility.getRowCount()][XLUtility.getColumnCount(0)];
		
		

		for(int i=1 ; i<=XLUtility.getRowCount();i++) {
			
			
			for(int j=0 ; j<XLUtility.getColumnCount(0);j++) {
				
				
				apiData[i-1][j]=  XLUtility.getCellData(i, j);
				
			}
		}

		
		
		
		
		return apiData;
		
		
		
	}
	
	@DataProvider(name="GetUserName")
	public String[] getAllUsername() {
		
		
		XLUtility.loadExcel("Sheet1");
		
		String username[]=new String[XLUtility.getRowCount()];
		
		
		for(int i=1;i<=username.length;i++) {
			
			username[i-1]=XLUtility.getCellData(i, 1);
		}
		
		
		
		return username;
	
		
		
		
		
	}
	
	

}
