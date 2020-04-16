package knightstour;

public class Knight {

    private int[][] chessBoard;
    private int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
    private final int BOARD_SIZE;
    private final int NUM_OF_MOVES;

    public Knight(int size) {
        this.BOARD_SIZE = size;
        this.NUM_OF_MOVES = size;
        this.chessBoard = new int[BOARD_SIZE][BOARD_SIZE];
        this.setUpBoard();
    }

    private void setUpBoard() {
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int v = 0; v < this.BOARD_SIZE; v++) {
                this.chessBoard[i][v] = Integer.MIN_VALUE;
            }
        }
    }

    private String printSolution() {
        String s = "***Knight Tour***\n";
        for(int i=0; i<this.BOARD_SIZE; i++) {
            s += "____";
        }
        s += "\n";
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            s += String.format("%d| ", i+1);
            for (int v = 0; v < this.BOARD_SIZE; v++) {
                String str = Integer.toString(this.chessBoard[i][v]);
                s += String.format(" %s ", str.length() == 2 ? str : " " + str);
            }
            s += "\n";
        }
        return s;
    }

    public String tour() {
        this.chessBoard[0][0] = 1;

        if (this.solve(2, 0, 0)) {
            return this.printSolution();
        } else {
            return "No Feasible Solution....";
        }
    }

    private boolean solve(int stepCount, int x, int y) {
        if (stepCount == this.BOARD_SIZE * this.BOARD_SIZE + 1) {
            return true;
        }

        for (int i = 0; i < this.NUM_OF_MOVES; i++) {
            int nextXStep = x + this.xMove[i];
            int nextYStep = y + this.yMove[i];

            if (this.isPossbileStep(nextXStep, nextYStep)) {
                this.chessBoard[nextXStep][nextYStep] = stepCount;

                if (this.solve(stepCount + 1, nextXStep, nextYStep)) {
                    return true;
                }

                // BackTrack
                this.chessBoard[nextXStep][nextYStep] = Integer.MIN_VALUE;
            }
        }
        return false;
    }

    private boolean isPossbileStep(int nextX, int nextY) {
        if (nextX < 0 || nextX >= this.BOARD_SIZE) {
            return false;
        }
        if (nextY < 0 || nextY >= this.BOARD_SIZE) {
            return false;
        }
        if (this.chessBoard[nextX][nextY] != Integer.MIN_VALUE) {
            return false;
        }

        return true;
    }

}
