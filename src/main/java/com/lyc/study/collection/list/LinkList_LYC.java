package com.lyc.study.collection.list;

import java.util.*;

/**
 * Created by liyuanchi on 2017/12/12
 */
public class LinkList_LYC {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("test");
        linkedList.add("2333");

        for (String s : linkedList
             ) {
            System.out.println(s);
        }
    }
}
