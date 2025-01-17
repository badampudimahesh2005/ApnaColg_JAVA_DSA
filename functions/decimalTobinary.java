package functions;

import java.util.Scanner;

public class decimalTobinary {


    public static int DecimalToBinary(int n){
        int p=0;
        int bin=0;

        while(n>0){
            int rem=n%2;

            bin+=rem*Math.pow(10, p);
            p++;
            n=n/2;
        }
        return bin;
    }

    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();



        System.out.println(DecimalToBinary(n));
        sc.close();

    }
    
}
