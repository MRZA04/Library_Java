package Library_System;
import java.time.LocalDate;

public class Loan {
	private Member member;
	private Book book;
	private LocalDate issueDate;
	private LocalDate dueDate;
	private boolean overdue;
	private int daysOverdue;

	public Loan(Member member, Book book, LocalDate issueDate, LocalDate dueDate, boolean overdue, int daysOverdue) {
		this.member = member;
		this.book = book;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.overdue = overdue;
		this.daysOverdue = daysOverdue;
	}
	

	public Member getMember() {
		return member;
	}

	public Book getBook() {
		return book;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public boolean getOverdue() {
		return overdue;
	}
	
	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}
	
	public int getDaysOverdue() {
		return daysOverdue;
	}
	
	public void setDaysOverdue(int daysOverdue) {
		this.daysOverdue = daysOverdue;
	}
	
	public void printLoan() {
		System.out.println(book.getBookName() + " Loaned out to member " + member.getMemberID() + " on " + issueDate + " and due on " + dueDate);
	}
	
}

