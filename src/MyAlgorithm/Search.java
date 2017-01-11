package MyAlgorithm;

import DataStructure.BinaryTree;
import DataStructure.TreeNode;

import java.util.*;

public class Search {

    public static TreeNode DFS(BinaryTree tree, int data) {
//        Stack<TreeNode> stack = new Stack<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(tree.getHead());

        while(!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            visited.add(currentNode.getData());

            if (currentNode.getData() == data)
                return currentNode;

            if (currentNode.getLeft() != null && !visited.contains(currentNode.getLeft().getData()))
                stack.push(currentNode.getLeft());

            if (currentNode.getRight() != null && !visited.contains(currentNode.getRight().getData()))
                stack.push(currentNode.getRight());

            visited.remove(currentNode.getData());
        }

        return null;
    }

    public static TreeNode BFS(BinaryTree tree, int data) {
//        Queue<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(tree.getHead());

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            visited.add(currentNode.getData());

            if (currentNode.getData() == data)
                return currentNode;

            if (currentNode.getLeft() != null && !visited.contains(currentNode.getLeft().getData()))
                queue.offer(currentNode.getLeft());

            if (currentNode.getRight() != null && !visited.contains(currentNode.getRight().getData()))
                queue.offer(currentNode.getRight());
        }

        return null;
    }
}
