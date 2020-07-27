package com.lyc.study.leetcode.no5472;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/7/26
 * @time: 21:51
 * @desc:
 * 题目： 5472. 重新排列字符串
 *
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 *
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 *
 * 返回重新排列后的字符串。
 *
 * 示例 1：
 *
 * 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 *
 * 输出："leetcode"
 *
 * 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 *
 * 示例 2：
 *
 * 输入：s = "abc", indices = [0,1,2]
 *
 * 输出："abc"
 *
 * 解释：重新排列后，每个字符都还留在原来的位置上。
 *
 * 示例 3：
 *
 * 输入：s = "aiohn", indices = [3,1,4,2,0]
 *
 * 输出："nihao"
 *
 * 示例 4：
 *
 * 输入：s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 *
 * 输出："arigatou"
 *
 * 示例 5：
 *
 * 输入：s = "art", indices = [1,0,2]
 *
 * 输出："rat"
 *
 *  
 *
 * 提示：
 *
 * s.length == indices.length == n
 *
 * 1 <= n <= 100
 *
 * s 仅包含小写英文字母。
 *
 * 0 <= indices[i] < n
 *
 * indices 的所有的值都是唯一的（也就是说，indices 是整数 0 到 n - 1 形成的一组排列）。
 */
public class ShuffleString {

    public static void main(String[] args) {
        String s = "aaiougrt";
        int[] indices = new int[]{4,0,2,6,7,3,1,5};
        System.out.println(restoreString2(s, indices));
    }

    /**
     * 第一种解法
     * 首先是 初始化一个长度为s.length的字符数组chars 用于存放最终的结果
     * 然后将原始字符串转为char
     * fori循环s.length长度， 此时 chars[indices[i]] = sChar[i]; 将结果存入chars
     * 最后 以字符串的形式输出chars
     * @param s
     * @param indices
     * @return
     */
    public static String restoreString2(String s, int[] indices) {
        char[] chars = new char[s.length()];
        char[] sChar = s.toCharArray();
        for (int i = 0; i < s.length() ; i++) {
            chars[indices[i]] = sChar[i];
        }
        return new String(chars);
    }


    /**
     * 第二种也是第一步的原理，没有将s转为字符数组，而是使用了s.charAt(i)方法得到字符串s具体的字符
     * @param s
     * @param indices
     * @return
     */

    public static String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }
}












