package src;

import java.io.Console;

public class ShoppingCart {

    public static void main(String[] args) {

    // Create array list for cart to store items
    
    
    
    // Create a menu
        // Print instructions

        System.out.println("Welcome to your shopping cart.");
        System.out.println("Enter 'list' to display current cart.");
        System.out.println("Enter 'add'<SPACE><ITEM> to add items to cart.");
        System.out.println("Enter 'delete'<SPACE><S/N> to delete items from cart.");
        System.out.println("Enter 'quit' to terminate program.");

        // Handle user input

        Console cons = System.console();
        String userInput = cons.readLine(">>>");
        userInput = userInput.toLowerCase();

        while(userInput != "quit") 
        {
            // 1. Display cart status

            if (userInput == "list")
            {
                displayCart(cart)
            }

            // 2. Adding items to cart, one or more items seperated by a comma (,)

            else if (userInput == "add")
            {
                
            }

            // 3. Delete items with user specified index(es)
            else if (userInput == "delete")
            {
                
            }
            else
            {
                // print invalid input
            }
        }


    

    // 3. Delete by using numbering
        // if user 0 - invalid enter list number
        // if user key -ve number throw exception
    
    // 4. Terminate/Exit by typing "quit"
    


    }

   // create functions outside of psvm but inside class

      

}
