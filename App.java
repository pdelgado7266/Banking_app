
//Banking app - This app will allow users to deposit, withdraw, or retrieve their balance. It will implement a 
//do-while loop that will continuously prompt to ask the user what they would like to do, as well as utilize a 
//series of if-else statements that will perform the indicated function depending on the user's choice. It will 
//also implement exception handling in case users enter an invalid character, which will prompt the user to restart
// the program. It will also utilize a printMenu function that will print out the menu for the user.

import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        String fname;
        String lname;
        double amount;
        double balance = 0.00;
        int choice;
        boolean validInput = false;
        
        Scanner sc = new Scanner(System.in);

        //This do-while loop will present the users with their choices as well as call the printMenu method. 

do{ 
        try{
        System.out.println("Please enter your first name: ");
        fname = sc.nextLine();
        System.out.println("Please enter your last name: ");
        lname = sc.nextLine();
        System.out.println("Hi " + fname + "!");
        printMenu();
        choice = sc.nextInt();
          
           while(choice < 1 || choice > 4){
                System.out.println("Error. Please enter a valid choice.");
                choice = sc.nextInt();
                }

        while(choice != 4){
            if(choice == 1){
                System.out.println("How much would you like to deposit?");
                amount = sc.nextDouble();
                sc.nextLine();
                balance += amount;
                System.out.printf("Your balance is %.2f\n", balance);
                printMenu();
                choice = sc.nextInt();
                sc.nextLine();
               
            }
            else if(choice == 2){
                System.out.println("How much would you like to withdraw?");
                amount = sc.nextDouble();
                 sc.nextLine();
                 if(amount > balance){
                    System.out.println("Error, not enough funds.");
                    printMenu();
                    choice = sc.nextInt();
                    sc.nextLine();
                 }
                 else if(amount <= balance){
                   balance -= amount;
                  System.out.printf("Your balance is %.2f\n", balance);
                  printMenu();
                  choice = sc.nextInt();
                  sc.nextLine();
                 }
               
            }

            else if(choice == 3){
                System.out.printf("Your balance is %.2f\n", balance);
                printMenu();
                choice = sc.nextInt();
                sc.nextLine();
            }

        }

        System.out.println("Goodbye!");
        validInput = true;

        //This catch statement will provide users when an exception occurs. 
    } catch(InputMismatchException e){
        System.out.println("Invalid input. Please restart the application & enter a valid choice.");
        sc.nextLine();
       
        choice = 0;
    }
    finally{
         sc.nextLine();
    }

    } while(!validInput);
    sc.close();
    }
    
    public static void printMenu(){
        System.out.println("Please select an option: 1 deposit, 2 withdraw, 3 balance, 4 exit");
    }

}