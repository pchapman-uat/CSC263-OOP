public class Main{
    public static void main(String[] args) {
        System.out.println("Hello World");
        Cephalopod cephalopod = new Cephalopod("Cuttlefish", 40, 8, 0);
        cephalopod.printInfo();
        cephalopod.removeArm();
        cephalopod.removeArm(2);

        Octopus octopus = new Octopus("Dumbo", 3);
        octopus.printInfo();
        octopus.removeTentacle();
        octopus.regrowTentacle();
        octopus.regrowTentacle();
        octopus.removeTentacle(5);

        Squid squid = new Squid("Giant", 5);
        squid.printInfo();
        squid.removeTentacle();
        squid.removeArm(3);
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
    
    public int getTentencle(){
        return this.tentacles;
    }

    public int getArms(){
        return this.arms;
    }

    public void setArm(int arms){
        this.arms = arms;
    }
    public void setTentencle(int limb){
        this.tentacles = limb;
    }
    // ===REMOVING LIMBS===

    // NOTE: Assignment - Polymorphism
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
        // Check for limb type, if not valid end by returning
        if(type == 0){
            limbs = this.tentacles;
            limb = "tentacle";
        }else if(type == 1){
            limbs = this.arms;
            limb = "arm";
        } else return;
        // If there are more than 0 limbs
        if(limbs>0) {
            // Update the limbs
            limbs -= change;
            // Prevent negative number
            if(limbs < 0) limbs = 0;
            // Display the lost limb message
            System.out.println("I lost "+change+" "+limb+"(s)!");
            // Update the variable
            if(type == 0) this.tentacles = limbs;
            else if (type == 1) this.arms = limbs;
            // Display remaining Limbs
            System.out.println("I have "+limbs+" "+limb+"(s) left!");
        } else {
            // Display if there is no limbs to remove
            System.out.println("I have no "+limb+"s to lose!");
        }
    }
}

class Octopus extends Cephalopod{
    // Maximum Limbs
    private int maxLimbs = 8;
    // NTOE: Assignment - Polymorphism
    public Octopus(String subSpecies, int age){
        super("Octopus", subSpecies, age, 0, 8);
    }
    public Octopus(int age){
        super("Octopus", age, 0, 8);   
    }
    // NOTE: Assignment - Polymorphism
    public void regrowTentacle(){
        regrowLimb(1);
    }
    public void regrowTentacle(int limbs){
        regrowLimb(limbs);
    }
    
    private void regrowLimb(int limbs){
        // If they have the max or more limbs
        if(this.getTentencle() >= this.maxLimbs) System.out.println("Unable to grow more limbs");
        else{
            // If adding excedes max, set to max
            if(this.getTentencle()+limbs>maxLimbs)  this.setTentencle(maxLimbs);
            // Else add to limbs
            else this.setTentencle(this.getTentencle()+limbs);

            // Display regrown message
            System.out.println("I have regrown "+limbs+" tentecle(s)! I now have "+this.getTentencle()+" in Total!");
           
        }
    }
}

class Squid extends Cephalopod{
    public Squid(String subSpecies, int age){
        super("Squid", subSpecies, age, 8, 2);
    }
    public Squid(int age){
        super("Squid", age, 8, 2);
    }
}