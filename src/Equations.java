import java.util.ArrayList;

public class Equations {

    // Calculate the gain of a given path
    double gain(ArrayList<Edge> path) {
        double result = 1;
        for (Edge edge : path) {
            result *= edge.weight;
        }
        return result;
    }

    // Calculate the gains of the Forward Paths
    ArrayList<Double> forwardPathGains(ArrayList<ArrayList<Edge>> forwardPaths){
        ArrayList<Double> gains = new ArrayList<Double>();
        double temp = 0;
        double sum = 0;
        for(ArrayList<Edge> path: forwardPaths){
            temp = gain(path);
            gains.add(temp);
            sum += gain(path);
        }
        return gains;
    }

    // Calculate the gains of the Loops
    ArrayList<Double> loopsGains(ArrayList<ArrayList<Edge>> loops){
        ArrayList<Double> loopsGains = new ArrayList<Double>();
        for(ArrayList<Edge> loop: loops){
            loopsGains.add(gain(loop));
        }
        return loopsGains;
    }

    // Calculates the overall Delta
    double delta(ArrayList<ArrayList<Edge>> forwardPaths, ArrayList<ArrayList<ArrayList<Edge>>> nonTouching, ArrayList<ArrayList<Edge>> loops) {
        double result = 1;
        double sum = 0;

        // The gains of the individual loops
        for(ArrayList<Edge> loop: loops){
            sum += gain(loop);
        }
        result = 1 - sum;

        // The gains of the non-touching loops
        for (int i = 0; i < nonTouching.size(); i++) {
            sum = 1;
            for (int j = 0; j < nonTouching.get(i).size(); j++) {
                sum *= gain(nonTouching.get(i).get(j));
            }
            if (nonTouching.get(i).size() % 2 == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        return result;
    }
}