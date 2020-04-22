package org.fan.fdk.test;

public class InorderTravel {

    static class Tree {
        Tree left;
        Tree right;
        int val;
    }

    Tree prev = null;

    private boolean isBinarySearchTree(Tree root) {
        if (root == null) {
            return true;
        }
        if (!isBinarySearchTree(root.left)) {
            return false;
        }
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return isBinarySearchTree(root.right);
    }
}
