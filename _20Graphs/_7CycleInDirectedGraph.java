import java.util.*;

public class _7CycleInDirectedGraph {

    static class Edge{
        int src;
        int dest;

        Edge(int source, int destination){
            this.src=source;
            this.dest=destination;
        }
    }


    public static void createGraph(ArrayList<Edge> graph[]){

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,3));

        // graph[0].add(new Edge(0,1));
        // graph[1].add(new Edge(1,2));

        // graph[2].add(new Edge(2,3));

        // graph[3].add(new Edge(3,0));
    }

    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        boolean recStack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(isCycleUtil(graph, i, visited, recStack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int src, boolean visited[], boolean recStack[]){
        visited[src]=true;
        recStack[src]=true;

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest]){
                if(isCycleUtil(graph, e.dest, visited, recStack)){
                    return true;
                }
            }else if(recStack[e.dest]){
                return true;
            }
        }
        recStack[src]=false;
        return false;
    }
    public static void main(String[] args) {

        ArrayList<Edge> graph[] = new ArrayList[4];
        createGraph(graph);

        if(isCycle(graph)){
            System.out.println("Cycle is present");
        }else{
            System.out.println("Cycle is not present");
        }

        
    }
    
}
