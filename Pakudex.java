import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Pakudex extends PakuriProgram
{
    private String[] stringDex = new String[20];                    //new String array to store species names of Pakuri objects

    private Pakuri[] pakuriDex = new Pakuri[20];                    //new Pakuri array to store Pakuri objects so that they can be created and manipulated by the following methods

    public Pakudex()
    {

        pakuriDex = new Pakuri[20];
        stringDex = new String[20];

    }

    public Pakudex(int capacity)                                        //constructor initializes capacity of the arrays to whatever the user inputs in the program
    {


            pakuriDex = new Pakuri[capacity];
            stringDex = new String[capacity];
    }


    public int getSize()                                        //returns the number of elements currently stored in the array
    {

        int size = 0;
        int i;

        for (i = 0; i < pakuriDex.length; i++)                  //iterates through entire array to see if elements of the array are not null; if null, that means nothing has been added yet to the array at
                                                                // that index and the size can be returned
        {

            if (stringDex[i] != null)
            {

                size++;
            }
            if (pakuriDex[i] == null)
            {
                break;
            }

        }
        return size;
    }

    public int getCapacity()                                                //returns the length of the array passed in through the constructor at the beginning of the program
    {

        return pakuriDex.length;
    }

    public String[] getSpeciesArray()                                       //returns a String array of the names of the Pakuri objects currently stored in the Pakudex class
    {
        int i;
        int arrayNum = 1;
        if (getSize() == 0)                                                         //prints error message if no Pakuri have been added to array
        {

            System.out.println("No Pakuri in Pakudex yet!");
            return null;

        } else
        {

            System.out.println("Pakuri In Pakudex: ");

        }


        for (i = 0; i <= getSize() - 1; ++i)
        {
            System.out.println(arrayNum + ". " + stringDex[i]);
            arrayNum++;
        }


        return stringDex;
    }

    public int[] getStats(String species)                                   //returns stats of the Pakuri objects created when they were initially created by the Pakuri class
    {

        int i = 0;
        int[] quickAttack = new int[3];
        boolean foundPokemon = false;
        for (i = 0; i < getSize(); ++i)
        {
            if (stringDex[i].equals(species))                               //adds the Pakuri values of attack, defense, and speed to array
            {

                System.out.println();
                System.out.println("Species: " + species);
                quickAttack[0] = pakuriDex[i].getAttack();
                System.out.println(quickAttack[0]);
                quickAttack[1] = pakuriDex[i].getDefense();
                System.out.println(quickAttack[1]);
                quickAttack[2] = pakuriDex[i].getSpeed();
                System.out.println(quickAttack[2]);
                System.out.println();
                foundPokemon = true;

            }

        }
        if (foundPokemon == false)                  //boolean statement is false if species element is not found in the array, prompting the error message
        {

            System.out.println("Error: No such Pakuri!\n");
            return null;

        }

        return quickAttack;
    }

    public void sortPakuri()                                                //sorts the String array of Pakuri species names into lexicographical order
    {

        Arrays.sort(stringDex , Comparator.nullsLast(Comparator.naturalOrder()));

    }

    public boolean addPakuri(String species)                                 //adds Pakuri object to Pakuri array
    {

        int i = 0;
        Pakuri pocketMonster = new Pakuri(species);

        for (i = 0; i < pakuriDex.length; i++){

            if (pakuriDex[i] == null){                                       //adds Pakuri object to the Pakuri array if nothing exists at the next index (i.e next index equals null)

                pakuriDex[i] = pocketMonster;
                stringDex[i] = species;
                System.out.println("Pakuri species " + species + " successfully added! \n");
                return true;

            }

            else if (getSize() == getCapacity()){                           //prints error message if the Pakudex is full, determined if the current size of the array equals the possible capacity

                System.out.println("Error: Pakudex is full!\n");
                return false;
            }
            else if (stringDex[i].equals(species)) {

                System.out.println("Error: Pakudex already contains this species! \n");             //prints error message if user attempts to add Pakuri object to the Pakudex that already exists in the array
                return false;
            }

        }

        return false;
    }

    public boolean evolveSpecies(String species)                            //evokes .evolve() method from the Pakuri class to evolve the Pakuri objects and redefine their Pakuri attribues (i.e attack, defense, speed)
    {

        int i = 0;

        boolean foundPokemon = false;
        for (i = 0; i < getSize(); ++i)
        {
            if (stringDex[i].equals(species))
            {
                System.out.println(species + " has evolved! \n");

                pakuriDex[i].evolve();
                return true;

            }
        }
        if (foundPokemon == false)
        {

            System.out.println("Error: No such Pakuri!\n");
            return false;

        }
        return false;
    }

}








