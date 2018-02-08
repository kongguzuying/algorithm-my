package com.lmtech.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 求最大值减去最小值小于num的子数组
 */
public class MaxMinSubArray {

    @Test
    public void test() {
        MaxMinSubArray obj = new MaxMinSubArray();
        int[] arr = new int[] { 2,3,4,1,2,3,4,123,1,2,3,4,12 };
        int res = obj.getNum(arr, 4);
        System.out.println(res);

        List<Integer> is = new ArrayList<>();
        is.add(1);
        is.add(12);
        is.add(13);
        is.add(14);

        Integer i = new Integer(1);
        System.out.println(is.contains(i));
    }

    public int getNum(int[] arr, int num) {
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        int i = 0, j = 0, res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);

                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);

                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }

}
