package dijkstra.salgorithm;

public class DijkstraSAlgorithm {

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(7);

        dijkstra.addVertex("A");
        dijkstra.addVertex("E");
        dijkstra.addVertex("G");
        dijkstra.addVertex("J");
        dijkstra.addVertex("N");
        dijkstra.addVertex("R");
        dijkstra.addVertex("T");

        dijkstra.addEdge("A", "N", 30);
        dijkstra.addEdge("A", "T", 80);

        dijkstra.addEdge("E", "R", 15);

        dijkstra.addEdge("G", "R", 45);
        dijkstra.addEdge("G", "T", 10);
        dijkstra.addEdge("G", "E", 5);

        dijkstra.addEdge("N", "E", 45);
        dijkstra.addEdge("N", "G", 25);
        dijkstra.addEdge("N", "T", 40);

        dijkstra.addEdge("R", "J", 20);

        dijkstra.addEdge("T", "J", 50);
        dijkstra.addEdge("T", "R", 15);
        dijkstra.addEdge("T", "G", 10);

        System.out.println(dijkstra.printEdges());
        System.out.println(dijkstra.dijkstra("A"));
        
    }

}
