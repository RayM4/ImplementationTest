import DataStructure.*;
import MyAlgorithm.Search;
import MyAlgorithm.Sort;
import Test.Test_ClinkList;

import java.util.Arrays;


public class Main {

    final static int DATA_SET[] = {
        50, 25, 75, 15, 35, 65, 100, 5, 22, 49, 33
    };

    //Enable tests
    public static void main(String[] args) {
//        test_Strings();
        test_DataStructures();
//        test_Algorithms();
    }

    public static boolean test(int x) {
        return (x < 0);
    }

    //Helpers
    private static void addToTree(BinaryTree tree) {
        for (int i : DATA_SET)
            tree.addRecursive(i);
    }

    private static void addToLinkList(LinkList list) {
        for (int i : DATA_SET)
            list.add(i);
    }

    private static void addToLinkList(CircularLinkList list) {
        for (int i : DATA_SET)
            list.add(i);
    }

    private static void addToLinkList(CLinkList list) {
        for (int i : DATA_SET)
            list.add(i);
    }

    private static void addToLinkList(DoublyLinkedList list) {
        for (int i : DATA_SET)
            list.add(i);
    }

    private static void printArray(int[] arr) {
        System.out.println("Array:");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.print("\n");
    }


    //TEST (testing framework eventually)
    private static void test_DataStructures() {
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

        System.out.println("------ CLinkList");
        CLinkList clist = new CLinkList();
        addToLinkList(clist);
        clist.printList();
        clist.remove(100);
        clist.remove(22);
        clist.remove(50);
        clist.remove(25);
        System.out.println("------ removing");
        System.out.println("size: "+clist.length());
        clist.printList();
        System.out.println("-- test cases:");
        Test_ClinkList.run();

        System.out.println("------------- DLink List");
        DoublyLinkedList dlist = new DoublyLinkedList();
        addToLinkList(dlist);
        dlist.printList();
        System.out.println("reversing dlist");
        dlist.reverse();
        dlist.printList();
    }

    public static void test_Strings() {
        System.out.println("Palindrome");
        System.out.println(Practice.StringExtender.isPalindrome("bab"));
        System.out.println(Practice.StringExtender.isPalindrome("Earth"));
        System.out.println(Practice.StringExtender.isPalindrome("aaaaaaaPaaaaaaa"));

        System.out.println("-----------");
        System.out.println("Anagrams");
        System.out.println(Practice.StringExtender.isAnagramNoSort("Dictionary", "Indicatory"));
        System.out.println(Practice.StringExtender.isAnagramNoSort("Apollo", "Artemis"));
        System.out.println(Practice.StringExtender.isAnagramNoSort("Listen", "Silent"));
        System.out.println(Practice.StringExtender.isAnagramNoSort("Witch", "Wizard"));

        System.out.println("-----------");
        System.out.println(Practice.StringExtender.lengthOfLongestSubstring("abcabcbb"));
//        String a = "abc";
//        String a2 = "bbbb";
//        String b = "baikl;ksdlaksla";
//        String c = "Attt";
//        System.out.println(a.compareTo(a2));
//        System.out.println(a.compareToIgnoreCase(c));
//        System.out.println(c.compareToIgnoreCase(b));
//        System.out.println(c.compareToIgnoreCase(a));
    }

    private static void test_Algorithms() {
        int[] unsortedArray = { 10, 5, 11, 16, 7, 15, 49, 19 };

        System.out.println("BuubleSort");
        printArray(unsortedArray);

        int[] myBubbleSort = Sort.bubbleSort(unsortedArray);

        printArray(myBubbleSort);

        System.out.println("---------------------------");

        System.out.println("QuickSort");
        int[] unsortedArray2 = { 10, 5, 11, 16, 7, 15, 49, 19 };
        printArray(unsortedArray2);

        Sort.normalQSort(unsortedArray2, 0, unsortedArray2.length-1);
        printArray(unsortedArray2);

        System.out.println("---------------------------");

        System.out.println("QuickSort - Random Pivot");
        int[] unsortedArray3 = { 10, 5, 11, 16, 7, 15, 49, 19 };
        printArray(unsortedArray3);

        Sort.randQSort(unsortedArray3, 0, unsortedArray3.length-1);
        printArray(unsortedArray3);

        System.out.println("---------------------------");
        System.out.println("MergeSort");
        int[] unsortedArray4 = { 10, 5, 11, 16, 7, 15, 49, 19 };
        printArray(unsortedArray4);

        Sort.mergeSort(unsortedArray4, 0, unsortedArray4.length-1);
        printArray(unsortedArray4);

        System.out.println("---------------------------");
        BinaryTree tree = new BinaryTree(50);
        addToTree(tree);
        tree.printTree();

        System.out.println("\nSearch - DFS");
        TreeNode dfsSuccess1 = Search.DFS(tree, 35);
        TreeNode dfsSuccess2 = Search.DFS(tree, 49);
        TreeNode dfsSuccess3 = Search.DFS(tree, 100);

        try {
            System.out.println(dfsSuccess1.getData());
            System.out.println(dfsSuccess2.getData());
            System.out.println(dfsSuccess3.getData());
            TreeNode dfsFail1 = Search.DFS(tree, 99);
            System.out.println(dfsFail1.getData());
        } catch (NullPointerException e) {
            System.out.println("DFS returned null - " + e);
        }

        System.out.println("\nSearch - BFS");
        TreeNode bfsSuccess1 = Search.BFS(tree, 35);
        TreeNode bfsSuccess2 = Search.BFS(tree, 49);
        TreeNode bfsSuccess3 = Search.BFS(tree, 100);

        try {
            System.out.println(bfsSuccess1.getData());
            System.out.println(bfsSuccess2.getData());
            System.out.println(bfsSuccess3.getData());
            TreeNode bfsFail1 = Search.BFS(tree, 99);
            System.out.println(bfsFail1.getData());
        } catch (NullPointerException e) {
            System.out.println("BFS returned null - " + e);
        }

    }

    private static void test_puzzles() {

    }
}
