package com.amusia.leetcodedemo.demo1;

import com.google.gson.Gson;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 2021-3-17 第一次练习
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

//    public static void moveZeroes(int[] nums) {
//        System.out.println("before：" + new Gson().toJson(nums));
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[j] = nums[i];
//                if (j != i) {
//                    nums[i] = 0;
//                }
//                j++;
//            }
//        }
//        System.out.println("after：" + new Gson().toJson(nums));
//    }

    /**
     * 2021-3-18 移动零 第二次练习
     * */
//    public static void moveZeroes(int[] nums){
//        System.out.println("before"+new Gson().toJson(nums));
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i]!=0){
//                nums[j] = nums[i];
//                if(j!=i){
//                    nums[i] = 0;
//                }
//                j++;
//            }
//        }
//        System.out.println("after"+new Gson().toJson(nums));
//    }

    /**
     * 2021-3-18 移动零 第三次练习
     * */
    public static void moveZeroes(int[] nums){
        System.out.println("before"+new Gson().toJson(nums));
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i <nums.length ; i++) {
            nums[i] = 0;
        }
        System.out.println("after"+new Gson().toJson(nums));
    }
}
