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
        Path folder;
        
        if(args.length > 0) // if that args are passed 
        {
            folderName = args[0]; // set folder name from args

            folder = Paths.get(folderName);

            if(!Files.exists(folder))
                {
                    Files.createDirectory(folder);
                    System.out.printf("'%s' folder created to store user shopping cart. \n", folderName);
                }
                else
                {
                    System.out.printf("'%s' folder has already been created. Cart would be stored in '%s' \n", folderName, folderName);
                }
        }
        else
        {
            folderName = "cartdb"; // set folder name to default "db"

            folder = Paths.get(folderName);

            if(!Files.exists(folder))
                {
                    Files.createDirectory(folder);
                    System.out.println("No folder specified,'db' folder created to store user shopping cart. \n");
                }
                else
                {
                    System.out.println("No folder specified, storing user shopping cart in existing 'db' folder. \n");
                }
        }
        
        System.out.println("Welcome to your shopping cart.");
        System.out.println("==============================");

         // Handle user command
        Console cons = System.console();

        System.out.println("Please login by entering 'login'<SPACE><USERNAME>.");
        String userInput = cons.readLine("> ").toLowerCase(); 

        userLogin(userInput, folderName); // Login user       
        displayMenu(); // Show the menu after successful login
 
        userInput = cons.readLine("> ");
        String command = userCommand(userInput);

        while(!command.equals("quit"))   
        {
            switch (command) 
            {   
                case("login"):

                    userLogin(userInput, folderName);
                    addUsers(userInput);
                    displayMenu();
                    break;

                case("users"):
                    System.out.println(userList);
                    break;

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

    public static void userLogin(String userInput, String folderName) throws IOException // Method 1 - Do-While for login
    {
        do
        {   
            if(userInput.startsWith("login"))
            {   
                String userName = userInput.substring(5).trim();
                if (!userList.contains(userName))
                {
                    userList.add(userName);
                }

                if(userName.length() > 0) // Means there is a username after login
                {                   
                    Path p = Paths.get(folderName).resolve(userName + ".txt"); // or can use userName.concat(".txt");
                    // Path userFile = Paths.get(folderName, userName + ".txt"); also can

                    if(!Files.exists(p))
                    {
                        Files.createFile(p);

                        File f = p.toFile();
                        String absPath = f.getAbsolutePath();

                        System.out.printf("Logging '%s' in.. Created '%s.txt' file to store cart at <%s> \n", userName, userName, absPath);
                        System.out.println();

                        break;
                    }
                    else
                    {
                        File f = p.toFile(); 
                        String absPath = f.getAbsolutePath();

                        System.out.printf("Logging '%s' in.. Using '%s.txt' file to store cart at <%s> \n", userName, userName, absPath);
                        System.out.println();

                        break;
                    }

                }
                else
                {
                    System.out.println("Invalid username. Please login with 'Login'<SPACE><USERNAME>\n");
                }
            }

        } while(true);

    }   
    
    public static void displayMenu() // Method 1 - Printing Instructions
    {
         // Create and print menu instructions
         System.out.println("To login other user(s):            Enter 'login'<SPACE><USERNAME>");
         System.out.println("To display list of user(s):        Enter 'users'");
         System.out.println("To display current user's cart:    Enter 'list'");
         System.out.println("To add items to cart:              Enter 'add'<SPACE><ITEM>");
         System.out.println("To delete items from cart:         Enter 'delete'<SPACE><S/N>");
         System.out.println("To save current user's cart:       Enter 'save'");
         System.out.println("To terminate program:              Enter 'quit'");
         System.out.println("To display instructions again:     Enter 'menu'"); 

    }

    public static String userCommand(String inputLine) // Method 2 - Getting user's input
    {      
        Scanner scan = new Scanner(inputLine);
        String command = scan.next().trim().toLowerCase();

        scan.close();

        return command;
    }
    
    public static List<String> addUsers(String inputLine)
    {
        String userName = inputLine.substring(5).trim();

        if(!userList.contains(userName))
        {
            userList.add(userName);
        }
        else
        {
            System.out.printf("%s is already logged into the system. \n", userName);
        }
        

        return userList;
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