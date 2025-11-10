package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.ui.pojo.User;

public class ExcelUtility {
	@DataProvider(name = "LoginTestExcelDataProvider")
	public static Iterator<User> readExcelfile(String fileName){
		File file = new File(System.getProperty("user.dir") + "//testData//"+ fileName);
		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		List<User> userList = null;
		Row row;
		Cell emailAddresscell;
		Cell passwordCell;
		User user;
		
		try {
			xssfWorkbook = new XSSFWorkbook(file);
			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator= xssfSheet.iterator();
		    userList = new ArrayList<User>();
		    rowIterator.next();
			while(rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddresscell= row.getCell(0);
				passwordCell = row.getCell(1);
				user =new User(emailAddresscell.toString(), passwordCell.toString());
				userList.add(user);
				xssfWorkbook.close();
				
			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
		
	}
	
	

}
