package Practice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Binary Search Tree Puzzles
 */
public class BSTPuzzles {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //remove a node from a BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            if (root.right != null) {
                if (root.left != null) {
                    TreeNode min = rotateTree(root.right);
                    min.left = root.left;
                    //check if right is the same
                    min.right = (root.right.val != min.val) ? root.right : root.right.right;
                    return min;
                } else {
                    return root.right;
                }
            } else if (root.left != null) {
                return root.left;
            }
            return null;
        }

        if (root.left != null)
            removeNode(root.left, root, key);
        if (root.right != null)
            removeNode(root.right, root, key);
        return root;
    }

    private TreeNode removeNode(TreeNode node, TreeNode parent, int key) {
        if (node.val==key) {
            TreeNode min = node;
            if (node.left != null && node.right != null) {
                min = rotateTree(node.right);
                min.left = node.left;
                //check if right is the same
                min.right = (node.right.val != min.val) ? node.right : node.right.right;
            } else if (node.left == null && node.right != null) {
                min = node.right;
            } else {
                min = node.left;
            }

            if (node.val > parent.val)
                parent.right = min;
            else
                parent.left = min;
            return min;
        }

        if (node.left != null)
            removeNode(node.left, node, key);
        if (node.right != null)
            removeNode(node.right, node, key);
        return null;
    }

    public TreeNode rotateTree(TreeNode node) {
        /*
        Finds min node and returns subtree
        */
        TreeNode min = node;
        TreeNode minParent = null;
        TreeNode parent = null;
        TreeNode current = node;
        while(current != null) {
            if (current.val < min.val) {
                min = current;
                minParent = parent;
            }
            parent = current;
            current = current.left;
        }
        if (minParent != null)
            minParent.left = min.right;
        return min;
    }

    //sum all left leaves
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && (root.left.left == null && root.left.right==null))
            return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    //invert a BST
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;
        return root;
    }

    //max depth of a bst
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left > right) ? (left+1) : (right+1);
    }

    //compare 2 BST
    //using queues
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p == null && q != null) || (p != null && q == null))
            return false;

        Deque<TreeNode> queue1 = new ArrayDeque<TreeNode>();
        Deque<TreeNode> queue2 = new ArrayDeque<TreeNode>();

        queue1.add(p);
        queue2.add(q);

        while(!queue1.isEmpty() && !queue1.isEmpty()) {
            TreeNode p1 = queue1.removeFirst();
            TreeNode q1 = queue2.removeFirst();

            if (p1.val != q1.val)
                return false;

            if (p1.left != null && q1.left != null) {
                queue1.push(p1.left);
                queue2.push(q1.left);
            } else if ((p1.left==null && q1.left!=null) || (p1.left!=null && q1.left==null)) {
                return false;
            }

            if (p1.right != null && q1.right != null) {
                queue1.push(p1.right);
                queue2.push(q1.right);
            } else if ((p1.right==null && q1.right!=null) || (p1.right!=null && q1.right==null)) {
                return false;
            }
        }

        return (queue1.isEmpty() && queue1.isEmpty());
    }

    //recursive
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
