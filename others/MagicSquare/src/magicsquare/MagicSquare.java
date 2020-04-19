
package magicsquare;
import java.util.Scanner;

public class MagicSquare {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type the size of Magic Squre: ");
        MSquire ms = new MSquire(input.nextInt());
        System.out.println(ms);
    }
    
}
