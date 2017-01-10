package Practice;

import java.util.*;

/**
 * Linklist puzzles
 */
public class ListPuzzles {

    //class definition
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //remove nth from last element in linked list
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode next = head;

        for (int i = 0; i < n; i++)
            next = next.next;

        if (next == null)
            return current.next;

        while (next.next != null) {
            current = current.next;
            next = next.next;
        }
        current.next = current.next.next;
        return head;
    }

    //is the int linked list a palindrome
    public static boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        ListNode current = head;
        while (current != null) {
            deque.push(current.val);
            current = current.next;
        }
        while (!deque.isEmpty()) {
            if (!deque.peekFirst().equals(deque.peekLast())) {
                return false;
            }
            deque.removeLast();
            if (!deque.isEmpty())
                deque.removeFirst();
        }
        return true;
    }

    //reverse linked list
    public static ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private static ListNode reverse(ListNode head, ListNode curr) {
        if (head==null)
            return curr;
        ListNode next = head.next;
        head.next = curr;
        return reverse(next, head);
    }

    //Remove all occurrence of an element from a linked list
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements(head.next, val);
        if (head.val==val)
            return head.next;
        return head;
    }

    //swap every pair
    // A->B->C->D => B->A->D->C
    // A->B->C => B->A->C
    public static ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        if (head.next==null)
            return head;
        ListNode top = head.next;
        ListNode jump = top.next;
        top.next = head;
        head.next = swapPairs(jump);
        return top;
    }

    //remove all duplicates from linked list
    // A,A,B,C => A,B,C
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<Integer>();
        if (head == null || head.next==null)
            return head;
        ListNode prev = head;
        ListNode current = head.next;

        set.add(prev.val);

        while (current != null) {
            if (!set.add(current.val))
                prev.next = current.next;
            else
                prev = current;
            current = current.next;
        }
        return head;
    }

    //Remove all values which have another duplicate in list
    //A,A,B,C => B,C
    public ListNode removeValuesIfDuplicate(ListNode head) {
        if (head==null || head.next==null)
            return head;

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        ListNode current = head;

        while (current != null) {
            if (map.containsKey(current.val))
                map.put(current.val, map.get(current.val)+1);
            else
                map.put(current.val, 1);
            current = current.next;
        }

        ListNode newList = new ListNode(0);
        current = newList;
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) {
                current.next = new ListNode(i);
                current = current.next;
            }
        }

        return newList.next;
    }
}
