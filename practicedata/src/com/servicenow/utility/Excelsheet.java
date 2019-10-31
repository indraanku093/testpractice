package com.servicenow.utility;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Excelsheet 
{
	
	

	public static String dataread(int i, int j, String shpath, String shname) throws Exception, IOException 
		{
		
		File file = new File ("./testdata/"+shpath+".xlsx");
		FileInputStream fileinputstream = new FileInputStream(file);
		Workbook w= WorkbookFactory.create(fileinputstream);
		String data = w.getSheet(shname).getRow(i).getCell(j).getStringCellValue();
		//Decoded date
	   
		return data;
	}

	public static int datawrite(int i, int j, String id, String shpath, String shname) throws EncryptedDocumentException, IOException
	{

		File file = new File("./testdata/"+shpath+".xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(shname);
		while(sh.getRow(i)!=null)
		{i++;}
		
		Row r = sh.createRow(i);
		Cell c = r.createCell(j);
		c.setCellType(CellType.STRING);
		c.setCellValue(id);
		FileOutputStream fos= new FileOutputStream(file);
		wb.write(fos);
		return i;
	}
	
	public static void datareadcond(String shpath, String shname, String tid, int i, int j) throws EncryptedDocumentException, IOException
	{
		File file = new File("./testdata/"+shpath+".xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		int length = wb.getSheet(shname).getLastRowNum();
		System.out.println(length);
		for(; i<j; i++)
		{	
				
				
					String value = wb.getSheet(shname).getRow(i).getCell(5).getStringCellValue();
					Reporter.log(value);
				    i++;
			
		
		}
	}
	
	public static void datawritenormal(int i, int j, String shpath, String status, String shname) throws EncryptedDocumentException, IOException
	{

		File file = new File("./testdata/"+shpath+".xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(shname);
		Row r = sh.getRow(i);
		Cell c = r.createCell(j);
		c.setCellType(CellType.STRING);
		c.setCellValue(status);
		FileOutputStream fos= new FileOutputStream(file);
		wb.write(fos);
	}
}
	
