package org.fan.fdk.test;

public class FindKMax {

    private int findKMax(int[] array, int k) {
        if (array == null) {
            return -1;
        }
        if (array.length == 1) {
            if (k == 1) {
                return array[0];
            } else {
                return -1;
            }
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int partition = partition(array, start, end);
            if (partition + 1 == k) {
                return array[k];
            } else if (partition + 1 > k) {
                end = partition - 1;
            } else {
                start = partition + 1;
                k = k - (partition + 1);
            }
        }
        return -1;
    }

    private int partition(int[] array, int start, int end) {
        int p = start;
        for (int i = start + 1; i <= end; i++) {
            if (array[start] < array[i]) {
                swap(array, p + 1, i);
                p++;
            }
        }
        swap(array, start, p+1);
        return p+1;
    }

    private void swap(int[] array, int p, int q) {
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }

}
