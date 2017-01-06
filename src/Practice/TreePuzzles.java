package Practice;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Pre-order, In-order, and Post-order tree traversals
 */
public class TreePuzzles {

    //Recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();

        if (root == null)
            return order;

        recursivePreorder(root, order);

        return order;
    }

    private static void recursivePreorder(TreeNode node, List<Integer> order) {
        order.add(node.getData());
        if (node.getLeft() != null)
            recursivePreorder(node.getLeft(), order);
        if(node.getRight() != null)
            recursivePreorder(node.getRight(), order);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();

        if (root == null)
            return order;

        recursiveInorder(root, order);

        return order;
    }

    private static void recursiveInorder(TreeNode node, List<Integer> order) {
        if(node.getLeft() != null)
            recursiveInorder(node.getLeft(), order);
        order.add(node.getData());
        if(node.getRight() != null)
            recursiveInorder(node.getRight(), order);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        if (root == null)
            return order;

        recursivePostorder(root, order);

        return order;
    }

    private static void recursivePostorder(TreeNode node, List<Integer> order) {
        if (node.getLeft() != null)
            recursivePostorder(node.getLeft(), order);
        if (node.getRight() != null)
            recursivePostorder(node.getRight(), order);
        order.add(node.getData());
    }


    //Iterative
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> order = new ArrayList<>();

        if (root == null)
            return order;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode node;
        while(!stack.isEmpty()) {
            node = stack.pop();
            order.add(node.getData());

            if (node.getRight() != null)
                stack.addFirst(node.getRight());

            if (node.getLeft() != null)
                stack.addFirst(node.getLeft());

        }
        return order;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> order = new ArrayList<>();

        if (root == null)
            return order;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while(!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                TreeNode temp = stack.pop();
                order.add(temp.getData());
                node = temp.getRight();
            }
        }
        return order;
    }


}
