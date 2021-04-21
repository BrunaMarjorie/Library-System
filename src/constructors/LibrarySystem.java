package constructors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LibrarySystem {

	// Creating the database for the system:
	private BookCollection collection = new BookCollection();
	private ReadersContacts contacts = new ReadersContacts();
	private BorrowingList list = new BorrowingList();

	public void System() {

		// Reading 'books.txt' file:

		try {

			BufferedReader br = new BufferedReader(new FileReader("books.txt"));
			String line = br.readLine();

			while (line != null) {

				// Separating the data in small parts:
				String[] data = line.split(":");

				// Converting the data in the appropriate type:
				int bookID = Integer.parseInt(data[0]);
				String title = (data[1]);
				String author = (data[2]);
				String date = (data[3]);

				// Creating the books and adding them to the collection:
				Book book = new Book(bookID, title, author, date);
				this.collection.addBook(book);

				// Reading the next line:
				line = br.readLine();
			}
			br.close();

			// Checking for errors when reading the file:
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Reading 'users.txt' file:

		try {

			BufferedReader br = new BufferedReader(new FileReader("users.txt"));
			String line = br.readLine();

			while (line != null) {

				// Separating the data in small parts:
				String[] data = line.split(":");

				// Converting the data in the appropriate type:
				int userID = Integer.parseInt(data[0]);
				String firstName = (data[1]);
				String secondName = (data[2]);
				String address = (data[3]);

				// Creating the users and add them to the list of contacts:
				Reader user = new Reader(userID, firstName, secondName, address);
				contacts.addUser(user);

				// Reading the next line:
				line = br.readLine();
			}
			br.close();

			// Checking for errors when reading the file:
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Reading 'borrowings.txt' file:

		try {

			BufferedReader br = new BufferedReader(new FileReader("borrowings.txt"));
			String line = br.readLine();

			while (line != null) {

				// Separating the data in small parts:
				String[] data = line.split(":");

				// Converting the data in the appropriate type:
				int bookID = Integer.parseInt(data[0]);
				int userID = Integer.parseInt(data[1]);
				String dateBorrow = (data[2]);
				boolean devolution = Boolean.parseBoolean(data[3]);

				// Creating the borrowings and add them to the list:

				Borrowing borrow = new Borrowing(collection.getBookByID(bookID), contacts.getReaderByID(userID),
						dateBorrow, devolution);
				list.addBorrow(borrow);

				// Reading the next line:
				line = br.readLine();
			}
			br.close();

			// Checking for errors when reading the file:
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Getting collection of books:
	public BookCollection getCollection() {
		return collection;
	}

	// Getting collection of readers:
	public ReadersContacts getContacts() {
		return contacts;
	}

	// Getting collection of borrowings:
	public BorrowingList getList() {
		return list;
	}

}
