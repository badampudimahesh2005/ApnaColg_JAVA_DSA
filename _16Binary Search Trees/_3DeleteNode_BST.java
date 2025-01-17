public class _3DeleteNode_BST {
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
    
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
         
    }
    

    public static Node delete(Node root, int val){

        if(root.data >val){
            root.left=delete(root.left, val);
        }else if(root.data < val){
            root.right=delete(root.right,val);
        }else{

            //case 1: No child
            if(root.left == null && root.right==null){
                return null;
            }

            //case 2: Single child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //case 3: Node with Two children 

            //Finding inorderSuccessor -> leftmost node in right subTree
            Node inorderSuccessor = findInorderSuccessor(root.right);
            root.data=inorderSuccessor.data;

            root.right = delete(root.right, inorderSuccessor.data);
            //why we are assigning to the root.right here because after deleting the inorder successor ,
            // if it has another node(right node-> since inorder successor always has 0 or 1 node) it will connect to root.right



        }
        return root;
    }


    //----------------inorder Successor
    public static Node findInorderSuccessor(Node root){
        while (root.left != null) {
            root=root.left;
        }
        return root;
    }


    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        
        int values[]={8,5,10,3,6,11,1,4,14};
        Node root =null;

        for(int val: values){
            root=insert(root,val);
        }
        inOrder(root);
        System.out.println();
        delete(root,5);

        inOrder(root);
        System.out.println();
    }
}
