package data.structures;

public class RPN_Algorithm {
    String input;
    RPN_Algorithm(String[] expression){
        ArrayStack stack = new ArrayStack(expression.length);
        for (String expression1 : expression) {
            input = expression1;
            if(isAnOperator(input)){
                Double y = Double.parseDouble((String)stack.pop());
                Double x = Double.parseDouble((String)stack.pop());
                Double z = evaluate(x, y, input);
                String a = z.toString();
                stack.push(a);
            }
            else{
                stack.push(input);
            }
        }
    }
    private boolean isAnOperator(String op){
        return (op.length() == 1 && "DMAS".contains(op));
    }
    private double evaluate(double x, double y, String op){
        Double z = null;
        switch (op) {
            case "A":
                z = x + y;
                break;
            case "S":
                z = x - y;
                break;
            case "M":
                z = x * y;
                break;
            case "D":
                z = x / y;
                break;
            default:
                break;
        }
        System.out.println(x + " " + op + " " + y + " = " + z);
        return z;
        
    }
    public static void main(String[] args){
        String[] arr = {"2", "4", "D", "3", "4", "M", "A"};
        RPN_Algorithm obj = new RPN_Algorithm(arr);
    }
}
