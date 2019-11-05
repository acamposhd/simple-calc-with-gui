package Classes;

public class Operations {

    public static float C;
    public static long dec = 0;
    public static String operator;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method sets the String value of the operator and returns it
    to its public variable*/
    public static String setOperator(String op) {
        operator = op;
        return operator;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method makes an addition with two float variables
    and returns a float result in another variable*/
    public static float add(float a, float b) {
        C = a + b;
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method makes a substraction  with two float variables
    and returns a float result in another variable*/
    public static float subs(float a, float b) {
        C = a - b;
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method makes a multiplication  with two float variables
    and returns a float result in another variable*/
    public static float mult(float a, float b) {
        C = a * b;
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method makes a division  with two float variables
    and returns a float result in another variable*/
    public static float div(float a, float b) {
        C = a / b;
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method takes the n percent of n number
    and returns a float result in another variable*/
    public static float perc(float a, float b) {
        C = b * (a / 100);
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method takes the square root of n number
    and returns a float result in another variable*/
    public static float sqrt(float a) {
        C = (float) Math.sqrt(a);
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method takes the cubic root of n number
    and returns a float result in another variable*/
    public static float cubicRoot(float a) {
        C = (float) Math.pow(a, (1.0 / 3.0));
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method takes the value of C and make a parse to string
    then returns the value to a string variable*/
    public static String print() {
        return String.valueOf(C);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method  power square n number
    and returns a float result in another variable*/
    public static float elevatedSquare(float a) {
        C = (float) Math.pow(a, 2);

        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method  power cube n number
    and returns a float result in another variable*/
    public static float elevatedCube(float a) {
        C = (float) Math.pow(a, 3);
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method power n  n number
    and returns a float result in another variable*/
    public static float elevatedToN(float a, float b) {
        C = (float) Math.pow(a, b);
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method makes the sin function of n number
    and returns a float result in another variable*/
    public static float sin(float a) {
        C = (float) Math.sin(a);
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method makes the cos function of n number
    and returns a float result in another variable*/
    public static float cos(float a) {
        C = (float) Math.cos(a);
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method makes the tan function of n number
    and returns a float result in another variable*/
    public static float tan(float a) {
        C = (float) Math.tan(a);
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method makes the factorial of n number
    and returns a float result in another variable*/
    public static float fact(float a) {

        float factorial = 1;
        for (int i = (int) a; i > 0; i--) {
            factorial = factorial * i;
        }
        C = factorial;
        return C;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method makes the factorial of input number
    and returns a float result in another variable*/
    public static long decimalToBinary(int input)
    {
        String conc = ""; 
        while (input != 0) {
            int r = (int)(input % 2);
            conc = r + conc;
            input /= 2; 
        }
        dec = Integer.parseInt(conc);
        return dec;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method makes the factorial of n number
    and returns a float result in another variable*/
    public static long binaryToDecimal(int number) {

        int binary = number;
        int power = 0;
        while (binary != 0) {
            int finalNumber = binary % 10;
            dec += finalNumber * Math.pow(2, power);
            power++;
            binary = binary / 10;
        }
        return dec;
    }
}
