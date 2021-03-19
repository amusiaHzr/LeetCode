package com.amusia.leetcodedemo.demo1;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    /**
     * 三数之和暴力求解
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) { //target
            int target = nums[i]; ////target
            for (int j = 0; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[j] + nums[k]) + target == 0) {
                        List<Integer> integers = Arrays.asList(target,nums[j], nums[k]);
                        Collections.sort(integers);
                        result.add(integers);
                    }
                }
            }
        }
        System.out.println("result = " + new Gson().toJson(result));
        return new ArrayList<>(result);
    }
}
