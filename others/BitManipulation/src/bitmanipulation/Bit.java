package bitmanipulation;

public class Bit {
    // ex, x = 6, position = 5; 
    // 0000 0110 => x
    // 0000 0101 => position
    // 0000 0001 => 1 // shift this 1 to left by 5 positions
    // 0010 0000 => mask

    // 0010 0000 => mask
    // 0000 0110 => x
    // ------------------------------
    // 0010 0110 => 38 // successfully made the 5th position to 1
    public static int setBit(int x, int position) {
        int mask = 1 << position;
        return mask | x;
    }

    // ex, x = 6, position = 5; 
    // 0000 0110 => x
    // 0000 0101 => position
    // 0000 0001 => 1 // shift this 1 to left by 5 positions
    // 0010 0000 => mask
    // 1101 1111 => ~mask // use not operator to flip all 0 and 1
    // 1111 1011 => mask
    // 0000 0110 => x
    // ------------------------------
    // 0000 0010 => 2 // successfully made the 2nd   position to 0
    public static int clearBit(int x, int position) {
        int mask = 1 << position;
        mask = ~mask;
        return mask & x;
    }

    // flip at specified position. if its 0 => 1, if its 1 => 0
    // 0000 0110 => x
    // 0000 0100 => 4
    // 0000 1110 => flipped x
    public static int flipBit(int x, int position) {
        int mask = 1 << position;
        return mask ^ x;
    }

    // returns true, if the specific position is set to 1
    // 0110 0110 => 102
    // 0000 0101 => 5 // is 5th position set to 1? the position of 32
    // 0000 0011 => shifted x by 5 positions
    // 0000 0001 => 1 // use and operator with 1
    //----------------
    // 0000 0001
    public static boolean isBitSet(int x, int position) {
        int shifted = x >> position;
        int result = shifted & 1;
        return result == 1;
    }

    // if state = 1, set tte bit at the given position
    // if state = 0 clear the bit at the given position
    public static int modifyBit(int x, int position, int state) {
        int mask = 1 << position;
        return (x & ~mask) | (-state & mask);
    }

    // returns true if the given x is even
    // 0110 => 6
    // 0001 => 1;
    //--------
    // 0000 => meanings even
    public static boolean isEven(int x) {
        return (x & 1) == 0;
    }

    // slightly faster in js, c++, as 1 is true
    // 0110 => x
    // 1001 => ~x
    // 0001 => 1
    // -----------
    // 0001 => 1 
    public static boolean isEven2(int x) {
        int result = ~x & 1;
        return result == 1;
    }

    // true is the given x is power of two
    // 1000 => 8
    // 0111 => 7
    //----------
    // 0000 => yes
    public static boolean isPower2(int x) {
        return (x & x - 1) == 0;
    }
    
    // print decimal number in binary number
    public static void convertBinary(int num) {
        int[] binary = new int[40];
        int index = 0;
        while(num > 0) {
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i=index-1; i>=0; i--) {
            System.out.println(binary[i]);
        }
    }
}