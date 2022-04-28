import java.util.ArrayList;

public class Output {
    void printForwardPaths(ArrayList<ArrayList<Edge>> forwardPaths, ArrayList<Double> gains, ArrayList<Double> deltaI){
        String path = "";
        System.out.println("\nForward Paths: ");
        System.out.println("=======================================");
        for(int i = 0; i < forwardPaths.size(); i++){
            path = "";
            for(int j = 0; j < forwardPaths.get(i).size(); j++){
                path = path + forwardPaths.get(i).get(j).source + " - ";
            }
            System.out.println(path + "Gain: " + gains.get(i) + " - " + "Delta(i): " + deltaI.get(i));
        }
    }

    void printLoops(ArrayList<ArrayList<Edge>> loops, ArrayList<Double> loopsGains){
        String path = "";
        System.out.println("\nLoops: ");
        System.out.println("=======================================");
        // All the loops
        for(int i = 0; i < loops.size(); i++){
            // Loop
            path = "";
            for(int j = 0; j < loops.get(i).size(); j++){
                path += (loops.get(i).get(j).source + " - ");
            }
            path += loops.get(i).get(0).source + " - ";
            System.out.println(path + "Gain: " + loopsGains.get(i));
        }
    }

    void printNonTouchingLoops(ArrayList<ArrayList<ArrayList<Edge>>> nonTouchingLoops){
        String path = "";
        int temp = 0;
        System.out.println("\nNon Touching Loops: ");
        System.out.println("=======================================");
        for(ArrayList<ArrayList<Edge>> list: nonTouchingLoops){
            for(ArrayList<Edge> loop: list){
                path = "";
                for(Edge edge: loop){
                    path += (edge.source + " - ");
                }
                path += loop.get(0).source + " - ";
                System.out.print(path + "||| ");
            }
            System.out.println("");
        }
    }
}
