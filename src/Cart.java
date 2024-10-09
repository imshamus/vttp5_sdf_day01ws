package src;

import java.io.Console;
import java.util.Scanner;
import java.util.HashSet;

public class Cart 
{
    public static void main(String[] args) 
    {
        System.out.println("Welcome to your shopping cart.");
        System.out.println("=============================="); 
            
        // displayMenu();
        // String command = userCommand();

        // Handle user command
        Console cons = System.console();

        String userInput = "";
        userInput = cons.readLine("> ");
        
        Scanner scan = new Scanner(userInput);
        String userCommand = scan.next().trim().toLowerCase();

        String items = "";


        scan.close();

        while(!userCommand.equals("quit"))
        {
            System.out.println(userCommand);

            switch (userCommand) 
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
            
            userCommand = userCommand();

        }



        /* Do-While loop ============================== <Not in use> ========================================================
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
        while(!userCommand().equals("quit")); 
        ===================================================================================================================== */ 

        

    } // End of entry point



    // METHODS 
    
    public static void displayMenu() // Method 1 - Printing Instructions
    {
         // Create and print menu instructions
         System.out.println("Enter 'list' to display current cart.");
         System.out.println("Enter 'add'<SPACE><ITEM> to add items to cart.");
         System.out.println("Enter 'delete'<SPACE><S/N> to delete items from cart.");
         System.out.println("Enter 'quit' to terminate program."); 

    }

    /* public static String userCommand() // Method 2 - Getting user's input
    {
         // Handle user command
        Console cons = System.console();

        String userInput = "";
        userInput = cons.readLine("> ");
        
        Scanner scan = new Scanner(userInput);
        userInput = scan.next().trim().toLowerCase();
        scan.close();

        return userInput;
    } */

    /* public static void listItems() // Method 2 - List items in cart line by line
    {
        HashSet<String> items = new HashSet<>();

        for(int i = 0 ; i < items.size(); i++)
        {
            items.add(null)
        }
    }
 */
    public static void addItems()
    {

    }

    public static void deleteItems()
    {

    }
    




} // End of Public class Cart