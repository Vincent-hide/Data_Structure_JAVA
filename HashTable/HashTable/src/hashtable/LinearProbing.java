package hashtable;

public class LinearProbing {

    private int num;
    private int max;
    private String[] arr;

    public LinearProbing(int max) {
        this.max = max;
        this.num = 0;
        this.arr = new String[max];
    }

    @Override
    public String toString() {
        String s = "____Linear Probing____\n";

        s += String.format("*** %d items listed *** \n", this.num);
        for (String val : this.arr) {
            s += String.format("value: %s\n", val);
        }
        return s;
    }
    
    private int hashFunc(String key) {
        int sum = 0;
        for(int i=0; i<key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum%this.max;
    }
    
    public boolean insert(String key) {
        // to keep 20% of the array space for speed and avoid collision and cluster 
        if(this.num == (int)(this.max*.8)) return false;
        int loc = hashFunc(key);
        
        while(this.arr[loc] != null && this.arr[loc] != "DELETED") {
            loc = (loc+1)%this.max;
        }
        this.arr[loc] = key;
        this.num++;
        return true;
    }
    
    public boolean search(String key) {
        int loc = hashFunc(key);
        
        while(this.arr[loc] != null) {
            if(this.arr[loc] == key) {
                return true;
            }
            loc = (loc+1)%this.max;
        }
        return false;
    }
    
    public boolean delete(String key) {
        int loc = hashFunc(key);
        
        while(this.arr[loc] != null) {
            if(this.arr[loc] == key) {
                this.arr[loc] = "DELETED";
                this.num--;
                return true;
            }
            loc = (loc+1)%this.max;
        }
        return false;
    }

}
