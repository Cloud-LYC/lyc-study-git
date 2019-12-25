package com.lyc.study.textuuid;

import java.util.UUID;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/10/31
 * @time: 14:47
 * @desc:
 */
public class TestUUID {


    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            UUID uuid = UUID.randomUUID();
            System.out.println("uuid ="+ uuid.toString()+"\t hashCode = "+ (uuid.hashCode() > 0 ? uuid.hashCode() : -uuid.hashCode()));
        }


    }


}
