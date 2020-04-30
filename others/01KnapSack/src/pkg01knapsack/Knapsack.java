package pkg01knapsack;

public class Knapsack {

    private Item[] items;
    private int numItems;
    private int capacity;
    private int[][] memory;

    public Knapsack(Item[] items, int numItems, int capacity) {
        this.items = items;
        this.capacity = capacity;
        this.numItems = numItems;
        this.memory = new int[this.numItems][this.capacity+1];
    }

    public String printMemoery() {
        String s = "*** Memoery ***\n";
        for (int memo[] : this.memory) {
            for (int val : memo) {
                s += "Memoery: " + val + "\n";
            }
        }
        return s;
    }

    private int max(int val1, int val2) {
        return val1 > val2 ? val1 : val2;
    }

    // w/ Memorialization
    public int topDown() {
        return this.topDown(0, this.capacity);
    }

    private int topDown(int index, double currentWeight) {
        // Basecase 
        if (index == this.numItems) {
            return 0; // no more items
        }
        if (currentWeight <= 0) {
            return 0; // no more capacity
        }
        if (this.memory[index][(int)currentWeight] != 0) {
            return this.memory[index][(int)currentWeight]; // if the calculation is done and stored in the memoralization array, return the value
        } else {
            int val1 = 0;
            if (this.items[index].weight <= currentWeight) {
                double itemWeight = this.items[index].weight;
                val1 = this.items[index].value + this.topDown(index + 1, currentWeight - itemWeight);
            }
            int val2 = this.topDown(index + 1, currentWeight);
//            System.out.println("val1: " + val1);
//            System.out.println("val2: " + val2);
//            System.out.println("index: " + index + " - weight: " + currentWeight);
//            System.out.println("---------------");
            return this.memory[index][(int)currentWeight] = this.max(val1, val2);
        }
    }

    // w/o Memorialization
    public int topDown2() {
        return this.topDown2(0, this.capacity);
    }

    private int topDown2(int index, double currentWeight) {
        // Basecase 
        if (index == this.numItems) {
            return 0; // no more items
        }
        if (currentWeight <= 0) {
            return 0; // no more capacity
        }

        int profit = 0;
        if (this.items[index].weight <= currentWeight) {
            profit = this.items[index].value + this.topDown2(index + 1, currentWeight - this.items[index].weight);
        }

        int profit2 = this.topDown2(index + 1, currentWeight);

        return this.max(profit, profit2);
    }
}
