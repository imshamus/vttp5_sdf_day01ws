package src;

import java.io.Console;
import java.util.Scanner;

public class Cart 
{
    public static void main(String[] args) 
    {
        System.out.println("Welcome to your shopping cart.");
        System.out.println("=============================="); 
            
        displayMenu();

        while(!userCommand().equals("quit"))
        {
            switch (userCommand()) 
            {
                case ("list"):
                    System.out.println("listed");                
                    break;
                case ("add"):
                    System.out.println("added");
                    break;
                case ("delete"):
                    System.out.println("deleted");
                    break;
                case("quit"):
                    System.exit(0);
        
                default:
                    System.out.println("invalid input");
                    break;
            }


        }


        /* do 
        {  
            // Display cart status 

            if (userCommand().equals("list"))
            {
                // displayCart();
                System.out.println("listed");
            }

            // Adding items to cart, one or more items seperated by a comma (,)

            else if (userCommand().equals("add"))
            {
                System.out.println("added");
            }

            // 3. Delete items with user specified index(es)
            else if (userCommand().equals("delete"))
            {
                System.out.println("deleted");
            }
            else if (!userCommand().equals("quit"))
            {
                // print invalid input
                System.out.println("Invalid input");
            }
            else
            {
                continue;
            }
            
        }
        while(!userCommand().equals("quit")); */


    // 3. Delete by using numbering
        // if user 0 - invalid enter list number
        // if user key -ve number throw exception
    
    // 4. Terminate/Exit by typing "quit"

    } // End of entry point



    // METHODS 
    
    public static void displayMenu() // Method 1
    {
         // Create and print menu instructions
         System.out.println("Enter 'list' to display current cart.");
         System.out.println("Enter 'add'<SPACE><ITEM> to add items to cart.");
         System.out.println("Enter 'delete'<SPACE><S/N> to delete items from cart.");
         System.out.println("Enter 'quit' to terminate program."); 

    }

    public static String userCommand() // Method 2
    {
         // Handle user command
        Console cons = System.console();

        String userCommand = "";

        userCommand = cons.readLine("> ");
        
        Scanner scan = new Scanner(userCommand);

        userCommand = scan.next().trim().toLowerCase();

        scan.close();

        return userCommand;
    }
    




} // End of Public class Cart