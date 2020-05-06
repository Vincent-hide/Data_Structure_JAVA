package mazerat;

public class Maze {

    private int row;
    private int col;
    public String[][] map;

    // this constructor takes a pointer of a map. pass by reference.
    public Maze(String[][] map) {
        this.map = map;
        this.row = map.length;
        this.col = map[0].length;
    }

    public String info() {
        String s = "";
        s += String.format("[row]: %d\n", this.row);
        s += String.format("[col]: %d\n", this.col);
        return s;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.row; i++) {
            for (int v = 0; v < this.col; v++) {
                s += this.map[i][v] + " ";
            }
            s += "\n";
        }
        return s;
    }

    // -------------------------------------------------------------------------
    public String solve() {
        if (this.solveMaze(0, 0)) {
            return this.toString();
        } else {
            return "No Solutions ...";
        }
    }

    private boolean solveMaze(int x, int y) {

        if (this.isFinish(x, y)) {
            return true;
        }
        
        // show each step
//        System.out.println("_____________________________________");
//        System.out.println(this.toString());
//        System.out.println("_____________________________________");

        if (this.validity(x, y)) {
            this.map[x][y] = "X";

            if (this.solveMaze(x + 1, y)) {
                return true;
            }

            if (this.solveMaze(x, y + 1)) {
                return true;
            }

            // BackTrack
            this.map[x][y] = "0";
        }
        return false;
    }

    private boolean validity(int x, int y) {
        if (x < 0 || x >= this.row) {
            return false;
        }
        if (y < 0 || y >= this.col) {
            return false;
        }
        if ("1".equals(this.map[x][y])) {
            return false;
        }
        return true;
    }

    private boolean isFinish(int x, int y) {
        if (x == this.row - 1 && y == this.col - 1) {
            this.map[x][y] = "X";
            return true;
        }
        return false;
    }
}
