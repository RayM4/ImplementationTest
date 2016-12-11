package Practice;

import DataStructure.LinkList;
import DataStructure.Node;

/**
 * Created by ray on 12/10/2016.
 */
public class NumberPuzzles {
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = {-1,-1};
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length;j++) {
                if (nums[i] + nums[j]==target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }

            }
        }
        return arr;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        int value1 = addLinkedList(l1, 1);
        int value2 = addLinkedList(l2, 1);
        int total = value1 + value2;
        return buildList(total);
    }

    //breaks on max limit of integer for java
    private int addLinkedList(Node n, int place) {
        if (n.getNext() == null)
            return n.getData() * place;
        return n.getData() * place + addLinkedList(n.getNext(), place*10);
    }

    private Node buildList(int value) {
        char[] arr = Integer.toString(value).toCharArray();
        Node curr = new Node(Character.getNumericValue(arr[0]));
        for (int i = 1; i < arr.length; i++) {
            Node current = new Node(Character.getNumericValue(arr[i]));
            current.setNext(curr);
            curr = current;
        }
        return curr;
    }
}
