import java.util.*;

public class SimpleParser {
    static String input;
    static int pos = 0;
    static char token;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        input = sc.nextLine().replaceAll(" ", "") + "$";
        token = input.charAt(pos);

        if (E() && token == '$') {
            System.out.println("Success: Input is valid.");
        } else {
            System.out.println("Error: Invalid expression.");
        }
    }

    static void nextToken() {
        pos++;
        if (pos < input.length()) {
            token = input.charAt(pos);
        }
    }

    static boolean E() {
        return T() && EPrime();
    }

    static boolean EPrime() {
        if (token == '+') {
            nextToken();
            return T() && EPrime();
        }
        return true;
    }

    static boolean T() {
        return F() && TPrime();
    }

    static boolean TPrime() {
        if (token == '*') {
            nextToken();
            return F() && TPrime();
        }
        return true;
    }

    static boolean F() {
        if (token == '(') {
            nextToken();
            if (E() && token == ')') {
                nextToken();
                return true;
            }
            return false;
        } else if (Character.isLetter(token)) {
            nextToken();
            return true;
        }
        return false;
    }
}