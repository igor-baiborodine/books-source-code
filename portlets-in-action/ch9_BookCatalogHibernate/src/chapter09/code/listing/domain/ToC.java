package chapter09.code.listing.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ToC")
@Table(name="toc_tbl")
public class ToC {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="toc_id")
	private long toc_id;

	@Column(name="book_id")
	private long book_id;

	@Column(name="toc_file")
	private byte[] toc_file;

	@Column(name="file_name")
	private String file_name;

	@Column(name="extension")
	private String extension;
	
	@Column(name="active")
	private int active;
	
	public ToC() {
		
	}
	
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
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String toString() {
		return "file name " + file_name + " extension " + extension + " book_id " + book_id;
	}
}
