package LinkedLists;

public class _7Zig_Zag_LinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data ){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;


    public void appendAtHead(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void appendAtTail(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
    }

    public void printLinkedList(){

        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
    }
    

    //---------------------Zig_Zag Linked list-----------

    public Node miNode(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public void zigZag(){

        //midnode
        Node mid=miNode(head);

        //reverse the second half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next; 
        }

        // alternate merging
        Node lefNode=head;
        Node rigNode=prev;
        Node nextLNode;
        Node nextRNode;

        while (lefNode!=null && rigNode!=null) {
            nextLNode=lefNode.next;
            lefNode.next=rigNode;
            nextRNode=rigNode.next;
            rigNode.next=nextLNode;

            //update variables
            lefNode=nextLNode;
            rigNode=nextRNode;
        }
    }
    public static void main(String[] args) {
        

        Zig_Zag_LinkedList ll=new Zig_Zag_LinkedList();
        ll.appendAtHead(1);
        ll.appendAtTail(2);
        ll.appendAtTail(3);
        ll.appendAtTail(4);
        ll.appendAtTail(5);
        ll.appendAtTail(6);

        ll.printLinkedList();
        ll.zigZag();
        ll.printLinkedList();
    }
}
