package DataStructure;

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

    public LinkList copyOfListReversed() {
        LinkList list = new LinkList();
        list.add(head.getData());
        return deepCopy(head, list);
    }

    public LinkList copyOfList() {
        return this.copyOfListReversed().copyOfListReversed();
    }

    private LinkList deepCopy(Node originalNode, LinkList list) {
        if (originalNode.getNext() == null) {
            return list;
        }
        Node n = new Node(originalNode.getNext().getData());
        list.add(n);
        return deepCopy(originalNode.getNext(), list);
    }

    public void printList() {
        Node curr = head;
        while(curr.getNext() != null) {
            System.out.println(curr.getData());
            curr = curr.getNext();
        }
        System.out.println(curr.getData());
    }

}