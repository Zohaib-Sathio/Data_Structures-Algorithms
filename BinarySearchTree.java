// Program by UZAIR HUSSAIN 
// Github: github.com/uzairhussain193
// LinkedIn: linkedin.com/in/uzairhussain19

import java.util.Scanner;


public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node insert(Node root, int val){
        if(root==null){
            root= new Node(val);
            return root;
        }
        if(val<root.data){
            root.left= insert(root.left, val);
        }
        if(val>root.data){
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void Inorder(Node root){
        if(root==null){
            return;
        }
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right); 
    }
    public static void PreOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        PreOrder(root.left);
        PreOrder(root.right); 
    }
    public static void Postorder(Node root){
        if(root==null){
            return;
        }
        Postorder(root.left);
        Postorder(root.right); 
        System.out.print(root.data+" ");
    }
    
    public static boolean search(Node root, int value){
        if(root==null ){
            return false;
        }
        if(root.data==value){
            return true;
        }
        else if(value<root.data){
            return search(root.left, value);
        }
        else{
            return search(root.right, value);
        }
    }
    public static Node delete(Node root, int value){
        if(value<root.data){
            root.left=delete(root.left, value);
        }
        else if(value>root.data){
            root.right=delete(root.right, value);
        }
        else{// ROOT.data = value
            //case 1
            //leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            // case 2 
            // one child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            // case 3
            // successor
            Node IS = inorderSuccessor(root.right);
            root.data=IS.data;
            delete(root.right, IS.data);                       
        }
        return root;
    }
    private static Node inorderSuccessor(Node root) {
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int[] values={5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root= insert(root, values[i]);
        }
        System.out.println("Before deleting 4");
        
        System.out.print("In Order traversal: ");
        Inorder(root);
        System.out.print("\nPre Order traversal: ");
        PreOrder(root);
        System.out.print("\nPost Order traversal: ");
        Postorder(root);
        
        

        delete(root, 4);
        System.out.println("\nAfter deleting 4");
        System.out.print("In Order traversal: ");
        Inorder(root);
        System.out.print("\nPre Order traversal: ");
        PreOrder(root);
        System.out.print("\nPost Order traversal: ");
        Postorder(root);
        System.out.print("\nEnter value to search: ");
        int a= s.nextInt();
        if(search(root, a)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
    }
}
