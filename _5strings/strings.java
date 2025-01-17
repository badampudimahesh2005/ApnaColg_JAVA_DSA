package strings;

import java.util.Scanner;

public class strings {


    public static void main(String[] args){

        char ch[]={'m','a','h','e','s','h'};
        
        String str="mahesh";
        String str1=new String("mahesh");
        System.out.println(ch);
        System.out.println(str);
        System.out.println(str1);

        System.out.println(str1.charAt(5));


        //..........Strings are immutable
        Scanner sc = new Scanner(System.in);
        

        //.........input in string
        // String a=sc.nextLine();
        // System.out.println(a);

        sc.close();
    }
    
}
