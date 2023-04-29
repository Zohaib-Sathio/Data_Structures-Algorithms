// Program by UZAIR HUSSAIN 
// Github: github.com/uzairhussain193
// LinkedIn: linkedin.com/in/uzairhussain19

public class Array_Queue {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public Array_Queue(int capacity) {
        data = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == data.length;
    }
    public int size() {
        return size;
    }
    public void enqueue(int item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % data.length;    // finding index for rear
        data[rear] = item;
        size++;
    }
    public int dequeue() {  // pop
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int item = data[front];
        front = (front + 1) % data.length;
        size--;
        return item;
    }
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data[front];
    }
    public void displayQueue() {
        if (isEmpty()) {
          System.out.println("Queue is empty");
          return;
        }
        for (int i = front; i <= rear; i++) {
          System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {07,10,57,85,101};
        Array_Queue m = new Array_Queue(arr.length);
        for(int i=0;i<arr.length;i++){
            m.enqueue(arr[i]);
        }
        System.out.println(m.peek());
        m.displayQueue();
    }
}