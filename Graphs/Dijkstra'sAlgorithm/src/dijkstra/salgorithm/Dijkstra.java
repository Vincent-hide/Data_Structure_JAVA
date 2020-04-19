package dijkstra.salgorithm;

public class Dijkstra {

    private int num;
    private int max;
    private String[] vertices;
    private int[][] edges;
    private final int MAX;

    public Dijkstra(int max) {
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
                if (i != v) {
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
            if (this.vertices[i].equals(vertex)) {
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

    // update the weight aka edge of node in the queue
    private void updateQ(PriorityQueue q, PQNode node) {
        int index = q.contains(node.label);
        if (index != -1) {
            q.weightSwap(index, node);
        }
    }

    public String dijkstra(String vertex) {
        int loc = this.findVertex(vertex);
        if (loc == -1) {
            return null;
        }

        String s = "**** Dijkstra’s Shortest Path Algorithm ****\n";
        PriorityQueue q = new PriorityQueue(this.num);

        q.enqueue(new PQNode(vertex, 0, "Origin"));
        for (int i = 0; i < this.num; i++) {
            if (this.vertices[i].equals(vertex)) {
                continue;
            }
            q.enqueue(new PQNode(this.vertices[i], this.MAX, "UNKNOWN"));
        }

        while (!q.isEmpty()) {
            PQNode dequeued = q.dequeue();
            s += String.format("| %s:  %s/%d || => |", dequeued.label, dequeued.prev, dequeued.edge);
            loc = this.findVertex(dequeued.label);

            for (int i = 0; i < this.num; i++) {
                if (this.edges[loc][i] != this.MAX) {
                    if (this.edges[loc][i] != 0) {
                        int edge = this.edges[loc][i] + dequeued.edge;
                        String label = this.vertices[i];
                        String prev = this.vertices[loc];

                        this.updateQ(q, new PQNode(label, edge, prev));
                    }
                }
            }

            // shows priority queue in each iteration
            System.out.println("-------------");
            System.out.println(q);
            System.out.println("dequeued: " + dequeued.label);
            System.out.println("root: " + q.root().label);
            System.out.println("------------------------");

        }
        return s + "|";
    }
}
