package classes;

public class Constructors {
    
    public static void main(String args[]){
        
        // Student s2=new Student("Mahesh");
        // Student s3=new Student(55);

        Student s1=new Student();
        s1.name="mahesh";
        s1.roll=55;
        s1.password="abcdefg";
        s1.marks[0]=100;
        s1.marks[1]=90;
        s1.marks[2]=80;

        Student scopy=new Student(s1); //copy of s1
        scopy.password="xyz";
        s1.marks[2]=100;
        // scopy marks are also chaged even changing the s1 after scopy
        for(int i=0;i<3;i++){
            System.out.println(scopy.marks[i]);
        }

    }
}

class Student{
    String name;
    int roll;
    String password;
    int marks[];


    //shallow copy constructor

    // Student(Student s1){
    //     marks=new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.marks=s1.marks;

    // }


    //Deep copy constructor
    Student(Student s1){
        marks=new int[3];
        this.name=s1.name;
        this.roll=s1.roll;

        for(int i=0;i<marks.length;i++){

            this.marks[i]=s1.marks[i];
        }
    }



    //constructor
    Student(){
        marks=new int[3];

        System.out.println("constructor is called...");
    }
    Student(String name){
        marks=new int[3];

        this.name=name;
    }
    Student(int roll){
        marks=new int[3];

        this.roll=roll;
    }
    Student(String name,int roll){
        marks=new int[3];

        this.name=name;
        this.roll=roll;

    }
}