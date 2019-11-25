package PDFReaderImpl;
public class Parameters {
	private String lastLine;
	private String beforeLastLine;
	private String regex;
	
	public String getRegex() {
		return regex;
	}
	public String getLastLine() {
		return lastLine;
	}
	public String getBeforeLastLine() {
		return beforeLastLine;
	}
	public Parameters() {
		
	}
	public Parameters(String regex,String beforeLastLine, String lastLine ) {
		super();
		this.lastLine = lastLine;
		this.beforeLastLine = beforeLastLine;
		this.regex = regex;
	}
	@Override
	public String toString() {
		return "Parameters [lastLine=" + lastLine + ", beforeLastLine=" + beforeLastLine + ", regex=" + regex + "]";
	}
	
}
