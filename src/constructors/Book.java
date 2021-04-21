package constructors;

public class Book extends LibrarySystem {

	// Creating a book object:
	private String bookTitle;
	private String bookAuthor;
	private String date; // date the book was published;
	private int bookID;
	private boolean isAvailable; // check if the book is available to be borrowed;

	// This method is called when reading 'books.txt', as the ID already exists:
	public Book(int bookID, String bookTitle, String bookAuthor, String date) {
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.date = date;
		this.isAvailable = true; // when creating a new book, it is automatically set as available;

	}

	// This method is called when the employee registers a new book, and an ID will be
	// created:
	public Book(String bookTitle, String bookAuthor, String date) {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.date = date;
		this.isAvailable = true; // when creating a new book, it is automatically set as available;

	}

	// Setting book ID:
	public void setBookID(int ID) {
		this.bookID = ID;
	}

	// Getting book ID:
	public int getBookID() {
		return bookID;
	}

	// Getting book title:
	public String getBookTitle() {
		return bookTitle;
	}

	// Setting book title:
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	// Getting book author:
	public String getBookAuthor() {
		return bookAuthor;
	}

	// Setting book author:
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	// Getting book publishing date:
	public String getDate() {
		return date;
	}

	// Setting book publishing date:
	public void setDate(String date) {
		this.date = date;
	}

	// Checking if the book is available to be borrowed:
	public boolean isAvailable() {
		return isAvailable;
	}

	// Setting book availability:
	public void setIsAvailable(boolean available) {
		this.isAvailable = available;
	}

	// Printing the books:
	@Override
	public String toString() {
		return "[ID= " + bookID + ", Title= " + bookTitle + ", Author= " + bookAuthor + ", date= " + date + "]";
	}

}
