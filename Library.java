package Library_System;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Library {
	private List<Book> books;
	private List<Member> members;
	private List<Loan> loans;
	
	public Library() {
		books = new ArrayList<>();
		members = new ArrayList<>();
		loans = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void addMember(Member member) {
		LocalDate joined = LocalDate.now();
		member.setJoined(joined);
		members.add(member);
	}

	public void createLoan(Loan loan) {
		loans.add(loan);
	}
	
	
	public Book searchTitle(String bookName) {
		boolean exists = false;
		for (Book book : books) {
			if (book.getBookName().contains(bookName)) {
				book.printBook();
				exists = true;
				return book;
			}
		}
		if (!exists) {
			System.out.println("No Book Found Matching Title: " + bookName);
		}
		return null;
	}
	
	public Book searchISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn() == isbn) {
				book.printBook();
				return book;
			}
		}
		System.out.println("No Book Found Matching ISBN: " + isbn);
		return null;
	}
	
	public void viewBooks() {
		for (Book book : books) {
			book.printBook();
		}
		
	}
	
	public Member searchMemberID(int memberID) {
		for (Member member : members) {
			if (member.getMemberID() == memberID) {
				member.printMember();
				return member;
			}
		}
		System.out.println("No Member Found Matching ID: " + memberID);
		return null;
	}
	
	public void viewMembers() {
		for (Member member : members) {
			member.printMember();
		}
	}
	
	public void viewLoans() {
		if (loans.isEmpty()) {
			System.out.println("No Current Loans to be Made");
		} 
		
		for (Loan loan : loans) {
			loan.printLoan();
		}
		
	}
	
	public boolean removeBook(String isbn) {
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if (book.getIsbn().equals(isbn)) {
				books.remove(i);
				System.out.println(isbn + " Removed");
				return true;
			}
		}
		System.out.println("No book found with ISBN: " + isbn);
		return false;
	}
	
	public boolean removeMember(int memberID) {
		for (int i = 0; i < members.size(); i++) {
			Member member = members.get(i);
			if (member.getMemberID() == memberID) {
				members.remove(i);
				System.out.println(memberID + " Removed");
				return true;
			}
		}
		System.out.println("No member found with ID: " + memberID);
		return false;
	}
	
	public boolean checkout(String isbn, int memberID) {
	    Book book = searchISBN(isbn);
	    if (book == null) {
	        System.out.println("No Book Found in the database with ISBN: " + isbn);
	        return false;
	    }
	    
	    if (book.getCopiesAvailable() <= 0) {
	        System.out.println("No Available copies of " + isbn + " " + book.getBookName());
	        return false;
	    }
	    
	    for (Loan loan : loans) {
	    	if (loan.getBook().getIsbn().equals(isbn) && loan.getMember().getMemberID() == memberID) {
	    		System.out.println(memberID + " already has" + isbn + book.getBookName() + " checked out");
	    		return false;
	    	}
	    }

	    for (Member member : members) {
	        if (member.getMemberID() == memberID) {
	            LocalDate issueDate = LocalDate.now();
	            LocalDate dueDate = issueDate.plusWeeks(2);
	            Loan loan = new Loan(member, book, issueDate, dueDate, false, 0);
	            loans.add(loan);
	            book.setCopiesAvailable(book.getCopiesAvailable() - 1);
	            System.out.println("Book checked out successfully.");
	            return true;
	        }
	    }

	    System.out.println("No Member found with ID: " + memberID);
	    return false;
	}
	
	public boolean returnBook(String isbn, int memberID) {
		Loan returnLoan = null;
		for (Loan loan : loans) {
			if (loan.getBook().getIsbn().equals(isbn) && loan.getMember().getMemberID() == memberID) {
				returnLoan = loan;
				break;
			}
		}
		if (returnLoan !=null) {
			Book book = returnLoan.getBook();
			book.setCopiesAvailable(book.getCopiesAvailable() + 1);
			loans.remove(returnLoan);
			System.out.println("Book " + isbn + "Returned by member " + memberID);
			return true;
		} else {
			System.out.println("No record found for " + memberID + "for " + isbn);
			return false;
		}
	}
	
	public void updateOverdue() {
		LocalDate today = LocalDate.now();
		for (Loan loan : loans) {
			if (today.isAfter(loan.getDueDate())) {
				loan.setOverdue(true);
				long daysOverdue = ChronoUnit.DAYS.between(loan.getDueDate(), today);
				loan.setDaysOverdue((int) daysOverdue);
			} else {
				loan.setOverdue(false);
				loan.setDaysOverdue(0);
			}
		}
	}
	
	public void printOverdue() {
		if (loans.isEmpty()) {
			System.out.println("No Overdue Loans");
		}
		for (Loan loan : loans) {
			if (loan.getOverdue()){
				loan.printLoan();
			}
		}
	}
	
	
}