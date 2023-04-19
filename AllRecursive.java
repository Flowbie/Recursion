/******************************************************************************************************************
* @Austin Dolan
* ICS 211
* AllRecursive.java
* 4/18/2023
******************************************************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;

public class AllRecursive {
   public static void main(String[] args) {
      int choice = 0;                                           // Choice used to loop menu until user selects 0
      Scanner scan = new Scanner(System.in);
      System.out.println("Hello, I can perform 3 functions: \n1. Display a triangle of size n \n2. Print in decreasing order from n \n3. Perform an accumulation function of n \nAll by using recursion! \nWhich operation would you like to perform? (Press 1, 2, 3 and enter, or 0 to exit)");
      try {
         choice = scan.nextInt();                              // User selects 1, 2, 3, or 0
         menu(choice);
      } catch (InputMismatchException as) {                    // If user throws IME error set choice to -1 and rerun menu
         choice = -1;
         menu(choice);
      }
   }

   public static void menu(int choice) throws InputMismatchException{
      Scanner scan = new Scanner(System.in);
      if (choice != 1 && choice != 2 && choice != 3 && choice != 0) {
         System.out.println("Please press 1, 2, or 3 and enter or 0 to quit");
         try {
            choice = scan.nextInt();
            menu(choice);
         } catch (InputMismatchException as) {
            choice = -1;
            menu(choice);
         }

      } else {
         scan = new Scanner(System.in);
         if (choice == 1) {
            System.out.println("This function can print an inverted triangle \nHow many levels do you want to print? \nType a number between 1 and 12 inclusively");
            int iLevels = 0;
            try {
               iLevels = scan.nextInt();
            } catch (InputMismatchException as) {
               menu(choice);
            }
            if (iLevels < 1 && iLevels > 12) {
               System.out.println("Invalid Entry: The server is connected to a potato please keep numbers between 1 and 12 inclusively");
               try {
                  iLevels = scan.nextInt();
               } catch (InputMismatchException as ) {
                  menu(choice);
               }
            } else {
               levels(iLevels);
               choice = -1;
               menu(choice);
            }
         } else if (choice == 2) {
            System.out.println("This function will take a number, print every number in descending order, and stop at 0 \nType a number between 1 and 12 inclusively");
            int iNum = 0;
            try {
               iNum = scan.nextInt();
            } catch (InputMismatchException as) {
               menu(choice);
            }
            if (iNum < 1 && iNum > 12) {
               System.out.println("Invalid Entry: The server is connected to a potato please keep numbers between 1 and 12 inclusively");
               try {
                  iNum = scan.nextInt();
               } catch (InputMismatchException as ) {
                  menu(choice);
               }
            } else {
               decrease(iNum);
               choice = -1;
               menu(choice);
            }
         } else if (choice == 3) {
            System.out.println("This function will take a number and add all the numbers between 1 and your number \nType a number between 1 and 12 inclusively");
            int iNum = 0;
            try {
               iNum = scan.nextInt();
            } catch (InputMismatchException as) {
               menu(choice);
            }
            if (iNum < 1 && iNum > 12) {
               System.out.println("Invalid Entry: The server is connected to a potato please keep numbers between 1 and 12 inclusively");
               try {
                  iNum = scan.nextInt();
               } catch (InputMismatchException as ) {
                  menu(choice);
               }
            } else {
               System.out.println(accumulation(iNum));
               choice = -1;
               menu(choice);
            }
         }else {
            System.out.println("Goodbye");
            return;
         }
      }
   }

   public static void invTriangle(int n) {
      if (n == 0)
         return;
      System.out.print("* ");
      invTriangle(n - 1);
   }

   public static void levels(int n) {
      if (n == 0)
         return;
      invTriangle(n);
      System.out.println();
      levels(n - 1);
   }

   public static int decrease(int n) {
      int result = n;
      if (n < 0) {
         return n;
      } else {
         System.out.println(result);
         result = decrease(n - 1);
         return n;
      }
    }

   public static int accumulation(int n) { 
      int result;   
      if (n == 0) {
         return 0;
      } else {
         result = accumulation(n - 1) + n;
         return result;
      }
   }
}
