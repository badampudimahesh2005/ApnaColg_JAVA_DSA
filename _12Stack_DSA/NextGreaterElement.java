package Stack_DSA;

import java.util.Stack;

public class NextGreaterElement {

    public static void printArr(int arr[]){
        for(int ele:arr){
            System.out.print(ele +" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        Stack<Integer> s= new Stack<>();
        int nextGreater[]=new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){

            while(!s.empty() && arr[s.peek()]<=arr[i]){
                
                    s.pop();
                }
            
            if(s.empty()){
                nextGreater[i]=-1;
            }
            else{
                nextGreater[i]=arr[s.peek()];
            }
            s.push(i);
        }

        printArr(nextGreater);

        //Next greater Right
        //Next greater Left
        //Next smaller Right
        //Next smaller Left

        
        
    }
}
 