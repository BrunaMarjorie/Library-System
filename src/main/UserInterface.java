package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import constructors.Book;
import constructors.Borrowing;
import constructors.LibrarySystem;
import constructors.Reader;
import searching.Sorting;

public class UserInterface {

	private LibrarySystem library = new LibrarySystem(); // Creating the library system;
	private Scanner sc = new Scanner(System.in);
	private int option;

	// Grabbing database records:
	public UserInterface() {
		library.System();
	}

	// Main menu:
	public void startMenu() {

		menu(); // Calling menu options;

		option = integerValidation(); // Checking user input;

		options(); // Returning function user asked for;

	}

	// Validating user input:
	private int integerValidation() {
		while (true) {
			try {
				return sc.nextInt();

				// Sending error in case input is not a valid integer:
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("Invalid option. Please, try again.");

			}
		}
	}

	// Returning the function according to user input:
	private void options() {
		if (option == 1) {
			searchBook();
			
			boolean loop = true;

			while (loop) {
				System.out.println();
				String function = "Search another book."; // Setting the function to be repeated;
				insideMenu(function); // Calling inside menu;
				if (option == 1) {
					searchBook(); // Repeating the function;
					loop = true;
					
				} else {
					insideMenu(function); // Looping until valid input;
					loop = false;
				}
			}

		} else if (option == 2) {
			searchUser();

			boolean loop = true;

			while (loop) {
				System.out.println();
				String function = "Search another user."; // Setting the function to be repeated;
				insideMenu(function); // Calling inside menu;
				if (option == 1) {
					searchUser(); // Repeating the function;
					loop = true;
					
				} else {
					insideMenu(function); // Looping until valid input;
					loop = false;
				}
			}

		} else if (option == 3) {
			System.out.println("Enter '1' to list books by title, or '2' to list them by author:");

			option = integerValidation(); // Checking user input;

			boolean loop = true;

			while (loop) {
				if (option == 1) { // Printing users by name;
					library.getCollection().listBooksByTitle();
					loop = false;

				} else if (option == 2) { // Printing users by ID;
					library.getCollection().listBooksByAuthor();
					loop = false;

				} else { // Looping until valid input;
					System.out.println("Invalid option. Please, try again.");
					option = integerValidation(); // Checking user input;
					loop = true;
				}

			}

			while (!loop) {
				System.out.println("Enter an option: ");
				System.out.println("1 - Go back to the main menu;");
				System.out.println("0 - Finish session.");

				option = integerValidation(); // Checking user input;

				if (option == 1) {
					loop = true;
					startMenu(); // Returning to Main Menu;

				} else if (option == 0) {
					System.out.println("Thank you for using Library System.");
					loop = true;
					System.exit(1); // Finishing program;

				} else { // Looping until valid input;
					System.out.println("Invalid option. Please, try again.");
					System.out.println();
					loop = false;
				}
			}

		} else if (option == 4) {
			System.out.println("Enter '1' to list users by name, or '2' to list them by ID:");

			option = integerValidation(); // Checking user input;

			boolean loop = true;

			while (loop) {
				if (option == 1) { // Printing users by name;
					library.getContacts().listUsersByName();
					loop = false;

				} else if (option == 2) { // Printing users by ID;
					library.getContacts().printContacts();
					loop = false;

				} else { // Looping until valid input;
					System.out.println("Invalid option. Please, try again.");
					option = integerValidation(); // Checking user input;
					loop = true;
				}

			}

			while (!loop) {
				System.out.println("Enter an option: ");
				System.out.println("1 - Go back to the main menu;");
				System.out.println("0 - Finish session.");

				option = integerValidation(); // Checking user input;

				if (option == 1) {
					loop = true;
					startMenu(); // Returning to Main Menu;

				} else if (option == 0) {
					System.out.println("Thank you for using Library System.");
					loop = true;
					System.exit(1); // Finishing program;

				} else { // Looping until valid input;
					System.out.println("Invalid option. Please, try again.");
					System.out.println();
					loop = false;
				}

			}
		} else if (option == 5) {
			borrow();

		} else if (option == 6) {
			returnBook();

		} else if (option == 7) {
			listBooksBorrowed();

		} else if (option == 8) {
			bookUpdate();

		} else if (option == 9) {
			userUpdate();

			// Finishing the program when the user inputs '0':
		} else if (option == 0) {
			System.out.println("Thank you for using Library System.");
			System.exit(1);

			// Sending an error when the user inputs an integer not part of the menu:
		} else {
			System.out.println("Invalid option. Please, try again.");

			option = integerValidation(); // Checking user input;

			options();
		}
	}

