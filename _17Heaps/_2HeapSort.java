public class _2HeapSort {

    public static void heapify(int i, int size, int[]arr){
        int left=2*i+1;
        int right=2*i+2;
        int largest =i;

        if(left<size && arr[left]>arr[largest]){
            largest=left;
        }

        if(right<size && arr[right]>arr[largest]){
            largest=right;
        }

        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;

            heapify(largest, size, arr);
        }
    }

    public static void heapSort(int arr[]){
        int n=arr.length;

        //step1 --> build max heap
        for(int i=n/2;i>=0;i--){
            heapify(i,n,arr);   //o(n/2 logn)
        }

        //push the largest element at the end
        for(int i=n-1;i>0;i--){
            
            int temp= arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(0,i,arr); //o(n logn)

        }
    }
    
    public static void main(String[] args) {
        int arr[]={1,2,4,5,3};
        int arr2[]={20,10,30,5,50,40};
        heapSort(arr);

        heapSort(arr2);

        for (int i : arr) {
            System.out.println(i);
        }

    }
}
