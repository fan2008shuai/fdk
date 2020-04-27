package org.fan.fdk.test;

public class BalanceTree {

    static class Tree {
        Tree left;
        Tree right;
        int val;
    }

    private boolean isBalance(Tree root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }

    private int treeDepth(Tree root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (Math.max(left, right)) + 1;
    }


}
