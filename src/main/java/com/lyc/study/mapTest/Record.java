package com.lyc.study.mapTest;

import java.io.Serializable;
import java.util.Map;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2020/6/29
 * @time: 21:50
 * @desc:
 */
public class  Record implements Serializable {
    private static final long serialVersionUID = -5037621005375986457L;

    private Map<String, String> valueMap;

    public Map<String, String> getValueMap() {
        return valueMap;
    }

    public void setValueMap(Map<String, String> valueMap) {
        this.valueMap = valueMap;
    }
}
