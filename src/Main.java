import DataStructure.BinaryTree;
import DataStructure.CircularLinkList;
import DataStructure.LinkList;
import MyAlgorithm.Sort;

public class Main {

    final static int DATA_SET[] = {
        50, 25, 75, 15, 35, 65, 100, 5, 22, 49, 33
    };

    public static void main(String[] args) {
        test_Algorithms();
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

    private static void printArray(int[] arr) {
        System.out.println("Array:");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.print("\n");
    }

    //TEST
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
        System.out.println("Hello World!");

        System.out.println(Practice.StringExtender.isPalindrome("Eevee"));
        System.out.println(Practice.StringExtender.isPalindrome("Earth"));
        System.out.println(Practice.StringExtender.isPalindrome("aaaaaaaPaaaaaaa"));
        String a = "abc";
        String a2 = "bbbb";
        String b = "baikl;ksdlaksla";
        String c = "Attt";
        System.out.println(a.compareTo(a2));
        System.out.println(a.compareToIgnoreCase(c));
        System.out.println(c.compareToIgnoreCase(b));
        System.out.println(c.compareToIgnoreCase(a));
        int num = 10000000;
        System.out.println(num);
    }

    private static void test_Algorithms() {
        int[] unsortedArray = { 10, 5, 11, 16, 7, 15, 49, 19 };

        System.out.println("BuubleSort");
        printArray(unsortedArray);

        Sort mySort = new Sort();
        int[] myBubbleSort = mySort.bubbleSort(unsortedArray);

        printArray(myBubbleSort);

        System.out.println("---------------------------");

        System.out.println("QuickSort");
        int[] unsortedArray2 = { 10, 5, 11, 16, 7, 15, 49, 19 };
        printArray(unsortedArray2);

        mySort.normalQSort(unsortedArray2, 0, unsortedArray2.length-1);
        printArray(unsortedArray2);

        System.out.println("---------------------------");

        System.out.println("QuickSort - Random Pivot");
        int[] unsortedArray3 = { 10, 5, 11, 16, 7, 15, 49, 19 };
        printArray(unsortedArray3);

        mySort.randQSort(unsortedArray3, 0, unsortedArray3.length-1);
        printArray(unsortedArray3);
    }

}
