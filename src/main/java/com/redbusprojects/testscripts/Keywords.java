package com.redbusprojects.testscripts;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.redbusprojects.excelReader.Xls_Reader;
import com.redbusprojects.testbase.TestBase;


public class Keywords extends TestBase{
	
	public static Xls_Reader xls = new Xls_Reader(
			System.getProperty("user.dir") + "/src/main/java/com/redbusprojects/testdata/Test Suite1.xlsx");
	static Keywords k;
	public static final Logger log = Logger.getLogger(Keywords.class.getName());
	
	public void executeReport(String testcases, Hashtable<String, String> data) throws Exception{
		loadproperties();
		PropertyConfigurator.configure("log4j.properties");
		
		System.out.println("Execute test case name:"+testcases);
		String keyword = null;
		String objectKeys =null;
		String dataKeys = null;
		for(int rNum=2;rNum<=xls.getRowCount("Test Steps");rNum++){
			if(testcases.equals(xls.getCellData("Test Steps", "TCID", rNum))){
				keyword = xls.getCellData("Test Steps", "Keyword", rNum);
				objectKeys = xls.getCellData("Test Steps", "Object", rNum);
				dataKeys = xls.getCellData("Test Steps", "Data", rNum);
				
				System.out.println("Test Steps is :"+keyword+"-"+objectKeys+"-"+dataKeys);
				
				ApplicationDependKeywords appdependkeyword=new ApplicationDependKeywords();
				GeneralKeywords generickeyword = new GeneralKeywords();
				String result = null;
				switch (keyword) {
				
				case "openBrowser":
					result = generickeyword.openBrowser(objectKeys);
					break;
				case "navigateURL":
					result = generickeyword.navigateURL(objectKeys);
					break;
				case "verifyLink":
					result = generickeyword.verifyLink(objectKeys);
					break;
				case "click":
					result = generickeyword.click(objectKeys);
					break;
				case "swichToFrame":
					result = generickeyword.swichToFrame(objectKeys);
					break;
				case "input":
					result = generickeyword.input(objectKeys,data.get(dataKeys));
					break;
					
				default:
					break;
				}
			}
		}
	}

	public static Keywords getInstance(){
		
		if(k==null){
			
			try{
				k = new Keywords();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return k;
		
		
	}
}
