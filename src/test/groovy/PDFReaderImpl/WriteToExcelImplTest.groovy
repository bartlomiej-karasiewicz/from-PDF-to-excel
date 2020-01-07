package PDFReaderImpl

import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import spock.lang.Specification

class WriteToExcelImplTest extends Specification {


    def "save data in excel file"(){
        given:
        File file=new File("src/test/resources/all_in_File.pdf")
        PDFLinesExtractor pdfLinesExtractor=new PDFLinesExtractor(file)
        when:
        List<String> lst=pdfLinesExtractor.getLines()
        WriteToExcelImpl.checkPattern(lst)
        then:
        readExcel(new File("excel.xls"))
    }

    def void readExcel(File file){
        FileInputStream fileInputStream = new FileInputStream(file)
        HSSFWorkbook workbook= new HSSFWorkbook(fileInputStream)
        HSSFSheet worksheet=workbook.getSheetAt(0)
        HSSFRow row1=worksheet.getRow(1)
        HSSFCell cellA1=row1.getCell(0)
        String a1Value=cellA1.getStringCellValue()
        HSSFRow row2=worksheet.getRow(1)
        HSSFCell cellB1=row2.getCell(1)
        String b1Value=cellB1.getStringCellValue()
        HSSFRow row3=worksheet.getRow(1)
        HSSFCell cellC1=row3.getCell(2)
        String c1Value=cellC1.getStringCellValue()

        assert a1Value == "PDF File "
        assert b1Value == "PDF File "
        assert c1Value == "DF File "
    }
}
