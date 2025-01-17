package Arrays;

public class binarySearch {
    
    public static int BinarySearch(int numbers[],int key){
        int start=0;
        int end=numbers.length-1;
       
        while(start<=end){
            int mid=(end+start)/2;
            if(numbers[mid]==key){
                return mid;
            }
            
            if(key>numbers[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        int numbers[]={2,4,6,8,10,12,14};
        System.out.println(BinarySearch(numbers, 10));
        
    }
}
