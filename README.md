"# vttp5_sdf_day01ws" 

# Objective
The objective of this workshop is to write a console-based shopping cart with
Java. The shopping cart will be stored with an appropriate collection type.

# Setup
a. Create an account on Github.com. You can ignore this step if you have an
account.
b. Create a repository on Github
c. Open your IDE and create the directories called src and classes; these
directories are for your source code and compiled Java classes respectively
d. Make the project directory a Git repository
e. Add .gitignore to ignore the target directory
f. Add the remote repository (step b above) as the origin of your local
repository

# Workshop
Write a Java console program that allows a user to add, remove and list the
contents of a shopping card.
The behaviour of the program is shown below. The > is the prompt

Welcome to your shopping cart
> list
Your cart is empty
> add apple
apple added to cart
> add orange, pear
orange added to cart
pear added to cart
> list
1. apple
2. orange
3. pear
delete 2
orange removed from cart
> list
1. apple
2. pear
> add apple, grapes
You have apple in your cart
grapes added to cart
> list
1. apple
2. pear
3. grapes
> delete 4
Incorrect item index

You are to implement the following commands:

• list - list the contents of the cart. If the cart is empty, print an
appropriate message. The contents of the cart should be numbered when
you are listing them
• add - add one or more items to the cart. Multiple items are separated by a
comma (,).
You should not add an item that is already in the cart. Print an appropriate
message.
Item names are case sensitive (or you can try implementing case
insensitive)
• delete - delete an item from the cart based on the item’s index (from
list command). If an incorrect index is provided, display an error message

git checkout -b feature/implement-shopping-cart-db  # Create and switch to your new branch 
checkout switches the branch, -b creates the new branch.

git add .  # Add your changes
git commit -m "Started implementing ShoppingCartDB and directory management"
git push -u origin feature/implement-db

bugfix/: Used for branches that fix a bug.
hotfix/: Used for urgent fixes that need to go out quickly.
release/: Used for preparing a new release of the project.
chore/: For minor tasks that don't add features or fix bugs (e.g., refactoring, updating documentation).

The / gives the branch name a hierarchical structure, like folders in a file system. This makes it easier to sort and filter branches, especially in large projects where there are many branches.
For example, if you're working on multiple features, you might have branches like:
feature/user-authentication
feature/payment-integration
feature/implement-shopping-cart-db

Merging
git checkout main  # or git checkout master
git pull origin main  # or git pull origin master
git merge feature/implement-shopping-cart-db
git add .  # Stage the resolved files
git commit -m "Merged feature/implement-shopping-cart-db into main"
git push origin main  # or git push origin master

