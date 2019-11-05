package calculator;

import GUI.CalcGui;
import javax.swing.UIManager;

public class Calculator {

    public static void main(String[] args) {
//try catch to set the Look and feel type of buttons
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        CalcGui calc = new CalcGui(); // instance of the CalcGUI
        calc.show();
        calc.setLocationRelativeTo(null);

    }

}
