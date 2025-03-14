import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _DfsAndBfsForUnconnectedComp {

    static class Edge{
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge> graph []){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }


    //---------------------Breadth First Search------------------------------------------------

    public static void bfs(ArrayList<Edge> graph[]){


        boolean visited[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                bfsUtil(graph, i, visited);
            }
        }

    }

    //time-complexity -> O(V+E) where V is the number of vertices and E is the number of edges in the graph 
    
    public static void bfsUtil(ArrayList<Edge> graph[], int source, boolean visited[]){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");

            for(Edge e: graph[current]){
                if(!visited[e.destination]){
                    queue.add(e.destination);
                    visited[e.destination] = true;
                }
            }
        }
    }


    //-----------------Depth First Search --------------------------------------

    public static void dfs(ArrayList<Edge> graph[]){


        boolean visited[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfsUtil(graph, i, visited);
            }
        }

    }


    public static void dfsUtil( ArrayList<Edge> graph[], int source, boolean visited[]){

        System.out.print(source + " ");
        visited[source] = true;

        for(int i=0;i< graph[source].size();i++){
            Edge e= graph[source].get(i);
            if(!visited[e.destination]){
                dfsUtil(graph, e.destination, visited);
            }
        }

    }

    public static void main(String[] args) {
        
    }
    
}
