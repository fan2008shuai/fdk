package org.fan.fdk.test;

public class Hehe {
    private static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("1" + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        print(10);
//        int n = 5;
//        for (int i = 1; i <= n; i++) {//控制行数
//            for (int k = 1; k <= n-i; k++) {//控制空格的个数
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= 2 * i - 1; j++) {//控制打印的图形
//                System.out.print("*");
//            }
//            System.out.println();//控制换行
//        }
    }
}
