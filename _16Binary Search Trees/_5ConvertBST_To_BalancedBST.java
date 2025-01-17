import java.lang.reflect.Array;
import java.util.ArrayList;

public class _5ConvertBST_To_BalancedBST {

    static class Node{
        int data;
        Node leftNode;
        Node righNode;

        Node(int data){
            this.data=data;
            this.leftNode=null;
            this.righNode=null;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data >val){
            root.leftNode=insert(root.leftNode, val);
        }else{
            root.righNode = insert(root.righNode, val);
        }

        return root;
    }

    //Inorder sequence Array 
    public static void getInorder(ArrayList<Integer> inorder,Node root){
        if(root == null){
            return;
        }
        getInorder(inorder,root.leftNode);
        inorder.add(root.data);
        getInorder(inorder, root.righNode);
    }


    //Creating Balanced bSt
    public static Node createBalancedBST(ArrayList<Integer> inorder, int st, int end){
        if(st >end){
            return  null;
        }
        int mid= (st+end)/2;
        Node root= new Node(inorder.get(mid));
        root.leftNode=createBalancedBST(inorder, st, mid-1);
        root.righNode=createBalancedBST(inorder, mid+1, end);
        return root;
    }

    public static Node convertToBalancedBST(Node root){
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(inorder, root);

        //sorted order --> Balanced BST
        root=createBalancedBST(inorder, 0, inorder.size()-1);
        return root;
    }

    //PRE-ORDER TRAVERSAL 
    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.leftNode);
        preOrderTraversal(root.righNode);
    }


    public static void main(String[] args) {

                    //       8
                    //      / \
                    //     6   10
                    //    /      \
                    //   5        11
                    //  /          \
                    // 3            12

        Node root= new Node(8);
        root.leftNode = new Node(6);
        root.leftNode.leftNode = new Node(5);
        root.leftNode.leftNode.leftNode = new Node(3);

        root.righNode= new Node(10);
        root.righNode.righNode= new Node(11);
        root.righNode.righNode.righNode= new Node(12);


        root =convertToBalancedBST(root);
        

                    //        8
                    //      /  \
                    //     5    11
                    //    / \   / \
                    //   3   6 10  12
                    preOrderTraversal(root);
                
        
    }

    
}