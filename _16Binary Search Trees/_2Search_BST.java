public class _2Search_BST {

    static class Node{
        int data;
        Node leftNode;
        Node rightNode;

        Node(int data){
            this.data=data;
            this.leftNode=null;
            this.rightNode=null;
        }
    }

    public static Node insertNode(Node root , int val){
        if(root == null){
            root=new Node(val);
            return root;
        }

        if(root.data >val){
            root.leftNode = insertNode(root.leftNode, val);
        }else{
            root.rightNode=insertNode(root.rightNode, val);
        }

        return root;
    }

    //-----------------------------------Searching in BST
    public static boolean searchKeyInBst(Node root,int key){

        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data <key){
            return searchKeyInBst(root.rightNode, key);
        }else{
            return searchKeyInBst(root.leftNode, key);
        }
    }
    public static void main(String args[]){
        int values[]={8,5,10,3,6,11,1,4,14};
        Node root =null;

        for(int val: values){
            root=insertNode(root,val);
        }
        boolean found=searchKeyInBst(root, 1);
        if(found){
            System.out.println("Key: is found");
        }else{
            System.out.println("Key: is not found");

        }
    }
    
}
