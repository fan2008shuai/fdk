package org.fan.fdk.other;

/**
 * @create 2020-04-2020/4/21
 * @Time 16:15
 * @describe
 */
public class NoStackTree {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

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
        NoStackTree tree = new NoStackTree();
        tree.LinkedList(node1);
    }

    public void LinkedList(ListNode root) {
        if (root == null) {
            return;
        }
        ListNode last = null;
        ListNode now = root;
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
            System.out.println(now);

            if (now.left==null){
                if (now.right!=null){
                    last = now;
                    now = now.right;
                }else {
                    last = now;
                    now = now.father;
                }
            }else {
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

}

class ListNode {
    public int no;
    public ListNode left;
    public ListNode right;
    public ListNode father;

    public ListNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "no=" + no +
                '}';
    }
}
