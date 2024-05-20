public class Main{
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
class Animal {
    // Class variables
    // TODO: Add Setters and Getters
    private int age;
    public String species;

    // Constructor
    public Animal(String species, int age){
        this.age = age;
        this.species = species;
    }

    // Print information about the animal 
    public void printInfo(){
        System.out.println("My Species is: "+this.species);
        System.out.println("My Age is: "+this.age);
    }

    // === GETTERS/SETTERS===

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}