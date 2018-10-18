package com.lyc.study.collection.DepthAction;

import java.io.Serializable;

/**
 * 用户深度行为
 * Created by liyuanchi on 2017/11/1
 */

public class UserDepthActionDto implements Serializable{
//    深度行为类别
    private int depthActionType;

//    深度行为发生次数
    private int actionTimes;

//    深度行为发生时间
    private long lastActionTm;

    private String name;

    public int getDepthActionType() {
        return depthActionType;
    }

    public void setDepthActionType(int depthActionType) {
        this.depthActionType = depthActionType;
    }

    public int getActionTimes() {
        return actionTimes;
    }

    public void setActionTimes(int actionTimes) {
        this.actionTimes = actionTimes;
    }

    public long getLastActionTm() {
        return lastActionTm;
    }

    public void setLastActionTm(long lastActionTm) {
        this.lastActionTm = lastActionTm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
