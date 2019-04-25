package com.lyc.study.danli;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/4/1
 * @time: 17:58
 * @desc:
 */
public class test {

    public static void main(String[] args) {
        PrivilegeSingle single = PrivilegeSingle.getPrivilegeSingle();

        List<String> infos = single.getInfos("姓名");

        System.out.println(JSON.toJSON(infos));
    }
}
