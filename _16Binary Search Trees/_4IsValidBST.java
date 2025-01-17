public class _4IsValidBST {
    
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
    public static boolean isValidBst(Node root, Node min, Node max){

        if(root == null ){
            return true;
        }

        if(min!= null && root.data <=min.data){
            return false;
        }

        else if(max!=null && root.data >=max.data){
            return false;
        }

        return isValidBst(root.left, min, root) && isValidBst(root.right, root, max);

    }

    public static void main(String[] args){
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int val: values){
            root=insert(root, val);
        }

        
        System.out.println(isValidBst(root, null, null));
    }

}
