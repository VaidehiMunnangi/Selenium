package day8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven {

	@Test(dataProvider="data")
	public void printDetails(String a,int b) {		
		System.out.println("a: " + a + "  and b: " + b );
	}
	
	@DataProvider
	public Object[][] data() {
		Object[][] values = new Object[5][2];
		
		values[0][0] = "First";
		values[0][1] = 1;
	
		values[1][0] = "Second";
		values[1][1] = 2;
		
		values[2][0] = "Third";
		values[2][1] = 3;
		
		values[3][0] = "Fourth";
		values[3][1] = 4;
		
		values[4][0] = "Fifth";
		values[4][1] = 5;
		
		return values;
		
	}
}
