public class Edge implements Cloneable{
    int source;
    int destination;
    double weight;
    Edge(int source, int destination, double weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // To copy an Edge object by value not by reference
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Compares the this object with the input one
    public boolean equal(Edge edge){
        if(this.source == edge.source
        && this.destination == edge.destination
        && this.weight == edge.weight){
            return true;
        }
        return false;
    }
}
