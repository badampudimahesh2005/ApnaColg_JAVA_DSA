import java.util.ArrayList;
import java.util.Collections;

public class _17KruskalsAlgorithm {
    
    static class Edge implements Comparable<Edge>{
        int src, dest, weight;

        Edge( int src,int destination, int weight){
            this.src = src;
            this.dest=destination;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }


    static void createGraph(ArrayList<Edge> edges){
        //edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n=4;
    static int[] parent = new int[n];
    static int[] rank = new int[n];

    public static  void init(){
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    public static int find(int x){
        if(parent[x]==x)
        return x;
    // return find(par[x]);
    //Path compression 
    return parent[x]=find(parent[x]);
    }

    public static void union(int a, int b){
        int parA=find(a);
        int parB=find(b);

        if(rank[parA] == rank[parB]){
            parent[parB]=parA;
            rank[parB]++;
        }else if(rank[parA] < rank[parB]){
            parent[parB]=parA;
        }else{
            parent[parA]=parB;
        }
    }

    public static void kruskalMST(ArrayList<Edge> edges, int v){
        init();
        Collections.sort(edges);//O(ElogE)
        int minCost =0;
        int count=0;

        for(int i=0; count<v-1;i++){//O(V)
            Edge e= edges.get(i);
            //(src, dest, wt)
            int parA = find(e.src);
            int parB = find(e.dest);

            // if(parA == parB) cycle is present 
            if(parA != parB){
                union(e.src, e.dest);
                minCost += e.weight;
                count++;
            }
        }

        System.out.println(minCost);
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalMST(edges, v);
    }





}
