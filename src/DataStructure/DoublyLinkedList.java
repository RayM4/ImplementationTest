package DataStructure;

/**
 * Implementation of a Doubly Linked List
 */
public class DoublyLinkedList {
    private DNode head;
    private DNode tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(int n) {
        DNode node = new DNode(n);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
    }

    public DNode removeHead() {
        DNode temp = head;
        head = head.getNext();
        if (head == null)
            tail = null;
        return temp;
    }

    public DNode removeTail() {
        DNode temp = tail;
        tail = tail.getPrev();
        if (tail == null)
            head = null;
        return temp;
    }

    public DNode remove(int n) {
        DNode curr = head;
        while (curr != null) {
            if (curr.getData() == n) {
                if (curr == head) {
                    head = head.getNext();
                    if (head == null)
                        tail = null;
                } else if (curr == tail) {
                    tail = tail.getPrev();
                    if (tail == null)
                        head = null;
                } else {
                    curr.getPrev().setNext(curr.getNext());
                }
                return curr;
            }
        }
        return null;
    }
}
