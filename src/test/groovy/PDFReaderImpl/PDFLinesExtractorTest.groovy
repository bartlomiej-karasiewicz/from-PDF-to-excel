package PDFReaderImpl

import spock.lang.Ignore
import spock.lang.Specification

@Grab('cglib:cglib:3.1')
@Grab('org.ow2.asm:asm-all:5.0.3')
class PDFLinesExtractorTest extends Specification {

    @Ignore
    def "Extract lines from PDF"(){
        given:
        def mockFile=Mock(File)
        PDFLinesExtractor pdfLinesExtractor=new PDFLinesExtractor(mockFile)
        List<String> arr=[]

        when:
        pdfLinesExtractor.getLines() >> arr

        then:
        arr.size()>1
    }
}
