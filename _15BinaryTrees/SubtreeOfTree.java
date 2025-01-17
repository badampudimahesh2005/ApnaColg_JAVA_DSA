package BinaryTrees;

import java.util.*;
/**
 * SubtreeOfTree
 */
public class SubtreeOfTree {

    static class Node {
    
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    //Identical checking  process

    public static boolean isIdentical(Node node, Node subRoot){

        if(node == null && subRoot == null){
            return true;
        }else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }

        return true;
         
    }

    public static boolean isSubtree(Node root, Node subRoot){

        if(root == null){
            return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }

        // boolean leftAns = isSubtree(root.left,subRoot);
        // boolean rightAns = isSubtree( root.right, subRoot);
        // return leftAns || rightAns;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

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

         /*
                      2
                     / \
                    4   5 
          */

          Node subTree1= new Node(2);
          subTree1.left = new Node(4);
          subTree1.right = new Node(5);
          /*
                     2
                    / \
                   4   5
                  /
                 3  
           */
          Node subTree2= new Node(2);
          subTree2.left = new Node(4);
          subTree2.left.left = new Node(3);
          subTree2.right = new Node(5);


          System.out.println(isSubtree(root, subTree1));
          System.out.println(isSubtree(root, subTree2));


    }
}