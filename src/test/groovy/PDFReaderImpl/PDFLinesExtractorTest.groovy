package PDFReaderImpl

import spock.lang.Specification


class PDFLinesExtractorTest extends Specification {

    def "extract lines from PDF"(){
        given:
        File file=new File("src/test/resources/dummy.pdf")
        PDFLinesExtractor pdfLinesExtractor=new PDFLinesExtractor(file)
        List<String> getLines= new ArrayList<>()
        when:
        getLines << pdfLinesExtractor.getLines()
        then:
        getLines.size()>=1

    }
}
