package PDFReaderImpl

import org.apache.poi.EncryptedDocumentException
import spock.lang.Specification


class PDFLinesExtractorTest extends Specification {

    def "should extract lines from PDF"(){
        given:
        File file=new File("src/test/resources/pdf_file.pdf")
        PDFLinesExtractor pdfLinesExtractor=new PDFLinesExtractor(file)
        expect:
        ["PDF_file "]==pdfLinesExtractor.getLines()
    }
    def "should throw exception during extract lines when PDF is with password"(){
        given:
        File file=new File("src/test/resources/encry-protected.pdf")
        PDFLinesExtractor pdfLinesExtractor=new PDFLinesExtractor(file)
        when:
        pdfLinesExtractor.getLines()
        then:
        thrown (EncryptedDocumentException)
    }
    def "should throw exception during extract lines when file is broke"(){
        given:
        File file=new File("src/test/resources/IOException.pdf")
        PDFLinesExtractor pdfLinesExtractor=new PDFLinesExtractor(file)
        when:
        List<String> listOfStrings= pdfLinesExtractor.getLines()
        then:
        listOfStrings.isEmpty()
    }
}
