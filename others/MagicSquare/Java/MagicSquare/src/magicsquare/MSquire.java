package magicsquare;

public class MSquire {

    private final int N;
    private final int CONSTANT;
    private int[][] matrix;

    public MSquire(int n) {
        this.N = n;
        this.CONSTANT = n * (n * n + 1) / 2;
        this.matrix = new int[n][n];
        this.makeMagic();
    }

    private void makeMagic() {
        int i = this.N / 2;
        int j = this.N - 1;

        for (int m = 1; m <= this.N * this.N;) {
            if (i == -1 && j == this.N) {
                i = 0;
                j = this.N - 2;
            } else if (i == -1) {
                i = this.N - 1;
            } else if (j == this.N) {
                j = 0;
            }

            if (this.matrix[i][j] != 0) {
                i += 1;
                j -= 2;
            } else {
                this.matrix[i][j] = m++;
                i--;
                j++;
            }
        }
    }

    @Override
    public String toString() {
        String s = "*** Magic Matrix ***\n";
        s += String.format("[Size]: %d X %d\n", this.N, this.N);
        s += "[CONSTANT]: " + this.CONSTANT + "\n\n";
        for (int i=0; i<this.N; i++) {
            for (int v=0; v<this.N; v++) {
                String temp = Integer.toString(this.matrix[i][v]);
                s += String.format("%s ", this.matrix[i][v] < 10 ? " " + temp : temp);
            }
            s += "\n";
        }
        return s;
    }
}
