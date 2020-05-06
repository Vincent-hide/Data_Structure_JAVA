package coinchange;

import java.util.Scanner;

public class Coins {

    private int totalAmt;
    private int numOfCoins;
    private int[] coins;
    private int[][] table;
    private Scanner input = new Scanner(System.in);

    public Coins(int totalAmt, int numOfCoins) {
        this.totalAmt = totalAmt;
        this.numOfCoins = numOfCoins;
        this.coins = new int[numOfCoins + 1];
        this.coinSetUp();
        this.table = new int[numOfCoins + 1][totalAmt + 1];
    }

    private void coinSetUp() {
        this.coins[0] = 0;
        for (int i = 1; i < this.numOfCoins + 1; i++) {
            System.out.print("Coin: ");
            this.coins[i] = input.nextInt();
        }
    }

    private int min(int num1, int num2) {
        return num1 > num2 ? num2 : num1;
    }

    public String info() {
        String s = "*** info ***\n";
        s += "Total Amount to be made: $" + this.totalAmt + "\n";
        s += "Number of coins you have: " + this.numOfCoins + "\n";
        for (int val : this.coins) {
            s += "$" + val + "\n";
        }
        return s;
    }

    public int minChange() {
        for (int i = 0; i < this.totalAmt + 1; i++) {
            this.table[0][i] = Integer.MAX_VALUE;
        }

        System.out.println(this.printTable());
        this.minChange(1, 1);
        System.out.println(this.printTable());
        return this.table[this.numOfCoins][this.totalAmt];
    }

    private void minChange(int row, int col) {
        // Basecase
        if (row == this.numOfCoins && col == this.totalAmt + 1) {
            return;
        }

        if (col == this.totalAmt + 1) {
            row++;
            col = 1;
        }

        if (this.coins[row] <= col) {
            // substract and add with the previous result
            int val1 = 1 + this.table[row][col - this.coins[row]];
            int val2 = this.table[row - 1][col];
            this.table[row][col] = this.min(val1, val2);
            this.minChange(row, col + 1);
        } else {
            this.table[row][col] = this.table[row - 1][col];
            this.minChange(row, col + 1);
        }
    }

    public String printTable() {
        String s = "*** Table *****\n";

        for (int i = 0; i < this.numOfCoins + 1; i++) {
            s += String.format(" [%d]: ", this.coins[i]);
            for (int v = 0; v < this.totalAmt + 1; v++) {
                s += (this.table[i][v] == Integer.MAX_VALUE) ? " X " : (this.table[i][v] > 9) ? this.table[i][v] + " " : " " + this.table[i][v] + " ";
            }
            s += "\n";
        }
        return s;
    }
}
