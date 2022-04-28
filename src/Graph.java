import java.util.ArrayList;

public class Graph {
    int vertices;
    ArrayList<Edge>[] adjacencyList;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i <vertices ; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public ArrayList<Edge>[] addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList[source].add(edge);
        return adjacencyList;
    }
}
