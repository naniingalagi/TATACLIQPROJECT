package com.GenricUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class use to only for excel specific common method
 * @author CHANDAN KUMARa
 *
 */
public class MsExcelUtility {
	 public Workbook wb=null;
	
	/**
	 * This method use to open the excel
	 * @param filepath
	 * @throws IOException
	 */
	public void openExcel(String filepath) throws IOException {
		FileInputStream fisExcel= new FileInputStream(filepath);
		wb = WorkbookFactory.create(fisExcel);
	}
	/**
	 * This method use to fetch the data from the excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @throws IOException 
	 */

	public  String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws IOException {
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();

		return data;
	}
	/**
	 * This method use to save data inside the excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param message
	 * @param filePath
	 * @throws IOException
	 */
	
	public void createRow(String sheetName,int rowNum,int cellNum,String message) {
		wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(message);
	}

	public  void setDataintoExcel(String sheetName,int rowNum,int cellNum,String message) throws IOException {
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(message);

	}

	/**
	 * This method use to save data into the excel
	 * @throws IOException
	 */
	public  void saveExcel(String savefilePath) throws IOException {

		FileOutputStream fosExcel = new FileOutputStream(savefilePath);
		wb.write(fosExcel);
		}
	/**
	 * THis method use to close the workbook
	 */
	public  void closeExcel() {
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("while close Excel some exception occured...please check the utility");
		}
	}
	/**
	 * This method use to fetch the multiple data from excel
	 * @param sheet
	 * @return
	 */

	public  Object[][] getMultipleDataFromExcel(String sheet) {
	Sheet sh = wb.getSheet(sheet);
		
		Object[][] arr=new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
		
		for(int i=0;i<=sh.getLastRowNum();i++) {
			
			for(int  j=0;j<sh.getRow(i).getLastCellNum();j++) {
				
				
				
				arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}
	
}
