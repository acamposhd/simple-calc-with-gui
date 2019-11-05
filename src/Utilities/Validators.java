package Utilities;

import Classes.Operations;
import GUI.CalcGui;
import static GUI.CalcGui.stop;
import static Utilities.Utilities.numberOne;
import java.text.DecimalFormat;
import java.awt.event.KeyEvent;

/**
 *
 * @author AlbertFields
 */
public class Validators extends CalcGui {

    static DecimalFormat formater = new DecimalFormat("#"); // when the result is an entire number it will formated taking off the .0 after the number
    public static String result;// this variable will take the String value of the operation's results
    public static String error = "SYNTAX ERROR";//Syntax error message to be displayed
    //start of the flags aplied
    public static Boolean errorValidator;
    public static Boolean validator = false;
    public static Boolean emptyInput;
    public static Boolean emptyOutput;
    public static Boolean validateEquals;
    public static Boolean validateZero;
    public static Boolean errorInfinity;
    //end of the flags
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method turn a result type 5.0 just for the entire number
  if the number its decimal it let it as it is. It returns the
  value of result*/
    public static String isEntire(float C) {
        if (C % 1 == 0) {
            result = formater.format(C);
            return result;
        }
        result = String.valueOf(C);
        return result;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method prints the value of result*/
    public static String print() {
        return String.valueOf(result);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method checks the typed key in order to 
  don't allow letters or symbols */
    public static void keyTyped(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (c != '`') {
            ke.consume();
        }
        ke.consume();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method checks if the textbox (inputJtxt) is empty 
  and returns a boolean value */
    public static Boolean emptyInput(String input) {
        CalcGui.input = input;
        if (input.equals("")) {
            emptyInput = true;
            return emptyInput;
        }
        emptyInput = false;
        return emptyInput;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method checks if the label (outputJtxt) is empty 
  and returns a boolean value */
    public static Boolean emptyOutput(String output) {
        CalcGui.output = output;
        if (output.equals("")) {
            emptyOutput = true;
            return emptyOutput;
        }
        emptyOutput = false;
        return emptyOutput;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method checks if the textbox has an Syntax error message
  and returns a boolean value*/
    public static boolean syntaxError(String error) {
        if (error.equals(Validators.error)) {
            errorValidator = true;
            return errorValidator;
        } else {
            errorValidator = false;
            return errorValidator;
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method validates all the variables, the texbox and the output label
    in order to find errors and exceptions. it validates the integrity of
    the data and displays an SYNTAX ERROR message if something is wrong*/
    
    public static void bigValidator(String input, String output) {
       /*First it checks if the operator is different to one digit
        and it will work when the operators key is pressed instead of 
        the equals one. It will take the operator off and is going to make tha 
        last operation ordered, then, it will display the result with the new operator
        */
        if (CalcGui.operator.equals("(^2)")
                || CalcGui.operator.equals("(^3)")
                || CalcGui.operator.equals("SQRT")
                || CalcGui.operator.equals("CUBICRT")
                || CalcGui.operator.equals("sin")
                || CalcGui.operator.equals("cos")
                || CalcGui.operator.equals("tan")
                || CalcGui.operator.equals("!")) {
            Operations.operator = CalcGui.operator;
        }

        CalcGui.input = input;
        CalcGui.output = output;
        Validators.emptyInput(CalcGui.input); //validates if the textbox is empty
        Validators.emptyOutput(CalcGui.output);//validates if the textbox is empty

       //if both of them are full it will enter to a switch
        if (Validators.emptyInput == false && Validators.emptyOutput == false) {

            switch (Operations.operator) {
                /* this switch case will evaluate the operator and will do something
                depending of it
                */
                /*
               prints the result with its new operator
               gives the value of the text and label to its variables
                and evaluates if the result is error or infinity before to 
                print it to the label it also makes the operation when one of the operators is 
                pressed, accting as an equals key. At the end (if the procces did't enter
                to the switch) it evaluates if the character in the textbox is just a symbol
                or a dot, if so it will keep it like that until another valid key is pressed.
                */
                case "+":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input); 
                    Operations.add(numberOne, Utilities.numberTwo);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;
                case "-":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.subs(numberOne, Utilities.numberTwo);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;

                case "*":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.mult(numberOne, Utilities.numberTwo);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }

                    break;

                case "/":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Validators.secondNumberIsZero(CalcGui.input);
                    Operations.div(numberOne, Utilities.numberTwo);
                    numberOne = Operations.C;
                    Validators.isEntire(numberOne);
                    Validators.checkInfinity();

                    Validators.validateSyntaxError(CalcGui.input, CalcGui.output, error);
                    if (errorValidator) {
                        Validators.setError();
                    } else {
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;

                case "%":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.perc(numberOne, Utilities.numberTwo);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;
                case "SQRT":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.sqrt(numberOne);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;
                case "CUBICRT":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.cubicRoot(numberOne);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;
                case "(^2)":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.elevatedSquare(numberOne);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;
                case "(^3)":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.elevatedCube(numberOne);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;
                case "(^n)":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.elevatedToN(numberOne, Utilities.numberTwo);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;
                case "sin":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.sin(numberOne);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;
                case "cos":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.cos(numberOne);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;
                case "tan":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.tan(numberOne);
                    if (String.valueOf(Operations.C).equals("Infinity")) {
                        CalcGui.input = error;
                        CalcGui.output = error;

                    } else {
                        numberOne = Operations.C;
                        Validators.isEntire(numberOne);
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;
                case "!":
                    CalcGui.output = CalcGui.output.substring(0, CalcGui.output.length() - 1) + Operations.operator;
                    Utilities.numberTwo = Float.parseFloat(CalcGui.input);
                    Operations.fact(numberOne);
                    numberOne = Operations.C;
                    Validators.isEntire(numberOne);
                    Validators.checkInfinity();
                    Validators.validateSyntaxError(CalcGui.input, CalcGui.output, error);
                    if (errorValidator) {
                        Validators.setError();
                    } else {
                        Operations.setOperator(CalcGui.operator);
                        CalcGui.output = (Validators.print() + CalcGui.operator);
                        CalcGui.input = "";
                    }
                    break;

                default:

            }

        } else {

            Validators.emptyInput(CalcGui.input);
            if (Validators.emptyInput) {
                CalcGui.input = "";

            } else {
                if (CalcGui.input.equals("-")) {
                    CalcGui.output = error;

                } else {

                    Utilities.numberOne = Utilities.setNumberOne(Float.parseFloat(CalcGui.input));
                    Operations.setOperator(CalcGui.operator);
                    CalcGui.output = (CalcGui.input + String.valueOf(CalcGui.operator));
                    CalcGui.input = "";

                }
            }
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method checks if the screens have a syntax error message
    if so the method cleans the screens and set the new value
    in the text box. It also evaluates if there is another number in the textbox
    and concatenates that one with the new one*/

    public static void validateSyntaxError(String input, String output, String symbol) {
        CalcGui.input = input;
        CalcGui.output = output;
        Validators.syntaxError(output);
        if (Validators.errorValidator == true) {

            CalcGui.input = symbol;
            CalcGui.output = "";
        } else {
            CalcGui.input = CalcGui.input + symbol;
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method checks if the screens have a syntax error message when a 
    if so the method cleans the screens*/
    public static void validateOperator(String input, String output, String operator) {
        CalcGui.input = input;
        CalcGui.output = output;
        Validators.syntaxError(CalcGui.input);
        if (Validators.errorValidator == true) {
            CalcGui.input = "";
            CalcGui.output = "";
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method checks if the screens have a syntax error message
    when the dot key is pressed. If so the method erase the error
    message and set a 0. instead; also it uses the method:
    "validateDoubleDot" all in order to don't allow the user 
    set more that one decimal point to the textbox*/
    public static void validateSyntaxErrorDot(String input, String output, String symbol) {
        CalcGui.input = input;
        CalcGui.output = output;

        Validators.syntaxError(CalcGui.output);
        if (Validators.errorValidator == true) {
            CalcGui.input = "";
            CalcGui.output = "";
            CalcGui.input = "0" + symbol;

        } else {

            if (CalcGui.input.equals("")) {
                CalcGui.input = "0" + symbol;
            } else {
                Validators.validateDoubleDot(CalcGui.input);
                if (stop == true) {
                    CalcGui.input = CalcGui.input;
                } else {
                    char lastDigit = CalcGui.input.charAt(CalcGui.input.length() - 1);
                    if (lastDigit == '.') {
                        CalcGui.input = CalcGui.input;
                    } else {
                        if (CalcGui.input.equals("")) {
                            CalcGui.input = "0" + symbol;
                        } else {
                            if (CalcGui.input.equals("-")) {
                                CalcGui.input = CalcGui.input + "0" + ".";
                            } else {
                                CalcGui.input = CalcGui.input + ".";
                            }

                        }

                    }

                }
            }
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method checks if the screens have a syntax error message
    when the negative key (-) is pressed. If so the method erase the error
    message and set a - instead; also it uses the method:
    "validateDoubleNegative" all in order to don't allow the user 
    set more that one decimal point to the textbox; instead of that it sets
    and takes off the negative symbol when the button is pressed*/
    public static void validateSyntaxErrorNegative(String input, String output, String symbol) {
        CalcGui.input = input;
        CalcGui.output = output;

        Validators.syntaxError(CalcGui.output);
        if (Validators.errorValidator == true) {
            CalcGui.input = "";
            CalcGui.output = "";
            CalcGui.input = symbol;

        } else {

            if (CalcGui.input.equals("")) {
                CalcGui.input = "";
            } else {
                Validators.validateDoubleNegative(CalcGui.input);
                if (stop == true) {
                    CalcGui.input = CalcGui.input;
                } else {
                    char lastDigit = CalcGui.input.charAt(CalcGui.input.length() - 1);
                    if (lastDigit == '-') {
                        CalcGui.input = CalcGui.input;
                    } else {
                        if (CalcGui.input.equals("")) {
                            CalcGui.input = symbol;
                        }
                        CalcGui.input = CalcGui.input + "-";
                    }
                }
            }
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*validates if the user press more than once the dot key
    if so it sets a flag to be use in the validator method*/
    public static boolean validateDoubleDot(String input) {
        CalcGui.input = input;
        char charArray[] = CalcGui.input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '.') {
                stop = true;
                return stop;
            } else {
                stop = false;
            }
        }
        return stop;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*validates if the user press more than once the dot key
    if so it sets a flag to be use in the validator method*/
    public static boolean validateDoubleNegative(String input) {
        CalcGui.input = input;
        char charArray[] = CalcGui.input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '-') {
                stop = true;
                return stop;
            } else {
                stop = false;
            }
        }
        return stop;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method checks if the the result is "Infinity" if so
    it sets SYNTAX ERROR messages to the label and textbox*/
    public static void checkInfinity() {
        if (String.valueOf(Operations.C).equals("Infinity")
                || String.valueOf(Operations.C).equals("-Infinity")
                || String.valueOf(Operations.C).equals("infinity*")) {
            Validators.setError();
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method cleans all the variables*/
    public static void inicialize() {
        CalcGui.input = "0";
        CalcGui.output = "";
        Utilities.numberOne = 0;
        Utilities.numberTwo = 0;
        Operations.C = 0;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*this method set the label and the textbox with SYNTAX ERROR messages
    and clean the other variables*/
    public static void setError() {
        CalcGui.input = error;
        CalcGui.output = error;
        Utilities.numberOne = 0;
        Utilities.numberTwo = 0;
        Operations.C = 0;
        result = error;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method checks if the first number of the textbox is a 0
    if so it will replace for the first number to be pressed
    if the first number is zero again it will be seting the same
    zero in order to don't have many initial zeros*/
    public static void firstNumberIsZero(String input, String symbol) {

        if (input.charAt(0) == '0' && input.charAt(1) != '.') {
            CalcGui.input = symbol;
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*validate if the second number is Zero and then is used in the 
    negative button and in the dot one in order to apply 
    the same than in the "ValidateZero" method*/

    public static void secondNumberIsZero(String input) {

        if (Utilities.numberTwo == 0) {
            CalcGui.input = error;
            CalcGui.output = error;
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*This method will validate functions in order to replace the code directly in the buttons*/
    public static void validateFunctions(String input, String output, String operator) {

        if ((!"".equals(CalcGui.input) && CalcGui.output.substring(0, CalcGui.output.length() - 1).endsWith("n"))) {
            CalcGui.output = (CalcGui.output.substring(0, CalcGui.output.length() - 4) + operator);
        } else {
            if ((!"".equals(CalcGui.output) && CalcGui.output.substring(0, CalcGui.output.length()).endsWith("n"))) {
                CalcGui.output = (CalcGui.input.substring(0, CalcGui.input.length()) + operator);
                numberOne = Float.parseFloat(CalcGui.input);
                CalcGui.input = "0";
            } else {
                if ((!"".equals(CalcGui.output) && CalcGui.output.substring(0, CalcGui.output.length()).endsWith("s"))) {
                    CalcGui.output = (CalcGui.input.substring(0, CalcGui.input.length()) + operator);
                    numberOne = Float.parseFloat(CalcGui.input);
                    CalcGui.input = "0";
                } else {
                    if ((!"".equals(CalcGui.output) && CalcGui.output.endsWith("!"))) {
                        CalcGui.output = CalcGui.input + operator;
                        numberOne = Float.parseFloat(CalcGui.input);
                        CalcGui.input = "0";
                    } else {
                        if (!"".equals(CalcGui.output)) {
                            CalcGui.output = (CalcGui.output.substring(0, CalcGui.output.length() - 1) + operator);
                        }
                    }
                }
            }
        }
    }
}
