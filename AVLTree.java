package data.structures;

public class AVLTree {

    private int key, height;
    private AVLTree left, right;
    public static final AVLTree NIL = new AVLTree();

    private AVLTree() {
        left = right = this;
        height = -1;
    }

    AVLTree(int key) {
        this.key = key;
        left = right = NIL;
    }

    AVLTree(int key, AVLTree left, AVLTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
        height = 1 + Math.max(left.height, right.height);
    }

    public int size() {
        if (this == NIL) return 0;
        return 1 + left.size() + right.size();
    }

    @Override
    public String toString() {
        if (this == NIL) {
            return "";
        }
        return left + " " + key + " " + right;
    }

    public boolean add(int key) {
        int oldsize = size();
        grow(key);
        return size() > oldsize;
    }

    private AVLTree grow(int key) {
        if (this == NIL) return new AVLTree(key);
        
        if (key == this.key) return this;
        
        if (key < this.key)
            left = left.grow(key);
        else 
            right = right.grow(key);
        
        rebalance();
        
        height = 1 + Math.max(left.height, right.height);
        
        return this;
    }

    private void rebalance() {
        if (right.height > left.height + 1) {
            if (right.left.height > right.right.height)
                right.rotateRight();
            rotateLeft();
        }

        if (left.height > right.height + 1) {
            if (left.right.height > left.left.height)
                left.rotateLeft();
            rotateRight();
        }
    }

    private void rotateLeft() {
        left = new AVLTree(key, left, right.left);
        key = right.key;
        right = right.right;
    }

    private void rotateRight() {
        right = new AVLTree(key, left.right, right);
        key = left.key;
        left = left.left;
    }

    public int getRoot() {
        return key;
    }

    public void setRoot(int key) {
        this.key = key;
    }

    public AVLTree getLeft() {
        return left;
    }

    public void setLeft(AVLTree left) {
        this.left = left;
    }

    public AVLTree getRight() {
        return right;
    }

    public void setRight(AVLTree right) {
        this.right = right;
    }
    public static void main(String[] args) {
        AVLTree avl = new AVLTree(1);
        avl.add(2);
        avl.add(4);
        avl.add(3);
        System.out.println(avl.toString());
    }

}
