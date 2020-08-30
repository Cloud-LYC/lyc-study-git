package com.lyc.study.leetcode.no394;

import java.util.Stack;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/6/13
 * @time: 17:54
 * @desc:
 *
 * 394.字符串解码 https://leetcode-cn.com/problems/decode-string
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 *
 * 输出："aaabcbc"
 *
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 *
 * 输出："accaccacc"
 *
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 *
 * 输出："abcabccdcdcdef"
 *
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 *
 * 输出："abccdcdcdxyz"
 *
 *
 * Java Stack 类 https://www.runoob.com/java/java-stack-class.html
 *
 *
 */
public class DecodeString {

    public static void main(String[] args) {
        decodeString("14[e]");
    }

    public static String decodeString(String sourceString) {

        //创建一个栈
        Stack<String> stack = new Stack<String>();

        //遍历这个字符串
        for( int i = 0; i < sourceString.length(); i++ ) {
            //得到第一个结尾]
            if(sourceString.charAt(i) == ']') {
                String string="";

                // 栈顶元素不等于"["
                while(!"[".equals(stack.peek())) {
                    //塞入临时存放该[]内数据的字符串
                    string = stack.pop() + string;
                }
                stack.pop();
                String countString="";

                //得到要重复的数量
                while((!stack.isEmpty()) && (stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')) {
                    countString = stack.pop()+countString;
                }
                int count=Integer.parseInt(countString);

                String retString="";

                //根据数量进行循环追加
                for(int j = 0; j < count; j++) {
                    retString = retString + string;
                }
                //最外层的[]数据结果 数据入栈
                stack.push(retString);

            } else {  // 非 ] 数据入栈
                String str= "" + sourceString.charAt(i);
                stack.push(str);
            }
        }

        String aaa = "";
        while(!stack.isEmpty()) {
            aaa = stack.pop() + aaa;
        }
        return aaa;
    }
}
