package chapter12.code.listing.domain;

public class Book {
	private String name;
	private String author;
	private Long isbnNumber;
	private String tocFileExtension;
	private String category;
	
	public Book(String name, String author, long isbnNumber, String category) {
		this.name = name;
		this.author = author;
		this.isbnNumber = isbnNumber;
		this.category = category;
	}
	
	public Book(String name, String author, long isbnNumber) {
		this.name = name;
		this.author = author;
		this.isbnNumber = isbnNumber;
	}
	public Book() {
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTocFileExtension() {
		return tocFileExtension;
	}
	public void setTocFileExtension(String tocFileExtension) {
		this.tocFileExtension = tocFileExtension;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(Long isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		Book otherBook = (Book)otherObject;
		if(otherBook.getIsbnNumber() == this.isbnNumber) {
			return true;
		} else {
			return false;
		}
	}
}
