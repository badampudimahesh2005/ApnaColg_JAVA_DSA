
import java.util.*;
public class _16DisjointSetDataStructure {

    static int n=7;
    static int par[]= new int [n];
    static int rank[]=new int[n];

    public static  void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }

    public static int find(int x){
        if(par[x]==x)
        return x;
    // return find(par[x]);
    //Path compression 
    return par[x]=find(par[x]);
    }

    public static void union(int a, int b){
        int parA=find(a);
        int parB=find(b);

        if(rank[parA] == rank[parB]){
            par[parB]=parA;
            rank[parB]++;
        }else if(rank[parA] < rank[parB]){
            par[parB]=parA;
        }else{
            par[parA]=parB;
        }
    }



    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);

        System.out.println(find(3));
        System.out.println(find(4));

    }
    
}
