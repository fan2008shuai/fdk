package org.fan.fdk.test;

public class Find {

        private int find(int[] array, int k) {
            if (array == null) {
                return -1;
            }
            int start = 0;
            int end = array.length - 1;
            while (start < end) {
                int mid = (array[start] + array[end]) / 2;
                if (array[mid] == k) {
                    return mid;
                } else if (array[mid] > array[start] && array[mid] > array[end]) {
                    if (array[mid] > k && array[start] < k ) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }

                } else {
                    if (array[mid] < k && array[end] > k) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return -1;
        }
}
