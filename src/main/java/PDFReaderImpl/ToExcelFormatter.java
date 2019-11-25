package PDFReaderImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ToExcelFormatter {
    private static final String NULL_STRING = "null";
    private static final String PA_20 = "pa20";
    private final List<String> initialLines;

    ToExcelFormatter(List<String> initialLines) {
        this.initialLines = initialLines;
    }

    List<String> paddedForExcel() {
        List<String> paddedLines = new ArrayList<>(initialLines);
        paddedLines.addAll(
                initialLines.stream()
                        .filter(this::isLastLine)
                        .flatMap(line -> Stream.of(NULL_STRING, NULL_STRING))
                        .collect(Collectors.toList())
        );
        return paddedLines;
    }

    private boolean isLastLine(String line) {
        return line.contains(PA_20);
    }
}
