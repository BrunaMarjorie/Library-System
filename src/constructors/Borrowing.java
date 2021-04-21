package constructors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Borrowing {

	// Creating a borrowing object:
	private Book book;
	private Reader user;
	private String dateBorrow;
	private boolean devolution;
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	// This method is called when the employee registers a new borrowing:
	public Borrowing(Book book, Reader user) {
		this.book = book;
		this.user = user;
		Date date = new Date();
		this.dateBorrow = df.format(date); // setting today's date;
		this.devolution = false; // setting by default the book as not returned;
		this.book.setIsAvailable(false); // setting the book as not available;
	}

	// This method is called when reading 'borrowings.txt', checking if the books
	// has being returned or not:
	public Borrowing(Book book, Reader user, String dateBorrow, boolean devolution) {
		this.book = book;
		this.user = user;
		this.dateBorrow = dateBorrow;
		this.devolution = devolution;
		// setting book availability:
		if (devolution == false) {
			this.book.setIsAvailable(false);
		} else {
			this.book.setIsAvailable(true);
		}

	}

	// Getting the information of the book borrowed:
	public Book getBook() {
		return book;
	}

	// Getting the information of the reader that borrowed the book:
	public Reader getUser() {
		return user;
	}

	// Getting the date of the borrowing:
	public String getDateBorrow() {
		return dateBorrow;
	}

	// Checking if the book has being returned:
	public boolean isDevolution() {
		return devolution;
	}

	// Returning a book:
	public void setDevolution(boolean devolution) {
		this.devolution = devolution;
		if (devolution) {
			book.setIsAvailable(true);
		}
	}

	// Printing the borrowings:
	@Override
	public String toString() {
		return "book= " + book.getBookID() + "(" + book.getBookTitle() + ")" + ", user= " + user.getUserID()
				+ ", dateBorrow= " + dateBorrow + ", devolution= " + devolution;
	}

}
