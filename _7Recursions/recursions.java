package Recursions;

public class recursions {

    //factorial of a number
    /*

    int fact=1;
     for(int i=2;i<=n;i++){
        fact=fact*i;
     }
     return fact;

     */


    public static int factorial(int n){

        if(n==0 || n==1){
            return n;
        }
        return n*factorial(n-1);//TC-O(n) sp-O(n)
    }

    //sum of first n natural numbers

    /* 
     int sum=0;
     for(int i=1;i<=n;i++){
        sum+=i;
     }
    */
    public static int sumOfNumbers(int n){
        if(n==1){
            return 1;
        }
        
        return n+sumOfNumbers(n-1);
    }

    //print nth fibonacci number
    /*
    if(n==0 || n==1){
        return n;
    }

    int prev=0;
    int current=1;
    for(int i=2;i<=n;i++){
        int next=prev+current;
        prev=current;
        current=next;
    }
    return current;
     
     */
    public static int fibonacciNumer(int n){
        if(n==0 || n==1){
            return n;
        }
        
        return fibonacciNumer(n-1)+fibonacciNumer(n-2);//TC-O(2^n) sp-O(n)  it makes pgrm slow,however we can make linear TC in DP 
    }

    //check if array is sorted or not
    public static boolean isSorted(int[] arr,int i){

        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);//TC-O(n) sp-O(n)

    }

    //write a fun to find the first occurence of an element in an array
    public static int firstOccurence(int arr[],int key,int i){
        //base case
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }

        return firstOccurence(arr, key, i+1);
    }

    
    //write a function to find the last occurence of an element in an array
    public static int lastOccurence(int arr[],int key,int i){
        // if(i== -1){
        //     return -1;
        // }
        // if(arr[i]==key){
        //     return i;
        // }
        
        // return lastOccurence(arr, key, i-1);

        //another method
        if(arr.length==-1){
            return -1;
        }
        int isfound=lastOccurence(arr, key, i+1);
        if(isfound==-1 && arr[i]==key){
            return i;
        }
        return isfound;
    }

    public static void main(String args[]){
        int n=5;
        System.out.println("factorial of "+n+" is "+factorial(n));
        System.out.println("sum of "+n +" natural numbers "+sumOfNumbers(n));
        System.out.println("fibonacci of "+n+"th numbers is "+fibonacciNumer(n));


        int arr[]={1,2,3,4,5};
        int arr2[]={2,3,5,4,1};
        if(isSorted(arr, 0)){
            System.out.println("array is sorted");
        }else{
            System.out.println("array is not sorted");
        }


        int idx=firstOccurence(arr2, 5, 0);
        if(idx!=-1){
        System.out.println("key found at index: "+idx);
        }else{
            System.out.println("key not found");

        }

        
    }
    
}
 