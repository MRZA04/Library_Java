package Library_System;

public class Book {
	private String isbn;
	private String bookName;
	private String author;
	private String publisher;
	private boolean fiction;
	private int copiesAvailable;
	
	public Book(String isbn, String bookName, String author, String publisher, boolean fiction, int copiesAvailable) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.fiction = fiction;
		this.copiesAvailable = copiesAvailable;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public boolean getFiction() {
		return fiction;
	}
	
	public void setFiction(boolean fiction) {
		this.fiction = fiction;
	}
	
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	
	public void printBook() {
		System.out.println("Title: " + bookName + " Author: " + author + " Publisher: " + publisher + " ISBN: " + isbn + " Fiction: " + fiction + " Copies: " + copiesAvailable);
	}
}
