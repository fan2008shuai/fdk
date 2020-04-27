package org.fan.fdk.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fan.shuai on 2020/4/27.
 */
public class MergeLinkedlist {
    /**
     * 两个输入器会产生问题，所以需要设置为一个输入器
     */
    public Scanner sc;
    public int K;
    public int N;
    public List<List<Integer>> lists;

    public MergeLinkedlist() {
        sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        init();
    }

    private void init() {
        lists = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(sc.nextInt());
            }
            lists.add(list);
        }
    }
    public void mergeAll(){
        List<Integer> list = lists.get(0);
        for (int i =1;i<K;i++){       // k
            list = mergeTwo(lists.get(i),list);  // n
        }
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+"-->");
        }
        System.out.println("Null");
    }

    public List<Integer> mergeTwo(List<Integer> list1,List<Integer> list2){  // n
        List<Integer> list = new ArrayList<>();
        int i =0;
        int j=0;
        while (i<list1.size()&&j<list2.size()){
            if (list1.get(i)<=list2.get(j)){
                list.add(list1.get(i));
                i++;
            }else {
                list.add(list2.get(j));
                j++;
            }
        }
        while (i<list1.size()){
            list.add(list1.get(i));
            i++;
        }
        while (j<list2.size()){
            list.add(list2.get(j));
            j++;
        }
        return list;
    }


    //遍历方式一：
    public void print() {
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(lists.get(i).get(j) + "-->");
            }
            System.out.println("Null");
        }
    }
    //多态
    public void print(List<List<Integer>> lists) {
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(lists.get(i).get(j) + "-->");
            }
            System.out.println("Null");
        }
    }
    //遍历方式二：
    public void print1() {
        Iterator<List<Integer>> it = lists.iterator();
        int i =0;
        while (it.hasNext()) {
            Iterator<Integer> itt = it.next().iterator();
            while (itt.hasNext()) {
                i = itt.next();
                System.out.print(i+ "-->");
            }
            System.out.println("Null");
        }
    }
    //遍历方式三：
    public void print2() {
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + "-->");
            }
            System.out.println("Null");
        }
    }
    public static void main(String[] args) {

        MergeLinkedlist merge = new MergeLinkedlist();
        merge.mergeAll();

    }
}
