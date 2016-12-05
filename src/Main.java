import DataStructure.BinaryTree;
import DataStructure.CircularLinkList;
import DataStructure.LinkList;

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

        System.out.println("------");

        BinaryTree tree = new BinaryTree(50);
        addToTree(tree);
        tree.printTree();

        System.out.println("------");
        LinkList list = new LinkList();
        addToLinkList(list);
        list.printList();

        System.out.println("------");
        LinkList copy = list.copyOfList();
        copy.printList();

        System.out.println("------");
        CircularLinkList circle = new CircularLinkList();
        addToLinkList(circle);
        circle.printList();
    }

    private static void addToTree(BinaryTree tree) {
        for (int i : DATA_SET)
            tree.add(i);
    }

    private static void addToLinkList(LinkList list) {
        for (int i : DATA_SET)
            list.add(i);
    }

    private static void addToLinkList(CircularLinkList list) {
        for (int i : DATA_SET)
            list.add(i);
    }

}
