package topologicalsort;

public class TopologicalSort {

    public static void main(String[] args) {
        int numOfVer = 8;
        Topological topologocal = new Topological(numOfVer);
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G", "H"};

        for (String val : vertices) {
            topologocal.addVertex(val);
        }

        topologocal.addEdge("A", "C", 1);

        topologocal.addEdge("B", "C", 1);
        topologocal.addEdge("B", "D", 1);

        topologocal.addEdge("C", "E", 1);

        topologocal.addEdge("D", "F", 1);

//        topologocal.addEdge("H", "G", 1);
        topologocal.addEdge("E", "H", 1);
        topologocal.addEdge("E", "F", 1);

        topologocal.addEdge("F", "G", 1);

        System.out.println(topologocal.printVertices());
        System.out.println(topologocal.printEdges());
       System.out.println(topologocal.topologicalSort());
        System.out.println(topologocal.topoSort());

    }

}
