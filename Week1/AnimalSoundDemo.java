abstract class Animal {
    abstract void makeSound(String sound);
}

class Dog extends Animal {
    @Override
    void makeSound(String sound) {
        System.out.println("The dog is barking: " + sound);
    }
}

class Cat extends Animal {
    @Override
    void makeSound(String sound) {
        System.out.println("The cat is meowing: " + sound);
    }
}

public class AnimalSoundDemo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound("Woof Woof!");

        Animal cat = new Cat();
        cat.makeSound("Meow Meow!");
    }
}
