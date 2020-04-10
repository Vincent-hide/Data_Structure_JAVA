package hashtable;

public class QuadraticProbing {

    private int num;
    private int max;
    private String[] arr;

    public QuadraticProbing(int max) {
        this.max = max;
        this.num = 0;
        this.arr = new String[max];
    }

    @Override
    public String toString() {
        String s = "____Quadratic Probing____\n";

        s += String.format("**** %d items listed **** \n", this.num);
        for (String val : this.arr) {
            s += String.format("value: %s\n", val);
        }
        return s;
    }

    private int hashFunc(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % this.max;
    }

    public boolean insert(String key) {
        if (this.num == (int) (this.max * .8)) {
            return false;
        }

        int loc = hashFunc(key);
        int counter = 1; // no point of starting with ZERO..
        int firstLoc = loc;

        while (this.arr[loc] != null && this.arr[loc] != "DELETED") {
            loc = (firstLoc + (counter * counter)) % this.max;
            counter++;
        }
        this.arr[loc] = key;
        this.num++;
        return true;
    }
    
    public boolean saerch(String key) {
        int counter = 1;
        int loc = hashFunc(key);
        int firstLoc = loc;
        
        while(this.arr[loc] != null && this.arr[loc] != "DELETED") {
            if(this.arr[loc] == key) {
                return true;
            }
            loc = (firstLoc+(counter*counter))%this.max;
            counter++;
        }
        return false;
    }
    
    public boolean delete(String key) {
        int counter = 1;
        int loc = hashFunc(key);
        int firstLoc = loc;
        
        while(this.arr[loc] != null) {
            if(this.arr[loc] == key) {
                this.arr[loc] = "DELETED";
                this.num--;
                return true;
            }
            loc = (firstLoc+(counter*counter))%this.max;
            counter++;
        }
        return false;
    }
}
