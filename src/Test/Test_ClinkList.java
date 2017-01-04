package Test;

import DataStructure.CLinkList;
import DataStructure.Node;

/**
 * Test cases for ClinkList
 * No framework at the moment
 */
public class Test_ClinkList {
    final static int DATA_SET[] = {
        50, 25, 75, 15, 35, 65, 100, 5, 22, 49, 33
    };

    public static void run() {
        test_add();
        test_remove();
    }

    private static void test_add() {
        CLinkList clist = new CLinkList();
        addToLinkList(clist);
        if (clist.length() == DATA_SET.length)
            System.out.println("SUCCESS - list length match");
        else
            System.out.println("ERROR - list length mismatch");

        Node curr = clist.getStart();
        for (int i : DATA_SET) {
            if (i != curr.getData()) {
                System.out.println("ERROR - list data mismatch");
                System.out.println("\t original data: " + i);
                System.out.println("\t list data: " + curr.getData());
                break;
            }
            curr = curr.getNext();
        }
        System.out.println("SUCCESS - list data match");
    }

    private static void test_remove() {
        CLinkList clist = new CLinkList();
        if (clist.remove(10) == null)
            System.out.println("SUCCESS - empty list remove pass");
        else
            System.out.println("ERROR - empty list remove fail");
        clist.add(10);
        clist.add(5);
        clist.add(7);

        if (clist.remove(10).getData() == 10)
            System.out.println("SUCCESS - list remove with value pass");
        else
            System.out.println("ERROR - list remove with value fail");

        if (clist.remove(2) == null)
            System.out.println("SUCCESS - empty list remove without value pass");
        else
            System.out.println("ERROR - empty list remove without value fail");

        clist.remove(5);
        clist.remove(7);

        if (clist.length() == 0)
            System.out.println("SUCCESS - list removal pass");
        else
            System.out.println("ERROR - list removal fail");
    }

    private static void addToLinkList(CLinkList list) {
        for (int i : DATA_SET)
            list.add(i);
    }
}
