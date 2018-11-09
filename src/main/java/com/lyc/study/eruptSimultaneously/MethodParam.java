package com.lyc.study.eruptSimultaneously;

import com.google.common.collect.Lists;
import com.lyc.model.User;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2018/11/9
 * @time: 11:10
 * @desc: 分批并发查询
 */
public class MethodParam {
    /**
     * 在批量查例如用户信息的时候会遇到传参（userIds）如果过多，会出现超时的情况
     * 此时可以将其进行分批、并发查询
     */

    public List<User> getUsersByIds(List<Integer> userIdList){
        //参数校验
        if (CollectionUtils.isEmpty(userIdList)){
            //打日志或者输出错误信息，，直接返回空集合
            System.out.println("[MethodParam] getUsersByIds param is empty userIdList = {}"+userIdList);
        }

        //userId去重、去空
        List<Integer> allIds = userIdList.stream().distinct().filter(Objects::nonNull).collect(Collectors.toList());

        //设置单次查询的List大小
        int limit = 50;

        List<User> result;

        //小于限制大小，直接调用查询
        if (allIds.size() <= limit){
            result = page(allIds);
        } else {
            result = Lists.partition(allIds, limit).parallelStream().flatMap(list -> {
                return page(list).stream();
            }).collect(Collectors.toList());
        }

        return result;
    }

    private List<User> page(List<Integer> userIds){
        //开始查询
        //走数据库查询也好，调用其它服务也好
        System.out.println("开始查询");
        return Collections.emptyList();
    }
}
