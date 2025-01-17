package Recursions;

public class X_PowerN {

    public static int power(int x,int n){
        if(n==1){
            return x;
        }

        return x*power(x, n-1);
    }

      
public static int optimizedpower(int x,int n){
    if(n==0){
        return 1;
    }
    //int halfpower=optimizedpower(x, n/2)*optimizedpower(x,n/2); Tc->O(n)
    
    int halfpower=optimizedpower(x, n/2);
    int halfpowersq=halfpower*halfpower;

    //n is odd
    if(n % 2 != 0){
        halfpowersq=halfpowersq*x;
    }
    return halfpowersq;

    
}
    public static void main(String args[]){
        int x=5;

       // System.out.println(power(x, 3));
        System.out.println(optimizedpower(x, 4));
    }
    
}
