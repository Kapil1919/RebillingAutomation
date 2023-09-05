package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtils {
	
	//create instance of an workbook interface 
	Workbook wb;
	
	
	
	//constructor block of the class
	public ExcelFileUtils() throws Throwable {
		
		//create instance of File input stream class
		 
		
		 FileInputStream fi = new FileInputStream("E:\\New Project\\Project_Rebilling\\TestInput\\InputFile.xlsx");
		
		 wb = new XSSFWorkbook(fi);
                 
		
		
		
	}
		
		//count no. of rows
		public int rowCount(String sh) {
			
			
			return wb.getSheet(sh).getLastRowNum();

			
		}
		
		//count no. of columns
		public int colCount(String sheetname) {
			
			return wb.getSheet(sheetname).getRow(0).getLastCellNum();
			
		}
		
		//To get the data from the cell
		public String getData(String sheetname, int row, int col) {
			
		String data = "";
		
		if(wb.getSheet(sheetname).getRow(row).getCell(col).getCellType() == CellType.NUMERIC) {
		
			//if the cell data is numeric.
		 int celldata = (int) wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
		 data = String.valueOf(celldata);
		
		}
		
		else
		 {
			
			
			data = wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
			
			
		}
		
		return data;
		
		
		
		}
		
			
		//To set the data from the cell
			 public void setData(String sheetname, int row, int col, String status) throws Throwable {
				 
				 Sheet sh = wb.getSheet(sheetname);
				 Row r = sh.getRow(row);
				 Cell cell = r.createCell(col);
				 cell.setCellValue(true);
				 
				 
				 //if the test case is passed.
				 if(status.equalsIgnoreCase("PAAS")){
					 
					 
					 CellStyle cs = wb.createCellStyle();
					 Font f = wb.createFont();
					 f.setColor(IndexedColors.GREEN.getIndex());
					 
					 f.setBold(true);
					 cs.setFont(f);
					 
					r.getCell(col).setCellStyle(cs);
					
				 }
					
					
					//if the test case is failed
					
					if(status.equalsIgnoreCase("FAIL")) {
						
						CellStyle cs = wb .createCellStyle();
						Font f = wb.createFont();
						f.setColor(IndexedColors.RED.getIndex());
						
						f.setBold(true);
						cs.setFont(f);
						
						r.getCell(col).setCellStyle(cs);
					
						
						
					}
					
					//if the test case is not executed
					
					if(status.equalsIgnoreCase("NOT EXECUTED")) {
						
						CellStyle cs = wb.createCellStyle();
						Font f = wb.createFont();
						f.setColor(IndexedColors.BLUE.getIndex());
						
						f.setBold(true);
						cs.setFont(f);
						
						r.getCell(col).setCellStyle(cs);
						
						
					}
					 
					FileOutputStream fo = new FileOutputStream("E:\\New Project\\Project_Rebilling\\TestOutput\\DataDriven.xlsx"); 
					wb.write(fo);
					fo.close();
					 
				 }
			 
			
			 
				
				 
			 }
			 
			 
			 
			
			 
		
