package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ray on 12/3/2016.
 */
public class StringExtender {

    public static boolean isPalindrome(String str) {
        //Same spelling front and back e.g. Eevee
        char[] word = str.toCharArray();
        int front = 0;
        int back = str.length() - 1;

        while (front < back) {
            if (word[front] != word[back]) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        char[] a1 = a.toLowerCase().toCharArray();
        char[] b1 = b.toLowerCase().toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);

        return Arrays.equals(a1, b1);
    }

    public static boolean syntaxChecker(String pattern) {
        char[] strArray = pattern.toCharArray();
        ArrayList<Character> open = new ArrayList<Character>(){{
            add('(');
            add('[');
            add('{');
        }};
        ArrayList<Character> close = new ArrayList<Character>(){{
            add(')');
            add(']');
            add('}');
        }};
        Stack<Character> stack = new Stack<>();

        for (char c : strArray) {
            if (open.contains(c)) {
                stack.push(c);
            } else if (close.contains(c)) {
                if (!stack.empty()) {
                    char value = stack.pop();
                    if (open.indexOf(value) != close.indexOf(c)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

}
