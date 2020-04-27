package org.fan.fdk.test;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void findMaxSum(int[] arr) {
        List<Integer> list = new LinkedList<>();
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("illegal args");
        }

        int max = Integer.MIN_VALUE;
        int curMax = 0;
        int index = 0;
        for (int i : arr) {
            if (curMax <= 0) {
                curMax = i;
                list.clear();
            } else {
                curMax += i;
            }
            list.add(index);

            if (max < curMax) {
                max = curMax;
            }
            index++;
        }

        for (Integer data : list) {
            System.out.println(data);
        }
    }
}
