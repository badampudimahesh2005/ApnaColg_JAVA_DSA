package Arrays;

public class lineraSearch {


    public static int Search(int numbers[],int k){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==k){
                return i;
            }
        }
        return -1;
    }

    //.........Largest Number In The Array..............

    public static int largestnum(int numbers[]){
        int largest=0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]>largest) {
                largest=numbers[i];
            }
        }

        return largest;
    }

    public static void main(String[] args){

        int numbers[]={2,3,5,7,11,13,17,19};
        int key=11;
        System.out.println("index of the key is :"+Search(numbers,key));

        System.out.println("largest element in the array: "+largestnum(numbers));
    }
}
