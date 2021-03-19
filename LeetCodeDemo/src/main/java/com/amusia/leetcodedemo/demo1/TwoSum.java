package com.amusia.leetcodedemo.demo1;

import com.google.gson.Gson;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        twoSum(nums, target);
    }

    /**
     * 2021-3-19 第一遍练习（暴力解法）
     * @param nums
     * @param target
     */
    public static void twoSum(int[] nums, int target) {
        int result[] = new int[2];
        for (int i = 0; i < nums.length-1 ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                    break;
                }
            }
        }

        System.out.println("result = " + new Gson().toJson(result));
    }
}
