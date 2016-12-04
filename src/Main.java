import DataStructure.BinaryTree;

import java.util.ArrayList;

public class Main {

    final static int DATA_SET[] = {
        50, 25, 75, 15, 35, 65, 100, 5, 22, 49, 33
    };

    public static void main(String[] args) {

        System.out.println("Hello World!");

//        System.out.println(Practice.StringExtender.isPalindrome("Eevee"));
//        System.out.println(Practice.StringExtender.isPalindrome("Earth"));
//        System.out.println(Practice.StringExtender.isPalindrome("aaaaaaaPaaaaaaa"));
//        String a = "abc";
//        String a2 = "bbbb";
//        String b = "baikl;ksdlaksla";
//        String c = "Attt";
//        System.out.println(a.compareTo(a2));
//        System.out.println(a.compareToIgnoreCase(c));
//        System.out.println(c.compareToIgnoreCase(b));
//        System.out.println(c.compareToIgnoreCase(a));
//        int num = 10000000;
//        System.out.println(num);

        BinaryTree tree = new BinaryTree(50);
        addToTree(tree);
        tree.printTree();
    }

    private static void addToTree(BinaryTree tree) {
        for (int i : DATA_SET) {
            tree.add(i);
        }
    }

}
