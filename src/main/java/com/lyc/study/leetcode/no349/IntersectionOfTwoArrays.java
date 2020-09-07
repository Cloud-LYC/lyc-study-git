package com.lyc.study.leetcode.no349;

import java.util.HashSet;
import java.util.Set;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/9/6
 * @time: 22:05
 * @desc: 349. 两个数组的交集 //https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 *
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,4,5,3};
        int[] nums2 = {1,6,7,8,9,5,3};


        System.out.println(intersection(nums1, nums2));

    }

   private static  int[] intersection(int[] nums1, int[] nums2) {

       Set<Integer> checkSet = new HashSet<>();
       Set<Integer> result = new HashSet<>();
       if (nums1 == null || nums2 == null) {
           return null;
       }

       for (int i : nums1) {
           checkSet.add(i);
       }

       for (int i : nums2) {
           if (checkSet.contains(i)) {
               result.add(i);
           }
       }

       int[] finalResult = new int[result.size()];
       int start = 0;
       for (int item : result) {
           finalResult[start] = item;
           start++;
       }

       return finalResult;
    }




}
