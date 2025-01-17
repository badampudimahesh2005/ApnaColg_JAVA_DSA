package LinkedLists;

/**
 * CircularLinkedList
 */

public class _4CircularLinkedList {

    public static Node head;
    public static Node tail;
    public static int size;

     public static class Node{
    
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }


        public void insertNodeAtHead(int data){
            Node newNode=new Node(data);
            size++;
            if(head==null){
                head=tail=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }

        public void insertNodeAtTail(int data){
            Node newNode=new Node(data);
            size++;
            if (head==null) {
                head=tail=newNode;
                return;
                
            }
            tail.next=newNode;
            tail=newNode;

            
        }



        
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




    
    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        //detect cycle
         Node slow=head;
         Node fast=head;

         boolean cycle=false;
         while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast){
                cycle=true;
                break;
            }

         }
         if(cycle==false){
            return;
         }

         slow=head;
        //find the last node
        Node lastNode=null;
        while(slow!=fast){
            lastNode=fast;
            slow=slow.next;
            fast=fast.next;

        }
        //make the lastnode.next is null
        lastNode.next=null;

    }




    public static void main(String[] args) {
        head= new Node(1);
        Node temp=new Node(2);
        head.next=temp;

        head.next.next=new Node(3);
        head.next.next.next=temp;
        
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
}