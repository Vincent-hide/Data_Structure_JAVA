package topologicalsort;

public class Topological {

    private int num;
    private int max;
    private String[] vertices;
    private int[][] edges;
    private final int MAX;

    public Topological(int max) {
        this.max = max;
        this.num = 0;
        this.vertices = new String[max];
        this.edges = new int[max][max];
        this.MAX = Integer.MAX_VALUE;
        this.setup();
    }

    private void setup() {
        for (int i = 0; i < this.max; i++) {
            for (int v = 0; v < this.max; v++) {
                if (i == v) {
                    continue;
                } else {
                    this.edges[i][v] = this.MAX;
                }
            }
        }
    }

    public boolean isEmpty() {
        return this.num == 0;
    }

    public boolean isFull() {
        return this.num == this.max;
    }

    public int getDegree(String vertex) {
        int loc = this.findVertex(vertex);
        if (loc == -1) {
            return -1;
        }
        int degree = 0;
        for (int i = 0; i < this.num; i++) {
            if (this.edges[loc][i] != this.MAX && this.edges[loc][i] != 0) {
                degree++;
            }
        }
        return degree;
    }

    public String printVertices() {
        String s = "**** Adjacency List ****\n";
        for (int i = 0; i < this.num; i++) {
            s += String.format("Vertex %d: %s\n", i + 1, this.vertices[i]);
        }
        return s;
    }

    public String printEdges() {
        String s = "**** Adjacency Matrix ****\n";
        s += "   ";
        for (int i = 0; i < this.num; i++) {
            s += String.format(" [%s]", this.vertices[i]);
        }
        s += "\n";
        for (int i = 0; i < this.num; i++) {
            s += String.format("[%s]", this.vertices[i]);
            for (int v = 0; v < this.num; v++) {
                s += this.edges[i][v] == this.MAX ? " IF " : this.edges[i][v] == 0 ? " 00 " : String.format(" %s ", (Integer.toString(this.edges[i][v]).length() != 1) ? this.edges[i][v] : " " + this.edges[i][v]);
            }
            s += "\n";
        }
        return s;
    }

    private int findVertex(String vertex) {
        for (int i = 0; i < this.num; i++) {
            if (this.vertices[i] == vertex) {
                return i;
            }
        }
        return -1;
    }

    public boolean addVertex(String vertex) {
        if (this.num == this.max) {
            return false;
        }

        this.vertices[this.num++] = vertex;
        return true;
    }

    public boolean addEdge(String from, String to, int weight) {
        int fromV = this.findVertex(from);
        int toV = this.findVertex(to);

        if (fromV != -1 && toV != -1) {
            this.edges[fromV][toV] = weight;
            return true;
        }
        return false;
    }
    
    
    // -------------------------------------------------------------------------
    public String topologicalSort() {
        String s = "**** Topological Sort ****\n";
        boolean visited[] = new boolean[this.num];
        Stack stack = new Stack(this.num);

        for (int i = 0; i < this.num; i++) {
            if (!visited[i]) {
                visited[i] = true;
                this.topologicalSort(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            s += String.format("%s => ", stack.pop().label);
        }

        return s + "END";
    }

    private void topologicalSort(int loc, boolean visited[], Stack stack) {
        for (int i = 0; i < this.num; i++) {
            if (this.edges[loc][i] != 0 && this.edges[loc][i] != this.MAX && !visited[i]) {
                visited[i] = true;
                this.topologicalSort(i, visited, stack);
            }
        }

        stack.push(new Vertex(this.vertices[loc], 1)); // set the value of each node as 1. 
    }

    public String topoSort() {
        String s = "**** Topological Sort ****\n";
        boolean visited[] = new boolean[this.num];

        // need an aditional index to keep track of current index 
        int locations[] = new int[this.num + 1];

        for (int i = 0; i < this.num; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                topoSort(i, visited, locations);
            }
        }

        for (int i = 0; i < this.num; i++) {
            s += String.format("%s <= ", this.vertices[locations[i]]);
        }
        return s + "START";
    }

    private void topoSort(int loc, boolean[] visited, int[] locs) {
        for (int i = 0; i < this.num; i++) {
            if (this.edges[loc][i] > 0 && this.edges[loc][i] != this.MAX && visited[i] == false) {
                visited[i] = true;
                topoSort(i, visited, locs);
            }
        }
        // the last index is a pointer to the next index where loc has to be stored
        locs[locs[locs.length - 1]] = loc;
        locs[locs.length - 1]++;
    }

}
