package PDFReaderImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.util.Arrays.asList;

public class PdfsToExcel {
	private static List<String> PDF_EXTENSIONS = asList("pdf", "PDF");

	private final Path directoryWithPDFs;

	private PdfsToExcel(Path directoryWithPDFs) {
		this.directoryWithPDFs = directoryWithPDFs;
	}

	public static void main(String[] args) throws IOException {
		assertAllParametersProvided(args);
		Path directoryPath = Paths.get(args[1]);

		new PdfsToExcel(directoryPath)
				.convertAll();

		System.out.println("Done");
	}

	private static void assertAllParametersProvided(String[] args) {
		if (args.length < 2) {
			System.out.println("Please specify path to directory. Example:");
			System.out.printf("java -jar %s <path>\n", args[0]);
			System.exit(1);
		}
	}

	private void convertAll() throws IOException {
		Files.list(directoryWithPDFs)
				.filter(Files::isRegularFile)
				.filter(this::isPdf)
				.map(Path::toFile)
				.map(PDFLinesExtractor::new)
				.map(PDFLinesExtractor::getLines)
				.map(ToExcelFormatter::new)
				.map(ToExcelFormatter::paddedForExcel)
				.findAny()
				.ifPresent(WriteToExcelImpl::checkPattern);
	}


	private boolean isPdf(Path path) {
		return PDF_EXTENSIONS.stream().anyMatch(extension -> path.toString().endsWith(extension));
	}
}
