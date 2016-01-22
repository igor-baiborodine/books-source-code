package chapter09.code.listing.domain;

public class ToC {
	private long toc_id;
	private long book_id;
	private byte[] toc_file;
	private String file_name;
	private String extension;
	
	public ToC(long book_id, String file, String extension, byte[] toc_file) {
		this.book_id = book_id;
		this.file_name = file;
		this.extension = extension;
		this.toc_file = toc_file;
	}
	public long getToc_id() {
		return toc_id;
	}
	public void setToc_id(long tocId) {
		toc_id = tocId;
	}
	public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long bookId) {
		book_id = bookId;
	}
	public byte[] getToc_file() {
		return toc_file;
	}
	public void setToc_file(byte[] tocFile) {
		toc_file = tocFile;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String fileName) {
		file_name = fileName;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String toString() {
		return "file name " + file_name + " extension " + extension + " book_id " + book_id;
	}
}
