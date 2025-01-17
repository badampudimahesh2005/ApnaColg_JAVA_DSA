package BinaryTrees;

import java.util.*;


public class BuildTree_preorder {

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

            static class BinaryTree {
                static int idx = -1;

                public static Node buildTree(int nodes[]){
                    idx++;
                    if(nodes[idx]== -1){
                        return null;
                    }

                    Node newNode = new Node(nodes[idx]);
                    newNode.left = buildTree(nodes);
                    newNode.right = buildTree(nodes);

                    return newNode;
                }


                //------------INORDER TRAVERSAL--------------------

                public static void inorderTraversal(Node root){
                    if(root == null){
                        // System.out.print(-1+" ");
                        return;
                    }
                    inorderTraversal(root.left);
                    System.out.print(root.data+" ");

                    inorderTraversal(root.right);
                }

                
                 //------------PREORDER TRAVERSAL--------------------

                 public static void preorderTraversal(Node root){
                    if(root == null){
                        // System.out.print(-1+" ");
                        return;
                    }
                    System.out.print(root.data+" ");
                    preorderTraversal(root.left);
                    preorderTraversal(root.right);
                }

                 //------------POSTORDER TRAVERSAL--------------------

                 public static void postorderTraversal(Node root){
                    if(root == null){
                        // System.out.print(-1+" ");
                        return;
                    }
                    postorderTraversal(root.left);
                    postorderTraversal(root.right);
                    System.out.print(root.data+" ");

                }


                //Level Order Traversal

                public static void levelOrder(Node root){

                    if(root == null){
                        return;
                    }

                    Queue<Node> q= new LinkedList<>();
                    q.add(root);
                    q.add(null);
                    while (!q.isEmpty() ) {
                        Node currNode = q.remove();
                    if (currNode==null) {
                        System.out.println();

                        if(q.isEmpty()){
                            break;
                        }else{
                            q.add(null);
                        }
                        
                    } else{
                        System.out.print(currNode.data+" ");
                        if(currNode.left != null){
                            q.add(currNode.left);
                        }
                        if(currNode.right != null){
                            q.add(currNode.right);
                        }

                    }

                          
                }
                }

                
            }
    
    public static void main(String[] args) {
        
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root= tree.buildTree(nodes);
        // System.out.println(root.data);

        System.out.println("Inorder Traversal");
        tree.inorderTraversal(root);

        System.out.println("\nPreorder Traversal");
        tree.preorderTraversal(root);

        System.out.println("\nPostorder Traversal");
        tree.postorderTraversal(root);

        System.out.println("\nLevel Order Traversal");

        tree.levelOrder(root);

        
    }
}