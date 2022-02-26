package data.structures;

public class DoublyLinkedQueue {

    Node head = new Node(null);
    int size;

    public class Node {

        Node prev = this, next = this;
        Object data;

        Node(Object object) {
            this.data = object;
        }

        Node(Object object, Node prev, Node next) {
            this.data = object;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(Object object) {
        head.prev = head.prev.next = new Node(object, head.prev, head);
        size++;
    }

    public void addFirst(Object object) {
        //Not working with other methods
        head.next = new Node(object, head, head.next);

//        Node temp = head.next;
//        head.next = node;
//        head.next.next = temp;
        size++;
    }

    public Object remove() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object obj = head.next.data;
        head.next = head.next.next;
        size--;
        return obj;
    }

    public Object removeLast() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object obj = head.prev.data;
        head.prev = head.prev.prev;
        head.prev.next = head;
        size--;
        return obj;
    }

    public void addInMid(Object object) {
        //Not working with other methods
        int half = size / 2;
        int i = 0;

        for (Node p = head.next; p != head; p = p.next) {
            i++;
            if (i == half) {
                p.next = new Node(object, p, p.next);
                size++;
                break;
            }
        }
    }

    public Object removeSpecific(Object object) {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object obj = null;
        if (head.next.data.equals(object)) {
            obj = head.next.data;
            head.next = head.next.next;
            size--;
            return obj;
        } else {
            for (Node p = head.next; p.next != head; p = p.next) {
                if (p.next.data.equals(object)) {
                    obj = p.next.data;
                    p.next = p.next.next;
                    size--;
                    return obj;
                }
            }
        }
        return obj;
    }

    public void print() {
        for (Node p = head.next; p != head; p = p.next) {
            System.out.println(p.data);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (head.next == null);
    }

    public boolean contains(Object object) {
        if (head.next.data.equals(object)) {
            return true;
        }
        for (Node p = head.next; p != head; p = p.next) {
            if (p.data.equals(object)) {
                return true;
            }
        }
        return false;
    }

    public Object peekLast() {
        if (size == 0) {
            throw new IllegalStateException("Empty Queue");
        }
        return head.prev.data;
    }

    public Object peekFirst() {
        if (size == 0) {
            throw new IllegalStateException("Empty Queue");
        }
        return head.next.data;
    }

    public DoublyLinkedQueue reverse() {
        DoublyLinkedQueue queue = new DoublyLinkedQueue();
        for (Node p = head.prev; p != head; p = p.prev) {
            queue.add(p.data);
        }
        return queue;
    }
    
    public void merge(Node head1, Node head2){
        head1.prev.next = head2.next;
        head2.next.prev = head1.prev;
        head2.prev.next = head1;
        head1.prev = head2.prev;
    }

    public static void main(String[] args) {
        DoublyLinkedQueue queue = new DoublyLinkedQueue();
        queue.add(4);
        queue.add(5);
        queue.add("Sathio");
        queue.add("Zohaib");
        queue.add(6);
        queue.add(7);
        
        queue.print();
        
//        System.out.println("Removed: " + queue.removeLast());
//
//        System.out.println("Last element: " + queue.peekLast());

//        queue.remove();
//        System.out.println("Removed: " + queue.removeSpecific(5));
//        System.out.println(queue.contains(4));

        //reversing
//        System.out.println("\nQueue2: ");
//        DoublyLinkedQueue queue2 = queue.reverse();
//        queue2.print();

        //Merging two queues
//        DoublyLinkedQueue queue3 = new DoublyLinkedQueue();
//        queue3.add("Z");
//        queue3.add("H");
//        queue3.add("S");
//        queue3.merge(queue3.head, queue.head);
//        queue3.print();
        

//        System.out.println("\nQueue: ");
//        queue.print();
//        System.out.println("Size: " + queue.size());
    }
}
