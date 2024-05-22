public class Main{
    public static void main(String[] args) {
        System.out.println("Hello World");
        Cephalopod cephalopod = new Cephalopod("Cuttlefish", 40, 8, 0);
        cephalopod.printInfo();
        cephalopod.removeArm();
        cephalopod.removeArm(2);
    }
}

// NOTE: Assignment - Abstraction
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

    // NOTE: Assignment - Encapsulation
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
// TODO: Add Arms Attribute
// NOTE: Assignment - Inheritance
class Cephalopod extends Animal{
    // Class variables
    private String subSpecies;
    private int arms;
    private int tentacles;
    // NOTE: Assignment - Polymorphism
    // Constructor
    public Cephalopod(String species, String subSpecies, int age, int arms, int tentacles){
        // Call the constructor of the base class
        super(species, age);
        // Set the additonal class variables
        this.subSpecies = subSpecies;
        this.arms = arms;
        this.tentacles = tentacles;
    }
    // Secondary constructor for without sub species
    public Cephalopod(String species, int age, int arms, int tentacles){
        super(species, age);
        this.arms = arms;
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
            System.out.println("My Species is: "+this.getSubSpecies()+" "+this.getSpecies());
            System.out.println("My Age is: "+this.getAge());
        } else {
            super.printInfo();
        }
        if(this.arms > 0){
            System.out.println("I have "+this.arms+" arms!");
        }
        if(this.tentacles>0){
            System.out.println("I have "+this.tentacles+" tentacles!");
        }
    }

    // NOTE: Assignment - Encapsulation
    // ===GETTERS/SETTERS===
    public String getSubSpecies() {
        return subSpecies;
    }
    public void setSubSpecies(String subSpecies) {
        this.subSpecies = subSpecies;
    }
    public void removeArm(){
       this.removeLimb(1, 1);
    }
    public void removeArm(int arms){
        this.removeLimb(arms, 1);
    }
    public void removeTentacle(){
        this.removeLimb(1, 0);
    }
    public void removeTentacle(int limbs){
        this.removeLimb(limbs, 0);
    }
    private void removeLimb(int change, int type){
        int limbs;
        String limb;
        if(type == 0){
            limbs = this.tentacles;
            limb = "tentacle";
        }else if(type == 1){
            limbs = this.arms;
            limb = "arm";
        } else return;
        if(limbs>0) {
            limbs -= change;
            if(this.arms < 0) this.arms = 0;
            System.out.println("I lost "+change+" "+limb+"(s)!");
            if(type == 0) this.tentacles = limbs;
            else if (type == 1) this.arms = limbs;
            System.out.println("I have "+this.arms+" "+limb+"(s) left!");
        } else {
            System.out.println("I have no "+limb+"s to lose!");
        }
    }
}