	// Printing the main menu:
	private void menu() {

		System.out.println("Enter your option: ");
		System.out.println("1 - Search for a specific book by title or author;");
		System.out.println("2 - Search for a specific user by name or ID;");
		System.out.println("3 - List all books by title or author;");
		System.out.println("4 - List all users by name or ID;");
		System.out.println("5 - Borrow a book;");
		System.out.println("6 - Return a book;");
		System.out.println("7 - List the books borrowed by a specific user;");
		System.out.println("8 - Update book collection;");
		System.out.println("9 - Update users informations;");
		System.out.println("0 - Finish session.");

	}

	// Menu inside options 1-2 and 4-7:
	private void insideMenu(String function) {

		System.out.println("Enter an option: ");
		System.out.println("1 - " + function); // This option would call the previous function again;
		System.out.println("2 - Go back to the main menu;");
		System.out.println("0 - Finish session.");

		option = integerValidation(); // Checking user input;

		if (option == 2) {
			startMenu(); // Returning to Main Menu;

		} else if (option == 0) {
			System.out.println("Thank you for using Library System.");
			System.exit(1); // Finishing program;

		}
	}

	// Menu inside option 8 (update book collection):
	private void bookInsideMenu() {
		System.out.println("Enter option:");
		System.out.println("1- Go back to update another book;");
		System.out.println("2- Go back to main menu;");
		System.out.println("0- Finish session.");

		option = integerValidation(); // Checking user input;

		if (option == 1) {
			bookUpdate(); // Returning to previous menu;

		} else if (option == 2) {
			startMenu(); // Returning to Main Menu:

		} else if (option == 0) {
			System.out.println("Thank you for using Library System.");
			System.exit(1); // Finishing program;

		} else {
			bookInsideMenu(); // Looping until valid input;
		}
	}

	// Menu inside option 9 (update users informations):
	private void userInsideMenu() {
		System.out.println("Enter option:");
		System.out.println("1- Go back to update another user;");
		System.out.println("2- Go back to main menu;");
		System.out.println("0- Finish session.");

		option = integerValidation(); // Checking user input;

		if (option == 1) {
			userUpdate(); // Returning to previous menu;

		} else if (option == 2) {
			startMenu(); // Returning to Main Menu:

		} else if (option == 0) {
			System.out.println("Thank you for using Library System.");
			System.exit(1); // Finishing program;

		} else {
			userInsideMenu(); // Looping until valid input;
		}
	}

	// Function called when option = 2:
	private void searchBook() {
		System.out.println("Enter the title or the author of the book: ");

		// Reading input and setting it lower case. The search code is case sensitive.
		String search = sc.next().toLowerCase();
		search += sc.nextLine().toLowerCase();

		ArrayList<String> listTitle = new ArrayList<>(); // Array for the titles found;
		ArrayList<String> listAuthor = new ArrayList<>(); // Array for the authors found;
		String toReturn = ""; // String to be added in the array;
		int countTitle = 0; // Counting the number of titles found;
		int countAuthor = 0; // Counting the number of authors found;

		for (int i = 0; i < library.getCollection().numBooks(); i++) {

			String author = library.getCollection().getBooks().get(i).getBookAuthor().toLowerCase();
			String title = library.getCollection().getBooks().get(i).getBookTitle().toLowerCase();

			// The key for the searching is using 'contains' instead of '==', so that you
			// can expand your results:
			// Searching for titles:
			if (title.contains(search)) {
				toReturn = "Book title: " + library.getCollection().getBooks().get(i).getBookTitle() + ", Book ID: ("
						+ library.getCollection().getBooks().get(i).getBookID() + "), Author: "
						+ library.getCollection().getBooks().get(i).getBookAuthor() + "\n";
				countTitle++;
				listTitle.add(toReturn);

				// Searching for authors:
			} else if (author.contains(search)) {
				toReturn = "Author: " + library.getCollection().getBooks().get(i).getBookAuthor() + ", Book title: "
						+ library.getCollection().getBooks().get(i).getBookTitle() + ", Book ID: ("
						+ library.getCollection().getBooks().get(i).getBookID() + ") \n";

				countAuthor++;
				listAuthor.add(toReturn);
			}

		}
		Sorting sort = new Sorting();

		if (countTitle != 0) {
			System.out.println("Total of " + countTitle + " titles found:");
			sort.sort(listTitle); // Sorting the titles;
		} else {
			// Message to be returned if no title was found:
			System.out.println("Your search - " + search + " - did not match any title in our system.");
		}

		System.out.println();

		if (countAuthor != 0) {
			System.out.println("Total of " + countAuthor + " titles found:");
			sort.sort(listAuthor); // Sorting the authors;
		} else {
			// Message to be returned if no author was found:
			System.out.println("Your search - " + search + " - did not match any author in our system.");
		}

	}

