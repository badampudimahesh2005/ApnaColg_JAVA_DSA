
import java.util.*;

public class _5CycleDetection {

    public static class Edge{
        int src;
        int dest;

        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;

        }
    }

    static void  createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,2));
        // graph[0].add(new Edge(0,3));

        // graph[1].add(new Edge(1,0));
        // graph[1].add(new Edge(1,2));

        // graph[2].add(new Edge(2,0));
        // graph[2].add(new Edge(2,1));

        // graph[3].add(new Edge(3,0));
        // graph[3].add(new Edge(3,4));

        // graph[4].add(new Edge(4,3));



        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));


    }


    public static boolean detectCycle(ArrayList<Edge> graph[]){

      boolean visited[] = new boolean[graph.length];

      for(int i=0;i<graph.length;i++){
    
        if(!visited[i]){
            //cycle exists in one of the connected components
            if(detectCycleUtil(graph, i, visited, -1)){
                return true;
            }
        }
      }
        return false;
    }

    public  static boolean detectCycleUtil(ArrayList<Edge> graph[], int src, boolean visited[], int parent){
        visited[src] = true;

        for(Edge e: graph[src]){
            //case3
            if(!visited[e.dest]){
                if(detectCycleUtil(graph, e.dest, visited, src)){
                    return true;
                }
            }
            //case1
            else if(visited[e.dest] && e.dest != parent){
                return true;
            }
            //case2--> do nothing -continue
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        System.out.println("Graph contains cycle: " + detectCycle(graph));
        
    }
    
}
