package MyAlgorithm;

import DataStructure.BinaryTree;
import DataStructure.TreeNode;

import java.util.*;

public class Search {

    public static TreeNode DFS(BinaryTree tree, int data) {
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(tree.getHead());

        while(!stack.empty()) {
            TreeNode currentNode = stack.pop();
            visited.add(currentNode.getData());

            if (currentNode.getData() == data)
                return currentNode;

            if (currentNode.getLeft() != null && !visited.contains(currentNode.getLeft().getData()))
                stack.add(currentNode.getLeft());

            if (currentNode.getRight() != null && !visited.contains(currentNode.getRight().getData()))
                stack.add(currentNode.getRight());

            visited.remove(currentNode.getData());
        }

        return null;
    }

    public static TreeNode BFS(BinaryTree tree, int data) {
        Queue<TreeNode> queue = new LinkedList<>();
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
