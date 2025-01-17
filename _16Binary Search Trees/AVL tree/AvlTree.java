/**
 * AvlTree
 */
public class AvlTree {
    static class Node{
        int data;
        int height;
        Node left, right;

        Node(int data){
            this.data=data;
            height=1;
            left=null;
            right=null;
        }
    }
    public static Node root;

    //------------Calculating the height of the tree
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    static int max(int a, int b){
        return (a>b) ? a : b;
    }

    //-----------Calculating Balance Factor

    public static int getBalanceFactor(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);

    }


    //------------LEFT ROTATION
    public static Node leftRotation(Node x){

        Node y=x.right;
        Node t2= y.left;

        //perform rotaion 
        y.left =x;
        x.right=t2;

        //update heights
        x.height =max(height(x.left), height(x.right))+1;
        y.height = max(height(y.left), height(y.right))+ 1;

        //return new root  
        return y;
            
    }

    // -------------RIGHT ROTATION
    public static Node rightRotation(Node y){

        Node x=y.left;
        Node t2= x.right;

        //perform rotaion 
        x.right = y;
        y.left =t2;

        //update heights
        y.height = max(height(y.left), height(y.right))+ 1;

        x.height =max(height(x.left), height(x.right))+1;

        //return new root  
        return x;
            
    }

    //---------------inserting nodes
    public static Node insert(Node root, int key){
        if(root ==null){
            return new Node(key);
        }

        if(key<root.data){
            root.left = insert(root.left, key);

        }else if(key> root.data){
            root.right = insert(root.right, key);
        }else{
            
        return root; //Duplicates keys are not allowed

        }


       
        //updare root height
        root.height = 1 + max(height(root.left), height(root.right));

        //Get root's balance factor
        int bf =getBalanceFactor(root);

        // LEFT-LEFT CASE
        if(bf >1 && key <root.left.data){
            return rightRotation(root);
        }

        // RIGHT-RIGHT CASE
        if(bf <-1 && key> root.right.data){
            return leftRotation(root);
        }
        // RIGHT-LEFT CASE
        if(bf <-1 && key <root.right.data){
            root.right=rightRotation(root.right);
            return leftRotation(root);
        }
        
        // LEFT-RIGHT CASE
        if(bf>1 && key > root.left.data){
            root.left=leftRotation(root.left);
            return rightRotation(root);
        }
        return root;// returned if AVL Balanced


    }

    //------------------PreOrder traversal
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        root =insert(root, 10);
        root =insert(root, 20);
        root =insert(root,30);
        root =insert(root, 40);
        root =insert(root, 50);
        root =insert(root, 25);
        

        preOrder(root);
        
    }
}