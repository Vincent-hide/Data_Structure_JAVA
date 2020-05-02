package pkg01knapsack;

public class Main {

    public static void main(String[] args) {
        Item[] items = {
            new Item(1, 10.00, 60),
            new Item(2, 20.00, 100),
            new Item(3, 30.00, 120),
        };

        Item[] items2 = {
            new Item(1, 2.00, 2),
            new Item(2, 2.00, 4),
            new Item(3, 4.00, 6),
            new Item(4, 5.00, 9),
        };
        
        Item[] items3 = {
            new Item(1, 5.00, 60),
            new Item(2, 3.00, 50),
            new Item(3, 4.00, 70),
            new Item(4, 2.00, 30),
        };

        
        // w Memorialization -------------------------------------------------
        Knapsack knapsack1 = new Knapsack(items, 3, 50);
        System.out.println("acumulative value: " + knapsack1.topDown());
        System.out.println("-------------------------------------------------");
        
        Knapsack knapsack2 = new Knapsack(items2, 4, 8);
        System.out.println("acumulative value: " + knapsack2.topDown());
        System.out.println("-------------------------------------------------");

        
        // w/o Memorialization -------------------------------------------------
        Knapsack knapsack3 = new Knapsack(items, 3, 50);
        System.out.println("acumulative value: " + knapsack3.topDown2());
        System.out.println("-------------------------------------------------");

        Knapsack knapsack4 = new Knapsack(items2, 4, 8);
        System.out.println("acumulative value: " + knapsack4.topDown2());
        System.out.println("-------------------------------------------------");
        
        
        Knapsack knapsack5 = new Knapsack(items3, 4, 5);
        System.out.println(knapsack5.bottomUp());
        System.out.println("-------------------------------------------------");
        System.out.println(knapsack5.printMatrixMemory());


    }

}
