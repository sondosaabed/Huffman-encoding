package huffman.application;

public class Code {
	private char c;
	private String code;
	
	public Code(char c,String code) {
		this.setC(c);
		this.setCode(code);
	}
	/*
	 * Getters and Setters
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
}
