package com.servicenow.testscripts.incident;

import org.testng.annotations.Test;

import com.servicenow.pagerepo.onelogin;
import com.servicenow.utility.Baselib;

public class testinc extends Baselib

{

	@Test(priority=1)
	public void openinc() throws Exception
	{
	
		
		System.out.println("Incident open");
		Thread.sleep(4000);
		onelogin.data(10,6,"IncidentTestcases", "Incident Module" );
	}
	
	@Test(priority=2)
	public void statepending() throws Exception
	{
		
		System.out.println("state pending");
		Thread.sleep(4000);
		onelogin.data(18,6,"IncidentTestcases", "Incident Module" );
		
	}
	
	@Test(priority=3)
	public void stateresolved() throws Exception
	{
		
		System.out.println("state resolved");
		Thread.sleep(4000);
		onelogin.data(32,6,"IncidentTestcases", "Incident Module" );
	}
}
