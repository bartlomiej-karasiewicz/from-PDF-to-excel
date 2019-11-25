package PDFReaderImpl;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WriteToExcelImpl {
	private static final String REF_PATTERN = "ref\\s*:";

	static void checkPattern(List<String> lines) {
		Pattern p = Pattern.compile(REF_PATTERN);
		Matcher m;
		List<Parameters> listOfObjects = new ArrayList<Parameters>();
		try {
			for (String str : lines) {
				m = p.matcher(str);
				if (m.find()) {
					listOfObjects.add(
							new Parameters(str.substring(7), lines.get(lines.size() - 2), lines.get(lines.size() - 1)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToExcel(listOfObjects);
	}

	private static void writeToExcel(List<Parameters> listOfObjects) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("excel.xls"));
			HSSFSheet worksheet = workbook.getSheetAt(0);
			int lastRow = worksheet.getLastRowNum();
			for (Parameters par : listOfObjects) {
				HSSFRow row = worksheet.createRow(++lastRow);
				int cellIndex = 0;
				row.createCell(cellIndex++).setCellValue(par.getRegex());
				row.createCell(cellIndex++).setCellValue(par.getBeforeLastLine());
				row.createCell(cellIndex++).setCellValue(par.getLastLine());
				workbook.write(new FileOutputStream("excel.xls"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
