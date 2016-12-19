package DataStructure;

import java.util.HashSet;
import java.util.Set;


public class BinaryTree {
    private TreeNode head;
    private Set<Integer> values;

    public BinaryTree(int data) {
        this.head = new TreeNode(data);
        this.values = new HashSet<>();
        values.add(data);
    }

    public TreeNode getHead() {return head;}

    public boolean add(int data) {
        if (!(values.contains(data))) {
            TreeNode node = new TreeNode(data);
            boolean left;
            TreeNode curr;
            TreeNode prev = head;

            if (head.compareTo(node) > 0) {
                curr = head.left;
                left = true;
            } else {
                curr = head.right;
                left = false;
            }

            while (curr != null) {
                if (curr.compareTo(node) > 0) {
                    prev = curr;
                    curr = curr.left;
                    left = true;
                }
                else {
                    prev = curr;
                    curr = curr.right;
                    left = false;
                }
            }

            if (left)
                prev.left = node;
            else
                prev.right = node;
            values.add(data);
            return true;
        }
        return false;
    }

    public boolean addRecursive(int data) {
        if (!values.contains(data)) {
            TreeNode node = new TreeNode(data);
            addToTree(head, node);
            return true;
        }
        return false;
    }

    private void addToTree(TreeNode prev, TreeNode n) {
        if (n.getData() < prev.getData()) {
            if (prev.getLeft() == null)
                prev.left = n;
            else
                addToTree(prev.getLeft(), n);
        } else {
            if (prev.getRight() == null)
                prev.right = n;
            else
                addToTree(prev.getRight(), n);
        }
    }


    public Integer remove(int data) {
        if (values.contains(data)) {
            TreeNode node = new TreeNode(data);
            boolean left;
            TreeNode curr;
            TreeNode prev = head;

            if (head.compareTo(node) > 0) {
                curr = head.left;
                left = true;
            } else {
                curr = head.right;
                left = false;
            }

            //children
            TreeNode nextLeft = curr.left;
            TreeNode nextRight = curr.right;

            while (curr.data != data) {
                if (curr.compareTo(node) > 0) {
                    prev = curr;
                    curr = curr.left;
                    left = true;
                }
                else {
                    prev = curr;
                    curr = curr.right;
                    left = false;
                }
                nextLeft = curr.left;
                nextRight = curr.right;
            }

            if (left) {
                if (nextLeft != null) {
                    prev.left = nextLeft;
                    nextLeft.right = nextRight;
                } else if (nextRight != null) {
                    prev.left = nextRight;
                } else {
                    prev.left = null;
                }
            }
            else {
                if (nextLeft != null) {
                    prev.right = nextLeft;
                    nextLeft.right = nextRight;
                } else if (nextRight != null) {
                    prev.right = nextRight;
                } else {
                    prev.right = null;
                }
            }

            values.remove(data);
        }
        return null;
    }

    public void printTree() {
        printNode(head, 0);
    }

    private void printNode(TreeNode node, int iter) {
        System.out.println(node.data);
        if (node.left != null) {
            System.out.print(numTabs(iter)+"Left: ");
            printNode(node.left, iter+1);
        }
        if (node.right != null) {
            System.out.print(numTabs(iter)+"Right: ");
            printNode(node.right, iter+1);
        }
    }

    private String numTabs(int num) {
        String tab = "";
        for (int i = 0; i < num; i++)
            tab = tab + "\t";
        return tab;
    }


}
