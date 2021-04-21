package constructors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import searching.Sorting;

public class BookCollection {

	// Creating a collection of the object Book:
	private ArrayList<Book> collection = new ArrayList<Book>();

	// Method to add a new book to the collection:
	public void addBook(Book book) {
		// Checking if the bookID already exists(in case it is reading 'books.txt'):
		int ID = book.getBookID();

		// If there is no bookID, it generates a new one:
		if (ID == 0) {
			int lastID = collection.get(collection.size() - 1).getBookID(); // Getting the ID of the last book inserted;
			ID = lastID + 1;
			book.setBookID(ID);
		}
		collection.add(book);
	}

	// Getting the collection of books:
	public ArrayList<Book> getBooks() {
		return collection;
	}

	// Getting book using ID as parameter:
	public Book getBookByID(int ID) {
		for (Book bc : collection) {
			if (bc.getBookID() == ID) {
				return bc;
			}
		}

		return null;
	}

	// Checking books available in stock:
	public String BooksStock() {
		ArrayList<String> stock = new ArrayList<>();
		int count = 0;
		String toReturn = ("Books in Stock: \n");
		System.out.println(toReturn);
		for (Book bc : collection) {
			if (bc.isAvailable() == true) {
				toReturn = "Title= " + bc.getBookTitle() + "(ID= " + bc.getBookID() + "), Author= " + bc.getBookAuthor()
						+ ", Date= " + bc.getDate() + "\n";
				stock.add(toReturn);
				count++;
			}
		}
		toReturn = ("Total: " + count);

		// Sorting the list in alphabetic order:
		Sorting sort = new Sorting();
		sort.sort(stock);

		return toReturn;
	}

	// Deleting book from the collection:
	public void deleteBook(Book book) {
		collection.remove(book);
	}

	// Checking the number of books in the collection:
	public int numBooks() {
		return collection.size();
	}

	// Sorting all the books by title:
	public Sorting listBooksByTitle() {
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < collection.size(); i++) {
			list.add(collection.get(i).getBookTitle() + " (ID: " + collection.get(i).getBookID() + "), Author: "
					+ collection.get(i).getBookAuthor() + "\n");
		}

		Sorting sort = new Sorting();
		sort.sort(list);

		return sort;
	}

	// Sorting all the books by author:
	public Sorting listBooksByAuthor() {
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < collection.size(); i++) {
			list.add(collection.get(i).getBookAuthor() + ", Book: " + collection.get(i).getBookTitle() + " (ID: "
					+ collection.get(i).getBookID() + ") \n");
		}

		Sorting sort = new Sorting();
		sort.sort(list);

		return sort;
	}

	// Printing the collection of books:
	public void printCollection() {
		for (int i = 0; i < collection.size(); i++) {
			System.out.println(collection.get(i));
		}
	}

	// Method to update the 'books.txt' file:
	public void publish() {
		try {
			FileWriter fw = new FileWriter("books.txt");

			BufferedWriter bw = new BufferedWriter(fw);

			// Creating the string to be written:
			for (int i = 0; i < collection.size(); i++) {
				String output = Integer.toString(collection.get(i).getBookID()) + ":" + collection.get(i).getBookTitle()
						+ ":" + collection.get(i).getBookAuthor() + ":" + collection.get(i).getDate();

				// Writing the string on the file:
				try {
					bw.write(output);
					bw.newLine();

					// Checking for errors when writing:
				} catch (IOException e) {
					System.out.println("An error has occured");
					e.printStackTrace();
				}
			}

			bw.close();

			// Checking for errors when finding the file:
		} catch (IOException e) {
			System.out.println("An error has occured");
			e.printStackTrace();
		}
	}
}
