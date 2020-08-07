package com.lyc.study.sort;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/7/31
 * @time: 15:36
 * @desc:
 */
public class ListTestSort {
    public static void main(String[] args) {
        List<Integer> ids1 = Lists.newArrayList(330002,
                330003,
                330004,
                410080,
                410076,
                330005,
                330007,
                330008,
                5001000,
                330015,
                4000017,
                330009,
                330010,
                330014,
                330013,
                330001,
                330012,
                330000) ;
        ids1.sort(Comparator.comparingInt(o -> o));

        System.out.println(ids1);


        List<Integer> ids2 = Lists.newArrayList(320023,
                320024,
                320007,
                320008,
                320010,
                320011,
                320012,
                320014,
                320015,
                320100,
                320000,
                320001,
                320002,
                320003,
                320018,
                320020,
                320021) ;
        ids2.sort(Comparator.comparingInt(o -> o));

        System.out.println(ids2);
    }
}
