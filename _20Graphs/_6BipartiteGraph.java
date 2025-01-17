import java.util.*;

public class _6BipartiteGraph {

    static class Edge{
        int src;
        int dest;
       

        Edge(int source, int destination){
            this.src=source;
            this.dest=destination;
        
        }

    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));

    }



    // 

    public static boolean isBipartite(ArrayList<Edge> graph[]){

        int col[] = new int[graph.length];
        Arrays.fill(col,-1);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(col[i] == -1){ //BFS
                q.add(i);
                col[i]=0;//yellow color

                while(!q.isEmpty()){
                    int curr = q.remove();

                    for(int j=0;j<graph[curr].size();j++){
                       Edge e= graph[curr].get(j);

                       //if the destination is not colored
                       if(col[e.dest] == -1){
                            col[e.dest]=1-col[curr];
                            q.add(e.dest);
                       }else if(col[e.dest] == col[curr]){ //if the destination is colored and it is same as the current color
                           return false;//not bipartite
                       }
                    }
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {

        int vertices=5;

        ArrayList<Edge> graph[]=new ArrayList[vertices];

        createGraph(graph);

        //if graph does not contain any cycle then it is a Bipartite graph by default

        if(isBipartite(graph)){
            System.out.println("Graph is Bipartite");
        }else{
            System.out.println("Graph is not Bipartite");
        }
        
        
        

    }
    
}
