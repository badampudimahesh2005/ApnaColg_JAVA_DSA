package Recursions;

public class NumbersInRevOrder {

public static void numbersInReverseOrder(int n){
    //base case
    if(n==1){
        System.out.println(n);
        return; 
    }
    // System.out.println(n+" ");
    numbersInReverseOrder(n-1);

    // for increasing order
    System.out.println(n+" ");

}
    public static void main(String args[]){
        int n=10;
        numbersInReverseOrder(n);
    }
    
}
