package Practice;

import java.util.*;

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

    public static boolean isAnagramNoSort(String a, String b) {
        if (a.length() != b.length())
            return false;

        char[] a1 = a.toLowerCase().toCharArray();
        char[] b1 = b.toLowerCase().toCharArray();

        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for (int i = 0; i < a1.length; i++) {
            mapCharCount(mapA, a1[i]);
            mapCharCount(mapB, b1[i]);
        }

        return mapA.equals(mapB);
    }

    private static void mapCharCount(Map<Character, Integer> map, char c) {
        if (map.keySet().contains(c))
            map.put(c, map.get(c)+1);
        else
            map.put(c, 1);
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

    public static int lengthOfLongestSubstring(String s) {
        int longest = 1;
        if (s.length() > longest)
            longest=1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length-1; i++) {
            Set<Character> set = new HashSet<>();
            set.add(arr[i]);

            for (int j=i+1; j < arr.length; j++) {
                if (!set.add(arr[j]))
                    j = arr.length;
            }
            if (set.size() > longest)
                longest = set.size();
        }
        return longest;

    }

}
