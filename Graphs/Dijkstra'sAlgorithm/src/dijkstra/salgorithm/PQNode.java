package dijkstra.salgorithm;

public class PQNode {
    public String label;
    public int edge;
    public String prev;
    
    public PQNode(String label, int edge, String prev) {
        this.label = label;
        this.edge = edge;
        this.prev = prev;
    }
}
