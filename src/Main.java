import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Declarations
        ArrayList<Edge>[] adjacencyList;
        Paths paths = new Paths();
        NonTouchingLoops nonTouchingLoops = new NonTouchingLoops();
        Result result = new Result();
        Scanner input = new Scanner(System.in);
        int vertices = 0, cmd = 0;
        String[] edge;

        // Get the number of vertices and initializing the graph
        System.out.println("Signal Flow Graph");
        System.out.println("=======================================");
        System.out.print("Enter the number of Nodes: ");
        vertices = input.nextInt();
        Graph graph = new Graph(vertices);
        adjacencyList = new ArrayList[vertices];

        // Getting the edges
        while(cmd != 2){
            System.out.println("\n1.Add Edge\n2.Calculate");
            System.out.print("Select the option's number: ");
            cmd = input.nextInt();
            if(cmd == 1){
                System.out.print("Edge: ");
                edge = input.next().split(",");
                adjacencyList = graph.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), Integer.parseInt(edge[2]));
            }
        }

        // Calculations
        ArrayList<ArrayList<Edge>> forwardPaths = paths.setForwardPaths(0, vertices - 1, vertices, adjacencyList);
        ArrayList<ArrayList<Edge>> loops = paths.setLoops(adjacencyList, vertices);
        ArrayList<ArrayList<ArrayList<Edge>>> nonTouch = nonTouchingLoops.nonTouchingIntoNode(loops);
        result.result(forwardPaths, loops, nonTouch);
    }
}