	// Function called when option = 2:
	private void searchUser() {
		System.out.println("Enter user ID, first or last name: ");

		// Reading input and setting it lower case. The search code is case sensitive.
		String search = sc.next().toLowerCase();
		search += sc.nextLine().toLowerCase();
		int userID = 0; // Creating variable for userID;

		// Trying to set 'search' as an integer:
		try {
			// If successful, 'userID' will receive 'search':
			userID = Integer.parseInt(search);
		} catch (NumberFormatException e) {
			// If not, userID will remain '0':
			userID = 0;
		}

		String toReturn = ""; // String to be returned;
		int count = 0; // Counting the number of users found;

		for (int i = 0; i < library.getContacts().numUsers(); i++) {

			String firstName = library.getContacts().getReaders().get(i).getUserFirstName().toLowerCase();
			String lastName = library.getContacts().getReaders().get(i).getUserLastName().toLowerCase();

			// The key for the searching is using 'contains' instead of '==', so that you
			// can expand your results:
			// Searching for user's first and last name, and also their ID:
			if ((firstName.contains(search) || lastName.contains(search)
					|| userID == library.getContacts().getReaders().get(i).getUserID())) {
				toReturn += "UserID: " + library.getContacts().getReaders().get(i).getUserID() + ", User name: "
						+ library.getContacts().getReaders().get(i).getUserFirstName() + " "
						+ library.getContacts().getReaders().get(i).getUserLastName() + ", Address: "
						+ library.getContacts().getReaders().get(i).getUserAddress() + "\n";
				count++;

			}
		}
		if (count > 0) { // Checking if any user was found:
			System.out.println("Search result: ");
			System.out.println(toReturn);
		} else {
			// Message to be returned if no user was found:
			System.out.println("Your search - " + search + " - did not match any user in our system.");
		}

	}

	// Function called when option = 5:
	private void borrow() {

		Borrowing borrow;
		
		searchBook(); //Searching for the book;
		
		System.out.println("\n Enter book ID: ");

		int bookID = integerValidation(); // Checking user input;

		Book book = library.getCollection().getBookByID(bookID); // Getting book by its ID;

		while (book == null) {
			// Message to be returned if bookID typed is not valid:
			System.out.println("Book ID " + bookID + " is not valid. \n");

			System.out.println("Enter book ID: ");

			bookID = integerValidation(); // Checking user input;

			book = library.getCollection().getBookByID(bookID); // Getting book by its ID;
		}

		if (!book.isAvailable()) {
			// Message to be returned if bookID typed is not available:
			System.out.println("Book " + book.getBookID() + " is not available.");

		} else if (book.isAvailable()) {
			System.out.println();
			searchUser(); //Searching for the user;
			System.out.println("Enter user ID: ");

			int userID = integerValidation(); // Checking user input;
			Reader user = library.getContacts().getReaderByID(userID); // Getting user by their ID;

			while (user == null) {
				// Message to be returned if userID typed is not valid:
				System.out.println("User ID " + userID + " is not valid. \n");

				System.out.println("Enter user ID: ");

				userID = integerValidation(); // Checking user input;

				user = library.getContacts().getReaderByID(userID); // Getting user by their ID;
			}

			// Sending message for confirmation:
			System.out.println("Book: " + library.getCollection().getBookByID(bookID).getBookTitle() + " and User: "
					+ library.getContacts().getReaderByID(userID).getUserFirstName() + " "
					+ library.getContacts().getReaderByID(userID).getUserLastName());

			System.out.println("Confirm borrowing? Enter 1(yes) or 2(no).");

			int publish = integerValidation(); // Checking user input;

			// Function if borrowing is confirmed:
			if (publish == 1) {
				borrow = new Borrowing(book, user); // Creating a borrowing with user and book informed;
				library.getList().addBorrow(borrow); // Adding new borrowing;
				library.getList().publish(); // Updating 'borrowings.txt' file;
				library.getCollection().publish(); // Updating 'books.txt' file;
				System.out.println("Borrowing updated successfully.");

				// Return if borrowing is canceled:
			} else {
				System.out.println("Borrowing canceled.");
			}
		}

		System.out.println();
		String function = "Borrow another book."; // Setting the function to be repeated;
		insideMenu(function); // Calling inside menu;
		if (option == 1) {
			borrow(); // Repeating the function;

		} else {
			insideMenu(function); // Looping until valid input;
		}
	}

