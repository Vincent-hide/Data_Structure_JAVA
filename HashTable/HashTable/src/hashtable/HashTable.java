package hashtable;

public class HashTable {

    public static void main(String[] args) {
        // set the size as a prime number for speed. It speeds up since % is used in the code
        LinearProbing linear = new LinearProbing(17);

        linear.insert("Grape");
        linear.insert("Mango");
        linear.insert("StrawBerry");
        linear.insert("Melon");
        linear.insert("WaterMelon");

        linear.insert("RaspBerry");
        linear.insert("GrapeFruit");
        linear.insert("BlueBerry");
        linear.insert("Peach");
        linear.insert("Pear");

        linear.insert("PineApple");
        linear.insert("Cherry");
        linear.insert("GreenApple");

        linear.insert("Orange"); // false

        System.out.println(linear);

        //______________________________________________________________________
        QuadraticProbing quadratic = new QuadraticProbing(17);

        quadratic.insert("Grape");
        quadratic.insert("Mango");
        quadratic.insert("StrawBerry");
        quadratic.insert("Melon");
        quadratic.insert("WaterMelon");

        quadratic.insert("RaspBerry");
        quadratic.insert("GrapeFruit");
        quadratic.insert("BlueBerry");
        quadratic.insert("Peach");
        quadratic.insert("Pear");

        quadratic.insert("PineApple");
        quadratic.insert("Cherry");
        quadratic.insert("GreenApple");

        quadratic.insert("Orange"); // false

        System.out.println(quadratic);

        //______________________________________________________________________
        
        DoubleHash doubeHash = new DoubleHash(17);
        
        doubeHash.insert("Grape");
        doubeHash.insert("Mango");
        doubeHash.insert("StrawBerry");
        doubeHash.insert("Melon");
        doubeHash.insert("WaterMelon");

        doubeHash.insert("RaspBerry");
        doubeHash.insert("GrapeFruit");
        doubeHash.insert("BlueBerry");
        doubeHash.insert("Peach");
        doubeHash.insert("Pear");

        doubeHash.insert("PineApple");
        doubeHash.insert("Cherry");
        doubeHash.insert("GreenApple");

        doubeHash.insert("Orange"); // false

        System.out.println(doubeHash);
    }

}
