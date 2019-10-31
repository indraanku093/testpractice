package com.servicenow.retryfailedtest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryfailed implements IRetryAnalyzer
{
	private int recount=0; 
	private	int	maxrecount=2;
	
	@Override
	
	public boolean retry(ITestResult result) 
	{
		
		if (recount < maxrecount) 
		{
            
            System.out.println("please rerun" + result.getName());
			recount++;
            return true;
        }
		return false;
	}

}