	// Function called when option = 6:
	private void returnBook() {
		System.out.println(library.getList().BooksBorrowed()); // List of books currently borrowed;

		System.out.println("Enter book to be returned: ");
		int bookID = integerValidation(); // Checking user input;

		// Checking if book is currently borrowed:
		if (!library.getCollection().getBookByID(bookID).isAvailable()) {
			library.getList().setDevolution(bookID, true); // If borrowed, set it as available;

			// If successfully set as available, save information:
			if (library.getCollection().getBookByID(bookID).isAvailable()) {
				library.getList().publish(); // Updating 'borrowings.txt' file;
				library.getCollection().publish(); // Updating 'books.txt' file;
				System.out.println("Returning updated successfully.");
			}
		} else {
			// Message to be returned if book is not currently borrowed:
			System.out.println("Book not borrowed yet.");
		}

		System.out.println();
		String function = "Return another book."; // Setting the function to be repeated;
		insideMenu(function); // Calling inside menu;
		if (option == 1) {
			returnBook(); // Repeating the function;

		} else {
			insideMenu(function); // Looping until valid input;
		}

	}

	// Function called when option = 7:
	private void listBooksBorrowed() {
		searchUser();

		System.out.println("Enter user ID: ");

		int userID = integerValidation(); // Checking user input;

		// Searching if user is in the system:
		if ((library.getContacts().getReaderByID(userID)) == null) {
			// Message to be returned if user is not in the system:
			System.out.println("Reader not in the system.");

		} else {
			// Printing list if user is found:
			System.out.println(library.getList().BooksBorrowedByUser(userID));
		}

		System.out.println();
		String function = "List another user."; // Setting the function to be repeated;
		insideMenu(function); // Calling inside menu;
		if (option == 1) {
			listBooksBorrowed(); // Repeating the function;

		} else {
			insideMenu(function); // Looping until valid input;
		}
	}

	// Function called when option = 8:
	private void bookUpdate() {
		System.out.println("Enter option: ");
		System.out.println("1 - Add a book to collection;");
		System.out.println("2 - Delete a book from collection;");
		System.out.println("3 - List all books in the system;");
		System.out.println("4 - List all books borrowed;");
		System.out.println("5 - List all books in stock;");
		System.out.println("6 - Return to the main menu;");
		System.out.println("0 - Finish session.");

		option = integerValidation(); // Checking user input;

		if (option == 1) {

			System.out.println("Enter the title of the book:");
			String title = sc.next();
			title += sc.nextLine();
			System.out.println("Enter the author of the book:");
			Scanner sc2 = new Scanner(System.in);
			String author = sc2.next();
			author += sc2.nextLine();
			System.out.println("Enter the date when the book was published: ");
			Scanner sc3 = new Scanner(System.in);
			String date = sc3.next();

			Book b1 = new Book(title, author, date); // Creating a new book object with information given;

			library.getCollection().addBook(b1); // Adding book to the collection;

			library.getCollection().publish(); // Updating 'books.txt' file;
			System.out.println("Book inserted in the library."); // Message to be returned;

			System.out.println();
			bookInsideMenu(); // Calling inside menu;
			sc2.close(); // Closing scanning input variable;
			sc3.close(); // Closing scanning input variable;

		} else if (option == 2) {

			System.out.println("Enter ID of the book to be deleted: ");

			int bookID = integerValidation(); // Checking user input;

			Book b1 = library.getCollection().getBookByID(bookID); // Getting the book by its ID;

			// Checking if book is in the system:
			if (b1 != null) {

				library.getCollection().deleteBook(b1); // Deleting book from collection;

				library.getCollection().publish(); // Updating 'books.txt' file;

				System.out.println("Book deleted succesfully."); // Message to be returned;

			} else {
				// Message to be returned if book is not in the system:
				System.out.println("Book not in the system.");
			}

			System.out.println();
			bookInsideMenu(); // Calling inside menu;

		} else if (option == 3) {
			// Printing all the books in the system:
			library.getCollection().printCollection();
			System.out.println();
			bookInsideMenu(); // Calling inside menu;

		} else if (option == 4) {
			// Printing all the books currently borrowed:
			System.out.println(library.getList().BooksBorrowed());
			System.out.println();
			bookInsideMenu(); // Calling inside menu;

		} else if (option == 5) {
			// Printing all the books currently available:
			System.out.println(library.getCollection().BooksStock());
			System.out.println();
			bookInsideMenu(); // Calling inside menu;

		} else if (option == 6) {
			startMenu(); // Returning to Main Menu;

		} else if (option == 0) {
			System.out.println("Thank you for using Library System.");
			System.exit(1); // Finishing program;

		} else {
			System.out.println("Invalid option. Please, try again.");
			option = integerValidation(); // Checking user input;
			bookUpdate(); // Looping until valid input;
		}

	}

