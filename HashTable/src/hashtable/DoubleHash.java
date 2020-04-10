package hashtable;

public class DoubleHash {
    private int num;
    private int max;
    private String[] arr;

    public DoubleHash(int max) {
        this.max = max;
        this.num = 0;
        this.arr = new String[max];
    }

    @Override
    public String toString() {
        String s = "____Double Probing____\n";

        s += String.format("*** %d items listed *** \n", this.num);
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
    
    private int hashFunc2(String key) {
        int sum = 0;
        for(int i=0; i<key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum%(this.max/2);
    }
    
    public boolean insert(String key) {
        if(this.num == (int)(this.max*.8)) return false;
        
        int loc = hashFunc(key);
        int loc2 = hashFunc2(key);
        
        while(this.arr[loc] != null && this.arr[loc] != "DELETED") {
            loc = (loc+loc2)%this.max;
        }
        
        this.arr[loc] = key;
        this.num++;
        return true;
    }
    
    public boolean search(String key) {
        int loc = hashFunc(key);
        int loc2 = hashFunc2(key);
        
        while(this.arr[loc] != null && this.arr[loc] != "DELETED") {
            if(this.arr[loc] == key) {
                return true;
            }
            loc = (loc+loc2)%this.max;
        }
        return false;
    }
    
    public boolean delete(String key) {
        int loc = hashFunc(key);
        int loc2 = hashFunc2(key);
        
        while(this.arr[loc] != null && this.arr[loc] != "DELETED") {
            if(this.arr[loc] == key) {
                this.arr[loc] = "DELETED";
                this.num--;
                return true;
            } 
            loc = (loc + loc2)%this.max;
        }
        return false;
    }
}
