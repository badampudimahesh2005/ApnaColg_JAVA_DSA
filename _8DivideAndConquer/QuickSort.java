package DivideAndConquer;

public class QuickSort {

     
    //printing array function
    public static void printArr(int arr[]){
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }


    public static void quickSort(int arr[],int start,int end){
        if(start>=end){
            return;
        }
        int pivotidx=partition(arr,start,end);

        quickSort(arr, start, pivotidx-1);
        quickSort(arr, pivotidx+1, end);
    }

    public static int partition(int arr[],int start,int end){
        int i=start-1;
        int pivot=arr[end];

        for(int j=start;j<end;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[end]=arr[i];
        arr[i]=temp;

    return i;

    }
   
    
    public static void main(String args[]){

        int arr[]={6,3,9,5,2,8}; 
        quickSort(arr, 0, arr.length-1);
        printArr(arr);

    }

    
}
