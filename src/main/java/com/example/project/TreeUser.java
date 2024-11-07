package com.example.project;

public class TreeUser {
    public static <T> int countLeaves(BT<T> bt) {
    // Call the recursive helper method starting from the root of the tree
    return countLeavesHelper(bt);
}

private static <T> int countLeavesHelper(BT<T> node) {
    if (node == null) {
        return 0; // Base case: No nodes in a null subtree
    }

    // Check if the current node is a leaf
    if (node.isLeaf()) {
        return 1; // This node is a leaf, so count it as 1
    }

    // Recursively count leaves in both the left and right subtrees
    return countLeavesHelper(node.getLeft()) + countLeavesHelper(node.getRight());
}

}
