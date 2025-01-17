package LinkedLists.DoublyLinkedList;

/**
 * DoublyLL
 */
public class DoublyLL {

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

    //-------------------Remove the Node------------------

    public int removeFirst(){
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        if(size==1){ 
        //Linked list has only one Node (head.next==null)
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null; 
        size--;
        return val;
    }


    public int removeLast(){
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){ 
            //Linked list has only one Node (head.next==null)
                int val=head.data;
                head=tail=null;
                size--;
                return val;
            }

            int val=tail.data;
            tail=tail.prev;
            tail.next=null;
            size--;
        return val;
        
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

        DoublyLL dll=new DoublyLL();
        dll.addFirst(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.addFirst(1);

        printLinkedList();

        dll.removeFirst();
        printLinkedList();

        dll.removeLast();
        printLinkedList();


        
        
    }
    
}