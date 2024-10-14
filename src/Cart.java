package src;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart 
{
    // Create a cart variable to hold items at class level (Global)
    public static List<String> cartList = new ArrayList<>();
    public static List<Integer> indexList = new ArrayList<>();
    public static List<String> userList = new ArrayList<>();
    


    public static void main(String[] args) throws IOException 
    {
        String folderName;

        if(args.length > 0 && !args[0].isEmpty())
        {
            folderName = args[0]; // set folder name from args
        }
        else
        {
            folderName = "db"; // set folder name to default "db"
        }

        Path directory = Paths.get(folderName);

        if(folderName.equals("db"))
        {
            if(!Files.exists(directory))
                {
                    Files.createDirectory(directory);
                    System.out.println("No folder specified,'db' folder created to store user shopping cart. \n");
                }
                else
                {
                    System.out.println("No folder specified, storing user shopping cart in existing 'db' folder. \n");
                }
        }
        else
        {
            if(!Files.exists(directory))
                {
                    Files.createDirectory(directory);
                    System.out.printf("'%s' folder created to store user shopping cart. \n", folderName);
                }
                else
                {
                    System.out.printf("'%s' folder has already been created. Cart would be stored in '%s' \n", folderName, folderName);
                }
        }
        
        System.out.println("Welcome to your shopping cart.");
        System.out.println("==============================");

         // Handle user command
        Console cons = System.console();
        String userInput = "";

        // Do-While for login
        do
        {   
            System.out.println("Please login by entering 'login'<SPACE><Username>.");
            userInput = cons.readLine("> "); 

            if(userInput.startsWith("login"))
            {   
                if(userInput.length() > 6)
                {
                    String userName = userInput.substring(6).trim();
                    
                    Path userFile = Paths.get(folderName).resolve(userName + ".txt"); // or can use userName.concat(".txt");
                    // Path userFile = Paths.get(folderName, userName + ".txt"); also can

                    Files.createFile(userFile);

                }
                else
                {
                    System.out.println("Please enter a username after 'login'. \n");
                }
                
            }

        } while(!userInput.startsWith("login"));
        
       
        // Handle user command
               


        // String loginCommand = userInput.split(" ")[0];
        // String userName = userInput.split(" ")[1];
        
        // System.out.println(loginCommand);
        // System.out.println(userName);
        
        // while (!loginCommand.equals("login"))
        // {
        //     System.out.println("Please login");
        //     userInput = cons.readLine("> ");        
        //     loginCommand = userInput.split(" ")[0];
        //     userName = userInput.split(" ")[1];
        // }

        // while (!userName.equals("login"))
        // {
        //     System.out.println("Please login by entering 'login'<SPACE><Username>.");
        //     userInput = cons.readLine("> ");   
        //     userName = userCommand(userInput);  
        // }
        
        // while(userName.equals("login"))
        // {
        //     System.out.println("Please login with your username");
        //     userName = cons.readLine("> ");

        //     if(!userName.isEmpty())
        //     {
        //         System.out.printf("%s logging in.. \n", userName);
        //     }
        //     else
        //     {
        //         continue;
        //     }
        // }

        displayMenu(); // Show the menu

        
        userInput = cons.readLine("> ");

        String command = userCommand(userInput);

        // System.out.printf("User input: %s \n", userInput); // Shows full input
        // System.out.printf("command: %s \n", command); // Shows selected command

        while(!command.equals("quit"))   
        {
            switch (command) 
            {   
                case ("list"):

                    if(cartList.isEmpty())
                    {
                        System.out.println("Your cart is empty. Add items using the 'Add' command.");
                    }
                    else
                    {
                        int i = 1;
                        for(String item : cartList)
                        {
                            System.out.printf("%d. %s \n", i, item);
                            i++;
                        }
                        System.out.println(cartList);
                    }          
                    break;

                case ("add"):

                    addItems(userInput); 
                    // System.out.println("added");
                    break;

                case ("delete"):
                    
                    deleteItems(userInput);
                    indexList.clear();
                    break;

                case("quit"):
                    System.exit(0);
                    break;

                case("menu"):
                    displayMenu();
                    break;

                default:
                    System.out.println("Invalid input.. Enter 'menu' for instructions." );
                    break;
            }
            
            userInput = cons.readLine("> ");
            command = userCommand(userInput);

        }
   
    } // End of entry point



    // METHODS 
    
    public static void displayMenu() // Method 1 - Printing Instructions
    {
         // Create and print menu instructions
         System.out.println("Enter 'list' to display current cart.");
         System.out.println("Enter 'add'<SPACE><ITEM> to add items to cart.");
         System.out.println("Enter 'delete'<SPACE><S/N> to delete items from cart.");
         System.out.println("Enter 'quit' to terminate program.");
         System.out.println("Enter 'menu' to display instructions again."); 

    }

    public static String userCommand(String inputLine) // Method 2 - Getting user's input
    {      
        Scanner scan = new Scanner(inputLine);
        String command = scan.next().trim().toLowerCase();

        scan.close();

        return command;
    }


    public static List<String> addItems(String inputLine) // Method 3 - Adding Items
    {
        String itemList = inputLine.toLowerCase().substring(4);
        String[] updatedItemList = itemList.split(",");

        for(String item : updatedItemList)
        {
            item = item.trim();

            if(!cartList.contains(item))
            {
                cartList.add(item);
                System.out.printf("%s added to cart. \n", item);
            }
            else
            {
                System.out.printf("%s is already in cart and won't be added again. \n", item);
            }
        }

        return cartList;

    }

    public static void deleteItems(String inputLine) // Method 4 - deleting items
    {
        String indexes = inputLine.substring(7);
        String[] updatedIndexes = indexes.split(",");

        if (cartList.isEmpty())
        {
            System.out.println("Please use 'add' to add something to cart first.");
        }

        else
        {
            for(String index : updatedIndexes)
            {   
                index = index.trim();

                try
                {
                    Integer indexNew = Integer.parseInt(index); 
                                
                    if(!indexList.contains(indexNew))
                    {
                        indexList.add(indexNew);
                    }
                    else if(indexNew <= 0)
                    {
                        System.out.println("Please enter a positive number.");
                    }
                }

                catch(NumberFormatException e)
                {
                    System.out.printf("'%s' is not a valid numeric input. Please enter a valid number. \n", index);
                }
            }    
            
            Collections.sort(indexList, Collections.reverseOrder()); // comparing it a different way, sort in descending order

            for (Integer itemToRemove : indexList)
            {
                try
                {
                    System.out.printf("%s is removed from the cart \n", cartList.get(itemToRemove - 1));
                    cartList.remove(itemToRemove - 1);

                }
                
                catch(IndexOutOfBoundsException e)
                {
                    System.out.println("Please enter a valid numeric index as shown in 'list'");
                }
            }

        }

    }

} // End of Public class Cart