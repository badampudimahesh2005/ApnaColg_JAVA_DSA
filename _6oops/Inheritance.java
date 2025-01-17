package classes;

public class Inheritance {
    
    public static void main(String args[]){

        Fish shark=new Fish();
        shark.eat();

        Dog dobby=new Dog();
        dobby.legs=4;
        dobby.eat();
        System.out.println("legs:"+dobby.legs);
        dobby.override();
        Mammals mam=new Mammals();
        mam.override();

    }
}


//base class
class Animal{
    String color;

    void eat(){
        System.out.println("eats");
    }

    void breathe(){
        System.out.println("breathes");
    }
    void override(){
        System.out.println("animal");
    }
}

//derived class
//single level inheritance
class Fish extends Animal{
    int fins;

    void  swim(){
        System.out.println("swims in water");
    }
}

//mutilevel inheritance

class Mammals extends Animal{
    int legs;
    void override(){
        System.out.println("mammals");
    }
}

class Dog extends Mammals{
    String breed;
    void override(){
        System.out.println("dog");
    }
}
   


