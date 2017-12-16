package com.redbusprojects.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.redbusprojects.testscripts.Keywords;
import com.redbusprojects.testutils.TestUtils;

public class TC_001LoginPage {

	
	@Test(dataProvider="getData")
	public void loginpagetestcase(Hashtable<String, String> data) throws Exception{
		
		if(!TestUtils.isTestcasesExecutable("loginpagetestcase", Keywords.xls))
			throw new SkipException("This is test cases run mode is no ");
		
		if(!data.get("Runmode").equals("Y"))
			throw new SkipException("this is test data rumode is no");
		
		Keywords k = Keywords.getInstance();
		k.executeReport("loginpagetestcase", data);
	}
	
	@DataProvider
	public Object[][] getData(){
		return TestUtils.getData("loginpagetestcase", Keywords.xls);
		
		
	}
}
