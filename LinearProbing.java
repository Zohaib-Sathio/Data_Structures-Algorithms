// Program by UZAIR HUSSAIN 
// Github: github.com/uzairhussain193
// LinkedIn: linkedin.com/in/uzairhussain19

public class LinearProbing {

    private int size;          // the number of key-value pairs currently stored
    private int capacity;     // the size of hashtable
    private Object[] keys;    // array to store keys
    private Object[] values;    // array to store values

    public LinearProbing(int capacity){
        this.capacity = capacity;
        keys = new Object[capacity];
        values = new Object[capacity];
    }     // end of constructor

    public int size(){
        return size;
    }    // end of size()

    public boolean isEmpty(){
        return (size == 0);
    }     // end of isEmpty

    public void makeHashTableEmpty(){
        size = 0;
        keys = new Object[capacity];
        values = new Object[capacity];
    }      // end of makeHashTableEmpty()

    public boolean contains(Object key){
        return (get(key) != null);      // if no value is retreived, it means key doesn't exist
    }     // end of contains()

    public int hash(Object key){
        return (key.hashCode() & 0x7FFFFFFF) % capacity; // always gives +ve integer
        // return Math.abs(key.hashCode())%capacity;           // may give -ve integer
    }    // end of hash()

    public void rehash(){
        int newCap = capacity * 2;
        Object [] oldKeys = keys;
        Object [] oldValues = values;
        // re intialize the arrays of key value pair, and size=0
        keys = new Object[newCap];
        values = new Object[newCap];
        size = 0;

        capacity = newCap;
        for (int i=0; i<oldKeys.length; i++){
            if (oldKeys[i]!=null){
                put(oldKeys[i], oldValues[i]);
            }
        }
    }  // end of rehash()

    public void put(Object key, Object value){
        // checking load factor
        if ((double)size / capacity > 0.75) {
            rehash();
        }
        int index = hash(key);
        while (keys[index]!=null && !keys[index].equals(key)){     // loop till end and until value associated with key is not found
            index = (index + 1) % capacity; // Move to the next index using linear probing
        }
        if (keys[index] == null){
            size++;
        }
        keys[index] = key;
        values[index] = value;
    }      // end of put()

    public Object get(Object key){
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {   // loop till end and until value associated with key is not found
            index = (index + 1) % capacity; // Move to the next index using linear probing
        }
        if (keys[index] == null) {
            return null;
        } else {
            return values[index];
        }
        // we can use below line for above if conditions
        // return keys[index] == null ? null : values[index]; // Return the value associated with the key, or null if the key is not found
    }       // end of get()

    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                System.out.println(keys[i] + " -> " + values[i]);
            }
        }
    }    

    public void remove(Object key){
        if (!contains(key)){
            return;
        }
        int index = hash(key);
        while (keys[index]!=null && !keys[index].equals(key)){
            index = (index + 1) % capacity;
        }
        keys[index] = values[index] = null;
        size--;
        // for (int i= index ; keys[i]!=null; i = (index+1) % capacity ){
        //     // Object temp1 = keys[i], temp2 = values[i];
        //     keys[index] = keys[i];
        //     values[index] = values[i];
        //     keys[i] = values[i] = null;
        //     index = i;
        // }
    }     // end of remove()

    public static void main(String[] args) {

        LinearProbing lp = new LinearProbing(6);

        lp.put(5, "Asad");
        lp.put(1, "AJ Styles");
        lp.put(7, "Uzair Hussain");
        lp.put(2, "Usman");
        lp.put(5, "Ertugrul");

        System.out.println(lp.get(5));
        System.out.println(lp.contains(2));
        System.out.println(lp.contains(3));

        System.out.println(lp.size());
        lp.remove(7);
        System.out.println(lp.size());
        lp.display();

    }
}

