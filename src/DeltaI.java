import java.util.ArrayList;

public class DeltaI {
    Equations equations = new Equations();

    ArrayList<Double> deltaI(ArrayList<ArrayList<Edge>> forwardPaths, ArrayList<ArrayList<ArrayList<Edge>>> nonTouching, ArrayList<ArrayList<Edge>> loops){
        // Declarations
        ArrayList<Double> gainI = new ArrayList<Double>();
        double result = 1;
        double sum = 0;

        // The Delta(i) for each forward path
        for(ArrayList<Edge> path: forwardPaths){
            result = 1;
            sum = 0;
            for(ArrayList<Edge> loop: loops){
                if(checkLoop(path, loop)){
                    sum += equations.gain(loop);
                }
            }
            result = 1 - sum;
            for (ArrayList<ArrayList<Edge>> list : nonTouching) {
                if(check(path, list)){
                   if(list.size() % 2 == 0){
                       result += gain(list);
                   }
                   else{
                       result -= gain(list);
                   }
                }
            }
            gainI.add(result);
        }
        return gainI;
    }

    // Check if the paths in the list lies on that forward path
    boolean check(ArrayList<Edge> path, ArrayList<ArrayList<Edge>> nonTouching){
        for(Edge mainEdge: path){
            for(ArrayList<Edge> loop: nonTouching){
                for(Edge edge: loop){
                    if(edge.equal(mainEdge)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean checkLoop(ArrayList<Edge> forwardPath, ArrayList<Edge> loop){
        for(int i = 0; i < forwardPath.size(); i++){
            for(int j = 0; j < loop.size(); j++){
                if(forwardPath.get(i).equal(loop.get(j))){
                    return false;
                }
            }
        }
        return true;
    }

    double gain(ArrayList<ArrayList<Edge>> list){
        double sum = 1;
        for(ArrayList<Edge> loop: list){
            sum *= equations.gain(loop);
        }
        return sum;
    }
}
