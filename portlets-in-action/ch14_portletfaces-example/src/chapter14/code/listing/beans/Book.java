package chapter14.code.listing.beans;

public class Book {
	private String name;
	private String author;
	private Long isbnNumber;
	private String category;
	private boolean preferredBook;
	
	public Book(String category, String name, String author, long isbnNumber) {
		this.category = category;
		this.name = name;
		this.author = author; 
		this.isbnNumber = isbnNumber;
	}
	public boolean isPreferredBook() {
		return preferredBook;
	}
	public void setPreferredBook(boolean isPreferredBook) {
		this.preferredBook = isPreferredBook;
	}
	public Book() {
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
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
