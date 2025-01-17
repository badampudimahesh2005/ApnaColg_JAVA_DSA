package LinkedLists;

/**
 * PalindromeOrNot
 */
public class _3PalindromeOrNot {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    public static Node head;
    public static Node tail;

    public static int size;


    //------------APPENDING NODE AT FIRST------------------------------
    public void appendAtHead(int data){
        Node newnode=new Node(data);
        size++;
        //when there is no head
        if(head==null){
            head=tail=newnode;
            return;
        }
        //link
        newnode.next=head;

        //changing head
        head=newnode;
    }

    //------------APPENDING NODE AT END---------------------------------

    public void appendAtTail(int data){

        Node newnode=new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }

        //Node current=head;
        // while (current.next != null) {
        //     current = current.next;
        // }
        // current.next = newNode;
        

        tail.next=newnode;
        tail=newnode;
    }

    

//----------------PRINT FUNCTION-------------------------------------

public  void printLinkedList(){
    if (head==null) {
        System.out.print("Linked List is empty");
    }
    Node temp=head;
    while (temp!=null) {
        System.out.print(temp.data+" ->");
        temp=temp.next;
    }
    System.out.println();
}


//------------------Palindrome or not----------------

public Node findMid(Node head){
    Node slow=head;
    Node fast=head;

    while (fast!=null && fast.next!=null) {
        slow=slow.next;
        fast=fast.next.next;
    }

    return slow; //slow is my midNode
}

public boolean checkPalindrome(){
    if(head == null || head.next==null){
        return true;  
    }
    //step1-find mid
    Node midNode=findMid(head);

    //step2-reverse from mid to end
    Node prev=null;
    Node curr=midNode;
    Node next;

    while (curr!=null) {
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    Node right=prev;
    Node left=head;

    //step3- check 1st half is equal to 2nd half
    while (right!=null) { 
        if(left.data!=right.data){
            return false;
        }
        left=left.next;
        right=right.next;
    }
    return true;
}
    
    public static void main(String[] args) {

        PalindromeOrNot ll= new PalindromeOrNot();
        ll.appendAtHead(1);
        ll.appendAtTail(2);
        ll.appendAtTail(3);
        ll.appendAtTail(2);
        ll.appendAtTail(1);
        ll.printLinkedList();

        System.out.println(ll.checkPalindrome());
        ll.printLinkedList();


        
    }

}