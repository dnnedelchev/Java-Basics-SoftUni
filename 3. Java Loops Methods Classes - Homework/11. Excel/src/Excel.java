import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excel {
	public static void main(String args[]) {
		Locale.setDefault(Locale.ROOT);
		SortedMap<String, Double> report = new TreeMap<String, Double>();
			
		try {
			InputStream file = new FileInputStream("3. Incomes-Report.xlsx");
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheetAt(0);
				int rows = sheet.getLastRowNum();

		        for (int i = 1; i <= rows; i++) {
		        	XSSFRow row = sheet.getRow(i);
		        	XSSFCell cell = row.getCell(0);
		        	String office = cell.toString();
		        	cell = row.getCell(5);
		        	Double totalIncome = cell.getNumericCellValue();
		        	if (report.containsKey(office)){
		        		report.put(office, report.get(office) + totalIncome);
		        	}
		        	else
		        		report.put(office, totalIncome);
		        }
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		DecimalFormat formatter = new DecimalFormat("#0.00");
		double totalIncome = 0;
		
		for (Entry<String, Double> rep : report.entrySet()) {
			String officeName = rep.getKey();
			Double income = rep.getValue();
			totalIncome += income;
			System.out.println(officeName + " -> " + formatter.format(income));
		}
		System.out.println("Grand Total: -> " + formatter.format(totalIncome));
	}

}

