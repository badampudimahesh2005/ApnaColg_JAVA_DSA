package Stack_DSA;

import java.util.Stack;

public class StackClass {

    public static void main(String[] args) {
        
        Stack<Integer> s=new Stack<>();
        
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
    
}
