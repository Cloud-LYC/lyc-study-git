package com.lyc.utils;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/1/22
 * @time: 17:07
 * @desc: 有相同属性（类别、属性名称相同）的两个对象之间copy属性值，
 *        包含单次copy和批量copy,一般用于数据库查询结果承载的Bean和DTO传输对象之间的转换
 */
public class Copier {

    public static <TARGET> InnerCopier<TARGET> to(Class<TARGET> target) {
        return new BeanUtilCopier<TARGET>(target);
    }

    public interface InnerCopier<TARGET> {

        /**
         * 批量copy
         *
         * @param source
         * @return
         */
        public List<TARGET> from(List source);

        /**
         * 单次copy
         *
         * @param source
         * @return
         */
        public TARGET from(Object source);

    }

    public static class BeanUtilCopier<TARGET> implements InnerCopier<TARGET> {

        private Class<TARGET> targetClass;

        public BeanUtilCopier(Class<TARGET> target) {
            this.targetClass = target;
        }

        @Override
        public List<TARGET> from(List source) {
            if (CollectionUtils.isEmpty(source)) {
                return Collections.emptyList();
            }
            List<TARGET> targetList = Lists.newArrayList();
            for (Object obj : source) {
                targetList.add(from(obj));
            }
            return targetList;
        }

        @Override
        public TARGET from(Object source) {
            TARGET target = createInstance(targetClass);
            BeanUtils.copyProperties(source, target);
            return target;
        }

        private TARGET createInstance(Class<TARGET> targetClass) {
            try {
                return targetClass.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
