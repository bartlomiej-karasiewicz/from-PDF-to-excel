package PDFReaderImpl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.EncryptedDocumentException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class PDFLinesExtractor {

    private File file;

    PDFLinesExtractor(File file) {
        this.file = file;
    }

    List<String> getLines() {
        try (PDDocument document = PDDocument.load(file)) {
            if (document.isEncrypted()) {
                throw new EncryptedDocumentException("The document is encrypted");
            }
            String documentText = new PDFTextStripper().getText(document);
            return documentText.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }
}
