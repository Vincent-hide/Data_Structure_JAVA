package pkg01knapsack;

import java.util.Iterator;
import java.util.Stack;

public class Knapsack {

    private Item[] items;
    private int numItems;
    private int capacity;
    private int[][] memory;

    public Knapsack(Item[] items, int numItems, int capacity) {
        this.items = items;
        this.capacity = capacity;
        this.numItems = numItems;
        this.memory = new int[this.numItems][this.capacity + 1];
    }

    public String printVerticalMemoery() {
        String s = "*** Memoery ***\n";
        for (int memo[] : this.memory) {
            for (int val : memo) {
                s += "Memoery: " + val + "\n";
            }
        }
        return s;
    }

    public String printMatrixMemory() {
        String s = "*** Memoery ***\nWeight:\t\t    ";
        for (int i = 0; i < this.capacity + 1; i++) {
            s += i + "  ";
        }
        s += "\n------------------------------------------------------------\n";
        for (int i = 0; i < this.numItems; i++) {
            s += String.format("[V: %d / W: %.2f]: ", this.items[i].value, this.items[i].weight);
            for (int v = 0; v < this.capacity + 1; v++) {
                s += this.memory[i][v] < 10 ? " " + this.memory[i][v] + " " : this.memory[i][v] + " ";
            }
            s += "\n";
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
        if (this.memory[index][(int) currentWeight] != 0) {
            return this.memory[index][(int) currentWeight]; // if the calculation is done and stored in the memoralization array, return the value
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
            return this.memory[index][(int) currentWeight] = this.max(val1, val2);
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

    public String bottomUp() {
        String s = "*** accumulative value ***\n";
        this.bottomUp(0, 0);
        s += this.memory[this.numItems - 1][this.capacity] + "\n";
        s += "*** Items that were chosen ***\n";
        s += this.takenItemsList();
        return s;
    }

    private void bottomUp(int itemIndex, int weightIndex) {
        if (this.isValidWeight(weightIndex)) {
            if (weightIndex >= this.items[itemIndex].weight) {
                if (itemIndex != 0) {
                    if (this.compareVal(itemIndex, weightIndex)) {
                        this.memory[itemIndex][weightIndex] = this.items[itemIndex].value;
                        this.memory[itemIndex][weightIndex] += this.memory[itemIndex - 1][weightIndex - (int) this.items[itemIndex].weight];
                    } else {
                        this.memory[itemIndex][weightIndex] = this.memory[itemIndex - 1][weightIndex];
                    }
                } else {
                    this.memory[itemIndex][weightIndex] = this.items[itemIndex].value;
                }
            } else {
                if (itemIndex != 0) {
                    this.memory[itemIndex][weightIndex] = this.memory[itemIndex - 1][weightIndex];
                }
            }
            this.bottomUp(itemIndex, weightIndex + 1);
        } else {
            weightIndex = 0;
            if (isValidItem(itemIndex + 1)) {
                this.memory[itemIndex + 1][weightIndex] = 2;
                this.bottomUp(itemIndex + 1, weightIndex);
            }
        }
    }

    // returns true if the current value is bigger than the value one row above
    private boolean compareVal(int itemIndex, int weightIndex) {
        return this.items[itemIndex].value + this.memory[itemIndex - 1][weightIndex - (int) this.items[itemIndex].weight] > this.memory[itemIndex - 1][weightIndex];
    }

    private boolean isValidWeight(int weightIndex) {
        return (weightIndex <= this.capacity);
    }

    private boolean isValidItem(int itemIndex) {
        return (itemIndex < this.numItems);
    }

    private String takenItemsList() {
        String s = "";
        Stack stack = new Stack();
        stack = this.takenItemsList(this.numItems - 1, this.capacity, stack);
        Iterator value = stack.iterator();
        while (value.hasNext()) {
            s += this.items[(int) value.next()].id + " & ";
        }
        return s;
    }

    private Stack takenItemsList(int itemIndex, int weightIndex, Stack stack) {

        if (itemIndex < 0 || weightIndex < 0) {
            return null;
        }

        // Basecase
        if (this.memory[itemIndex][weightIndex] == 0) {
            return stack;
        }

        if (this.checkIn(itemIndex, weightIndex)) {
            stack.push(itemIndex);
            int nextIndex = weightIndex - (int) this.items[itemIndex].weight;
            this.takenItemsList(itemIndex - 1, nextIndex, stack);
        } else {
            this.takenItemsList(itemIndex - 1, weightIndex, stack);
        }

        return stack;
    }

    // returns true if the current item was picked, otherwise false
    private boolean checkIn(int itemIndex, int weightIndex) {
        if (this.memory[itemIndex][weightIndex] != this.memory[itemIndex - 1][weightIndex]) {
            int sum = this.items[itemIndex].value + this.memory[itemIndex - 1][weightIndex - (int) this.items[itemIndex].weight];
            if (sum == this.memory[itemIndex][weightIndex]) {
                return true;
            }
        }
        return false;
    }
}
