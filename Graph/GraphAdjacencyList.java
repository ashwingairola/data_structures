import java.util.*;

class Graph {
  private int V; // No. of vertices
  private LinkedList<Integer>[] adj; // Array of adjacency lists

  public Graph(int v) {
    V = v;
    adj = new LinkedList[v];
    for(int i=0; i<v; ++i) {
      adj[i] = new LinkedList();
    }
  }

  public void addEdge(int u, int v) {
    this.adj[u].add(v);
    this.adj[v].add(u); // Undirected graph
  }

  static void printGraph(Graph graph) {
    for(int v = 0; v < graph.V; v++) {
      System.out.println("Adjacency list of vertex "+ v);
      System.out.print("head");
      for(Integer pCrawl: graph.adj[v]) {
        System.out.print(" -> "+pCrawl);
      }
      System.out.println("\n");
    }
  }
}

public class GraphAdjacencyList {
  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 4);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
  }
}
