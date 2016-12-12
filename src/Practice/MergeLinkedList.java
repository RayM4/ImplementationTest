package Practice;

import DataStructure.ListNode;


public class MergeLinkedList {
    //recursive
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode curr;

        if (l1.val < l2.val) {
            curr = l1;
            curr.next = mergeTwoLists(l1.next, l2);
        } else {
            curr = l2;
            curr.next = mergeTwoLists(l1, l2.next);
        }
        return curr;
    }

    //faster but procedural
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        boolean done1 = (curr1 == null);
        boolean done2 = (curr2 == null);
        ListNode head;

        if (done1 && done2) {
            return curr1;
        }
        else if (!done1 && !done2) {
            if (curr1.val < curr2.val) {
                head = curr1;
                curr1 = curr1.next;
                done1 = (curr1 == null);
            }
            else {
                head = curr2;
                curr2 = curr2.next;
                done2 = (curr2==null);
            }
        } else if (done1) {
            head = curr2;
            curr2 = curr2.next;
            done2 = (curr2==null);
        } else {
            head = curr1;
            curr1 = curr1.next;
            done1 = (curr1 == null);
        }

        ListNode curr = head;
        while(!done1 || !done2) {
            if (!done1 && !done2) {
                if (curr1.val < curr2.val) {
                    curr.next = curr1;
                    curr1 = curr1.next;
                    done1 = (curr1 == null);
                } else {
                    curr.next = curr2;
                    curr2 = curr2.next;
                    done2 = (curr2 == null);
                }
            } else if (done1) {
                curr.next = curr2;
                curr2 = curr2.next;
                done2 = (curr2 == null);
            } else {
                curr.next = curr1;
                curr1 = curr1.next;
                done1 = (curr1 == null);
            }
            curr = curr.next;
        }
        return head;

    }
}
