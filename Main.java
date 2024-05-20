public class Main{
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

// An Abstract Class is used as this is a base for animals, it itself will not be used
abstract class Animal {
    // Class variables
    private int age;
    public String species;

    // Constructor
    public Animal(String species, int age){
        this.age = age;
        this.species = species;
    }

    // Print information about the animal 
    public void printInfo(){
        System.out.println("My Species is: "+this.getSpecies());
        System.out.println("My Age is: "+this.getAge());
    }

    // === GETTERS/SETTERS===

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    
}
class Cephalopod extends Animal{
    // Class variables
    // TODO: Add getter and setter
    public String subSpecies;
    // Constructor
    public Cephalopod(String species, String subSpecies, int age){
        // Call the constructor of the base class
        super(species, age);
        // Set the additonal class variables
        this.subSpecies = subSpecies;
    }
    // Secondary constructor for without sub species
    public Cephalopod(String species, int age){
        super(species, age);
    }
    // Swim method
    public void swim(float distance){
        System.out.println("I am swiming for "+distance+" meters");
    }
    // This overrides the printInfo method from the base class
    @Override
    public void printInfo(){
        // If there is a sub species, print it, otherwise print the base class info
        if(subSpecies != null){
            System.out.println("My Species is: "+this.subSpecies+" "+this.getSpecies());
            System.out.println("My Age is: "+this.getAge());
        } else {
            super.printInfo();
        }
    }
}

