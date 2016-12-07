import DataStructure.BinaryTree;
import DataStructure.CircularLinkList;
import DataStructure.LinkList;
import MyAlgorithm.Search;
import MyAlgorithm.Sort;


public class Main {

    final static int DATA_SET[] = {
        50, 25, 75, 15, 35, 65, 100, 5, 22, 49, 33
    };

    public static void main(String[] args) {
//        test_Strings();
//        test_DataStructures();
        test_Algorithms();
    }

    //Helpers
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

    private static void printArray(int[] arr) {
        System.out.println("Array:");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.print("\n");
    }

    //TEST (Not going to write test cases)
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
    }

    public static void test_Strings() {
        System.out.println("Palindrome");
        System.out.println(Practice.StringExtender.isPalindrome("Eevee"));
        System.out.println(Practice.StringExtender.isPalindrome("Earth"));
        System.out.println(Practice.StringExtender.isPalindrome("aaaaaaaPaaaaaaa"));

        System.out.println("-----------");
        System.out.println("Anagrams");
        System.out.println(Practice.StringExtender.isAnagramNoSort("Dictionary", "Indicatory"));
        System.out.println(Practice.StringExtender.isAnagramNoSort("Apollo", "Artemis"));
        System.out.println(Practice.StringExtender.isAnagramNoSort("Listen", "Silent"));
        System.out.println(Practice.StringExtender.isAnagramNoSort("Witch", "Wizard"));

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
        BinaryTree tree = new BinaryTree(50);
        addToTree(tree);
        tree.printTree();

        System.out.println("\nSearch - DFS");
        int dfsSuccess1 = Search.DFS(tree, 35).getData();
        int dfsSuccess2 = Search.DFS(tree, 49).getData();
        int dfsSuccess3 = Search.DFS(tree, 100).getData();
        System.out.println(dfsSuccess1);
        System.out.println(dfsSuccess2);
        System.out.println(dfsSuccess3);

        try {
            int dfsFail1 = Search.DFS(tree, 99).getData();
            System.out.println(dfsFail1);
        } catch (NullPointerException e) {
            System.out.println("DFS returned null");
        }

        System.out.println("\nSearch - BFS");
        int bfsSuccess1 = Search.BFS(tree, 35).getData();
        int bfsSuccess2 = Search.BFS(tree, 49).getData();
        int bfsSuccess3 = Search.BFS(tree, 100).getData();
        System.out.println(bfsSuccess1);
        System.out.println(bfsSuccess2);
        System.out.println(bfsSuccess3);

        try {
            int bfsFail1 = Search.BFS(tree, 99).getData();
            System.out.println(bfsFail1);
        } catch (NullPointerException e) {
            System.out.println("BFS returned null");
        }
    }


}
