package functions;

import java.util.Scanner;

public class javabasics {

    public static int calculatesum(int num1,int num2){//parameters or formal parameters
        int sum=num1+num2;
        return sum;
    }

    public static int product(int num1,int num2){
        int mul=num1*num2;
        return mul;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();

        int sum=calculatesum(a, b);//arguments or actual parameters
        System.out.println("addition:"+sum);

        int mul=product(a, b);
        System.out.println("multiplication:"+mul);

        sc.close();
    }
}
