package Practice;

/**
 * Linklist puzzles
 */
public class ListPuzzles {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
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
}
