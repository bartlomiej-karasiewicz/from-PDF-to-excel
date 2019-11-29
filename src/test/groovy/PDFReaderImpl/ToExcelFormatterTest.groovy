package PDFReaderImpl

import spock.lang.Specification


class ToExcelFormatterTest extends Specification {


    def "adding nulls as String at the end of the list"(){
        given:
        File file=new File("src/test/resources/pa20_file.pdf")
        PDFLinesExtractor pdfLinesExtractor=new PDFLinesExtractor(file)
        ToExcelFormatter toExcelFormatter=new ToExcelFormatter(pdfLinesExtractor.getLines())
        expect:
        ["PDF_file  " ,"pa20 " ,"null","null"]==toExcelFormatter.paddedForExcel()
    }
}
