import java.util.ArrayList;

public class _1InsertionInHeap {


   static class  Heap {
   ArrayList<Integer> heap = new ArrayList<>();
   
   public void add(int data){
    //add at last index
    heap.add(data);

    int x=heap.size()-1;//cild index
    int par = (x-1)/2;//parent index

    while (x > 0 && heap.get(x) < heap.get(par)) { // for min-heap
        // Swap the parent and child
        int temp = heap.get(x);
        heap.set(x, heap.get(par));
        heap.set(par, temp);

        // Update x and par after swapping
        x = par;
        par = (x - 1) / 2;
    }
}


//peek from heap
public int peek(){
    return heap.get(0);
}


private void  heapify(int i){

    int smallest = i; // Initialize largest as root
    int left = 2 * i + 1; // left = 2*i + 1
    int right = 2 * i + 2; // right = 2*i + 2

    // If left child is smaller than root
    if(left <heap.size() && heap.get(smallest) > heap.get(left)){
        smallest=left;
    }

    // If right child is smaller than root
    if(right< heap.size() && heap.get(smallest)> heap.get(right)){
        smallest=right;
    }

    // If smallest is not root
    if(smallest!=i){
        int temp=heap.get(i);
        heap.set(i, heap.get(smallest));
        heap.set(smallest, temp);
// Recursively heapify the affected sub-tree
        heapify(smallest);
    }

}

public int remove(){
    int data = heap.get(0);

    //swap
    int temp=data;
    heap.set(0, heap.get(heap.size()-1));
    heap.set(heap.size()-1, temp);

    //deletion
    heap.remove(heap.size()-1);

    heapify(0);

    return data;
}



public boolean isEmpty(){
    return heap.size() == 0;
}
//print the heap
public void printHeap() {
    System.out.println(heap);
}


}

public static void main(String[] args) {
Heap minHeap = new Heap();

minHeap.add(2);
minHeap.add(3);
minHeap.add(4);
minHeap.add(5);
minHeap.add(10);
minHeap.printHeap();


System.out.println("Heap after insertion:");
minHeap.add(1);

minHeap.printHeap();

while (!minHeap.isEmpty()) {
    System.out.println(minHeap.peek());
    minHeap.remove();
}

}
}