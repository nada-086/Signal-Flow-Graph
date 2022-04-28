import java.util.ArrayList;

public class Result {
    Equations equations = new Equations();
    DeltaI deltaI = new DeltaI();
    Output output = new Output();
    NonTouchingLoops nonTouch = new NonTouchingLoops();

    void result(ArrayList<ArrayList<Edge>> forwardPaths, ArrayList<ArrayList<Edge>> loops, ArrayList<ArrayList<ArrayList<Edge>>> nonTouchingLoops){
        double result = 0;

        ArrayList<Double> forwardPathsGains = equations.forwardPathGains(forwardPaths);
        ArrayList<Double> deltaIGains = deltaI.deltaI(forwardPaths, nonTouchingLoops, loops);
        ArrayList<Double> loopsGains = equations.loopsGains(loops);

        for(int i = 0; i < forwardPathsGains.size(); i++){
            result += (deltaIGains.get(i) * forwardPathsGains.get(i));
        }
        double delta = equations.delta(forwardPaths, nonTouchingLoops, loops);
        output.printForwardPaths(forwardPaths, forwardPathsGains, deltaIGains);
        output.printLoops(loops, loopsGains);
        output.printNonTouchingLoops(nonTouchingLoops);

        System.out.println("=======================================");
        System.out.println("Delta: " + delta);
        System.out.println("Overall Gain: " + (result / delta));
    }
}
