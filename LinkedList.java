package data.structures;

public class LinkedList {

    Node start;
    int size;

    public class Node {

        Node next;
        Object data;

        Node(Object data) {
            this.data = data;
        }

        Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void insert(Object data) {
        if (start == null) {
            start = new Node(data);
            size++;
        } else {
            Node p;
            for (p = start; p.next != null; p = p.next) {
            }
            p.next = new Node(data);
            size++;
        }
    }

    public void display() {
        for (Node p = start; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }

    public void delete(Object target) {
        if (start.data == target) {
            start = start.next;
            size--;
        } else {
            for (Node p = start; p.next != null; p = p.next) {
                if (p.next.data == target) {
                    p.next = p.next.next;
                    size--;
                    return;
                }
            }
        }
    }
    public void deleteFirst(){
        if(start != null){
            start = start.next;
            size--;
        }
    }
    

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (start == null);
    }
    
    public boolean contains(Object object){
        if(start.data.equals(object)) return true;
        for(Node p = start; p != null; p = p.next){
            if(p.data== object) return true;
        }
        return false;
    }
    
    public Node merge(LinkedList list) {
        Node p;
        for (p = start; p.next != null; p = p.next) {
        }
        for (Node q = list.start; q != null; q = q.next) {
            p.next = q;
            p = p.next;
            size++;
        }
        return start;
    }
    
    public LinkedList reverse(){
        LinkedList list = new LinkedList();
        Node q;
        for(q = start; q.next != null; q = q.next){}
        list.insert(q.data);
        for(Node r = start; r.next != null; r = r.next){
            for(Node p = start; p.next != null; p = p.next){
            if(p.next == q){
                list.insert(p.data);
                q = p;
            }
        }
        }
        
        return list;
    }
    
    public LinkedList cloneList(){
        LinkedList clone = new LinkedList();
        for(Node p = start; p != null; p = p.next){
            clone.insert(p.data);
        }
        return clone;
    }
    
    public LinkedList subList(int a, int b) {
        LinkedList list2 = new LinkedList();
        int index = 0;
        for (Node p = start; p != null; p = p.next) {
            if (index >= a && index <= b) {
                list2.insert(p.data);
            }
            index++;
        }
        return list2;
    }
    public void sortList(){
            boolean wasChanged;
        do{
            Node current = start;
            Node previous = null;
            Node next = start.next;
            wasChanged = false;
            while(next!= null){
                if( (Integer) current.data > (Integer) next.data){
                    wasChanged = true;
                    if(previous != null){
                        Node temp = next.next;
                        previous.next = next;
                        next.next = current;
                        current.next = temp;
                    }
                    else{
                        Node temp = next.next;
                        start = next;
                        next.next = current;
                        current.next = temp;
                    }
                    current = next;
                    next = next.next;
                }
                else{
                    previous = current;
                    current = next;
                    next = next.next;
                }
            }
        }
        while(wasChanged);
    }
    


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(12);
        list.insert(122);
        list.insert(5);
        list.insert(55);
        list.insert(6);
        System.out.println(list.contains(35));
        LinkedList list2 = new LinkedList();
        list2.insert(345);
        list2.insert(1242);
        list.merge(list2);
//        list.sortList();
        list.display();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        
//        list.deleteFirst();
        
        
//        //List Clonning
//        LinkedList list4 = list.cloneList();
//        list4.display();
        
        //Merging
//        LinkedList list2 = new LinkedList();
//        list2.insert("Z");
//        list2.insert("S");
//        list.merge(list2);
        
        //Reversing
//        LinkedList list3 = list.reverse();
//        list3.display();


        
//        list.delete(12);
//        System.out.println(list.contains("zohaib"));
//
        
//        System.out.println("Size: " + list.size());
        
        
    }

    
    
    
    
        //Useable when data is of integer type
    
//    public int lowestNumber() {
//        int low = start.data;
//        for (Node p = head.next; p != null; p = p.next) {
//            if (p.data < low) {
//                low = p.data;
//            }
//        }
//        return low;
//    }
//
//    public int highestNumber() {
//        int high = head.data;
//        for (Node p = head.next; p != null; p = p.next) {
//            if (p.data > high) {
//                high = p.data;
//            }
//        }
//        return high;
//    }
}
