package DataStructure;

/**
 * Created by ray on 12/4/2016.
 */
public class TreeNode implements Comparable<TreeNode>{
    protected int data;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(TreeNode n) {
        if (n.data > data) {
            return -1;
        } else if (n.data < data) {
            return 1;
        }
        return 0;
    }

    public TreeNode getLeft() { return left;}
    public TreeNode getRight() { return right;}
    public int getData() {return data;}

}
