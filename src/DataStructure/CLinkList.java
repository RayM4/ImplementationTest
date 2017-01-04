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

    public Node getCurrent() { return this.current; }
    public Node getStart() { return this.start; }

    public void add(int data) {
        Node node = new Node(data);
        if (start == null) {
            start = node;
        } else {
            current.setNext(node);
        }
        node.setNext(start);
        current = node;
    }

    public void add(Node node) {
        if (start == null) {
            start = node;
        } else {
            current.setNext(node);
        }
        node.setNext(start);
        current = node;
    }

    public Node remove(int value) {
        Node curr = this.start;
        if (start == null)
            return null;

        do {
            Node temp = curr.getNext();
            if (temp.getData() == value) {
                if (temp == this.start) {
                    if (this.current == this.start) {
                        this.current = null;
                        this.start = null;
                    } else {
                        this.current.setNext(this.start.getNext());
                        this.start = this.start.getNext();
                    }
                } else {
                    curr.setNext(temp.getNext());
                }
                return temp;
            }
            curr = temp;
        } while(curr!=this.start);

        return null;
    }

    public void printList() {
        Node curr = this.start;
        if (curr != null) {
            do {
                System.out.println(curr.getData());
                curr = curr.getNext();
            }while(curr!=this.start);
        }
    }

    public int length() {
        if (this.start == null)
            return 0;

        int sum = 0;
        Node curr = this.start;
        do {
            sum++;
            curr = curr.getNext();
        }while(curr!=this.start);
        return sum;
    }

    public int size() {
        return length();
    }

}
