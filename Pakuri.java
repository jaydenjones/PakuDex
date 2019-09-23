public class Pakuri
{

        private String speciesName;
        private int attack, defense, speed;


    public Pakuri(String species) {                                 //constructor intializes any new Pakuri objects created to have the following attributes/values so that they can be utilized and stored in the Pakudex class

        speciesName = species;
        attack = (speciesName.length() * 7) + 9;
        defense = (speciesName.length() * 5) + 17;
        speed = (speciesName.length() * 6) + 13;

    }

    public String getSpecies(){

        return speciesName;

        }
    public int getAttack(){
        System.out.print("Attack: ");
        return attack;

    }

    public int getDefense(){
        System.out.print("Defense: ");
        return defense;

    }

    public int getSpeed(){
        System.out.print("Speed: ");
        return speed;

    }

    public void setAttack(int newAttack) {

        attack = newAttack;

    }

    public void evolve() {                                  //method changes initial values initialized by the constructor to the following values

        attack = attack * 2;
        defense = defense * 4;
        speed  = speed * 3;

    }

}
