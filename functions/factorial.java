package functions;

public class factorial {

    public static int fact(int n){
        if(n==1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static int bincoeff(int n,int r){
        // ncr= n!/r!*(n-r)!
        int nfact=fact(n);
        int rfact=fact(r);
        int n_rfact=fact(n-r);
        int res=nfact/(rfact*n_rfact);
        
        return res;
    }

    public static void main(String[] args){
        int n=5;
        int r=3;
        int ans =fact(n);
        System.out.println(ans);
        System.out.println(bincoeff(n, r));
    }
    
}
