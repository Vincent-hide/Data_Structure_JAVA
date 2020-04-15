package weighteddirected;

public class WeightedDirected {

    public static void main(String[] args) {
        WD graph = new WD(10);
        
        graph.addVertex("A");
        graph.addVertex("E");
        graph.addVertex("G");
        graph.addVertex("J");
        graph.addVertex("N");
        graph.addVertex("R");
        graph.addVertex("T");
        
        graph.addEdge("A", "N", 30);
        graph.addEdge("A", "T", 80);
        
        graph.addEdge("E", "R", 15);
        graph.addEdge("E", "T", 10);

        graph.addEdge("G", "E", 10);
        graph.addEdge("G", "R", 45);

        graph.addEdge("N", "E", 45);
        graph.addEdge("N", "G", 25);
        graph.addEdge("N", "T", 40);
        
        graph.addEdge("R", "J", 20);
        
        graph.addEdge("T", "G", 10);
        graph.addEdge("T", "J", 50);
        System.out.println(graph.addEdge("T", "R", 15));
        
        System.out.println(graph.printVertices());
        System.out.println(graph.printEdges());
        
        System.out.println("----------------------------");
        
        System.out.println(graph.BSF("N"));

        System.out.println("----------------------------");
        
        System.out.println(graph.DFSRec("A"));
        
        System.out.println("----------------------------");
        
        System.out.println(graph.DFS("A"));
        
        System.out.println("----------------------------");
        
        System.out.println(graph.getDegree("A"));
        
    }
    
}