	// Function called when option = 9:
	private void userUpdate() {
		System.out.println("Enter option: ");
		System.out.println("1 - Add an user to system;");
		System.out.println("2 - Delete an user from system;");
		System.out.println("3 - Update user address;");
		System.out.println("4 - Return to the main menu;");
		System.out.println("0 - Finish session.");

		option = integerValidation(); // Checking user input;

		if (option == 1) {

			System.out.println("Enter the user first name:");
			String fisrtName = sc.next();
			fisrtName += sc.nextLine();
			System.out.println("Enter the user last name:");
			Scanner sc2 = new Scanner(System.in);
			String lastName = sc2.next();
			lastName += sc2.nextLine();
			System.out.println("Enter the user address: ");
			Scanner sc3 = new Scanner(System.in);
			String address = sc3.next();
			address += sc3.nextLine();

			Reader r1 = new Reader(fisrtName, lastName, address); // Creating a new user object with information given;

			library.getContacts().addUser(r1); // Adding user to the collection;

			library.getContacts().publish(); // Updating 'users.txt' file;

			System.out.println("User inserted in the system."); // Message to be returned;

			System.out.println();
			userInsideMenu(); // Calling inside menu;
			sc2.close(); // Closing scanning input variable;
			sc3.close(); // Closing scanning input variable;

		} else if (option == 2) {
			System.out.println("Enter ID of the user to be deleted: ");

			int userID = integerValidation(); // Checking user input;

			Reader r1 = library.getContacts().getReaderByID(userID); // Getting the user by their ID;

			// Checking if user is in the system:
			if (r1 != null) {

				library.getContacts().deleteUser(r1); // Deleting user from collection;

				library.getContacts().publish(); // Updating 'users.txt' file;

				System.out.println("User deleted succesfully."); // Message to be returned;

			} else {
				// Message to be returned if user is not in the system:
				System.out.println("User not in the system.");
			}

			System.out.println();
			userInsideMenu(); // Calling inside menu;

		} else if (option == 3) {
			System.out.println("Enter ID of the user to be updated: ");

			int userID = integerValidation(); // Checking user input;

			Reader r1 = library.getContacts().getReaderByID(userID); // Getting the user by their ID;

			// Checking if user is in the system:
			if (r1 != null) {

				System.out.println("Enter new address:");
				String address = sc.next();
				address += sc.nextLine();

				library.getContacts().getReaderByID(userID).setUserAddress(address); // Setting new user address;

				library.getContacts().publish(); // Updating 'users.txt' file;

				System.out.println("Address updated successfully."); // Message to be returned;

			} else {
				// Message to be returned if user is not in the system:
				System.out.println("User not in the system.");
			}

			System.out.println();
			userInsideMenu(); // Calling inside menu;

		} else if (option == 4) {
			startMenu(); // Returning to Main Menu;

		} else if (option == 0) {
			System.out.println("Thank you for using Library System.");
			System.exit(1); // Finishing program;

		} else {
			System.out.println("Invalid option. Please, try again.");

			option = integerValidation(); // Checking user input;

			userUpdate(); // Looping until valid input;
		}
	}

}
