package org.fan.fdk.test;


import org.junit.Test;

public class QuickSort {
    private int partition(int[] array, int low, int high) {
        int p = low;
        for (int i = low + 1; i <= high; i++) {
            if (array[i] < array[low]) {
                swap(array, i, p+1);
                p++;
            }
        }
        swap(array, low, p);
        return p;
    }

    private void swap(int[] array, int p, int q) {
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int partition = partition(array, low, high);
        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, high);
    }

    private int getMid(int[] array) {
        int low = 0, high = array.length - 1;
        int mid = (low + high) / 2;
        while (true) {
            int partition = partition(array, low, high);
            if (partition == mid) {
                return mid;
            }
            if (partition > mid) {
                high = partition - 1;
            }
            if (partition < mid) {
                low = partition + 1;
            }
        }
    }

    @Test
    public void testMid() {
        int[] array = {0, 2, 1, 5, 3};
        if (array.length % 2 == 0) {
            int mid = getMid(array);
            System.out.println((array[mid] + array[mid + 1]) / 2);
        } else {
            System.out.println(array[getMid(array)]);
        }
    }

    @Test
    public void test() {
        int[] array = {5,1};
//        System.out.println(partition(array, 0, 2));
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\nok");
    }

}
