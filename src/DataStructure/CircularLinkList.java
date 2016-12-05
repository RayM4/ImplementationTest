package DataStructure;

public class CircularLinkList extends LinkList {

    public CircularLinkList() {
        super();
    }

    public CircularLinkList(Node n) {
        super(n);
    }

    @Override
    public void add(int data) {
        Node node = new Node(data);
        Node currentHead = this.head;
        node.setNext(currentHead);

        //link back
        if (this.head != null) {
            Node back = getBack();
            back.setNext(node);
        } else {
            node.setNext(node);
        }

        this.head = node;
    }

    @Override
    public Node remove() {
        Node poppedElement = head;
        Node back = getBack();
        back.setNext(poppedElement.getNext());
        this.head = poppedElement.getNext();
        return poppedElement;
    }

    @Override
    public void printList() {
        Node curr = head;
        while(curr.getNext() != head) {
            System.out.println(curr.getData());
            curr = curr.getNext();
        }
        System.out.println(curr.getData());
    }

    public Node getBack() {
        Node curr = this.head;

        while(curr.getNext() != null && curr.getNext() != this.head) {
            curr = curr.getNext();
        }
        return curr;
    }

}
