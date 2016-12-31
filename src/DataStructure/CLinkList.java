package DataStructure;

/*
This is a circularly linked list implementation without extending LinkList
*/

public class CLinkList {
    private Node current;
    private Node start;

    public CLinkList() {
        this.current = null;
        this.start = null;
    }

    public CLinkList(Node n) {
        this.start = n;
        this.current = n;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (start == null) {
            start = node;
        } else {
            current.setNext(node);
        }
        current = node;
    }

    public void add(Node node) {
        if (start == null) {
            start = node;
        } else {
            current.setNext(node);
        }
        current = node;
    }


}
