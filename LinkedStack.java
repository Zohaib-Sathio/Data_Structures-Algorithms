package data.structures;

public class LinkedStack {

    Node top;
    int size;

    LinkedStack() {
        top = null;
        size = 0;
    }

    public class Node {

        Object data;
        Node next;

        Node(Object object) {
            this.data = object;
        }
    }

    public void push(Object object) {
        if (top == null) {
            top = new Node(object);
            size++;
        } else {
            Node temp = top;
            top = new Node(object);
            top.next = temp;
            size++;
        }
    }

    public Object peek() {
        return top.data;
    }

    public Object pop() {
        Object obj = top.data;
        top = top.next;
        --size;
        return obj;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (top == null);
    }
    
    public String[] toArray(){
        String[] arr = new String[size];
        int index = 0;
        for(Node p = top; p != null; p = p.next){
            arr[index++] = p.data.toString();
        }
        return arr;
    }
    
    public boolean isEqual(LinkedStack stack){
        if(size != stack.size()) return false;
        Node q = stack.top;
        for(Node p = top; p != null; p = p.next){
            if(p.data != q.data)
                return false;
            q = q.next;
        }
        return true;
    }
    @Override
    public String toString(){
        if(isEmpty()) return "[]";
        StringBuffer buff = new StringBuffer("[" + top.data);
        for (Node p = top.next; p != null; p = p.next) {
            buff.append(", ").append(p.data);
        }
        return (buff + "]");
    }
    
    public LinkedList toLinkedList(){
        LinkedList list = new LinkedList();
        for (Node p = top; p != null; p = p.next) {
            list.insert(p.data);
        }
        return list;
    }

    public boolean contains(Object object) {
        if (top.data.equals(object)) {
            return true;
        }
        for (Node p = top; p != null; p = p.next) {
            if (p.data.equals(object)) {
                return true;
            }
        }
        return false;
    }
    
    public LinkedStack reverse(){
        LinkedStack reversed = new LinkedStack();
        for (Node p = top; p != null; p = p.next)
            reversed.push(p.data);
        return reversed;
    }

    public void print() {
        for (Node p = top; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(5);
        linkedStack.push(7);
        linkedStack.push(9);
        linkedStack.push(11);
        linkedStack.push("Zohaib");
        linkedStack.push("LinkedStack");
        System.out.println("Size: " + linkedStack.size());
        
        LinkedStack linkedStack2 = linkedStack.reverse();
        linkedStack.print();

        //To only print elements
//        linkedStack.print();

        //Checking for Equality
//        LinkedStack stack2 = new LinkedStack();
//        stack2.push(1);
//        stack2.push(3);
//        stack2.push(4);
//        stack2.push(5);
//        stack2.push("Zohaib");
//        System.out.println(stack2.isEqual(linkedStack));

        
        System.out.println("to String: " + linkedStack.toString());

        //LinkedStack to Array
//        String[] array = linkedStack.toArray();
//        for (String array1 : array) {
//            System.out.println(array1);
//        }

        //To linkedList
//        LinkedList list = linkedStack.toLinkedList();
//        for (LinkedList.Node p = list.start; p!= null; p = p.next) {
//            System.out.println(p.data);
//        }

//        System.out.println(linkedStack.peek());
//        System.out.println(linkedStack.contains(12));
        while (!linkedStack.isEmpty()) {
            System.out.println(linkedStack.pop());
        }
    }
}
