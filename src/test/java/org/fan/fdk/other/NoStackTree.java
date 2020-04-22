package org.fan.fdk.other;

/**
 * @create 2020-04-2020/4/21
 * @Time 16:15
 * @describe
 */
public class NoStackTree {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
//        ListNode node5 = new ListNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
//        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node2.father = node1;
        node3.father = node1;
        node4.father = node2;
//        node5.father = node2;
        node6.father = node3;
        node7.father = node3;
        //前序遍历应该输出1，2，4，5，3，6，7;
        //去掉五节点和四节点也正确

        traverse(node1);
    }

    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode last = null;
        TreeNode now = root;
        while (now != null) {
            if (last == now.left) {
                if (now.right != null) {
                    now = now.right;
                } else {
                    last = now;
                    now = now.father;
                    continue;
                }
            } else if (last == now.right) {
                last = now;
                now = now.father;
                continue;
            }

            System.out.println(now.val);

            if (now.left == null) {
                if (now.right != null) {
                    last = now;
                    now = now.right;
                } else {
                    last = now;
                    now = now.father;
                }
            } else {
                last = now;
                now = now.left;
            }

//            if (now.right==null){
//                last = now;
//                now = now.father;
//            }else {
//                last = now;
//                now = now.right;
//            }

        }
    }

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode father;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}


