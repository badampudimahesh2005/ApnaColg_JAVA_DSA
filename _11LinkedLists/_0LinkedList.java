

import java.util.Scanner;

public class _0LinkedList {

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

    


    //------------APPENDING NODE AT A POSITION--------------------------

    public void appendNodeAtPosition(int data,int pos){
        if(pos==0){
            appendAtHead(data);
            return;
        }
          
        Node newnNode=new Node(data);
        size++;
        int count=1;

        Node temp=head;
        while(temp!=null && pos!=count){
            temp=temp.next;
            count++;
        }
        newnNode.next=temp.next;
        temp.next=newnNode;
    }


    //================[DELETION OF NODE IN LINKED LIST]=================

    //--------------------REMOVE NODE AT FIRST-------------------------
    
    public int  removeAtFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;   
            return val;
        }

        int val=head.data;
        head=head.next;
        size--;
        return val;
    }


     //--------------------REMOVE NODE AT LAST------------------------- 

     public int removeAtLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size ==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
       
        //prev:i=size-2
        Node prev=head;
        for (int i = 0; i < size-2; i++) {
            prev=prev.next;
        }
        /*
         while(prev.next.data != tail.data){
            prev=prev.next;
         }
         */

        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;

    
        return val;
     }

     //-------------------------REMOVE NTH NODE FROM LL----------------

     public int removeNthNode( int pos){
        if(pos==1){
            int val = head.data;
            head=head.next;
            return val;
        }
        
        Node prev=null;
        Node curr=head;
        int count=1;

        /*
         for (int i = 1; i < pos; i++) {
                prev= curr;
                curr= curr.next;
            }
         */
        while(curr!=null && pos!=count){
            prev=curr;
            curr=curr.next;
            count++;
        }
        int val=curr.data;
        prev.next=curr.next;
        return val;
     }

     //----------------ITERATIVE SEARCH-------------------------------

     public int itrSearch(int key){ //O(n)
        Node temp=head;
        int i=0;

       while (temp!=null) {
        if (temp.data == key) {
            return i;
        }
        temp=temp.next;
        i++;
        
       }

       return -1;

     }

     //----------------------RECURSIVE SEARCH---------------------------


     public int  helper(Node head,int key){
        if(head ==null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
     }

     public int recursiveSearch(int key){

        return helper(head,key);
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

    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.printLinkedList();

        ll.appendAtHead(1);
        ll.appendAtTail(2);
        ll.appendAtTail(3);
        ll.appendAtTail(4);
        ll.appendAtTail(6);
        
        ll.printLinkedList();

        ll.appendNodeAtPosition(5, 4);
        ll.printLinkedList();

        ll.appendNodeAtPosition(5, 0);
        ll.printLinkedList();

        ll.removeAtFirst();
        ll.printLinkedList();

        ll.removeAtLast();
        ll.printLinkedList();





System.out.println("size: "+size);
        

        
    }
} 