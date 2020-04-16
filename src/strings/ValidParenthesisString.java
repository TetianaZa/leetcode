package strings;
//Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
//
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
//An empty string is also valid.

import java.util.Iterator;
import java.util.LinkedList;

public class ValidParenthesisString {

    public static boolean checkValidString(String s) {
        boolean isValid = true;
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (stack.size() == 0) return false;
                Iterator<Character> it = stack.descendingIterator();
                boolean hasStar = false;
                while (it.hasNext()) {
                    Character charac = it.next();
                    if (charac == '(') {
                        it.remove();
                        hasStar = false;
                        break;
                    } else if (charac == '*') {
                        hasStar = true;
                    }
                }
                if (hasStar) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(ch);
            }
        }

        Iterator<Character> it = stack.descendingIterator();
        int amountOfStar = 0;
        while (it.hasNext()) {
            Character charac = it.next();
            if (charac == '(' && amountOfStar > 0) {
                it.remove();
                amountOfStar--;
            } else if (charac == '*') {
                amountOfStar++;
            } else if (charac == '(' && amountOfStar == 0) {
                return false;
            }
        }


        return isValid;
    }

    //)((**)))))(()())()
    public static void main(String[] args) {
        //  String strToCheck = "()";
        String strToCheck = "***)(()())())))((**)))))(()())()";

        System.out.println(checkValidString(strToCheck));
    }
}
