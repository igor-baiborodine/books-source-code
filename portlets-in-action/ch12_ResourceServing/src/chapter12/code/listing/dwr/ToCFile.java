package chapter12.code.listing.dwr;

import java.io.InputStream;

public class ToCFile {
	private InputStream tocFile;
	private String fileName;
	
	public InputStream getTocFile() {
		return tocFile;
	}
	public void setTocFile(InputStream tocFile) {
		this.tocFile = tocFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
