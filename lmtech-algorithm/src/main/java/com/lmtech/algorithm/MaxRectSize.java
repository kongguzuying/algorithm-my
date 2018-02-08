package com.lmtech.algorithm;

import org.junit.Test;

import java.util.Map;
import java.util.Stack;

public class MaxRectSize {

    @Test
    public void test() {
        //int[][] map = new int[][] { {1,0,1,1}, {1,0,1,1}, {1,1,1,0}, {1,0,0,1} };
        int[][] map = new int[][] { {0,0,0,0}, {0,1,1,0}, {0,0,1,0}, {0,0,1,0} };
        int maxArea = maxRectSize(map);

        System.out.println(maxArea);
    }

    public int maxRectSize(int[][] map) {
        if (map == null || map.length == 0) {
            return 0;
        }

        this.maxRectAreaFromBottom(new int[] { 0,1,2,1,0 });

        int maxArea = 0;
        int maxArea2 = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRectAreaFromBottom(height), maxArea);
            maxArea2 = Math.max(maxRectAreaFromBottomByMinValue(height), maxArea2);
            System.out.println("temp maxArea:" + maxArea);
            System.out.println("temp maxArea2:" + maxArea2);
        }
        return maxArea;
    }

    private int maxRectAreaFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k -1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k -1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    private int maxRectAreaFromBottomByMinValue(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Integer minValue = null;
        for (int i = 0; i < height.length; i++) {
            if (minValue == null) {
                minValue = height[i];
            } else {
                if (minValue > height[i]) {
                    minValue = height[i];
                }
            }
        }
        maxArea = minValue * height.length;
        return maxArea;
    }
}
