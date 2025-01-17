package LinkedLists;

import java.util.*;
/**
 * MergesortUsingLL
 */

public class _6MergesortUsingLL {

    public static class Node {
    
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


    public void appendAtHead(int data){
        Node newnode=new Node(data);
        size++;
        if(head==null){
            
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;

    }


    public void appendAtTail(int data){
        Node newnNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newnNode;
            return;
        }
        tail.next=newnNode;
        tail=newnNode;
    }


    

    //print function
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

    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;

        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;//mid node
    }


    private Node merge(Node head1,Node head2){
        Node mergedLL =new Node(-1);   
        Node temp=mergedLL;

        while (head1!=null && head2!=null) {
            if(head1.data <= head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }

        while (head1!=null) {
            temp.next=head1;
                head1=head1.next;
                temp=temp.next;
        }

        while (head2!=null) {
            temp.next=head2;
                head2=head2.next;
                temp=temp.next;
        }

        return mergedLL.next;

    }
public Node mergeSort(Node head){

    if(head==null || head.next==null){
        return head;
    }
         //find mid
         Node mid = getMid(head);

         //left and right ms
         Node righthead=mid.next;
         mid.next=null; 
         Node newleft=mergeSort(head);
         Node newright=mergeSort(righthead);

         //merge
         return merge(newleft,newright); 
    }

    public static void main(String[] args) {
        MergesortUsingLL ll=new MergesortUsingLL();
        ll.appendAtHead(5);
        ll.appendAtTail(3);
        ll.appendAtTail(9);
        ll.appendAtTail(2);
        ll.appendAtTail(4);
        ll.appendAtTail(8);

        ll.printLinkedList();

        ll.head=ll.mergeSort(ll.head);
        ll.printLinkedList();




        
    }

    
}