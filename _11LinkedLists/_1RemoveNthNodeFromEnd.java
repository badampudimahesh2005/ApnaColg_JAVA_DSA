package LinkedLists;

public class _1RemoveNthNodeFromEnd {

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



//--------------------Remove nth from end-----------------------

// nth Node from end == (size-n+1)th Node from start

public void deletNthnodeFromEnd(int n){
    int sz=0;

    Node temp=head;
    while (temp!=null) {
        temp=temp.next;
        sz++;
    }

    if(n==sz){
        head=head.next;
        return;
    }

    int count =1;
    Node prev=head;
    while(count < (sz-n)){
        count++;
        prev=prev.next;
    }
    prev.next=prev.next.next;


}


    public static void main(String[] args) {

        RemoveNthNodeFromEnd ll=new RemoveNthNodeFromEnd();
        ll.appendAtHead(1);
        ll.appendAtTail(2);
        ll.appendAtTail(3);
        ll.appendAtTail(4);
        ll.appendAtTail(6);

        ll.deletNthnodeFromEnd(3);
        ll.printLinkedList();
        
    }
    
}
