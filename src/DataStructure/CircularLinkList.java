package DataStructure;

/**
 * Created by ray on 12/4/2016.
 */
public class CircularLinkList extends LinkList {
    @Override
    public void add(int data) {
        Node node = new Node(data);
        Node currentHead = this.head;
        node.setNext(currentHead);

        //link back
        Node back = getBack();
        back.setNext(node);
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

    public Node getBack() {
        Node curr = this.head;
        while(curr.getNext() != null || curr.getNext() != this.head) {
            curr = curr.getNext();
        }
        return curr;
    }

}
