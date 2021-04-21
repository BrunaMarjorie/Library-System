package constructors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BorrowingList {

	// Creating a collection of the object Borrowing:
	private ArrayList<Borrowing> borrowList = new ArrayList<>();

	// Method to add a new borrowing to the collection:
	public void addBorrow(Borrowing borrow) {
		borrowList.add(borrow);
	}

	// Checking all the books that are currently borrowed:
	public String BooksBorrowed() {
		int count = 0;
		String toReturn = ("Books borrowed: \n");
		for (Borrowing b : borrowList) {
			//Getting if the book is available, and if the devolution is set as false:
			if ((b.getBook().isAvailable() == false) && (!b.isDevolution())) {
				toReturn += "book= " + b.getBook().getBookTitle() + " (ID = " + b.getBook().getBookID() + "), user= "
						+ b.getUser().getUserID() + ", borrow date= " + b.getDateBorrow() + "\n";
				count++;
			}
		}
		toReturn += ("Total: " + count);

		return toReturn;
	}

	// Checking all the books that has being borrowed by an user:
	public String BooksBorrowedByUser(int userID) {
		String user = "";
		String toReturn = "";
		String list = "";
		int count = 0;
		for (Borrowing b : borrowList) {	
			//Searching for the userID, and returning the borrowings that are assigned to them:
			if (b.getUser().getUserID() == userID) {
				list += "book= " + b.getBook().getBookTitle() + ", borrow date= " + b.getDateBorrow()
						+ ", devolution= " + b.isDevolution() + "\n";
				count++;
				user = b.getUser().getUserFirstName() + " " + b.getUser().getUserLastName();
			}
		}
		toReturn += "Books borrowed by " + user + ": \n";
		toReturn += list;
		toReturn += ("Total: " + count);

		return toReturn;
	}

	// Setting if the book has being returned:
	public void setDevolution(int bookID, boolean devolution) {
		for (Borrowing b : borrowList) {
			if (b.getBook().getBookID() == bookID) {
				b.setDevolution(devolution);
				b.getBook().setIsAvailable(true);
			}
		}

	}

	// Printing the collection of borrowings:
	public void printList() {
		for (int i = 0; i < borrowList.size(); i++) {
			System.out.println(borrowList.get(i));
		}
	}

	// Method to update the 'borrowings.txt' file:
	public void publish() {
		try {
			FileWriter fw = new FileWriter("borrowings.txt");

			BufferedWriter bw = new BufferedWriter(fw);

			// Creating the string to be written:
			for (int i = 0; i < borrowList.size(); i++) {
				String output = Integer.toString(borrowList.get(i).getBook().getBookID()) + ":"
						+ Integer.toString(borrowList.get(i).getUser().getUserID()) + ":"
						+ borrowList.get(i).getDateBorrow() + ":" + borrowList.get(i).isDevolution();

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
