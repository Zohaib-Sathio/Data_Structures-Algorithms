package data.structures;

/*
    What is Reverse Polish Notation?
    
    Reverse Polish notation (RPN) is a method for conveying mathematical expressions without the use of separators such as brackets and parentheses. 
    In this notation, the operators follow their operands, hence removing the need for brackets to define evaluation priority. The operation is read 
    from left to right but execution is done every time an operator is reached, and always using the last two numbers as the operands. This notation 
    is suited for computers and calculators since there are fewer characters to track and fewer operations to execute.
*/

public class RPN_Algorithm {
    String input;
    
    RPN_Algorithm(String[] expression){ // This constructor takes an String array as an argument, which contains the expresssion that needs to be evalutated
        ArrayStack stack = new ArrayStack(expression.length); // An ArrayStack will be used for the evalutation of expression
        for (String expression1 : expression) {
            input = expression1;
            if(isAnOperator(input)){ // if the current character being traversed in the expression is an operator
                Double y = Double.parseDouble((String)stack.pop()); // pop the first element (convert to integer first)
                Double x = Double.parseDouble((String)stack.pop()); // pop the second element (convert to integer first)
                Double z = evaluate(x, y, input); // perform evaluation according to the operator
                String a = z.toString(); // finalize result of this operation
                stack.push(a); // push it to the stack for further operations
            } // if block ends
            else // if it is not operator, then it must be a number
                stack.push(input); // push number to the stack
        } // for loop ends
    } // constructor ends
    
    private boolean isAnOperator(String op){ // this function checks if the current element is an operator or not
        return (op.length() == 1 && "DMAS".contains(op)); // this returns a boolean value (true) if the input is correct and is an operator
    } // isAnOperator() ends
    
    private double evaluate(double x, double y, String op){ // this function performs arithematic operation depending upon the given operator
        Double z = null; // z is the result variable
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
        } // switch ends
        System.out.println(x + " " + op + " " + y + " = " + z);
        return z;
    } // evaluate() ends
    
    public static void main(String[] args){
        String[] arr = {"2", "4", "D", "3", "4", "M", "A"};
        RPN_Algorithm obj = new RPN_Algorithm(arr);
    } // main() ends
} // RPN_Algorithm() ends
