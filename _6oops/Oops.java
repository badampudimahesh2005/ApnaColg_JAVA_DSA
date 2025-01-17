package classes;

public class Oops {
    public static void main(String[] args){
        Pen p1=new Pen(); // Create a Pen object called p1
         
        p1.setColor("blue");
        System.out.println(p1.color);

        p1.setTip(2);
        System.out.println(p1.tip);


        Bank myac=new Bank();
        myac.username="mahesh";
        // myac.password="abcdefghijklmnopqrstuvwxyz"; not accessible
        myac.setPassword("abcdef");
        System.out.println(myac.getPassword());


        newclass n=new newclass();
    //    n.name="mahesh";
        newclass.name="mahesh"; //we can do like this variable is static
        // newclass.marks=5; gives the error:Cannot make a static reference to the non-static field
        n.marks=86;
        System.out.println(newclass.name);
    }
    
}

// access specifiers

class Bank{
    public String username;
    private String password;

    String getPassword(){
        return this.password;
    }

    public void setPassword(String pwd){
        password=pwd;
    }


}

class Pen{
    String color;
    int tip;

    void setColor(String newColor){
        color=newColor;
    }

    void setTip(int newTip){
        tip=newTip;
    }
}


class student{
    String name;
    int age ;
    float percentage;

    void setname(String newname){
        name=newname;
    }
   
    void calcPercentage(int phy,int chem,int math){
        percentage=(phy+chem+math)/3;
    }
}

class newclass{
    static String name;
    int marks;
}