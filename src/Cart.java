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
            
        displayMenu(); // Show the menu

        // Handle user command
        Console cons = System.console();

        String userInput = "";
        userInput = cons.readLine("> ");

        String command = userCommand(userInput);

        System.out.printf("command: %s \n", command); // Shows selected command
        System.out.printf("User input: %s \n", userInput); // Shows full input

        Scanner test = new Scanner(userInput).useDelimiter(",");

        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        

        test.close();

        

        // HashSet = 
        // String items = "";




        /* while(!command.equals("quit"))   
        {
            System.out.println(command);

            switch (command) 
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
            
            command = userCommand(userInput);

        } */
   
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

    public static String userCommand(String inputLine) // Method 2 - Getting user's input
    {      
        Scanner scan = new Scanner(inputLine);
        String command = scan.next().trim().toLowerCase();

        scan.close();

        return command;
    }

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