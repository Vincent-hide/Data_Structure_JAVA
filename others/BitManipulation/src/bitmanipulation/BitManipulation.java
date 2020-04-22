package bitmanipulation;

public class BitManipulation {

    public static void main(String[] args) {
        int a = 15;
        int b = 27;

        // a = 0000 1111
        // b = 0001 1011
        // ----------------------
        //     0000 1011 => 11
        //     0001 1111 => 31
        //     0001 0100 => 20
        //     0001 0000 => -16
        //     0011 1100 => 60
        //     0000 0011 => 3
        //     0000 0011 => 3
        // AND &
        int and = a & b;

        // OR | 
        int or = a | b;

        // XOR ^
        int xor = a ^ b;

        // One's completement ~
        int one = ~a;

        System.out.println("[and]: " + and);
        System.out.println("[or]: " + or);
        System.out.println("[xor]: " + xor);
        System.out.println("[one]: " + one);

        System.out.println("----------------------------");

        // left shift <<
        int left = a << 2;

        // right shift >> 
        int right = a >> 2;

        // right shift zero fill >>>
        int rightZero = a >>> 2;

        System.out.println("[left]: " + left);
        System.out.println("[right]: " + right);
        System.out.println("[rightZero]: " + rightZero);

        System.out.println("----------------------------");

        System.out.println("[set bit (6, 5)]: " + Bit.setBit(6, 5) + " = " + Integer.toBinaryString(Bit.setBit(6, 5)));
        System.out.println("[clear bit (6, 2)]: " + Bit.clearBit(6, 2) + " = " + Integer.toBinaryString(Bit.clearBit(6, 2)));
        System.out.println("[flip bit (6, 3)]: " + Bit.flipBit(6, 3) + " = " + Integer.toBinaryString(Bit.flipBit(6, 3)));
        System.out.println("[is bit set? (102, 5)]: " + Bit.isBitSet(102, 5));

    }

}
