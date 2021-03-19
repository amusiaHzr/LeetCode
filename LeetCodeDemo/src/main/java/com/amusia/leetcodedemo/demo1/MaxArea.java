package com.amusia.leetcodedemo.demo1;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：height = [1,2,1]
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {
    static int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};

    public static void main(String[] args) {
//        int result = maxArea(height);
        int result = maxArea1(height);
        System.out.println("result = " + result);
    }

//    //遍历所有的值，求出最大的面积
//    //时间复杂度 O(n^2) 双重for循环
//    private static int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = (j - i) * Math.min(height[j], height[i]);
//                max = Math.max(max, area);
//            }
//        }
//        return max;
//    }
//
//    //只有一个for循环，时间复杂度O(n)
//    private static int maxArea1(int[] height) {
//        int max = 0;
//        for (int i = 0, j = height.length - 1; i < j; ) {
//
//            //左边的高
//            int leftHeight = height[i];
//            //右边的高
//            int rightHeight = height[j];
//
//            //那边的高小则往那边移动一位
//            if(leftHeight<rightHeight){
//                i++;
//            }else{
//                j--;
//            }
//            //求出两个高中较小的minHeight
//            int minHeight = Math.min(leftHeight,rightHeight);
//            //计算面积
//            int area = (j-i+1)*minHeight;
//            //保留最大值
//            max = Math.max(max,area);
//
//
////            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
////            int area = (j - i + 1) * minHeight;
////            max = Math.max(max, area);
//        }
//        return max;
//    }


    /**
     * 2021-3-18 第二次练习 装最多水
     * @param height
     * @return
     */
    private static int maxArea(int[] height) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int area = (j - i) * minHeight;
                max = Math.max(area, max);
                count++;
            }
        }
        System.out.println("count = " + count);
        return max;
    }

    private static int maxArea1(int[] height) {
        int count = 0;
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
            count++;
        }
        System.out.println("count = " + count);
        return max;
    }


}
