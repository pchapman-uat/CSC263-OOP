public class Main{
    public static void main(String[] args) {
        System.out.println("Hello World");
        Animal animal = new Animal("Cat", 10);
        animal.printInfo();
        animal.setAge(11);
        animal.printInfo();
    }
}

class Animal {
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