package PDFReaderImpl

import org.apache.poi.EncryptedDocumentException
import spock.lang.Ignore
import spock.lang.Specification


class PDFLinesExtractorTest extends Specification {

    def "should extract lines from PDF"(){
        given:
        File file=new File("src/test/resources/pdf_file.pdf")
        PDFLinesExtractor pdfLinesExtractor=new PDFLinesExtractor(file)
        expect:
        ["PDF_file "]==pdfLinesExtractor.getLines()
    }
    @Ignore
    def "should throw exception when extract lines from PDF with password"(){
        given:
        File file=new File("src/test/resources/encrypted.pdf")
        PDFLinesExtractor pdfLinesExtractor=new PDFLinesExtractor(file)
        when:
        pdfLinesExtractor.getLines()
        then:
        thrown (EncryptedDocumentException)

    }
}
