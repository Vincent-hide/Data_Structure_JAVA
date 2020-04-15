package seperatechaining;

public class SeperateChaining {

    public static void main(String[] args) {
        Chain chaining = new Chain(10);

        chaining.insert("Grape");
        chaining.insert("Mango");
        chaining.insert("StrawBerry");
        chaining.insert("Melon");
        chaining.insert("WaterMelon");

        chaining.insert("RaspBerry");
        chaining.insert("GrapeFruit");
        chaining.insert("BlueBerry");
        chaining.insert("Peach");
        chaining.insert("Pear");

        chaining.insert("PineApple");
        chaining.insert("Cherry");
        chaining.insert("GreenApple");

        System.out.println(chaining);

        System.out.println("");
        System.out.println(chaining.search("Melon"));

        System.out.println(chaining.delete("StrawBerry"));

        System.out.println("");
        System.out.println(chaining);

    }

}
