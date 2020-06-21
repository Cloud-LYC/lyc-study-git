package com.lyc.study.list;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/6/19
 * @time: 11:07
 * @desc:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3)
 *    + (5 -> 6 -> 3)
 * 输出：8 -> 0 -> 6
 * 原因：342 + 365 = 708
 */
public class ListTest {
    public static void main(String[] args) {

        testList();

        testList2();

        testList3();

        List<List<Integer>> typeLists = new ArrayList<>();
        typeLists.add(Lists.newArrayList(1,2,3));
        typeLists.add(Lists.newArrayList(4,5));
        typeLists.add(Lists.newArrayList(6));
        List lists = JSON.parseObject("[[1,3,4,5],[2],[6]]", List.class);

        for (Object list : lists) {
            System.out.println((List<Integer>)list);
        }


        System.out.println("2333");


        /*List<Integer> sourceList = Lists.newArrayList(17684209,5381674,17271870,90571813,4190744,130453563,57650037,102186337,111784930,50044306,32779705,128566696,126212303,72172465,79278901,9039109,
                130789698,1766392,112257315,76903539,69982738,130645554,24267461,23085371,112506578,125887457,8885706,128112462,2309605,96944675,125735234,17918623,129675278,2215822,97900079,15081357,38075213,
                43606358,19631393,111579389,67454827,124227014,113866233,14900328,32372000,15080612,6038480,24535041,98230740,69311586,1887733,26978593,2551624,76676402,110643337,79265660,98285276,67215380,
                75092794,17775229,5220755,3227548,3309337,56768771,110375629,19682119,6136203,69158520,3010942,1862266,102037914,98016383,110847106,123074045,98837220,19690562,5206025,95268335,1865116,4521453,
                113870419,21172751,21760386,57441196,76838087,27297829,15969761,91914129,98385960,107918698,98744908,32692437,4564085,14716705,32872673,17513728,4206022,2801842,22178979,77067885,1865080,101813178,
                70452693,1859980,37801442,66353179,1766266,2648170,4069729,1766386,13829255,24454157,32859690,17852173,96899711,4065505,97833395,107144761,22223178,17908946,3268681,93567109,102186466,48889500);
        List<Integer> needFilter = Lists.newArrayList(48889500,102186466,93567109,17908946,4065505,96899711,17852173,13829255,1766386,2648170,1766266,22178979,17513728,32872673,14716705,4564085,98385960,
                91914129,15969761,76838087,57441196,21760386,21172751,113870419,4521453,1865116,95268335,5206025,19690562,98837220,123074045,110847106,102037914,69158520,6136203,19682119,110375629,67215380,79265660,
                110643337,76676402,26978593,1887733,69311586,24535041,6038480,32372000,113866233,111579389,19631393,43606358,38075213,15081357,97900079,17918623,128112462,8885706,125887457,112506578,23085371,24267461,
                69982738,1766392,79278901,128566696,32779705,50044306,102186337,98230740);


        for (Integer integer : needFilter) {
            if (sourceList.contains(integer)){
                sourceList.remove(integer);
            }
        }

        System.out.println(JSON.toJSON(sourceList));*/

    }



    public static void testList() {
        List<Integer> a = Lists.newArrayList(1,2,3,4,5);
        List<Integer> b = Lists.newArrayList(4,5);

        boolean b1 = a.containsAll(b);
        System.out.println(a);

    }

    public static void testList2() {
        List<Integer> a = Lists.newArrayList(1,2,3,4,5);
        List<Integer> b = new ArrayList<>();


        b.addAll(a.subList(0,5));

        System.out.println(b);

    }


    public static void testList3() {
        Set<Integer> c = new HashSet<>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        List<Integer> a = Lists.newArrayList(3,4,5);
        c.removeAll(a);

        List<Integer> b =  new ArrayList<>(c);


        System.out.println(b);

    }
}
