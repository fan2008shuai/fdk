package org.fan.fdk.other;

/**
 * Created by fan.shuai on 2020/4/20.
 */
public class Test {

    private static int findMin(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] > array[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private static int findK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == k) {
                return mid;
            }
            if (array[mid] > array[end]) {
                if (array[start] <= k && k < array[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (array[mid] < k && k <= array[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] array = {0};
//        int[] array = {1, 0};
//        int[] array = {3, 0, 1};
        int[] array = {3, 0, 1, 2};
//        int[] array = {2, 3, 0, 1};
        System.out.println(findMin(array));
        System.out.println(findK(array, 1));
    }
}
