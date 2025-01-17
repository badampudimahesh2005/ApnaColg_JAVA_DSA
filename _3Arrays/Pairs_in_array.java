package Arrays;

public class Pairs_in_array {


    public static void pairs(int numbers[]){

        int tp=0;
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                tp++;
                System.out.print("("+numbers[i]+","+numbers[j]+") ");
            }

            
        }
        //total no.of paris tp= n(n-1)/2
        System.out.println("total pairs:"+tp);
    }


    
    public static void main(String args[]){
        int numbers[]={2,4,6,8,10};

        pairs(numbers);

    }
}
