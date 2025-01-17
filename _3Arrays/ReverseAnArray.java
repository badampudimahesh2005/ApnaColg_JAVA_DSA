package Arrays;

public class ReverseAnArray {
    
    public static void reverse(int numbers[]){

        int i=0;
        int j=numbers.length-1;
        while(i<=j){
            int temp=numbers[i];
            numbers[i]=numbers[j];
            numbers[j]=temp;
            
            
            i++;
            j--;
        }

   

    }

    public static void main(String[] args){

    int numbers[]={2,4,6,8,10,11};
    System.out.println("Before reverse: ");
    for(int i=0;i<numbers.length;i++){
        System.out.print(numbers[i]+" ");
    }
    System.out.println();



    reverse(numbers);

    System.out.println("After reverse: ");

    for(int l=0;l<numbers.length;l++){
        System.out.print(numbers[l]+" ");
    }
}
}
