package utilities;
import java.io.FileInputStream; 
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelUtils {
	 Workbook wb;  
	 Sheet sh;    
	 Row row;  
	 Cell cell;
	
	 public void SetExcelFile(String path, String SheetName){
		try{
			FileInputStream f = new FileInputStream (path);
			 
			if(path.endsWith("xlsx"))     
				wb = new XSSFWorkbook(f);
			else if(path.endsWith("xls")) 
				wb = new HSSFWorkbook(f);
			else { 
				f.close(); 
				throw new Exception("invalid file name, should be xls or xlsx"); 
			}		
		    sh = wb.getSheet(SheetName);  
		 }catch(Exception e) {}
	 }
	
	 public int CountRows() { return sh.getLastRowNum()+1; }
	 public int CountCols() { return sh.getRow(0).getLastCellNum(); }
	 
	 public String getCellData(int row, int col) {
			cell=sh.getRow(row).getCell(col);
				 
			if(cell.getCellType()==CellType.STRING)   return cell.getStringCellValue();  
			if(cell.getCellType()==CellType.BOOLEAN)  return String.valueOf(cell.getBooleanCellValue());
				 
		    else if(cell.getCellType()==CellType.NUMERIC) {
				if(DateUtil.isCellDateFormatted(cell)) {
					 Date date = cell.getDateCellValue();
					 SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yy"); 
				     return ft.format(date);   }			 
		        return String.valueOf((int)cell.getNumericCellValue()); }	
		    
		    return null; 
		}
 }