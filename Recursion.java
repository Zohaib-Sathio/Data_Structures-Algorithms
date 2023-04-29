// Program by UZAIR HUSSAIN 
// Github: github.com/uzairhussain193
// LinkedIn: linkedin.com/in/uzairhussain19


import java.util.Scanner;

public class Recursion {
    public long fibonacci(int n){
        // takes less time
        if(n<=1 && n>-1){
            return n;
        }
        return (fibonacci(n-1)+fibonacci(n-2));
    }
    public long fibonacci2(int n){
        // taking more time then previous one
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else{
            return (fibonacci(n-1)+fibonacci(n-2));
        }   
    }
    public static long factorial(long n) {
        if (n == 0) {
            return 1;
        } 
        return (n * factorial(n - 1));
    }
    public static void main(String[] args) {
        Recursion r = new Recursion();
        Scanner s = new Scanner(System.in);
        long t1=0,t2=0;
        long t3=0,t4=0;

        // t1=System.currentTimeMillis()*100;
        // for(int i=0;i<30;i++){
        //     System.out.print(r.fibonacci(i)+" ");
        // }
        // t2=System.currentTimeMillis()*100;
        // // System.out.println("\nTime taken in sec: "+(t2-t1));
        // t1=System.currentTimeMillis()*100;
        // for(int i=0;i<30;i++){
        //     // r.fibonacci(i);
        //     System.out.print(r.fibonacci2(i)+" ");
        // }
        // t2=System.currentTimeMillis()*100;
        // System.out.println("\nTime taken in sec: "+(t2-t1));
       
        // Q 1 20SW finals
        t3=System.currentTimeMillis()*100;
        for(int i=12;i<=20;i++){
            long a = factorial(i);
            System.out.println("Factorial of "+i+"  is : "+a);
        }
        t4=System.currentTimeMillis()*100;
        // System.out.println("\nTime taken in sec: "+(t4-t3));
        // System.out.print("Enter number for factorial: ");
        // int a = s.nextInt();
        // System.out.println(factorial(a));


    }
}
