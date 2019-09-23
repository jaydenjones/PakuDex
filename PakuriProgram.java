
import java.util.InputMismatchException;
import java.util.Scanner;
public class PakuriProgram
{

    private void Menu(){

        System.out.print("Pakudex Main Menu \n" +    //will print menu for program
                "-----------------\n" +
                "1. List Pakuri\n" +
                "2. Show Pakuri\n" +
                "3. Add Pakuri\n" +
                "4. Evolve Pakuri\n" +
                "5. Sort Pakuri\n" +
                "6. Exit\n\n" +
                "What would you like to do? ");

    }

    public static void main(String [] args) {

        PakuriProgram printMenu = new PakuriProgram();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        int pakudexCapacity = 0;
        Pakudex pakuriIndex = new Pakudex(pakudexCapacity); // creates new Pakudex object through which the PakuriProgram driver class will utilize methods from

        while (pakudexCapacity == 0)
        {

            System.out.print("Enter max capacity of the Pakudex: ");

            try                                                                 //try-catch block accounts for potential InputMismatchException or NegativeArraySizeException if user input for
                                                                                //pakudexCapacity is not a valid integer size (i.e. inputting a String or -1 negative number)
            {

                pakudexCapacity = scanner.nextInt();
                if (pakudexCapacity < 0){

                    System.out.println("Please enter a valid size.");
                    pakudexCapacity = 0;

                }
                else {

                    pakuriIndex = new Pakudex(pakudexCapacity);

                }

            }
            catch (InputMismatchException | NegativeArraySizeException e)
            {

                System.out.println("Please enter a valid size.");
                scanner.next();

            }

        }

        System.out.println("The Pakudex can hold " + pakudexCapacity + " species of Pakuri.\n");
        int userChoice = 0;
        int i = 0;

        while (userChoice != 6)   //while loop so that program loops after every user selection in the menu
        {
            int userInput = 0;
            printMenu.Menu();

            while (userInput == 0)
            {
                try                                             // try-catch for if user selection in the menu equals zero
                {
                    userInput = scanner.nextInt();
                    if (userInput == 0)
                    {

                        throw new NumberFormatException("Unrecognized menu selection!\n");
                    }

                }
                catch (InputMismatchException e)
                {

                    System.out.println("Unrecognized menu selection!\n");
                    printMenu.Menu();
                    scanner.next();
                }
                catch (NumberFormatException excpt){

                    System.out.println(excpt.getMessage());
                    printMenu.Menu();

                }

            }

            try                                             // try-catch for if user selection in the menu is not valid (i.e. String or number that is not a menu option, like 0 or 10)
            {

                if (userInput == 1)
                {

                    pakuriIndex.getSpeciesArray();
                    System.out.println();
                }

                if (userInput == 2)
                {

                    System.out.print("Enter the name of the species to display: ");
                    String pokeMain = scanner.next();
                    pakuriIndex.getStats(pokeMain);

                }

                if (userInput == 3)
                {

                    if (pakuriIndex.getSize() == pakudexCapacity)
                    {

                        System.out.println("Error: Pakudex is full! \n");

                    } else
                    {
                        System.out.print("Enter the name of the species to add: ");
                        String pokeMain = scanner.next();
                        pakuriIndex.addPakuri(pokeMain);

                    }

                }

                if (userInput == 4)
                {
                    System.out.print("Enter the name of the species to evolve: ");
                    String pokeMain = scanner.next();
                    pakuriIndex.evolveSpecies(pokeMain);

                }

                if (userInput == 5)
                {
                    System.out.println("Pakuri have been sorted!\n");
                    pakuriIndex.sortPakuri();

                }

                if (userInput == 6)
                {

                    System.out.print("Thanks for using Pakudex! Bye!");
                    break;
                }
                if (userInput > 6 || userInput < 0)
                {

                    throw new NumberFormatException("Unrecognized menu selection!\n");

                }

            }
            catch (NumberFormatException excpt){

                System.out.println(excpt.getMessage());

            }

        }
    }

}
