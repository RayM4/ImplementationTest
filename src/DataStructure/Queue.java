package DataStructure;

public class Queue extends LinkList{
    private Node start;

    public Queue() {
        this.head = null;
        this.start = null;
    }

    public Queue(Node n) {
        this.head = n;
        this.start = this.head;
    }

    @Override
    public void add(int data) {
        super.add(data);

        if (start==null)
            start = head;
    }

    @Override
    public void add(Node n) {
        super.add(n);

        if (start==null)
            start = head;
    }

    @Override
    public Node remove() {
        Node poppedElement = start;
        start = start.getNext();
        if (start == null)
            head = null;
        return poppedElement;
    }

    public Node pop() {
        return this.remove();
    }

    public void push(int data) {
        this.add(data);
    }

    public void push(Node n) {
        this.add(n);
    }

}
