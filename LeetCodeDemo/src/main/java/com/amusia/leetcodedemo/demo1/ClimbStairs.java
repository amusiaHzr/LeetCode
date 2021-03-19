package com.amusia.leetcodedemo.demo1;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {

    public static void main(String[] args) {

        int result = climbStairs(6);
        System.out.println("result = " + result);
    }

    /**
     * 爬楼梯问题 求斐波拉契数
     * 递归方式 时间复杂度O(2^n)
     */
//    private static int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }


    /**
     * 加数组记录重复运算，时间复杂度变成O(n)
     * 空间复杂度 O(1)
     * @param n
     */
//    private static int climbStairs(int n) {
//        int memo[] = new int[n + 1];
//        return climbStairsMemo(n, memo);
//    }
//
//    private static int climbStairsMemo(int n, int[] memo) {
//        if (memo[n] > 0) {
//            return memo[n];
//        }
//        if (n == 1) {
//            memo[n] = 1;
//        } else if (n == 2) {
//            memo[n] = 2;
//        } else {
//            memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
//        }
//        return memo[n];
//    }

    /**
     * 时间复杂度 O(n),空间复杂度 O(1)
     *
     * @param n
     * @return
     */
//    private static int climbStairs(int n) {
//        if (n < 3) return n;
//        int first = 1;
//        int second = 2;
//        int third = 0;
//        for (int i = 3; i <=n ; i++) { // i = 3                i=4
//            third = first+second; // third = 1+2 = 3           third = 2+3 = 5
//            first = second;  // first = 2                      first = 3
//            second = third; // second = 3                      second = 5
//        }
//        return second;
//    }

    /**
     * 2021-3-19 爬楼梯第二次练习
     *
     * @param n
     * @return
     */
//    private static int  climbStairs(int n){
//        if(n<3)return n;
//        return climbStairs(n-1)+climbStairs(n-2);
//    }


//    private static int climbStairs(int n) {
//        int memo[] = new int[n + 1];
//        return climbStairsMemo(n, memo);
//    }
//
//    private static int climbStairsMemo(int n, int[] memo) {
//        if (memo[n] > 0) {
//            return memo[n];
//        } else if (n < 3) {
//            memo[n] = n;
//        } else {
//            memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
//        }
//        return memo[n];
//    }
    private static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int first = 1;
        int second = 2;
        int third;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
