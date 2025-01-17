package functions;

public class prime {

    public static boolean isPrime(int n){
       /*
        for(int i=2;i<n-1;i++){
            if(n%i==0){

                return false;   
            }
            
        }

        */

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        boolean ans=isPrime(19);
        System.out.println(ans);

        int count=0;
        for(int i=2;i<=100;i++){
            if(isPrime(i)){
                System.out.print(i +" ");
                count++;
            }
        }
        System.out.println("count:"+count);
    }
    
}
