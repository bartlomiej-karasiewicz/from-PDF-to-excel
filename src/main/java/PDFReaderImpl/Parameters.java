package PDFReaderImpl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Parameters {
	private String lastLine;
	private String beforeLastLine;
	private String regex;
}
