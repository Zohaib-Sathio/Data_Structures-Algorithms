package data.structures;

public class SinglyLinkedQueue {

    Node front, rear;
    int size;

    public class Node {

        Node next;
        Object data;

        Node(Object object) {
            this.data = object;
        }
    }

    public void add(Object object) {
        Node node = new Node(object);
        if (front == null) {
            front = node;
            rear = node;
        } else
            rear = rear.next = node;
        ++size;
    }

    public void print() {
        if (front != null)
            for (Node p = front; p != rear.next; p = p.next)
                System.out.println(p.data);
    }

    public Object delete() {
        Object obj;
        if (front == null) throw new IllegalStateException("Queue is Empty");
        obj = front.data;
        if (front.next == null)
            rear = front = null;
            else
            front = front.next;
        --size;
        return obj;
    }

    public Object deleteSpecific(Object object) {
        Object obj;
        if (front == null) throw new IllegalStateException("Queue is Empty");
        if (front.data.equals(object)) {
            obj = front.data;
            front = front.next;
            size--;
            return obj;
        } else
            for (Node p = front; p.next != rear.next; p = p.next)
                if (p.next.data.equals(object)) {
                    obj = p.next.data;
                    p.next = p.next.next;
                    size--;
                    return obj;
                }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public boolean contains(Object object) {
        if (front.data.equals(object))
            return true;
        for (Node p = front; p != rear.next; p = p.next)
            if (p.data.equals(object))
                return true;
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedQueue queue = new SinglyLinkedQueue();
        queue.add(9);
        queue.add(8);
        queue.add(7);
        queue.add(6);
        queue.add("Zohaib");
        queue.add("Sathio");
        queue.delete();
        System.out.println("Deleted: " + queue.deleteSpecific(8));
//        System.out.println(queue.contains(7));
        queue.print();
        System.out.println("Size: " + queue.size());
    }
}
