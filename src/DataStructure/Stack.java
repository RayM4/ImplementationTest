package DataStructure;


public class Stack extends LinkList{
    public Stack() {super();}

    public Stack(Node n) {super();}

    public Node peak() {
        return getHead();
    }

    public Node pop() {
        return this.remove();
    }

    public void push(Node n) {
        this.add(n);
    }

    public void push(int n) {
        this.add(n);
    }
}
