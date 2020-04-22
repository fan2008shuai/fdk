package org.fan.fdk.test;

public class Traverse {
    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }

    private void traverse(Node root) {
        if (root == null) {
            return;
        }
        Node p = root;
        Node pre = null;
        while (p != null) {
            if (p.left != null) {
                if (pre != p.left) {
                    System.out.println(p.val);
                    p = p.left;
                }
            } else if (p.right != null) {
                if (pre != p.right) {
                    System.out.println(p.val);
                    p = p.right;
                }
            } else {
                pre = p;
                p = p.parent;
            }
        }
    }
}
