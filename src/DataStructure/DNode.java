package DataStructure;

/**
 * Implementation of Node with next and prev
 */
public class DNode {
    private int data;
    private DNode next;
    private DNode prev;

    public DNode(int n) {
        this.data = n;
        this.next = null;
        this.prev = null;
    }

    public int getData() { return data; }
    public DNode getNext() { return next; }
    public DNode getPrev() { return prev; }

    public void setData(int n) { this.data = n;}
    public void setNext(DNode n) { this.next = n;}
    public void setPrev(DNode n) { this.prev = n;}
}
