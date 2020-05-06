package coinchange;

public class CoinChange {

    public static void main(String[] args) {
        Coins coins = new Coins(12, 3);
        System.out.println(coins.info());
        System.out.printf("Minimum Number of Change: %d coins\n", coins.minChange());
    }
    
}
