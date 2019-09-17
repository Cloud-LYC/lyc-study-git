package com.lyc.study.java8;

import com.google.common.collect.Lists;
import com.lyc.dto.UserDTO;

import java.util.Comparator;
import java.util.List;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/4/13
 * @time: 11:44
 * @desc:
 */
public class StreamStudy {

    public static void main(String[] args) {
        //构建List
        List<UserDTO> userDTOList = Lists.newArrayList(
                UserDTO.builder().userName("l1").userId(2).userPassword("2333").build(),
                UserDTO.builder().userName("l1").userId(1).userPassword("2333").build(),
                UserDTO.builder().userName("l1").userId(7).userPassword("2333").build(),
                UserDTO.builder().userName("l1").userId(6).userPassword("2333").build(),
                UserDTO.builder().userName("l1").userId(3).userPassword("2333").build(),
                UserDTO.builder().userName("l1").userId(5).userPassword("2333").build(),
                UserDTO.builder().userName("l1").userId(4).userPassword("2333").build()
        );
        sortShengXu(userDTOList); //属性排序 升序
        sortJiangXu(userDTOList); //属性排序 降序



    }

    private static void sortJiangXu(List<UserDTO> userDTOList) {

        userDTOList.sort(Comparator.comparingInt(UserDTO::getUserId).reversed());
        System.out.println("---------属性排序 升序--------");
        for (UserDTO userDTO : userDTOList) {
            System.out.println(userDTO);
        }
        System.out.println("\n");
    }

    private static void sortShengXu(List<UserDTO> userDTOList) {

        userDTOList.sort(Comparator.comparingInt(UserDTO::getUserId));
        System.out.println("---------属性排序 降序--------");
        for (UserDTO userDTO : userDTOList) {
            System.out.println(userDTO);
        }
        System.out.println("\n");
    }
}
