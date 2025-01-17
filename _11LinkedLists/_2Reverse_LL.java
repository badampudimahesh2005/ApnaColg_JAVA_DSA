package LinkedLists;

public class _2Reverse_LL {

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



//--------------Reverse a Linked List----------------------------

public void reverseALinkedList(){
    if(head ==null){
        return;
    }

    Node prev=null;
    Node curr=tail=head;
    Node next;

    while (curr!=null) {
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;

    }
    head=prev;
}
    
    public static void main(String[] args) {

        Reverse_LL ll=new Reverse_LL();
        ll.appendAtHead(1);
        ll.appendAtTail(2);
        ll.appendAtTail(3);
        ll.appendAtTail(4);
        ll.appendAtTail(6);

        ll.reverseALinkedList();
        ll.printLinkedList();

        
    }
}
