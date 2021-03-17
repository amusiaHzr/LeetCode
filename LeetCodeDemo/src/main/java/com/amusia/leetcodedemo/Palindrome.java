package com.amusia.leetcodedemo;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Palindrome {
    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(test);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        //1 过滤掉数字和标点
        //2 倒序比较
        String filteredS = filterNonNumAndChar(s);
        String reverseS = new StringBuffer(filteredS).reverse().toString();
        return reverseS.equals(filteredS);
    }

    private static String filterNonNumAndChar(String test) {

        String filteredS = test.replaceAll("[^a-zA-Z0-9]", "");

        return filteredS.toLowerCase();
    }


}