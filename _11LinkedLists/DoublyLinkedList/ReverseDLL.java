package LinkedLists.DoublyLinkedList;

/**
 * ReverseDLL
 */
public class ReverseDLL {

    public static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;



    //----------------------Adding Node-----------------
    public void addFirst(int data){
        Node newnode=new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode; 

    }

    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }

    //------------Reverse a Doubly Linked List--------------
         public void reverse(){
            Node curr=head;
            Node prev=null;
            Node next;

            while(curr!=null){
                next=curr.next;
                curr.next=prev;

                curr.prev=next;//new line 

                prev=curr;
                curr=next;
            }
            head=prev;
         }


    //printig the doubly Linked list
    public static void printLinkedList(){
        Node temp=head;

        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
    }


    
    public static void main(String[] args) {

        ReverseDLL dll=new ReverseDLL();
        dll.addFirst(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.addFirst(1);

        printLinkedList();
        dll.reverse();
        printLinkedList();
        
    }
}