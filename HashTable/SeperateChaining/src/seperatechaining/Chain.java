package seperatechaining;

public class Chain {

    private int num;
    private int max;
    private Node[] arr;

    public Chain(int max) {
        this.max = max;
        this.num = 0;
        this.arr = new Node[max];
    }

    public boolean isEmpty() {
        for (Node val : this.arr) {
            if (val != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "____Seperate Chiaining____\n";

        s += String.format("***** %d items listed ***** \n", this.num);
        for (Node val : this.arr) {
            s += String.format("value: %s", val == null ? val : val.data);
            if (val != null) {
                Node node = val.next;
                while (node != null) {
                    s += String.format(" => %s", node.data);
                    node = node.next;
                }
            }
            s += "\n";
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

    public void insert(String key) {
        int loc = hashFunc(key);

        if (this.arr[loc] == null) {
            this.arr[loc] = new Node(key);
            this.num++;
            return;
        }

        Node current = this.arr[loc];
        Node node = new Node(key);

        while (current.next != null) {
            current = current.next;
        }

        node.prev = current;
        current.next = node;
        this.num++;
    }

    public boolean search(String key) {
        int loc = hashFunc(key);

        if (this.arr[loc] == null) {
            return false;
        }

        if (this.arr[loc].data == key) {
            return true;
        }

        Node current = this.arr[loc].next;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean delete(String key) {
        int loc = hashFunc(key);

        if (this.arr[loc] == null) {
            return false;
        }

        if (this.arr[loc].data == key) {
            this.arr[loc] = this.arr[loc].next;
            this.arr[loc].prev = null;
            this.num--;
            return true;
        }

        Node current = this.arr[loc];
        while (current != null) {
            if (current.data == key) {
                current.next.prev = current.prev;
                current.prev.next = current.next;
                this.num--;
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
}
