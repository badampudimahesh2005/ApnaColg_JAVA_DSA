package Stack_DSA;

import java.util.Stack;



public class Reverse_A_Stack {

    
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.empty()){
            s.push(data);
            return;
        }

        int top=s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverseAStack(Stack<Integer> s){
        if(s.empty()){
            return;
        }
        int top=s.pop();
        reverseAStack(s);

        pushAtBottom(s,top);
    }

    public static void printStack(Stack<Integer> s){
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
    
    public static void main(String[] args) {

        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        
        reverseAStack(s);

        printStack(s);


        
    }
}
