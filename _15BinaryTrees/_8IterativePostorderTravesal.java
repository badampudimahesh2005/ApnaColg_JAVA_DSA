import java.util.*;
public class _8IterativePostorderTravesal {

    static class Node{
        int data;
        Node left;
        Node right;

    Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    //Using Single Stack

    static List<Integer> usingSingleStack(Node root){

        Node Curr= root;
        Stack<Node> st = new Stack<>();
        List<Integer> output = new ArrayList<>();

        while(Curr!= null || !st.isEmpty()){

            if(Curr != null){
                st.push(Curr);
                Curr=Curr.left;
            }else{
                Node temp = st.peek().right;
                if(temp == null){
                    temp=st.pop();
                    output.add(temp.data);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp=st.pop();
                        output.add(temp.data);
                    }
                    
                }else{
                    Curr=temp;
                }
            }
        }

        return output;
    }
    // Using Two Stacks
    static List<Integer> IterativePostOrder(Node root){
        List<Integer> output = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()){
            Node current = s1.pop();
            s2.push(current);

            if(current.left != null ){
                s1.push(current.left);
            }
            if(current.right!= null){
                s1.push(current.right);
            }

        }

        while(!s2.isEmpty()){
            output.add(s2.pop().data);
        }
        return output;

    }

    public static void main(String[] args) {

         /*
                 1
                / \
               2   3
              / \ / \
             4  5 6  7
         */

         Node root = new Node(1);
         root.left=new Node(2);
         root.right = new Node(3);
         root.left.left= new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);

         List<Integer> postTraversal = IterativePostOrder(root);
         for (Integer i : postTraversal) {
            System.out.print(i +" ");
         }
        
         System.out.println();
         List<Integer> postOrderTraversal2 =usingSingleStack(root);
         for (Integer i : postOrderTraversal2) {
            System.out.print(i +" ");
         }

    }
    
}