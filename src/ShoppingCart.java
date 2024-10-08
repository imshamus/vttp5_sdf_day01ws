package src;

import java.io.Console;
import java.util.HashSet;
import java.util.Scanner;

public class ShoppingCart {

    // Create array list for cart to store items
    public static HashSet<String> cart = new HashSet<>(); // Instantiate an object of HashSet

    // Create function to display menu
    public static String displayMenu()
    {
    // Create a menu

        // Print menu instructions
        System.out.println("Enter 'list' to display current cart.");
        System.out.println("Enter 'add'<SPACE><ITEM> to add items to cart.");
        System.out.println("Enter 'delete'<SPACE><S/N> to delete items from cart.");
        System.out.println("Enter 'quit' to terminate program.");  
                        
        // Handle user input
        Console cons = System.console();
        
        // String userInput = "";
        String userInput = cons.readLine("> ");

        Scanner scan = new Scanner(userInput);
        userInput = scan.next().trim().toLowerCase();

        scan.close();

        return userInput;
    }
    
    // Create function for displaying cart
    public static void displayCart()
    {
        if(cart.isEmpty())
        {
            System.out.println("Your shopping cart is empty");
        }
        else
        {
            for (Integer i = 0; i < cart.size(); i++)
            {
                System.out.println("Your shopping cart contains: ");
                System.out.println(cart);
            }   
        }
       
    }

    // Create function for adding items to cart

    public static void addItems()
    {
        
    }

    // Create function for deleting items from cart

    public static void deleteItems()
    {

    }

    public static void main(String[] args) 
    {
        System.out.println("Welcome to your shopping cart.");
        System.out.println("=============================="); 

        String userInput = "";
             
        do 
        {
            // Handle user input

            userInput = displayMenu();

            // Display cart status and return to menu

            if (userInput.equals("list"))
            {
                displayCart();
            }

            // Adding items to cart, one or more items seperated by a comma (,)

            else if (userInput.equals("add"))
            {
                System.out.println("added");
            }

            // 3. Delete items with user specified index(es)
            else if (userInput.equals("delete"))
            {
                System.out.println("deleted");
            }
            else if (!userInput.equals("quit"))
            {
                // print invalid input
                System.out.println("Invalid input");
            }
            else
            {
                continue;
            }
            
        }
        while(!userInput.equals("quit"));


    // 3. Delete by using numbering
        // if user 0 - invalid enter list number
        // if user key -ve number throw exception
    
    // 4. Terminate/Exit by typing "quit"
    


    }

   // create functions outside of psvm but inside class

      

}
