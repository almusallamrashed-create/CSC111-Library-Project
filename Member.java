
public class Member {

    // --- Attributes ---
    private int id;
    private String name;
    private int borrowedCount;      // books currently borrowed
    
    // Counters for statistics
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    // --- Static Variables (Shared) ---
    public static double TotalRevenue = 0.0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;

    // --- Constructor ---
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;
        
        // set all counters to zero
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }

    // --- Helper Methods ---
    
    // check if user reached the limit (5 books)
    private boolean canBorrow() {
        return this.borrowedCount < 5;
    }

    // check if user has books to return
    private boolean canReturn() {
        return this.borrowedCount > 0;
    }

    // --- Methods ---

    public void viewBorrowedCount() {
        System.out.println(">> Info: " + this.name + " has " + this.borrowedCount + " books.");
        
        // update counters
        this.numViewBorrowed++;
        Member.TotalViewBorrowed++;
    }

    public boolean borrowOne() {
        // check limit first
        if (!canBorrow()) {
            System.out.println("Error: Max limit (5) reached.");
            return false;
        }

        this.borrowedCount++;
        
        // add fees (0.50)
        double fee = 0.50;
        this.sessionFees += fee;
        Member.TotalRevenue += fee;
        
        // update stats
        this.numBorrows++;
        Member.TotalBorrows++;
        
        System.out.println("Done: Book borrowed. Fee: " + fee);
        return true;
    }

    public boolean returnOne() {
        // check if empty
        if (!canReturn()) {
            System.out.println("Error: No books to return.");
            return false;
        }

        this.borrowedCount--;
        
        // update stats (no fee for return)
        this.numReturns++;
        Member.TotalReturns++;
        
        System.out.println("Done: Book returned.");
        return true;
    }

    public void displayStatistics() {
        System.out.println("\n--- Session Stats ---");
        System.out.println(" ID: " + this.id);
        System.out.println(" Name: " + this.name);
        System.out.println(" Current Books: " + this.borrowedCount);
        System.out.println(" Views: " + this.numViewBorrowed);
        System.out.println(" Borrows: " + this.numBorrows);
        System.out.println(" Returns: " + this.numReturns);
        System.out.println(" Total Fees: " + this.sessionFees);
        System.out.println("---------------------");
    }

    public void reset() {
        // reset all local counters
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
        System.out.println("Stats reset for " + this.name);
    }

    // --- Setters & Getters ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}