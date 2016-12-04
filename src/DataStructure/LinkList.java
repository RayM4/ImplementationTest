package DataStructure;

/**
 * Created by ray on 12/3/2016.
 */
public class LinkList {
    protected Node head;

    public LinkList() {
        this.head = null;
    }

    public LinkList(Node n) {
        this.head = n;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int data) {
        Node node = new Node(data);
        node.setNext(head);
        head = node;
    }

    public void add(Node node) {
        node.setNext(head);
        head = node;
    }

    public Node remove() {
        Node poppedElement = head;
        head = head.getNext();
        return poppedElement;
    }

    public Node getHead() {return head;}

}