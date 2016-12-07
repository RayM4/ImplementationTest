package MyAlgorithm;

import DataStructure.BinaryTree;
import DataStructure.TreeNode;

import java.util.*;

public class Search {

    public static TreeNode DFS(BinaryTree tree, int data) {
//        Stack<TreeNode> stack = new Stack<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        stack.addFirst(tree.getHead());

        while(!stack.isEmpty()) {
//            TreeNode currentNode = stack.pop();
            TreeNode currentNode = stack.removeFirst();
            visited.add(currentNode.getData());

            if (currentNode.getData() == data)
                return currentNode;

            if (currentNode.getLeft() != null && !visited.contains(currentNode.getLeft().getData()))
                stack.addFirst(currentNode.getLeft());

            if (currentNode.getRight() != null && !visited.contains(currentNode.getRight().getData()))
                stack.addFirst(currentNode.getRight());

            visited.remove(currentNode.getData());
        }

        return null;
    }

    public static TreeNode BFS(BinaryTree tree, int data) {
//        Queue<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offerFirst(tree.getHead());

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.pollFirst();
            visited.add(currentNode.getData());

            if (currentNode.getData() == data)
                return currentNode;

            if (currentNode.getLeft() != null && !visited.contains(currentNode.getLeft().getData()))
                queue.offerFirst(currentNode.getLeft());

            if (currentNode.getRight() != null && !visited.contains(currentNode.getRight().getData()))
                queue.offerFirst(currentNode.getRight());
        }

        return null;
    }
}
