package functions;

import java.util.Scanner;

public class binaryTodecimal {
    


    public static int BinaryToDecimal(int n){
        int p=0;
        int dec=0;
        while(n>0){
            int ld=n%10;
            dec+=ld*Math.pow(2, p);
            p++; 

            n/=10;

        }
        return dec;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the binary number to convert into decimal: ");
        int n=sc.nextInt();

        System.out.println(+BinaryToDecimal(n));

        sc.close();
    }
    
}
