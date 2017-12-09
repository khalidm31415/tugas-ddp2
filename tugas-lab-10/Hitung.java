import java.util.ArrayList;
import java.lang.ArithmeticException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.Scanner;

public class Hitung {
    public static void main(String[] args) {
        /*
        String str = "((2 + (1.0 + 1 * 2) ^ 2 ^ 2))";
        hitung(str);
        hitung("2 + 2");
        hitung("( ( 1 + 2 ) * 3 ) ^ 4");
        hitung("2 ^ 1 ^ 2");
        hitung("1 / 0");
        */
        bacaInput();
    }

    // Mengevaluasi ekspresi "x op y" di mana op dapat berupa +, -, *, /, ^
    public static String singleEval(String expression) {
        String[] expressionArr = expression.split(" ");
        double x = Double.parseDouble(expressionArr[0]);
        double y = Double.parseDouble(expressionArr[2]);

        switch(expressionArr[1]) {
            case "+":
                return Double.toString(x + y);
            case "-":
                return Double.toString(x - y);
            case "*":
                return Double.toString(x * y);
            case "/":
                if (y == 0) throw new ArithmeticException("Division by zero");
                return Double.toString(x / y);
            case "^":
                return Double.toString(Math.pow(x, y));
            default:
                return "Unknown operator";
        }
    }
    
    // Mengevaluasi ekspresi "x op y op z op ..." di mana op dapat berupa +, -, *, /, ^
    public static String multiEval(String expression) {
        if (expression.contains("^")) {
            String[] expressionArr = expression.split(" ");
            ArrayList<String> expressionList = new ArrayList<String>();
            expressionList.addAll(Arrays.asList(expressionArr));

            int index = expressionList.lastIndexOf("^");
            String lastPower = expressionArr[index - 1] + " " + expressionArr[index] + " " + expressionArr[index + 1];
            String res = singleEval(lastPower);

            expressionList.remove(index + 1);
            expressionList.remove(index);
            expressionList.set(index - 1, res);

            expression = String.join(" ", expressionList);
            return multiEval(expression);
        }

        else if (expression.contains("*") || expression.contains("/")) {
            String[] expressionArr = expression.split(" ");
            ArrayList<String> expressionList = new ArrayList<String>();
            expressionList.addAll(Arrays.asList(expressionArr));

            int additionIndex = expressionList.indexOf("*");
            int substractionIndex = expressionList.indexOf("/");

            int index;
        
            if (additionIndex == -1) index = substractionIndex;
            else if (substractionIndex == -1) index = additionIndex;
            else if (additionIndex < substractionIndex) index = additionIndex;
            else index = substractionIndex;

            String firstAddSub = expressionArr[index - 1] + " " + expressionArr[index] + " " + expressionArr[index + 1];
            String res = singleEval(firstAddSub);

            expressionList.remove(index + 1);
            expressionList.remove(index);
            expressionList.set(index - 1, res);

            expression = String.join(" ", expressionList);
            return multiEval(expression);
        }

        else if (expression.contains("+") || Pattern.compile(" - ").matcher(expression).find()) {
            String[] expressionArr = expression.split(" ");
            ArrayList<String> expressionList = new ArrayList<String>();
            expressionList.addAll(Arrays.asList(expressionArr));

            int additionIndex = expressionList.indexOf("+");
            int substractionIndex = expressionList.indexOf("-");

            int index;
        
            if (additionIndex == -1) index = substractionIndex;
            else if (substractionIndex == -1) index = additionIndex;
            else if (additionIndex < substractionIndex) index = additionIndex;
            else index = substractionIndex;

            String firstAddSub = expressionArr[index - 1] + " " + expressionArr[index] + " " + expressionArr[index + 1];
            String res = singleEval(firstAddSub);

            expressionList.remove(index + 1);
            expressionList.remove(index);
            expressionList.set(index - 1, res);

            expression = String.join(" ", expressionList);
            return multiEval(expression);
       }

        else {
            return expression;
        }
    }
    
    //Mengevaluasi ekspresi matematika umum
    public static String eval(String expression) {
        Pattern kurungTerDalamPattern = Pattern.compile("\\([^\\(\\)]+\\)");
        Matcher kurungTerDalamMatcher = kurungTerDalamPattern.matcher(expression);

        if (kurungTerDalamMatcher.find()) {
            String kurungTerDalam = kurungTerDalamMatcher.group();
            String kurungTerDalamExpression = kurungTerDalam.replaceAll("[\\(\\)]", "");

            if (!Pattern.compile(" ").matcher(kurungTerDalamExpression.trim()).find()) {
                return eval(expression.replace(kurungTerDalam, kurungTerDalamExpression)).trim();
            }

            String res = multiEval(kurungTerDalamExpression);
            kurungTerDalam = expression.replace(kurungTerDalam, res);

            return eval(kurungTerDalam).trim();
        }
        else {
            return multiEval(expression).trim();
        }
    }

    public static void hitung(String expression) {
        try {
            System.out.println("= " + eval(expression));
        }
        catch (Exception e) {
            System.out.println("= ERROR");
        }
    }

    public static void bacaInput() {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        input.close();
        hitung(expression);
    }
}