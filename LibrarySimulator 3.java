/*
 * Group Members:
 * RASHID ABDULLAH ALMUSALLAM  ID: 446102214
 * MSHAL MUBARAK ALQAHTANI ID: 446104697
 * ABDULFATTAH MOHAMMED ALSHAQI ID: 446102665
 */
import java.util.Scanner;

public class LibrarySimulator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== Library System (Phase 2) ===");

        // get user info
        System.out.print("Enter ID: ");
        int userId = input.nextInt();
        input.nextLine(); // fix scanner line skip
        
        System.out.print("Enter Name: ");
        String userName = input.nextLine();
        
        System.out.print("Initial Books Count: ");
        int initialBooks = input.nextInt();

        // create member object
        Member member = new Member(userId, userName, initialBooks);
        System.out.println("User created: " + userName);

        int choice = -1;
        
        // menu loop
        while (choice != 0) {
            System.out.println("\nChoose Operation:");
            System.out.println(" 1. View Count");
            System.out.println(" 2. Borrow Book");
            System.out.println(" 3. Return Book");
            System.out.println(" 4. My Stats");
            System.out.println(" 5. Reset My Stats");
            System.out.println(" 6. Library Total Revenue");
            System.out.println(" 0. Exit");
            
            System.out.print("Choice: ");
            choice = input.nextInt();
            System.out.println(); 

            switch (choice) {
                case 1:
                    member.viewBorrowedCount();
                    break;
                case 2:
                    member.borrowOne();
                    break;
                case 3:
                    member.returnOne();
                    break;
                case 4:
                    member.displayStatistics();
                    break;
                case 5:
                    member.reset();
                    break;
                case 6:
                    // print static variables
                    System.out.println("--- Library Report ---");
                    System.out.println(" Total Revenue: " + Member.TotalRevenue);
                    System.out.println(" Total Views: " + Member.TotalViewBorrowed);
                    System.out.println(" Total Borrows: " + Member.TotalBorrows);
                    System.out.println(" Total Returns: " + Member.TotalReturns);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Wrong input.");
            }
        }
        
        input.close();
    }

}
