package Practice;

import DataStructure.LinkList;
import DataStructure.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ray on 12/10/2016.
 */
public class NumberPuzzles {
    public int[] twoSum(int[] nums, int target) {
        // finds indicies of array where values add up to target
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value) && map.get(value) != i)
                return new int[] {i, map.get(value)};
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
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
