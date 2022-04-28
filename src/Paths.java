import java.util.ArrayList;

public class Paths {
    ArrayList<ArrayList<Edge>> forwardPaths = new ArrayList<ArrayList<Edge>>();
    ArrayList<ArrayList<Edge>> loops = new ArrayList<ArrayList<Edge>>();
    Edge loop;

    // Find the Forward Paths
    public ArrayList<ArrayList<Edge>> setForwardPaths(int s, int d, int v, ArrayList<Edge>[] adjList) {
        boolean[] isVisited = new boolean[v];
        ArrayList<Edge> pathList = new ArrayList<>();
        forwardPathsUtil(s, d, isVisited, pathList, adjList, forwardPaths);
        return forwardPaths;
    }

    // Depth First Search
    private void forwardPathsUtil(int u, int d, boolean[] isVisited, ArrayList<Edge> pathList, ArrayList<Edge>[] adjList, ArrayList<ArrayList<Edge>> output) {
        if (u == d) {
            ArrayList<Edge> temp = (ArrayList<Edge>) pathList.clone();
            if(loop != null){
                temp.add(loop);
            }
            output.add(temp);
            return;
        }
        isVisited[u] = true;
        for(Edge edge: adjList[u]){
            if(!isVisited[edge.destination]){
                pathList.add(edge);
                forwardPathsUtil(edge.destination, d, isVisited, pathList, adjList, output);
                pathList.remove(edge);
            }
        }
        isVisited[u] = false;
    }

    // Finds the loops
    ArrayList<ArrayList<Edge>> setLoops(ArrayList<Edge>[] adjList, int vertices){
        for(int i = 0; i < adjList.length; i++){
            for(Edge edge: adjList[i]){
                if(edge.source == edge.destination){
                    ArrayList<Edge> temp = new ArrayList<>();
                    temp.add(edge);
                    loops.add(temp);
                }
                if(edge.source > edge.destination){
                    boolean[] isVisited = new boolean[vertices];
                    ArrayList<Edge> pathList = new ArrayList<>();
                    loop = edge;
                    forwardPathsUtil(edge.destination, edge.source, isVisited, pathList, adjList, loops);
                }
            }
        }
        loop = null;
        return loops;
    }
}