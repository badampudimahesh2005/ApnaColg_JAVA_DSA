
public class Height_of_BT {
    
static class Node{

    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

}

//Height of the tree
public static int heightOfBT(Node root){
    if(root == null){
        return 0;
    }

    int lh = heightOfBT(root.left);
    int rh = heightOfBT(root.right);

    return Math.max(lh,rh)+1;
}

//----------------------COUNT OF NODES IN THE TREE ---------

public static int countNodes(Node root){
    if(root == null){
        return 0;
    }

    int lcount =countNodes(root.left);
    int rcount =countNodes(root.right);

    return lcount+ rcount + 1;
}


//----------------SUM OF NODES IN THE TREE -------

public static int sumOFNodes(Node root){
    if(root == null){
        return 0;
    }

    int lsum = sumOFNodes(root.left);
    int rsum = sumOFNodes(root.right);

    return lsum + rsum + root.data;
}
    public static void main(String args[]){

        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left= new Node(6);
        root.right.right= new Node(7);
        
        System.out.println("Height of the tree: "+heightOfBT(root));

        System.out.println("Number of nodes in tree: "+countNodes(root));

        System.out.println("Sum of Node in the tree: "+sumOFNodes(root));

    }
}
