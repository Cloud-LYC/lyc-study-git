package com.lyc.study.leetcode.no557;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/8/30
 * @time: 19:46
 * @desc: 557. 反转字符串中的单词 III    https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 思路与算法
 *
 * 开辟一个新字符串。然后从头到尾遍历原字符串，直到找到空格为止，此时找到了一个单词，并能得到单词的起止位置。随后，根据单词的起止位置，可以将该单词逆序放到新字符串当中。如此循环多次，直到遍历完原字符串，就能得到翻转后的结果。
 *
 */
public class ReverseWord3 {
    public static void main(String[] args) {

        System.out.println(reverseWords("Let's take LeetCode contest"));
    }


    public static String reverseWords(String s) {

        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;

        while (i < length) {
            int start = i;
            //开辟一个新字符串。然后从头到尾遍历原字符串，直到找到空格为止，此时找到了一个单词，并能得到单词的起止位置
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            //随后，根据单词的起止位置，可以将该单词逆序放到新字符串当中
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
            //如此循环多次，直到遍历完原字符串，就能得到翻转后的结果
        }
        return ret.toString();
    }
}
