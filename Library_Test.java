package Library_System;

public class Library_Test {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("ISBN001", "Pride and Prejudice", "Jane Austen", "T. Egerton", false, 3));
        library.addBook(new Book("ISBN002", "1984", "George Orwell", "Secker & Warburg", false, 4));
        library.addBook(new Book("ISBN003", "The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", false, 2));
        library.addBook(new Book("ISBN004", "Moby Dick", "Herman Melville", "Harper & Brothers", false, 5));
        library.addBook(new Book("ISBN005", "To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", false, 3));

        // Adding members to the library
        library.addMember(new Member("Alice", "Wonderland", "555-0101", 101));
        library.addMember(new Member("Bob", "Builder", "555-0202", 102));
        library.addMember(new Member("Charlie", "Chocolate", "555-0303", 103));
        library.addMember(new Member("Dorothy", "Oz", "555-0404", 104));
        library.addMember(new Member("Edward", "Scissorhands", "555-0505", 105));

        // View books and members
        System.out.println("Books available in the library:");
        library.viewBooks();
        
        System.out.println("\nMembers of the library:");
        library.viewMembers();
        
        // Checkout some books
        System.out.println("\nChecking out some books:");
        library.checkout("ISBN001", 101); // Successful checkout
        library.checkout("ISBN003", 103); // Successful checkout
        library.checkout("ISBN001", 101); // Should fail due to already checked out
        
        // View loans
        System.out.println("\nCurrent loans:");
        library.viewLoans();
        
        // Return a book
        System.out.println("\nReturning a book:");
        library.returnBook("ISBN001", 101); // Return a book
        
        // Attempt to remove a book and a member
        System.out.println("\nRemoving a book and a member:");
        library.removeBook("ISBN005"); // Remove a book
        library.removeMember(105); // Remove a member
        
        // View books, members, and loans after removals
        System.out.println("\nBooks available after removal:");
        library.viewBooks();
        
        System.out.println("\nMembers of the library after removal:");
        library.viewMembers();
        
        // Print overdue loans (Assuming some loans are now overdue; may need manual setup or waiting)
        System.out.println("\nOverdue loans:");
        library.printOverdue();
    }
}
