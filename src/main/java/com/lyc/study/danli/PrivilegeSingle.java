package com.lyc.study.danli;

import java.util.ArrayList;
import java.util.List;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/4/1
 * @time: 17:55
 * @desc:
 */
public class PrivilegeSingle {
    private static final PrivilegeSingle single = new PrivilegeSingle();

    public static PrivilegeSingle getPrivilegeSingle(){
        return single;
    }

    public List<String> getInfos(String name) {
        List<String> result = new ArrayList<>();

        result.add(name);

        return result;
    }
}
