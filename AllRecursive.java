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
      int choice = 0;                                          // Choice used to loop menu until user selects 0
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

   //-------------------------------------------------------------------------
   //  Recursive Menu
   //------------------------------------------------------------------------- 
   public static void menu(int choice) throws InputMismatchException{
      Scanner scan = new Scanner(System.in);
      if (choice != 1 && choice != 2 && choice != 3 && choice != 0) {    // Validate user input to 1, 2, 3, or 0
         System.out.println("Please press 1, 2, or 3 and enter or 0 to quit");  // Will loop after each function 
         try {
            choice = scan.nextInt();
            menu(choice);
         } catch (InputMismatchException as) {                 // If user throws IME error set choice to -1 and rerun menu
            choice = -1;
            menu(choice);
         }

      } else {                                                 // If user enters valid input run functions
         scan = new Scanner(System.in);
         if (choice == 1) {                                    // Run levels and invTriangle function
            System.out.println("This function can print an inverted triangle \nHow many levels do you want to print? \nType a number between 1 and 12 inclusively");
            int iLevels = 0;
            try {
               iLevels = scan.nextInt();
            } catch (InputMismatchException as) {              // If user enters invalid input rerun menu
               menu(choice);
            }
            if (iLevels < 1 && iLevels > 12) {                 // Validate iLevels between 1-12 inclusively
               System.out.println("Invalid Entry: The server is connected to a potato please keep numbers between 1 and 12 inclusively");
               try {
                  iLevels = scan.nextInt();
               } catch (InputMismatchException as ) {          // If user enters invalid input rerun menu
                  menu(choice);
               }
            } else {                                           // Run levels, reset choice, and rerun menu
               levels(iLevels);
               choice = -1;
               menu(choice);
            }
         } else if (choice == 2) {                             // Run decrease function
            System.out.println("This function will take a number, print every number in descending order, and stop at 0 \nType a number between 1 and 12 inclusively");
            int iNum = 0;
            try {
               iNum = scan.nextInt();
            } catch (InputMismatchException as) {              // If user enters invalid input rerun menu
               menu(choice);
            }
            if (iNum < 1 && iNum > 12) {                       // Validate iNum 1-12 inclusively
               System.out.println("Invalid Entry: The server is connected to a potato please keep numbers between 1 and 12 inclusively");
               try {
                  iNum = scan.nextInt();
               } catch (InputMismatchException as ) {          // If user enters invalid input rerun menu
                  menu(choice);
               }
            } else {
               decrease(iNum);                                 // Run decrease, reset choice, and rerun menu
               choice = -1;
               menu(choice);
            }
         } else if (choice == 3) {
            System.out.println("This function will take a number and add all the numbers between 1 and your number \nType a number between 1 and 12 inclusively");
            int iNum = 0;
            try {
               iNum = scan.nextInt();
            } catch (InputMismatchException as) {              // If user enters invalid input rerun menu
               menu(choice);
            }
            if (iNum < 1 && iNum > 12) {                       // Validate iNum 1-12 inclusively
               System.out.println("Invalid Entry: The server is connected to a potato please keep numbers between 1 and 12 inclusively");
               try {
                  iNum = scan.nextInt();
               } catch (InputMismatchException as ) {          // If user enters invalid input rerun menu
                  menu(choice);
               }
            } else {
               System.out.println(accumulation(iNum));         // Run and print accumulation, reset choice, and rerun menu
               choice = -1;
               menu(choice);
            }
         }else {                                               // If user enters 0 unplug potato
            System.out.println("Goodbye");
            return;
         }
      }
   }

   //---------------------------------------------------------------------------------------------------
   //  Levels/invTriangle: Takes an int from user and prints an inverted triangle with that many levels
   //---------------------------------------------------------------------------------------------------
   public static void invTriangle(int n) {                     // Method for number of * per level
      if (n == 0)
         return;
      System.out.print("* ");
      invTriangle(n - 1);
   }

   public static void levels(int n) {                          // Method for levels of * in triangle
      if (n == 0)
         return;
      invTriangle(n);
      System.out.println();
      levels(n - 1);
   }

   //---------------------------------------------------------------------------------------------------
   //  Decrease: Takes an int from user and prints the number and every int in descending order until 0
   //---------------------------------------------------------------------------------------------------
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

   //----------------------------------------------------------------------------------
   //  Accumulation: Takes n from user and adds all the ints between 1 and n inclusive
   //----------------------------------------------------------------------------------
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
