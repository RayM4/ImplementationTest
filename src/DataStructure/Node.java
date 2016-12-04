package DataStructure;

/**
 * Created by ray on 12/4/2016.
 */
public class Node implements Comparable<Node>{
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public int compareTo(Node n) {
        if (n.getData() > data) {
            return -1;
        } else if (n.getData() < data) {
            return 1;
        }
        return 0;
    }

    public int getData() {return data;}
    public Node getNext() {return next;}

    public void setData(int data) {this.data = data;}
    public void setNext(Node n) {this.next = n;}
}
