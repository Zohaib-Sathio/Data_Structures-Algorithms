
package data.structures;

class TowerOfHanoi {
    
     static void Tower(int n, char src, char dest, char helper) {
         if (n == 1) {
             System.out.println("Transfer disk " + n + " From " + src + "  to " + dest);
             return;
         }
         Tower(n - 1, src, helper, desc);
         
         System.out.println("Transfer disk " + n + " From " + src + " to " + dest);
         
         Tower(n - 1, helper, dest, src);
     }

     public static void main(String[] args) {
         int n = 3;
         Tower(n, 'S','H','D');
     }
 }
