package com.amusia.leetcodedemo.demo2;

import com.amusia.leetcodedemo.PrintResult;

import java.awt.print.PrinterGraphics;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleArea {
    static int[] heights = {99, 2, 5, 6, 2, 3};

    public static void main(String[] args) {
        int result = largestRectangleArea2(heights);
        PrintResult.print(result);
    }

    /**
     * 暴力求解
     */
//    private static int largestRectangleArea(int[] heights) {
//        int max = 0;
//        for (int i = 0; i < heights.length; i++) {
//            // 找左边最后 1 个大于等于 heights[i] 的下标
//            int left = i;
//            int curHeight = heights[i];
//            while (left > 0 && heights[left - 1] >= curHeight) {
//                left--;
//            }
//
//            // 找右边最后 1 个大于等于 heights[i] 的索引
//            int right = i;
//            while (right < heights.length - 1 && heights[right + 1] >= curHeight) {
//                right++;
//            }
//
//            int width = right - left + 1;
//            max = Math.max(max, width * curHeight);
//
//        }
//        return max;
//    }


    /**
     * 暴力求解法
     *
     * @param heights
     * @return
     */
    private static int largestRectangleArea(int[] heights) {
        int max = 0;
        int curHeight;
        int left;
        int right;
        int area;
        for (int i = 0; i < heights.length; i++) {
            curHeight = heights[i];

            left = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }

            right = i;
            while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }

            area = (right - left + 1) * curHeight;

            max = Math.max(max, area);
        }
        return max;
    }


    /**
     * 使用栈，没明白逻辑，待复习
     * @param heights
     * @return
     */
    private static int largestRectangleArea2(int[] heights) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>(heights.length);
        for (int i = 0; i < heights.length; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                max = Math.max(max, curHeight * curWidth);
            }

            while (!stack.isEmpty()) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = heights.length;
                } else {
                    curWidth = heights.length - stack.peekLast() - 1;
                }
                max = Math.max(max, curHeight * curWidth);
            }

            stack.addLast(i);
        }




        return max;
    }
}
