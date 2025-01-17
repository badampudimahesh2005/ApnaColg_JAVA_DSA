package BinaryTrees;

public class DiameterofTree {
    
    static class  Node {
    
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh,rh)+1;
    }

    public static int diameter2(Node root){
        if(root == null){
            return 0;
        }

        int leftDiam =diameter2(root.left);
        int leftH = height(root.left);
        int rightDiam =diameter2(root.right);
        int rightH = height(root.right);

        int selfDiam = leftH+rightH + 1;


        return Math.max(selfDiam,Math.max(rightDiam, leftDiam));

        
    }

    static class info {
    
        int diam;
        int ht;

        public info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }

    }

    public static info diameter(Node root){

        if(root == null){
            return new info(0, 0);
        }

        info leftInfo = diameter(root.left);
        info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

        return new info(diam,ht);
    }

    

    public static void main(String args[]){

        
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left= new Node(6);
        root.right.right= new Node(7);
        
        // System.out.println(diameter2(root));

        System.out.println(diameter(root).diam);


    }
}
