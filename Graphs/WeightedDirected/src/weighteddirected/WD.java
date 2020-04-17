package weighteddirected;

public class WD {

    private int num;
    private int max;
    private String[] vertices;
    private int[][] edges;
    private final int MAX;

    public WD(int max) {
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
        if(loc == -1) return -1;
        int degree = 0;
        for(int i=0; i<this.num; i++) {
            if(this.edges[loc][i] != this.MAX && this.edges[loc][i] != 0) {
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

    public String BSF(String start) {
        int loc = this.findVertex(start);
        if (loc == -1) {
            return null;
        }
        boolean[] visited = new boolean[this.num];
        Queue q = new Queue();
        String s = "**** Breadth First Search ****\n";

        visited[loc] = true;
        q.enqueue(start);

        while (!q.isEmpty()) {
            QNode dequeued = q.dequeue();
            s += String.format("%s => ", dequeued.data);
            loc = findVertex(dequeued.data);

            for (int i = 0; i < this.num; i++) {
                if (this.edges[loc][i] != this.MAX && visited[i] == false) {
                    visited[i] = true;
                    q.enqueue(this.vertices[i]);
                }
            }
        }
        s += "null";
        return s;

    }

    public String DFS(String start) {
        int loc = this.findVertex(start);
        if(loc == -1) return null;
        
        boolean[] visited = new boolean[this.num];
        String s = "**** Depth First Search ****\n";
        
        Stack stack = new Stack();
        stack.push(start);
        
        while(!stack.isEmpty()) {
            SNode popped = stack.pop();
            loc = this.findVertex(popped.data);
            
            if(visited[loc] == false) {
                visited[loc] = true;
                s += String.format("%s => ", this.vertices[loc]);
            }
            
            for(int i=0; i<this.num; i++){
                if(this.edges[loc][i] != this.MAX && this.edges[loc][i] != 0 && visited[i] == false) {
                    stack.push(this.vertices[i]);
                }
            }
        }
        return s;
    }
    
    public String DFSRec(String start) {
        String s = "**** Depth First Search ****\n";
        int loc = findVertex(start);
        if (loc == -1) {
            return s;
        }
        boolean[] visited = new boolean[this.num];
        s += this.DFSRec(visited, loc);
        s += null;
        return s;
    }

    private String DFSRec(boolean[] visited, int loc) {
        String s = "";
        if(visited[loc] == true) {
            return s;
        }
        visited[loc] = true;
        
        s += String.format("%s => ", this.vertices[loc]);
        
        for(int i=0; i<this.num; i++) {
            if(this.edges[loc][i] != this.MAX) {
                s += this.DFSRec(visited, i);
            }
        }
        return s;
    }
}
